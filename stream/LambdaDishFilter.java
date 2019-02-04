package stream;

import java.util.Arrays;
import java.util.Comparator;
import java.util.IntSummaryStatistics;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Optional;
import java.util.stream.Collectors;

import lambdas.basics.util.LambdaHelper;
import stream.Dish.Type;

public class LambdaDishFilter {

	public static void main(String[] args) {
		lowCalorieDishName();
		lowCalorieSortDish();
		groupDishByType();
		getVegetarianDishName();
		getUniqueElements();
		getFirstTwoMeatDishesName();
		getLengthOfEachDishNameList();
		findAnyVegetarianDish();
		findMaximumCalorieDishByReduce(); 
		findMinimumCalorieDishByReduce();
		countNumberOfDishes();
		findMaximumCalorieDishByCollect();
		findMinumumCalorieDishByCollect();
		findAverageCaloriesOfAllDishesUsingCollect();
		IntSummaryCaloriesUsingCollect();
	}

	private static void IntSummaryCaloriesUsingCollect() {
		IntSummaryStatistics collect = LambdaHelper.populateDishList().stream().collect(Collectors.summarizingInt(Dish::getCalories));
		System.out.println("sum of all the calories:::"+collect.getSum());
		System.out.println("avg of all the calories:::"+collect.getAverage());
		System.out.println("max calorie dish:::"+collect.getMax());
		System.out.println("min calorie dish:::"+collect.getMin());
		System.out.println("count dishes:::"+collect.getCount());
	}

	private static void findMinumumCalorieDishByCollect() {
		Comparator<Dish> dishComparator = Comparator.comparing(Dish::getCalories);
		Optional<Dish> collect = LambdaHelper.populateDishList().stream().collect(Collectors.minBy(dishComparator));
		collect.ifPresent(s-> System.out.println("Minimum calorie dish::"+s.getName()+"--"+s.getCalories()));
		
	}

	private static void findAverageCaloriesOfAllDishesUsingCollect() {
		Double collect2 = LambdaHelper.populateDishList().stream().collect(Collectors.averagingInt(Dish::getCalories));
		System.out.println("average calories::"+collect2);
	}

	private static void findMaximumCalorieDishByCollect() {
		Comparator<Dish> dishComparator = Comparator.comparing(Dish::getCalories);
		Optional<Dish> collect = LambdaHelper.populateDishList().stream().collect(Collectors.maxBy(dishComparator));
		collect.ifPresent(s-> System.out.println(s.getName()+"--"+s.getCalories()));
		
	}

	private static void countNumberOfDishes() {
		Integer reduce = LambdaHelper.populateDishList().stream().map(d->{
			System.out.println("mapping and return 1");
			return 1;
			}).reduce(0,(a,b)-> {
				System.out.println("Filter adding members-"+a+"and-"+b);
				return a+b;}) ;
		System.out.println(reduce.equals(LambdaHelper.populateDishList().size()));
	}

	private static void findMaximumCalorieDishByReduce() {
		LambdaHelper.populateDishList().stream().map(d-> d.getCalories()).reduce((a,b) -> a>b?a:b).ifPresent(s-> System.out.println("maximum:::"+s.intValue()));
		
	}
	
	private static void findMinimumCalorieDishByReduce() {
		LambdaHelper.populateDishList().stream().map(d-> d.getCalories()).reduce((a,b) -> a<b?a:b).ifPresent(s-> System.out.println("minimum::::"+s.intValue()));
		
	}

	// short circuit evaluation
	private static void findAnyVegetarianDish() {
		 LambdaHelper.populateDishList().stream().filter(d-> d.isVegetarian()).findAny().ifPresent(d->System.out.println("Vegetarian Dish::"+d.getName()));
		 // short circuit evaluator , since exits at the first condition when the dish is not vegetarian
		 boolean allMatch = LambdaHelper.populateDishList().stream().allMatch(d-> {
			 System.out.println(d.getName());
			 return d.isVegetarian();
			 });
		 System.out.println("AllMatch condition:"+allMatch);
		 LambdaHelper.populateDishList().stream().filter(d-> d.isVegetarian()).findFirst().ifPresent(d->System.out.println("Vegetarian Dish::"+d.getName()));
		
	}

	private static void getLengthOfEachDishNameList() {
		List<Integer> collect = LambdaHelper.populateDishList().stream().map(d-> d.getName()).map(s-> s.length()).collect(Collectors.toList());
		System.out.println(collect);
	}

	private static void getFirstTwoMeatDishesName() {
		List<String> collect = LambdaHelper.populateDishList().stream().filter(d-> d.getType()==Type.MEAT).limit(2).map(d->d.getName()).collect(Collectors.toList());
		System.out.println(collect);
	}

	private static void getUniqueElements() {
		List<Integer> myList = Arrays.asList(2,1,2,4,6,6,7);
		List<Integer> collect = myList.stream().filter(i-> i%2==0).distinct().collect(Collectors.toList());
		System.out.println(collect);
	}

	private static void getVegetarianDishName() {
		List<String> collect = LambdaHelper.populateDishList().stream().filter(Dish::isVegetarian).map(Dish::getName)
				.collect(Collectors.toList());
		System.out.println(collect);
	}

	// using Collectors.groupingBy()
	private static void groupDishByType() {
		Map<Type, List<Dish>> collect = LambdaHelper.populateDishList().stream()
				.collect(Collectors.groupingBy(Dish::getType));
		Iterator<Entry<Type, List<Dish>>> iterator = collect.entrySet().iterator();
		while (iterator.hasNext()) {
			Entry<Type, List<Dish>> next = iterator.next();
			System.out.println("Dish Type:" + next.getKey() + " contains theses dishes:::");
			List<Dish> value = next.getValue();
			value.stream().forEach(d -> System.out.println(d.getName()));
		}

	}

	private static void lowCalorieDishName() {
		System.out.println("lowCalorieDishName starts:::::::::::::::::::::::::::::::::::::");
		/*
		 * LambdaHelper.populateDishList().stream().filter(d -> {
		 * System.out.println("filtering::"+d.getName()); return d.getCalories()
		 * < 400;
		 * 
		 * }).sorted(Comparator.comparing(Dish::getCalories)).map(Dish::getName)
		 * .forEach(s -> System.out.println(s)); ;
		 */
		List<String> collect = LambdaHelper.populateDishList().stream().filter(d -> {
			System.out.println("filtering::" + d.getName());
			return d.getCalories() < 400;

		}).sorted(Comparator.comparing((Dish d) -> {
			System.out.println("sorting::" + d.getName());
			return d.getCalories();
		})).map((Dish d) -> {
			System.out.println("mapping::" + d.getName());
			return d.getName();
		}).collect(Collectors.toList());
		
		System.out.println(collect);
		System.out.println("lowCalorieDishName ends::::::::::::::::::::::::::::::::::::::::::");
	}

	private static void lowCalorieSortDish() {
		LambdaHelper.populateDishList().stream().sorted(Comparator.comparing(Dish::getCalories)).forEach(d -> System.out
				.println(d.getName() + "-" + d.getCalories() + "-" + d.getType() + "-" + d.isVegetarian()));

	}
}
