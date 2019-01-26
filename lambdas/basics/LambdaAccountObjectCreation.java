package lambdas.basics;

import java.util.HashMap;
import java.util.Map;

/**
 * This class shows how to create object by calling constructors in lambdas
 * @author kusu
 *
 */

public class LambdaAccountObjectCreation {

	public static Map<String, AccountFunction<String, String, String, String, Account>> accountMap = new HashMap<>();

	static {
		accountMap.put(AccountType.RECURRING.name(), Account::new);
		accountMap.put(AccountType.TRADING.name(), Account::new);
		accountMap.put(AccountType.SAVING.name(), Account::new);
	}

	@FunctionalInterface
	public interface AccountFunction<T, U, V, W, Account> {
		public Account apply(T t, U u, V v, W w);
	}

	public static Account getAccountObjectByType(String account_type, String account_name, String account_id,
			String account_balance) {
		return accountMap.get(account_type).apply(account_name, account_id, account_type, account_balance);

	}

	public static void main(String[] args) {
		//AccountFunction<String, String, String, String, Account> accountFactory = Account::new;
		lambdas.basics.Account recurring = getAccountObjectByType(AccountType.RECURRING.name(), "KUSU001",
				"ACCOUNTRECURRING123", "1000");
		System.out.println(recurring.toString());
		lambdas.basics.Account saving = getAccountObjectByType(AccountType.SAVING.name(), "KUSU002", "ACCOUNTSAVING123",
				"2000");
		System.out.println(saving.toString());
		lambdas.basics.Account trading = getAccountObjectByType(AccountType.TRADING.name(), "KUSU003",
				"ACCOUNTTRADING123", "3000");
		System.out.println(trading.toString());

	}

}
