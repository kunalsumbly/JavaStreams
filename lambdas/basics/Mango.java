package lambdas.basics;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Predicate;

public class Mango extends Fruit {
	public Mango(int pWeight, String pColor) {
		super.setColor(pColor);
		super.setWeight(pWeight);
	}
	
	public static void main(String[] args) {
		List<Mango> populateMangoList = lambdas.basics.util.LambdaHelper.populateMangoList();
		// Different method for different conditions is wasteful coding and very verbose
		sumWeightGreenMangoes(populateMangoList);
		sumWeightGreenMangoesWithCertainWeight(populateMangoList);
		// what if tomorrow requirement is also to sumweight of green, red mangoes ?? More code change
		
		// All the client has to do is to create an method whose 
		//signature matches with functional interface Predicate test()
		// boolean test(T t);
		List<Mango> filterGreenMangoes = filterMangoes(populateMangoList,Mango::isGreen);  // client calls the already added method
		assert filterGreenMangoes.size() == 3; // enable assertion using -enableassertion in VM args
		
		
		
	}
	
	
	// Generic method can take in any condition and does not need to change, results in robust API
	private static List<Mango> filterMangoes(List<Mango> populateMangoList, Predicate<Mango> object) {
		List<Mango>  list = new ArrayList<>();
		for(Mango mango:populateMangoList){
			if(object.test(mango)) {
				list.add(mango);
			}
		}
		return list;
	}
	
	

	static boolean isGreen(Mango mango){ // this code is actually the implementation of Predicate.test()
		return "GREEN".equals(mango.getColor());
	}
	
	static boolean isHeavyMango(Mango mango){
		return mango.getWeight() > 100;
	}

	public static void sumWeightGreenMangoes(List<Mango> populateMangoList) {
		int sumWeight = 0;
		for(Mango mango:populateMangoList){
			if(mango.getColor().equals("GREEN")) {
				sumWeight +=mango.getWeight();
			}
		}
		System.out.println(sumWeight);
	}
	
	public static void sumWeightGreenMangoesWithCertainWeight(List<Mango> populateMangoList) {
		int sumWeight = 0;
		for(Mango mango:populateMangoList){
			if(mango.getColor().equals("GREEN") && mango.getWeight() > 100) {
				sumWeight +=mango.getWeight();
			}
		}
		System.out.println(sumWeight);
	}
}
