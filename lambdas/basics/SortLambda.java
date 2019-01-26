package lambdas.basics;

import java.util.Comparator;
import java.util.List;

import lambdas.basics.util.LambdaHelper;

public class SortLambda {
	public static void main(String[] args) {

		List<Banana> bananaList = LambdaHelper.populateBananaList();

		List<Apple> appleList = LambdaHelper.populateAppleList();
		System.out.println(":::::::::::::::default SORTING apple list:::::::::::::::::");
		LambdaHelper.iterateAndPrintList(appleList);
		System.out.println(":::::::::::::::default SORTING banana list:::::::::::::::::");
		LambdaHelper.iterateAndPrintList(bananaList);
		// Lambda sort
		bananaList.sort(Comparator.comparing(Fruit::getWeight)); // using method reference
		appleList.sort(Comparator.comparing(Fruit::getColor)); // using method reference

		System.out.println(":::::::::::::::AFTER SORTING by weight apple list:::::::::::::::::");
		LambdaHelper.iterateAndPrintList(appleList);
		System.out.println(":::::::::::::::AFTER SORTING by weight banana list:::::::::::::::::");
		LambdaHelper.iterateAndPrintList(bananaList);
		
		bananaList.sort(Comparator.comparing(Fruit::getWeight).reversed()); // using method reference
		System.out.println(":::::::::::::::AFTER SORTING by weight reverse banana list:::::::::::::::::");
		LambdaHelper.iterateAndPrintList(bananaList);
		

	}
}
