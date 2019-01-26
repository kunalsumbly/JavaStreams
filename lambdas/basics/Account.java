package lambdas.basics;

public class Account {
	public String accountId;
	public String accountName;
	public String accountType;
	public String accountBalance;

	public Account() {
	}

	public Account(String account_id, String account_name, String account_type, String account_balance) {
		this.accountId = account_id;
		this.accountName = account_name;
		this.accountType = account_type;
		this.accountBalance = account_balance;
	}
	@Override
	public String toString() {
		// TODO Auto-generated method stub
		return "accountType"+accountType+"::accountId"+accountId+"::accountBalance"+accountBalance+"::accountName"+accountName;
	}
}
