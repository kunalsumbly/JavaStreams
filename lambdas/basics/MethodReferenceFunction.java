package lambdas.basics;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class MethodReferenceFunction {

	public static void main(String[] args) {
		ArrayList<Integer> weights = new ArrayList<>(Arrays.asList(new Integer []{5,4,8,12,7}));
		
		// Creates an instance of Apple object
		Function<Integer,Apple> f = Apple::new; // Apple::new ->maps to new Apple(Integer)
		Apple apple = f.apply(10); // this actually calls the constructor
		System.out.println(apple.getWeight());
		
		// Using method reference in Lambda
		List<Apple> appleList = map(weights, Apple::new); // Apple::new is the method reference to Apple(Integer) contructor
		appleList.stream().forEach( a-> System.out.println(a.getWeight()));
	}
	
	
	// creates new objects of class Apple with passed list of weights
	static  List<Apple> map(List<Integer>myList, Function<Integer, Apple> f){
		List<Apple> returnList = new ArrayList<>();
		
		for (Integer i : myList){
			Apple apple = f.apply(i);
			returnList.add(apple);
		}
		
		return  returnList;

	}
	
	
	@FunctionalInterface
	public interface Function<T,R> {
		public R apply(T t);
	}
}
