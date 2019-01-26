package lambdas.basics;

import java.util.function.Function;

public class LambdaComposeFunctions {

	public static void main(String[] args) {
		Letter letter = new Letter();
		//basicFormatting(letter);
		
		Function<String,String> addHeaderLambda = Letter::addHeader ;
		Function<String,String> addFooterLambda = Letter::addFooter;
		Function<String, String> transformPipeline = addHeaderLambda.andThen(addFooterLambda);
		System.out.println(transformPipeline.apply("I am good, we are using lambda ")); // will first apply header and then apply footer , chaining functions
		
		
		Function<Integer,Integer> additonLambda = i -> i+1;
		Function<Integer,Integer> multiplyLambda = i->i*2;
		Function<Integer,Integer>  squareLambda = i->i*i;
		Function<Integer, Integer> compose2 = multiplyLambda.compose(additonLambda);
		System.out.println(compose2.apply(5));
		Function<Integer, Integer> compose3 = additonLambda.compose(multiplyLambda);
		System.out.println(compose3.apply(5));
		Function<Integer, Integer> compose4 = multiplyLambda.andThen(additonLambda).andThen(squareLambda);
		System.out.println(compose4.apply(5));
		
	
	}

	public static void basicFormatting(Letter letter) {
		String addHeader = letter.addHeader(" How are you::::");
		String addFooter = letter.addFooter(addHeader);
		System.out.println(addFooter);
	}

	static class Letter {

		static String addHeader(String text) {

			return "From Kunal, This is the header" + text;
		}

		static String addFooter(String text) {
			return text + "Thanks Regards, This is the footer";
		}
	}

}
