package stream;

import java.io.IOException;
import java.nio.charset.Charset;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.Arrays;
import java.util.stream.Stream;

public class StreamGenerator {
	public static void main(String[] args) {
		streamFromString();
		streamFromArrays();
		streamOfArrays();
		mergeArrays();
		fileStream();
		functionStream();
		finonacciStream();
		generateFibonacciSeries();
		fibonnacciTuples();

	}

	private static void fibonnacciTuples() {
		Stream.iterate(new int[] { 0, 1 }, s -> new int[] { s[1], s[0] + s[1] }).limit(15)
				.forEach(s -> System.out.println(s[0] + "-----" + s[1]));

	}

	private static void generateFibonacciSeries() {
		int [] a = new int [20] ;
		a[0] = 0;a[1]=1;
		for (int i=2; i < 20; i++) {
				a[i] = a[i-1] + a[i-2];
				System.out.println(a[i]);
		}
		System.out.println(a.length);
		
	}

	private static void finonacciStream() {
		// seed value is an array {0,1} and every time we are creating a new int [] with two elements
		// new int[]{s[1],s[0]+s[1]}
		// {0,1} {1,1} {1,2} {2,3} {3,5} {5,8} {8,13} {13,21}
		// finally map(n->n[0]) takes only the 0th element of the array stream and returns that
		Stream.iterate(new int[]{0, 1}, s -> new int[]{s[1], s[0] + s[1]})
        .limit(10)
        .map(n -> n[0]).forEach(System.out::println);
		
	}

	// Stream.iterate and Stream.generate create an infinite stream , where the
	// numbers are generated on demand , hence it is always necesssary to have a
	// limit()
	// associated on these functions, otherwise they would run for ever
	private static void functionStream() {
		Stream.iterate(0, n -> n + 2).limit(10).forEach(System.out::println);
		Stream.generate(Math::random).limit(4).forEach(System.out::println);

	}

	private static void fileStream() {
		try {
			Stream<String> linesStream = Files.lines(Paths.get("C:\\temp\\Instructions.txt"), Charset.defaultCharset());
			long count = linesStream.flatMap(s -> {
				String[] split = s.split(""); // will split each word into a
												// character
				// System.out.println(split);
				Stream<String> stream = Arrays.stream(split);
				return stream;
			}).distinct().count();
			System.out.println("number of unique words in the file" + count);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

	private static void streamFromString() {
		Stream<String> streamString = Stream.of("hello", "kunal", "java", "stream");
		streamString.map(String::toUpperCase).forEach(s -> System.out.println(s));
	}

	static void streamFromArrays() {
		int streamArray = Arrays.stream(new int[] { 3, 5, 8, 9, 21, 33, 57, 89 }).sum();
		System.out.println("Sum of array ints " + streamArray);
	}

	static void streamOfArrays() {
		Stream<Integer> streamInteger = Arrays.stream(new int[] { 3, 5, 8, 9, 21, 33, 57, 89 }).boxed();
		streamInteger.filter(s -> s % 3 == 0).forEach(s -> System.out.println(s));
	}

	static void mergeArrays() {
		int[] array1 = new int[] { 2, 4, 6, 7, 8, 9 };
		int[] array2 = new int[] { 8, 1, 11, 10, 55, 33 };

		Stream<Integer> boxed1 = Arrays.stream(array1).boxed();
		Stream<Integer> boxed2 = Arrays.stream(array2).boxed();
		Stream<Integer> flatMap = Stream.of(boxed1, boxed2).flatMap(s -> s);
		flatMap.forEach(s -> System.out.println(":::" + s));

	}
}
