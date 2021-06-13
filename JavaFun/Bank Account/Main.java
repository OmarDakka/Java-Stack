
public class Main {

	public static void main(String[] args) {
		BankAccount Ibrahim = new BankAccount();
		System.out.println(Ibrahim.getAccountNumber());
		System.out.println(BankAccount.getNumberOfAccounts());
		Ibrahim.setCheckingBalance(36);
		System.out.println(Ibrahim.getCheckingBalance());
		System.out.println(BankAccount.getAmountSaved());
	}

}
