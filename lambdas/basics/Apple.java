package lambdas.basics;

public class Apple extends Fruit implements Comparable  {
	
	public Apple(Integer i){
		super.setWeight(i);
		super.setColor("Default");
	}

	public Apple(int p_weight, String p_color) {
		super.setWeight(p_weight);
		super.setColor(p_color);
	}

	/**
	 *
	 * https://stackoverflow.com/questions/26107921/what-determines-ascending-or-descending-order-in-comparator-comparable-collect
	 * 5
	 * 
	 * @DavidPrun Good question. I have tried explaining this with an example.
	 * 
	 *            (x,y) -> (2, 5)
	 * 
	 *            Ascending Order (x.compareTo(y)):
	 * 
	 *            if x.compareTo(y) == 1, then x > y , since y is smaller than
	 *            x, you would have to move y in front of x.
	 * 
	 *            2.compareTo(5) == -1 , then don't move 5 in front of 2.
	 * 
	 *            Descending Order (y.compareTo(x)):
	 * 
	 *            if y.compareTo(x) == 1, then y > x , since y is greater than
	 *            x, you would have to move y in front of x.
	 * 
	 *            5.compareTo(2) == 1 , move 5 in front of 2.
	 * 
	 *            Basically, we will always move y in front of x, if the result
	 *            of compareTo method is 1.
	 */
	@Override
	public int compareTo(Object o) {
		System.out.println("this.getWeight()" + this.getWeight());
		System.out.println("o.getWeight()" + ((Apple) o).getWeight());
		
		// param --> y --> gives descending order
		//return sortDescendingOrder(o); // y.CompareTo(x)
		//
		// param --> y --> gives ascending order
		return sortAscendingOrder(o); //-->	// x.CompareTo(y)
	}

	 //the below case is x.compareTo(y) where this object --> x and Object o
	public int sortAscendingOrder(Object o) {
		return this.getWeight() < ((Apple) o).getWeight() ? -1 : (this.getWeight() > ((Apple) o).getWeight() ? 1 : 0);
	}

	// the below case is y.compareTo(x) where this object --> x and Object o
	public int sortDescendingOrder(Object o) {
		return ((Apple) o).getWeight() > this.getWeight() ? 1 : (((Apple) o).getWeight() < this.getWeight() ? -1 : 0);
	}

	@Override
	public String toString() {
		// TODO Auto-generated method stub
		return this.getWeight() + "-" + this.getColor();
	}
}