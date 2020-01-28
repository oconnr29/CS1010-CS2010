import java.io.*;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.*;

public class Bank implements BankInterface {
	long account;
	public Map<Long, BankCustomer> customerMap;

	public static
	// static BankCustomer[] bankCustomerArray = new BankCustomer[100];
	// static List<BankCustomer> customerList = new ArrayList<BankCustomer>();
	public Bank() {
		account = 1001;
		customerMap = new HashMap<Long, BankCustomer>();
	}

	public static void main(String[] args) throws Exception {
		FileReader fr = new FileReader("customers");
		BufferedReader br = new BufferedReader(fr);
		int i;
		while ((i = br.read()) != -1) {
			System.out.println((char) i);
		}
	}

	public BankCustomer findCustomer(int accountNumber) {
		BankCustomer customer = null;
		boolean customerFound = false;
		int counter = 0;
		return this.customerMap.get(accountNumber);
	}

	public BankCustomer findCustomer(String name, Date customerDateOfBirth, String customerAddress) {
		BankCustomer customer = null;
		boolean customerFound = false;
		int index = 0;
		while (customerFound && index < customerMap.size()) {
			customer = customerMap.get(index);
			if (name == customer.getCustomerName() && customerDateOfBirth == customer.getCustomerDateOfBirth()
					&& customerAddress == customer.getCustomerAddress()) {
				customerFound = true;
			}
			index++;
		}
		return (customer);
	}

	@Override
	public long CreateAccountNumber() {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public BankCustomer findCustomer(long accountNumber) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public BankCustomer findAccount(String name, Date customerDateOfBirth, String address) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public boolean debitAccount(long accountNumber, double debitAmount) {
		BankCustomer customer = findCustomer(accountNumber);
		boolean accountDebited = false;
		double balance = customer.getBalance();
		if (balance >= debitAmount) {
			customer.setBalance(balance - debitAmount);
			// Transactions myTransaction = new Transactions(
			// );

			accountDebited = true;
		} else
			accountDebited = false;
		return accountDebited;
	}

	@Override
	public boolean creditAccount(long accountNumber, double creditAmount) {
		// TODO Auto-generated method stub
		BankCustomer customer = findCustomer(accountNumber);
		double balance = customer.getBalance();
		customer.setBalance(balance + creditAmount);
		return false;
	}

	@Override
	public void printBalance(long accountNumber) {
		// TODO Auto-generated method stub
		BankCustomer customer = findCustomer(accountNumber);
		System.out.println(customer.getBalance());
	}

	public void printStatement(long accountNumber) {
		BankCustomer customer = findCustomer(accountNumber);
		ArrayList<Transactions> transactionList = customer.getCustomerTransactions();
		for (int counter = 0; counter < transactionList.size(); counter++) {
			Transactions customerTransaction = transactionList.get(counter);
			System.out.println(customerTramsaction.toString());
		}
	}

	public Long[] getAllCustomerAccountNumbers() {
		Long[] customerAccountNumbers = new Long[customerMap.keySet().size()];
		customerAccountNumbers = customerMap.keySet().toArray(customerAccountNumbers);
		return customerAccountNumbers;
	}

	public void createCustomer(String name, String address, String email, String dateOfBirth) {
		long accountNumber = createAccountNumber();
		DateFormat formatter = new SimpleDateFormat("dd-MM-yyyy");
		Date birthDate = null;
		try {
			birthDate = formatter.parse(dateOfBirth);
		} catch (ParseExecption e) {
			// TODO Auto-generated catch block
		}
		BankCustomer customer = new BankCustomer(accountNumber, SORT_CODE, name, address, email, birthDate,
				OPENING_BALANCE);
		customerMap.put(accountNumber, customer);
	}

	public void readCustomerFromFile() {
		
		try {
			FileReader fileReader = new FileReader("customers");
			BufferedReader bufferedReader = new BufferedReader(fileReader);
			boolean endOfFileFound = false;
			while(!endOfFileFound){
				String customerData = bufferedReader.readLine();
				if(customerData == null){
					endOfFileFound = true;
				}else {
					DateFormat formatter = new SimpleDateFormat("dd-MM-yyyy");
					String[] customerProperties = customerData.split(",");
					Date dateOfBirth = null;
					try {
					BankCustomer customer = new BankCustomer(
					Long.parseLong(customerProperties[0]),
					int.parseLong(customerProperties[1]),
					customerProperties[2],
					customerProperties[3],
					customerProperties[4],
					dateOfBirth,
					Double.parseDouble(customerProperties[6]));
					customerMap.put(customer.getAccountNumber(), customer);
				}
				}
			}
		}catch(FileNotFoundException e) {
			
		}catch(IOException e) {
			e.printStackTrace();
		}
	}

}
