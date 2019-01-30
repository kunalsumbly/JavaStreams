package stream;

import java.util.stream.IntStream;
import java.util.stream.Stream;

public class PythagoreanTriplets {
	public static void main(String[] args) {
		Stream<int[]> pythagoreanTriplets = IntStream.rangeClosed(1, 100).boxed()
				.flatMap(a -> 
					IntStream.rangeClosed(a, 100)
						.filter(b -> Math.sqrt(a * a + b * b) % 1 == 0).mapToObj(b -> new int[] { a, b, (int) Math.sqrt(a * a + b * b) }));
		
		pythagoreanTriplets.limit(6).forEach(a-> System.out.println(a[0]+","+a[1]+","+a[2]));
		
		/**IntStream.rangeClosed(1, 100)
				.flatMap(a -> 
					IntStream.rangeClosed(a, 100)
						.filter(b -> Math.sqrt(a * a + b * b) % 1 == 0)).mapToObj(a -> new int []{a});*/
		
	}

}
