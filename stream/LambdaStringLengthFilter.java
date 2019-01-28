package stream;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class LambdaStringLengthFilter {
	public static void main(String[] args) {
		lengthListFromStringList();
		mergeStringArrayUsingFlatMap();
		returnSquareListOfNumbers();
		cartesianCombinationOfTwoListsInOne();
	}

	private static void cartesianCombinationOfTwoListsInOne() {
		List<Integer> list1 = Arrays.asList(1, 2);
		List<Integer> list2 = Arrays.asList(3, 4, 5, 6);
		// This will return the combined List<Integer> for each pair
		list1.stream().flatMap(i -> list2.stream().map(j-> Arrays.asList(i, j))).forEach(a -> System.out.println(a));
		// This will return the combined List<Integer> for pair i,j only if (i+j) is divisible by 2.
		list1.stream().flatMap(i -> list2.stream().filter(j-> (i+j) %2==0).map(j-> Arrays.asList(i, j))).forEach(a -> System.out.println(a));
	}

	private static void returnSquareListOfNumbers() {
		List<Integer> myList = Arrays.asList(1, 2, 3, 4, 5, 6);
		List<Integer> collect = myList.stream().map(i -> i * i).collect(Collectors.toList());
		System.out.println(collect);
	}

	public static void lengthListFromStringList() {
		List<String> myList = Arrays.asList("Hello", "I am", "kunal", "sumbly");
		List<Integer> collect = myList.stream().map(s -> s.length()).collect(Collectors.toList());
		System.out.println(collect);
	}

	static void mergeStringArrayUsingFlatMap() {
		List<String> myList = Arrays.asList("Hello", "World", "Hello", "World"); // output
																					// should
																					// be
																					// a
																					// flattened
																					// combined
																					// String
																					// List
																					// without
																					// duplicates
																					// i.e.
																					// [H,el,o,W,r,d]
		System.out.println(myList);

		List<String> collect = myList.stream().map(string -> string.split("")).flatMap(s -> Arrays.stream(s)).distinct()
				.collect(Collectors.toList());
		System.out.println(collect);

	}

}
