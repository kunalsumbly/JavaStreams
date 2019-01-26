package lambdas.basics;

import java.util.HashMap;
import java.util.Map;
import java.util.function.Function;

public class LambdaFruitObjectCreation {

	static Map<String, Function<Integer, Fruit>> map = new HashMap<>();
	
	static {
		map.put("apple", Apple::new);
		map.put("banana", Banana::new);
	}

	// factory method to create objects
	public static Fruit giveMeFruit(String fruitName, Integer weight) {
		return map.get(fruitName).apply(weight);
	}
	
	public static void main(String[] args) {
		//client code
		Fruit appleFruit = giveMeFruit("apple", 100);
		System.out.println("appleFruit:"+appleFruit.getWeight());
		Fruit bananaFruit = giveMeFruit("banana", 200);
		System.out.println("bananaFruit:"+bananaFruit.getWeight());
	}

}
