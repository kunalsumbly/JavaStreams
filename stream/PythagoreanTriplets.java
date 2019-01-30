package stream;

import java.util.stream.IntStream;
import java.util.stream.Stream;

public class PythagoreanTriplets {
	public static void main(String[] args) {
		// be mindful of the fact of double vs int return type of the array
		// for int return type of the array , Math.sqrt(a*a + b*b) return double which loses precision when casting to int
		// and this causes issue when computing this condition-->   Math.sqrt(a*a + b*b) % 1 == 0
		
		// case 1 when , when we are doing filter first and then map is applied , in this case sqrt is computed 2 times.
		Stream<int[]> pythagoreanTriplets = IntStream.rangeClosed(1, 100).boxed()
				.flatMap(a -> 
					IntStream.rangeClosed(a, 100)
						.filter(b -> Math.sqrt(a * a + b * b) % 1 == 0).mapToObj(b -> new int[] { a, b, (int) Math.sqrt(a * a + b * b) }));
		
		pythagoreanTriplets.limit(6).forEach(a-> System.out.println(a[0]+","+a[1]+","+a[2]));
		
		
		
		// Case 2 when, we are doing the map first and computing the a,b,c triplets , here while calculating c it has to be double and not int
		// and then after this we apply the filter to only select those triplets which meet the condition where c %1 == 0 i.e is an integer
		Stream<double[]> pythagoreanTriplets2 = IntStream.rangeClosed(1, 100).boxed()
				.flatMap(a -> 
						IntStream.rangeClosed(a, 100)
						.mapToObj(
									b -> { 
										//System.out.println(a+"-------"+b+"------"+ Math.sqrt(a * a + b * b));
											//return new int[] { a, b, (int) Math.sqrt(a * a + b * b) };
										 return new double[] { a, b,  Math.sqrt(a * a + b * b) };
										})
						.filter(c -> {
							//System.out.println(b[0]+"-"+b[1]+"-"+b[2]);
							return (c[2] % 1==0 );
									}));

     pythagoreanTriplets2.limit(10).forEach(b-> System.out.println("::::::::::::::::::::"+b[0]+","+b[1]+","+b[2]));

		
	}

}
