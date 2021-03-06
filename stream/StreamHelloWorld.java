package stream;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import lambdas.basics.Account;
import lambdas.basics.AccountType;

public class StreamHelloWorld {
	public static void main(String[] args) {
		
		List<Account> myList = new ArrayList<Account>();
		Account account1 = new Account("1", "KUSU001", AccountType.SAVING.name(), "1000");
		Account account2 = new Account("2", "KUSU002", AccountType.TRADING.name(), "100");
		Account account3 = new Account("3", "KUSU003", AccountType.RECURRING.name(), "999");
		Account account4 = new Account("4", "KUSU004", AccountType.SAVING.name(), "1000");
		Account account5 = new Account("5", "KUSU005", AccountType.SAVING.name(), "100");
		Account account6 = new Account("6", "KUSU006", AccountType.RECURRING.name(), "1000");
		Account account7 = new Account("7", "KUSU007", AccountType.RECURRING.name(), "1000");
		Account account8 = new Account("8", "KUSU008", AccountType.RECURRING.name(), "1000");
		Account account9 = new Account("9", "KUSU009", AccountType.RECURRING.name(), "1000");
		Account account10 = new Account("10", "KUSU010", AccountType.RECURRING.name(), "1000");
		Account account11 = new Account("11", "KUSU011", AccountType.SAVING.name(), "1000");
		Account account12 = new Account("12", "KUSU012", AccountType.TRADING.name(), "1000");
		Account account13 = new Account("13", "KUSU013", AccountType.TRADING.name(), "1000");
		Account account14 = new Account("14", "KUSU0014", AccountType.TRADING.name(), "1000");
		Account account15 = new Account("15", "KUSU0015", AccountType.TRADING.name(), "1000");
		Account account16 = new Account("16", "KUSU0016", AccountType.SAVING.name(), "1000");
		Account account17 = new Account("17", "KUSU0017", AccountType.TRADING.name(), "1000");
		Account account18 = new Account("18", "KUSU0018", AccountType.RECURRING.name(), "1000");
		Account account19 = new Account("19", "KUSU0019", AccountType.SAVING.name(), "1000");
		
		
		myList.add(account1);
		myList.add(account10);
		myList.add(account11);
		myList.add(account12);
		myList.add(account13);
		myList.add(account14);
		myList.add(account15);
		myList.add(account16);
		myList.add(account17);
		myList.add(account18);
		myList.add(account19);
		myList.add(account2);
		myList.add(account3);
		myList.add(account4);
		myList.add(account5);
		myList.add(account6);
		myList.add(account7);
		myList.add(account8);
		myList.add(account9);
		
		
		// Filter only Savings Account Types
		// In this case filter() accepts the parameter which take input d and return boolean , which is of type Predicate<T> T -> boolean
		// forEach() accepts a parameter and does not return anything and simply prints out , hence is of type Consumer<T> T-> void
		myList.stream().filter(d -> d.accountType.equals(AccountType.SAVING.name())).collect(Collectors.toList())
				.forEach(s -> System.out
						.println(s.accountId + ":" + s.accountName + ":" + s.accountType + ":" + s.accountBalance));
		//filter RECURRING Saving Account Type List
		List<Account> recurringList = myList.stream().filter(d-> d.accountType.equals(AccountType.RECURRING.name())).collect(Collectors.toList());
		assert recurringList.size() == 7; 
	

		// SUM OF ALL THE RECURRING ACCOUNTS
		/*myList.stream().filter(d -> d.accountType.equals(AccountType.RECURRING.name())).collect(Collectors.toList())
				.forEach(a -> {
					int sumRecurringAccounts = 0;
					sumRecurringAccounts = Integer.valueOf(a.accountBalance) + sumRecurringAccounts;
				});*/
		
		Integer finalSumOfRecurringAccounts = myList.stream()
				.filter(d -> d.accountType.equals(AccountType.RECURRING.name()))
				.map(a -> Integer.valueOf(a.accountBalance)).reduce(0, (a, b) -> a + b);
		System.out.println("Sum::"+finalSumOfRecurringAccounts);
		Optional<Integer> finalSumOfRecurringAccountsOptional = myList.stream()
				.filter(d -> d.accountType.equals(AccountType.RECURRING.name()))
				.map(a -> Integer.valueOf(a.accountBalance)).reduce((a, b) -> a + b);
		finalSumOfRecurringAccountsOptional.ifPresent(a-> System.out.println(a));
		
	}
	
}
