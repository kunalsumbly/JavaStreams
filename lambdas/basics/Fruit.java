package lambdas.basics;

public class Fruit {
	private int weight;
	private String color;
	public String getColor() {
		return this.color;
	}

	public void setColor(String color) {
		this.color = color;
	}

	public int getWeight() {
		return this.weight;
	}

	public void setWeight(int weight) {
		this.weight = weight;
	}
	
	@Override
	public String toString() {
		// TODO Auto-generated method stub
		return this.getWeight() + "-" + this.getColor();
	}
}
