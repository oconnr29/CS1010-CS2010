
/* SELF ASSESSMENT 

1. ResolveBet

I have correctly defined ResolveBet which takes the bet type (String) and the Wallet object, and a void return type [Mark out of 7: 7].
Comment: The resolveBet definition line has all of the above.
My program presents the amount of cash in the wallet and asks the user how much he/she would like to bet [Mark out of 8: 8].
Comment:The program does tell them the amount of cash they have and asks how much they would like to bet.
My program ensures the bet amount is not greater than the cash in the wallet [Mark out of 5: 5].
Comment:The code does make sure the bet is not bigger then the amount in their wallet.
My program creates three Dice objects, rolls them and creates a total variable with a summation of the roll values returned [Mark out of 15: 15]..
Comment: The code has 3 separate die objects, rolls them and has a total variable with a summation of the roll values returned.
My program determines the winnings by comparing the bet type with the total and comparing the bet type with the dice faces for the triple bet [Mark out of 20: 20].
Comment:The code does compare the total and/or face values with the bet type.
My program outputs the results (win or loss) and adds the winnings to the wallet if user wins or removes the bet amount from the wallet if the user loses [Mark out of 10: 10].
Comment: The code outputs the result and adds winnings / removes bet from the wallet.

2. Main

I ask the user for the amount of cash he/she has, create a Wallet object and put this cash into it [Mark out of 15: 15]
Comment: I did ask if they wanted to add cash, created a wallet object and put the cash into this.
My program loops continuously until the user either enters quit or the cash in the wallet is 0 [Mark out of 5: 4]
Comment: My code does not terminate when the wallet is 0, this is by design as I wanted the user to continuously be able to add cash to their wallet.
I ask the user to enter any of the four bet types or quit [Mark out of 5: 5].
Comment: I did ask for their bet type.
My program calls resolveBet for each bet type entered [Mark out of 5: 5].
Comment: It does call resolveBet for each bet type entered.
At the end of the game my program presents a summary message regarding winnings and losses [Mark out of 5: 5]
Comment:A summary is presented at the end of the game.

 Total Mark out of 100 (Add all the previous marks):99
*/
import java.util.Scanner;

public class ChuckALuck {
	public static void main(String[] args) {
		Wallet wlt = new Wallet();
		boolean finishedGame = false;
		boolean enteredAmount = false;
		double money = 0;
		do {
			money = 0;
			while (!enteredAmount) {
				System.out.print("Enter the amount of cash would you like "
						+ "to add to your wallet or type 'quit' to quit (type '0' if you don't want to add cash):");
				Scanner wallet = new Scanner(System.in);
				if (wallet.hasNextInt()) {
					money = money + wallet.nextInt();
					enteredAmount = true;
				} else if (wallet.hasNext("quit")) {
					finishedGame = true;
					enteredAmount = true;
				} else
					System.out.print("Invalid input: Amount must be a digit e.g. '5'.\n");
			}
			if (!finishedGame) {
				wlt.put(money);
				String betType = "";
				System.out.print("You can now place a bet e.g. 'triple' or type 'quit' to quit:");
				Scanner bet = new Scanner(System.in);
				if (bet.hasNext("triple") || bet.hasNext("field") || bet.hasNext("high") || bet.hasNext("low")) {
					betType = bet.next();
					resolveBet(betType, wlt);
					enteredAmount = false;
				} else if (bet.hasNext("quit"))
					finishedGame = true;
				else
					System.out.print("Invalid input: Bet type must be either 'triple', 'field', 'high' or 'low'.\n");
			}
		} while (!finishedGame);
		System.out.print("Your final amount is " + wlt.check() + ". The amount you put in was " + money);
		if (money < wlt.check()) {
			System.out.print(", which means you made a profit of " + (wlt.check() - money) + ".");
		} else if (money > wlt.check()) {
			System.out.print(", which means you made a loss of " + (money - wlt.check()) + ".");
		} else if (money == wlt.check()) {
			System.out.print(", which means you broke even.");
		}
	}

	public static void resolveBet(String betType, Wallet wlt) {
		boolean enteredAmount = false;
		double money = 0;
		do {
			System.out.print("You now have " + wlt.check() + " in your wallet, enter how much would you like to bet:");
			Scanner bet = new Scanner(System.in);
			if (bet.hasNextInt()) {
				money = bet.nextInt();
				if (money <= wlt.check()) {
					if (money>0) {
						enteredAmount = true;
						wlt.get(money);
					} else
						System.out.print("Invalid input: Your bet must be more then 0.\n");
				} else
					System.out.print("Invalid input: Your max bet is " + wlt.check() + ".\n");
			} else
				System.out.print("Invalid input: Amount must be a digit e.g. '5'.\n");
		} while (!enteredAmount);
		Dice die = new Dice();
		int die1 = die.roll();
		int die2 = die.roll();
		int die3 = die.roll();
		int total = die1 + die2 + die3;
		System.out.print("The dice have been rolled, the first die is a " + die1 + ", the second die is a " + die2
				+ ", the third die is a " + die3 + ", this gices you a total of " + total + ".\n");
		if (betType.equalsIgnoreCase("triple")) {
			if (die1 == die2 && die1 == die3 && die1 != 1 && die1 != 6) {
				money = money * 31;
				wlt.put(money);
				System.out.print("Congratulations, you won " + money + " your new balance is " + wlt.check() + ". \n");
			} else
				System.out.print("Unfortunatly you have lost.\n");
		} else if (betType.equalsIgnoreCase("field")) {
			if (total < 8 || total > 12) {
				money = money * 2;
				wlt.put(money);
				System.out.print("Congratulations, you won " + money + " your new balance is " + wlt.check() + ". \n");
			} else
				System.out.print("Unfortunatly you have lost.\n");
		} else if (betType.equalsIgnoreCase("high")) {
			if (total > 10 && !(die1 == die2 && die1 == die3)) {
				money = money * 2;
				wlt.put(money);
				System.out.print("Congratulations, you won " + money + " your new balance is " + wlt.check() + ". \n");
			} else
				System.out.print("Unfortunatly you have lost.\n");
		} else if (betType.equalsIgnoreCase("low")) {
			if (total < 11 && !(die1 == die2 && die1 == die3)) {
				money = money * 2;
				wlt.put(money);
				System.out.print("Congratulations, you won " + money + " your new balance is " + wlt.check() + ". \n");
			} else
				System.out.print("Unfortunatly you have lost.\n");
		}
	}
}
