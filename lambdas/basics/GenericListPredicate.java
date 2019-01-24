package lambdas.basics;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import lambdas.basics.util.LambdaHelper;

/**
 * This class implements a generic filter for a List data type
 * @author kusu
 *
 */

public class GenericListPredicate {
	public static void main(String[] args) {
		List<Apple> appleList = filterList(LambdaHelper.populateAppleList(), (Apple a)-> a.getWeight() >100 );
		assert appleList.size() == 4;
		List<Integer> numbers =  new ArrayList(Arrays.asList(new Integer []{1,2,3,4,5,6,77,88,99,43,56,67}));
		
		Predicate<Integer> listPredicate = (Integer i) -> i % 2==0;
		List<Integer> numberList = filterList(numbers , listPredicate);
		
		assert numberList.size() == 5;
		List<String> strings = new ArrayList<>(Arrays.asList(new String []{"god","devil"}));
		List<String> stringList = filterList(strings , (String i) -> i.equals("god"));
		assert stringList.size() == 1;
	}
	
	// Generic function to filter any list based on a given predicate
	static <T> List<T> filterList(List<T> myList, Predicate<T> listPredicate) {
		List<T> newList = new ArrayList<>();
		for (T t : myList) {
			if (listPredicate.test(t)) {
				newList.add(t);
			}
		}
		return newList;
	}
	
	
	// Predicate accepts an Object T and returns boolean
	@FunctionalInterface
	public interface Predicate<T>{
		boolean test(T t);
	}

}
