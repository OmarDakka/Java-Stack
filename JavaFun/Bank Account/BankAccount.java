import java.util.Random;
public class BankAccount{
	private int accountNumber;
	private int checkingBalance;
	private Double savingsBalance;
	private static int NumberOfAccounts = 0;
	private static int amountSaved = 0;
	Random r = new Random();
	BankAccount() {
		NumberOfAccounts++;
		setAccountNumber(1000000000 + r.nextInt(1000000000-0));
	}
	public int getAccountNumber() {
		return accountNumber;
	}
	public void setAccountNumber(int accountNumber) {
		this.accountNumber = accountNumber;
	}
	public static int getNumberOfAccounts() {
		return NumberOfAccounts;
	}
	


//
//	public Double getSavingsBalance() {
//		return savingsBalance;
//	}
//
//	public void setSavingsBalance(Double savingsBalance) {
//		this.savingsBalance = savingsBalance;
//	}
//
	public void setCheckingBalance(int i) {
		checkingBalance += i;
		amountSaved+=checkingBalance;
	}
	
	public int getCheckingBalance() {
		return checkingBalance;
	}


//
//	public static int getNumberOfAccounts() {
//		return numberOfAccounts;
//	}
//
//	public static void setNumberOfAccounts(int numberOfAccounts) {
//		BankAccount.numberOfAccounts = numberOfAccounts;
//	}
//
	public static int getAmountSaved() {
		return amountSaved;
	}
//
//	public static void setAmountSaved(int amountSaved) {
//		BankAccount.amountSaved = amountSaved;
//	}
}