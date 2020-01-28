public class BankApplication {

	
	public static void main(String[] args) {
		Bank bank = new Bank();
		bank.readCustomerFromFile();
		Long [] accountNumber = bank.getAllCustomerAccountNumbers();
		for (long account: accountNumber) {
			System.out.println(account);
		}
		Scanner userInput = ;
		System.out.print("");
	}
}
