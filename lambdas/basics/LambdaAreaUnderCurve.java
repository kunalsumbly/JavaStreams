package lambdas.basics;

import java.util.function.Function;

public class LambdaAreaUnderCurve {

	public static void main(String[] args) {
		Double areaOfTheFunctionUnderCurve = integrate(x->x+10, 3.0, 7.0);  // f(x) = x+10 and x=3 and x= 7
		System.out.println("area of the linear function= "+areaOfTheFunctionUnderCurve);
		 areaOfTheFunctionUnderCurve = integrate(x->x-4, 3.0, 7.0);  // f(x) = x+10 and x=3 and x= 7
		System.out.println("area of the linear function= "+areaOfTheFunctionUnderCurve);
	}

	static Double integrate(Function<Double, Double> f, Double a, Double b) {
		
		/**
		 * f.apply(a) --> calculates y when x=a
		 * f.apply(b) --> calculates y when x=b
		 */
		return (f.apply(a) + f.apply(b)) * (b-a) / 2; // area of trapezium under the curve between x=a and x=b

	}

}
