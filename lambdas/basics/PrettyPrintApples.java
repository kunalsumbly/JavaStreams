package lambdas.basics;

import java.util.List;

import lambdas.basics.util.LambdaHelper;

// Another example of behaviour parameterization

public class PrettyPrintApples {
	public static void main(String[] args) {
		List<Apple> populateAppleList = LambdaHelper.populateAppleList();
		
		// Different blocks of code are being passed to prettyPrintApple , which get executed producing different output
		prettyPrintApple(populateAppleList, (Apple a) -> "Mix weight and color "+a.getWeight() + "-" + a.getColor());
		
		prettyPrintApple(populateAppleList, (Apple a) -> "Only weight "+String.valueOf(a.getWeight()));
		
		prettyPrintApple(populateAppleList, (Apple a) -> "Only color "+a.getColor());
		
		prettyPrintApple(populateAppleList, (Apple a) -> (a.getWeight() > 100 ? "A heavy " : "A light ") +a.getColor() +" Apple");
	}

	static void prettyPrintApple(List<Apple> inventory, ApplePrinter printer) {
		for (Apple apple : inventory) {
			System.out.println(printer.printApple(apple));
		}

	}

	@FunctionalInterface
	public interface ApplePrinter {
		String printApple(Apple apple);
	}

}
