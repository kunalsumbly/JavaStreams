package lambdas.basics;

import java.util.Collections;
import java.util.List;

import lambdas.basics.util.LambdaHelper;

public class SortComparable {

	public static void main(String[] args) {
		List<Apple> appleList = LambdaHelper.populateAppleList();

		for (Apple apple : appleList) {
			System.out.println(apple);
		}

		// Sort Apples by default implementation
		Collections.sort(appleList);

		System.out.println(":::::::::::::::AFTER SORTING by weight which is default implementation:::::::::::::::::");
		// After sort
		for (Apple apple : appleList) {
			System.out.println(apple);
		}

	}

}
