package lambdas.basics;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class FunctionInterfaceLambda {

	public static void main(String[] args) {
		String[] strArray = new String[] { "Mango", "beer", "god", "devil", "funny", "love" };
		List<String> strList = new ArrayList<>(Arrays.asList(strArray));
		List<Integer> returnLength = stringLength(strList, (String s) -> s.length());
		returnLength.stream().forEach((Integer i) -> System.out.println(i));

	}

	// takes the array of strings and returns an array of the respective string
	// elements of the array
	static <T, R> List<R> stringLength(List<T> myList, Function<T, R> f) {
		List<R> returnList = new ArrayList<>();
		for (T t : myList) {
			returnList.add(f.transform(t));
		}
		return returnList;

	}

	@FunctionalInterface
	public interface Function<T, R> { //T is string List and R is integer List
		public R transform(T t);
	}

}
