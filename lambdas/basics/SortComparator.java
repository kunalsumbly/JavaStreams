package lambdas.basics;

import java.util.Comparator;
import java.util.List;

import lambdas.basics.util.LambdaHelper;

public class SortComparator {
	public static void main(String[] args) {

		List<Banana> appleList = LambdaHelper.populateBananaList();
		System.out.println(":::::::::::::::Default SORTING list maintains the insertion order:::::::::::::::::");
		LambdaHelper.iterateAndPrintList(appleList);

		// Sort Apples by color
		LambdaHelper.oldJavaSortByColor(appleList);

		System.out.println(":::::::::::::::AFTER SORTING by COLOR:::::::::::::::::");

		LambdaHelper.iterateAndPrintList(appleList);

		// Lambda sort
		appleList.sort(Comparator.comparing(Fruit::getWeight)); // using method reference

		System.out.println(":::::::::::::::AFTER SORTING by weight again:::::::::::::::::");
		LambdaHelper.iterateAndPrintList(appleList);

	}

}
