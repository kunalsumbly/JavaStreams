package lambdas.basics.util;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

import lambdas.basics.Apple;
import lambdas.basics.Banana;
import lambdas.basics.Fruit;
import lambdas.basics.Mango;
import stream.Dish;

public class LambdaHelper {
	public static void oldJavaSortByColor(List<? extends Fruit> appleList) {
		Collections.sort(appleList, new Comparator<Fruit>() {
			@Override
			public int compare(Fruit o1, Fruit o2) {
				return o1.getColor().compareTo(o2.getColor());
			}
		});
	}

	public static List<Apple> populateAppleList() {
		List<Apple> appleList = new ArrayList<>();
		Apple apple1 = new Apple(100, "A");
		Apple apple2 = new Apple(70, "B");
		Apple apple3 = new Apple(80, "x");
		Apple apple4 = new Apple(90, "D");
		Apple apple5 = new Apple(50, "a");
		Apple apple6 = new Apple(101, "b");
		Apple apple7 = new Apple(110, "c");
		Apple apple8 = new Apple(120, "d");
		Apple apple9 = new Apple(130, "H");

		appleList.add(apple1);
		appleList.add(apple2);
		appleList.add(apple3);
		appleList.add(apple4);
		appleList.add(apple5);
		appleList.add(apple6);
		appleList.add(apple7);
		appleList.add(apple8);
		appleList.add(apple9);
		return appleList;
	}

	public static void iterateAndPrintList(List<? extends Fruit> appleList) {
		// After sort
		for (Object apple : appleList) {
			System.out.println(apple);
		}
	}

	public static List<Banana> populateBananaList() {
		List<Banana> BananaList = new ArrayList<>();
		Banana Banana1 = new Banana(100, "A");
		Banana Banana2 = new Banana(70, "B");
		Banana Banana3 = new Banana(80, "C");
		Banana Banana4 = new Banana(90, "x");
		Banana Banana5 = new Banana(50, "a");
		Banana Banana6 = new Banana(101, "b");
		Banana Banana7 = new Banana(110, "c");
		Banana Banana8 = new Banana(120, "d");
		Banana Banana9 = new Banana(130, "H");

		BananaList.add(Banana1);
		BananaList.add(Banana2);
		BananaList.add(Banana3);
		BananaList.add(Banana4);
		BananaList.add(Banana5);
		BananaList.add(Banana6);
		BananaList.add(Banana7);
		BananaList.add(Banana8);
		BananaList.add(Banana9);
		return BananaList;
	}

	public static List<Mango> populateMangoList() {
		List<Mango> MangoList = new ArrayList<>();
		Mango Mango1 = new Mango(100, "RED");
		Mango Mango2 = new Mango(70, "ORANGE");
		Mango Mango3 = new Mango(80, "GREEN");
		Mango Mango4 = new Mango(90, "ORANGE");
		Mango Mango5 = new Mango(50, "ORANGE");
		Mango Mango6 = new Mango(101, "YELLOW");
		Mango Mango7 = new Mango(110, "YELLOW");
		Mango Mango8 = new Mango(120, "GREEN");
		Mango Mango9 = new Mango(130, "RED");

		MangoList.add(Mango1);
		MangoList.add(Mango2);
		MangoList.add(Mango3);
		MangoList.add(Mango4);
		MangoList.add(Mango5);
		MangoList.add(Mango6);
		MangoList.add(Mango7);
		MangoList.add(Mango8);
		MangoList.add(Mango9);
		return MangoList;
	}

	public static List<Dish> populateDishList() {
		List<Dish> menu = Arrays.asList(new Dish("pork", false, 800, Dish.Type.MEAT),
				new Dish("beef", false, 700, Dish.Type.MEAT), new Dish("chicken", false, 400, Dish.Type.MEAT),
				new Dish("french fries", true, 530, Dish.Type.OTHER), new Dish("rice", true, 350, Dish.Type.OTHER),
				new Dish("season fruit", true, 120, Dish.Type.OTHER), new Dish("pizza", true, 550, Dish.Type.OTHER),
				new Dish("prawns", false, 300, Dish.Type.FISH), new Dish("salmon", false, 450, Dish.Type.FISH));

		return menu;
	}
}
