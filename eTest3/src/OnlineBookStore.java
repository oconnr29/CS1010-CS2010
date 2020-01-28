import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;

public class OnlineBookStore {
	public static int ISBN_INDEX = 0;
	public static int TITLE_INDEX = 1;
	public static int AUTHOR_INDEX = 2;
	public static int PUBLISHER_INDEX = 3;
	public static int PUBLISHER_YEAR_INDEX = 4;
	public static int QUANTITY_INDEX = 5;
	public static int PRICE_INDEX = 6;

	public static void main(String[] args) {
		ArrayList<Book> bookList = new ArrayList<Book>();
		try {
			FileReader fileReader = new FileReader("books");// Enter the entire
															// path of the file
															// if needed
			BufferedReader bufferedReader = new BufferedReader(fileReader);
			boolean endOfFile = false;
			while (!endOfFile) {
				String bookLine = bufferedReader.readLine();
				if (bookLine != null) {
					String[] bookData = bookLine.split(", ");
					String isbn = bookData[ISBN_INDEX];
					String title = bookData[TITLE_INDEX];
					String author = bookData[AUTHOR_INDEX];
					String publisher = bookData[PUBLISHER_INDEX];
					int publishYear = Integer.parseInt(bookData[PUBLISHER_YEAR_INDEX]);
					int quantity = Integer.parseInt(bookData[QUANTITY_INDEX]);
					double price = Double.parseDouble(bookData[PRICE_INDEX]);
					Book book = new Book(isbn, title, author, publisher, publishYear, quantity, price);
					bookList.add(book);

				} else {
					endOfFile = true;
				}
			}

			bufferedReader.close();
			fileReader.close();
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}

		printBookDetails(bookList);
		purchaseBook(bookList);
	}

	public static void printBookDetails(ArrayList<Book> booklist) {
		for (int i = 0; i < booklist.size(); i++) {
			System.out.println("Isbn: " + booklist.get(i).getIsbn() + "\nTitle: " + booklist.get(i).getTitle()
					+ "\nAuthor: " + booklist.get(i).getAuthor() + "\nPublisher: " + booklist.get(i).getPublisher()
					+ "\nPublished year: " + booklist.get(i).getPublishYear() + "\nQuanity: "
					+ booklist.get(i).getQuantity() + "\nPrice: $" + booklist.get(i).getPrice() + "\n");
		}
	}

	public static Book getBook(ArrayList<Book> booklist, String title) {
		Book book = null;
		for (int i = 0; i < booklist.size(); i++) {
			book = booklist.get(i);
			if (title.equals(book.getTitle())) {
				return book;
			}
		}
		return null;
	}

	public static void topUpCard(ChargeCard card, double amount) {
		if (card != null) {
			if (amount != 0) {
				card.topUpFunds(amount);
			}
		}
	}

	public static void purchaseBook(ArrayList<Book> booklist) {
		ChargeCard card = new ChargeCard();
		int funds = 0;
		System.out.print("Enter the funds (positive number) in your card: ");
		Scanner fundsInput = new Scanner(System.in);
		if (fundsInput.hasNextInt()) {
			funds = fundsInput.nextInt();
			topUpCard(card, funds);
			boolean finished = false;
			do {
				String title = null;
				System.out.print("Enter the book title you would like to purchase:");
				Scanner titleInput = new Scanner(System.in);
				if (titleInput.hasNext()) {
					do {
						title += titleInput.next();
						if (titleInput.hasNext())
							title += " ";
					} while (titleInput.hasNext());
				} else
					System.out.print("Error: Valid title not entered.");
				Book book = getBook(booklist, title);
				if (book != null) {
					if (book.getQuantity() > 0) {
						if (book.getPrice() < funds) {
							book.setQuantity(book.getQuantity() - 1);
							card.removeFunds(book.getPrice());
							boolean givenAnswer = false;
							do {
								System.out.print("Would you like to purchase another book ('yes' or 'no'):");
								Scanner purchaseInput = new Scanner(System.in);
								if (purchaseInput.hasNext()) {
									if (purchaseInput.hasNext("no")) {
										finished = true;
										givenAnswer = true;
									} else if (purchaseInput.hasNext("yes"))
										givenAnswer = true;
									else
										System.out.print("Error: Invalid input, please input either 'yes' or 'no'");
								}
							} while (!givenAnswer);
						}
						else{
							System.out.print("Error: Insuficent funds, would yyou like to add funds ('yes' or 'no')");
						Scanner addFundsInput = new Scanner(System.in);
						if(addFundsInput.hasNext("yes")){
							int funds2 = 0;
							System.out.print("Enter the funds (positive number) you would like to add to your card: ");
							Scanner addFundInput = new Scanner(System.in);
							if (addFundInput.hasNextInt()) {
								funds2 = addFundInput.nextInt();
								topUpCard(card, funds2);
							}else
								System.out.print("Error: positive number not entered.");
						}
						}
					}
				}
				else
					System.out.print("Error: Title not found.");
			} while (!finished);
		} else
			System.out.print("Error: positive number not entered.");
	}
}
