package lambdas.basics;

import java.util.List;

import lambdas.basics.util.LambdaHelper;

public class ConsumerInterfaceLambda {

	public static void main(String[] args) {
		List<Mango> appleList = LambdaHelper.populateMangoList();
		forEach(appleList, (Mango a) -> System.out.println(a.getWeight() + " is the weight of the banana of color " + a.getColor()));

	}

	static <T> void forEach(List<T> myList, Consumer<T> consumer) {
		for (T t : myList) {
			consumer.accept(t);
		}
	}

	// take a param of Type T and consumes it , void return
	@FunctionalInterface
	public interface Consumer<T> {
		void accept(T t);
	}
}
