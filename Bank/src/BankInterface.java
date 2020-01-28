import java.util.Date;

public interface BankInterface {
	
	public long CreateAccountNumber();
	public BankCustomer findCustomer(long accountNumber);
	public BankCustomer findAccount( String name, Date customerDateOfBirth, String address);
	public boolean debitAccount(long accountNumber, double debitAmount);
	public boolean creditAccount(long accountNumber, double creditAmount);
	public void printBalance(long accountNumber);
}
