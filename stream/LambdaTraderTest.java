package stream;

import java.util.Comparator;
import java.util.Optional;

import lambdas.basics.util.LambdaHelper;

public class LambdaTraderTest {
	public static void main(String[] args) {
		findTransactionsFrom2011andSortAscendingOrder();
		allUniqueCities();
		allTradersFromCambridgeSortedByName();
		allTradersNameSortedByName();
		anyTradersBasedinMilan();
		allTransactionValuesFromTradersInCambridge();
		highestValueOfAllTransactions();
		smallestValueOfAllTransactions();
		sumOfAllTransactionValues();
	}

	private static void sumOfAllTransactionValues() {
		Integer reduce = LambdaHelper.populateTransactionList().stream().map(d -> d.getValue()).reduce(0,
				(a, b) -> (a + b));
		System.out.println("Sum of all transactions" + reduce);
	}

	private static void smallestValueOfAllTransactions() {
		Optional<Transaction> min = LambdaHelper.populateTransactionList().stream()
				.min(Comparator.comparing(Transaction::getValue));
		min.ifPresent(d -> System.out.println("Smallest Value Transaction=" + d.getValue()));
		
		// another version
		Optional<Integer> reduce = LambdaHelper.populateTransactionList().stream().map(d -> d.getValue())
				.reduce(Integer::min);
		reduce.ifPresent(r -> System.out.println(r));
		
		// anotherVersion
		reduce = LambdaHelper.populateTransactionList().stream().map(d -> d.getValue())
				.reduce((a,b)-> a<b?a:b);
		reduce.ifPresent(r -> System.out.println(r));

	}

	private static void highestValueOfAllTransactions() {
		Optional<Transaction> max = LambdaHelper.populateTransactionList().stream()
				.max(Comparator.comparing(Transaction::getValue));
		max.ifPresent(d -> System.out.println("Highest Value Transaction=" + d.getValue()));
		
		// another version
		Optional<Integer> reduce = LambdaHelper.populateTransactionList().stream().map(d-> d.getValue()).reduce(Integer::max);
		reduce.ifPresent(r-> System.out.println(r));
		
		reduce = LambdaHelper.populateTransactionList().stream().map(d -> d.getValue())
				.reduce((a,b)-> a>b?a:b);
		reduce.ifPresent(r -> System.out.println(r));

	}

	private static void allTransactionValuesFromTradersInCambridge() {
		LambdaHelper.populateTransactionList().stream().filter(d -> d.getTrader().getCity().equals("Cambridge"))
				.forEach(d -> System.out.println("Transaction Value=" + d.getValue()));
	}

	private static void anyTradersBasedinMilan() {
		// my version
		LambdaHelper.populateTransactionList().stream().filter(d -> d.getTrader().getCity().equals("Milan")).findAny()
				.ifPresent(d -> System.out.println(d.getTrader().getName()));
		
		// another version
		boolean anyMatch = LambdaHelper.populateTransactionList().stream().anyMatch(d -> d.getTrader().getCity().equals("Milan"));
		
	}

	private static void allTradersNameSortedByName() {
		LambdaHelper.populateTransactionList().stream().map(d -> d.getTrader()).distinct()
				.sorted(Comparator.comparing(Trader::getName))
				.forEach(d -> System.out.println("Trader Name::" + d.getName() + "---Trade City::" + d.getCity()));
		
		String reduce = LambdaHelper.populateTransactionList().stream().map(d -> d.getTrader().getName()).distinct()
		.sorted().reduce("",(a,b)-> a+b);
		System.out.println(reduce);

	}

	private static void allTradersFromCambridgeSortedByName() {
		System.out.println("allTradersFromCambridgeSortedByName");
		// my version giving xtra duplicate row for Raoul, I went via Transaction --> trader and sicne there are 4 transaction records (1 trader has 2 transaction records hence getting an extra row)
		/*LambdaHelper.populateTransactionList().stream().filter(d -> d.getTrader().getCity().equals("Cambridge")).distinct()
				.map(d -> d.getTrader()).sorted(Comparator.comparing(Trader::getName))
				.forEach(d -> System.out.println("Trader Name::" + d.getName() + "---Trade City::" + d.getCity()));*/
		// actual answer
		LambdaHelper.populateTransactionList().stream().map(d -> d.getTrader())
				.filter(d -> d.getCity().equals("Cambridge")).distinct().sorted(Comparator.comparing(Trader::getName))
				.forEach(d -> System.out.println("Trader Name::" + d.getName() + "---Trade City::" + d.getCity()));
		System.out.println("allTradersFromCambridgeSortedByName");

	}

	private static void allUniqueCities() {
		LambdaHelper.populateTransactionList().stream().map(d -> d.getTrader().getCity()).distinct()
				.forEach(d -> System.out.println("city::" + d));

	}

	public static void findTransactionsFrom2011andSortAscendingOrder() {
		LambdaHelper.populateTransactionList().stream().filter(d -> d.getYear() == 2011)
				.sorted(Comparator.comparing(Transaction::getValue)).forEach(d -> System.out.println(d.getValue()));
	}

}
