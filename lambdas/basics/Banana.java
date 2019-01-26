package lambdas.basics;

public class Banana extends Fruit {
	
	public Banana(Integer i){
		super.setWeight(i);
		super.setColor("DEFAULT");
	}

	public Banana(int p_weight, String p_color) {
		super.setWeight(p_weight);
		super.setColor(p_color);
	}

}
