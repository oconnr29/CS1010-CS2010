/* SELF ASSESSMENT 
   1. Did I use appropriate CONSTANTS instead of numbers within the code? 
       Mark out of 5:5
       Comment: I used appropriate CONSTANTS
   2. Did I use easy-to-understand, meaningful CONSTANT names formatted correctly in UPPERCASE? 
       Mark out of 5:5
       Comment: I used easy-to-understand, meaningful CONSTANT names formatted correctly in UPPERCASE
   3. Did I use easy-to-understand meaningful variable names? 
       Mark out of 10:10
       Comment:  I used easy-to-understand meaningful variable names
   4. Did I format the variable names properly (in lowerCamelCase)? 
       Mark out of 5:5
       Comment:  I formated the variable names properly
   5. Did I indent the code appropriately? 
       Mark out of 10:10
       Comment:  
   6. Did I use an appropriate loop to allow the user to enter their guesses until they win or lose? 
       Mark out of 20:  20
       Comment:  I used an appropriate loop to allow the user to enter their guesses until they win or lose
   7. Did I check the input to ensure that invalid input was handled appropriately? 
       Mark out of 10: 10
       Comment:  I checked the input to ensure that invalid input was handled appropriately
   8. Did I generate the cards properly using random number generation (assuming all cards are equally likely each time)? 
       Mark out of 10: 10
       Comment:  I generated the cards properly using random number generation
   9. Did I output the cards correctly as 2, 3, 4, ... 9, 10, Jack, Queen, King? 
       Mark out of 10: 10
       Comment: I generated the cards properly using random number generation 
   10. Did I report whether the user won or lost the game before the program finished? 
       Mark out of 10:10
       Comment:  I reported whether the user won or lost the game before the program finished
   11. How well did I complete this self-assessment? 
       Mark out of 5:5
       Comment: I completed it to the best of my ability.
   Total Mark out of 100 (Add all the previous marks): 100
*/
import java.util.Scanner;
import java.util.Random;

public class HiLoCardGame {
	public static final int GENERATOR_CORRECTION = 2;
	public static final int GAME_END = 4;
	public static void main(String[] args)
	{
		boolean finished = false;
		int newCard = 0;
		int count = 0;
		Random randomCard = new Random();
		newCard = randomCard.nextInt(13);
		newCard = newCard + GENERATOR_CORRECTION;
		Scanner input = new Scanner(System.in);
		boolean jack = (newCard == 11);
		boolean queen = (newCard == 12);
		boolean king = (newCard == 13);
		boolean ace = (newCard == 14);
		if (jack)
		{
			System.out.println("The card is a Jack\nDo you think the next card will be higher, lower or equal?");
		}
		else if (queen)
		{
			System.out.println("The card is a Queen\nDo you think the next card will be higher, lower or equal?");
		}
		else if (king)
		{
			System.out.println("The card is a King\nDo you think the next card will be higher, lower or equal?");
		}
		else if (ace)
		{
			System.out.println("The card is an ace\nDo you think the next card will be higher, lower or equal?");
		}
		else System.out.println("The card is a " + newCard + "\nDo you think the next card will be higher, lower or equal?");
		do 
		{
			if (count < GAME_END)
			{
				int oldCard = newCard;
				newCard = randomCard.nextInt(13);
				newCard = newCard + GENERATOR_CORRECTION;
				String userInput = input.next();
				if (userInput.equalsIgnoreCase("higher"))
				{
					if (newCard > oldCard)
					{
						finished = false;
					} 
					else
					{
						finished = true;
						jack = (newCard == 11);
						queen = (newCard == 12);
						king = (newCard == 13);
						ace = (newCard == 14);
						if (jack)
						{
							System.out.println("You lose. The card was a Jack.");
						}
						else if (queen)
						{
							System.out.println("You lose. The card was a Queen.");
						}
						else if (king)
						{
							System.out.println("You lose. The card was a King.");
						}
						else if (ace)
						{
							System.out.println("You lose. The card was an ace.");
						}
						else System.out.println("You lose. The card was a " + newCard + ".");
					}
				} 
				else if (userInput.equalsIgnoreCase("lower")) 
				{
					if (newCard < oldCard) 
					{
						finished = false;
					} 
					else 
					{
						finished = true;
						jack = (newCard == 11);
						queen = (newCard == 12);
						king = (newCard == 13);
						ace = (newCard == 14);
						if (jack)
						{
							System.out.println("You lose. The card was a Jack.");
						}
						else if (queen)
						{
							System.out.println("You lose. The card was a Queen.");
						}
						else if (king)
						{
							System.out.println("You lose. The card was a King.");
						}
						else if (ace)
						{
							System.out.println("You lose. The card was an ace.");
						}
						else System.out.println("You lose. The card was a " + newCard + ".");	
					}	
				} 
				else if (userInput.equalsIgnoreCase("equal")) 
				{
					if (newCard == oldCard) 
					{
						finished = false;
					}
					else 
					{
						finished = true;
						jack = (newCard == 11);
						queen = (newCard == 12);
						king = (newCard == 13);
						ace = (newCard == 14);
						if (jack)
						{
							System.out.println("You lose. The card was a Jack.");
						}	
						else if (queen)
						{
							System.out.println("You lose. The card was a Queen.");
						}
						else if (king)
						{
							System.out.println("You lose. The card was a King.");
						}
						else if (ace)
						{
							System.out.println("You lose. The card was an ace.");
						}
						else System.out.println("You lose. The card was a " + newCard + ".");
					}
				} 
				else 
				{
					System.out.println("Error: No valid entry, try again.");
					count--;
					newCard = oldCard;
				}
				if (finished == false && count < GAME_END - 1)
				{
					jack = (newCard == 11);
					queen = (newCard == 12);
					king = (newCard == 13);
					ace = (newCard == 14);
					if (jack)
					{
						System.out.println("The card is a Jack\nDo you think the next card will be higher, lower or equal?");
					}
					else if (queen)
					{
						System.out.println("The card is a Queen\nDo you think the next card will be higher, lower or equal?");
					}
					else if (king)
					{
						System.out.println("The card is a King\nDo you think the next card will be higher, lower or equal?");
					}
					else if (ace)
					{
						System.out.println("The card is an ace\nDo you think the next card will be higher, lower or equal?");
					}
					else System.out.println("The card is a " + newCard + "\nDo you think the next card will be higher, lower or equal?");
				}
			}
			else
			{	
				System.out.println("Congratulations. You got them all correct.");
				finished = true;
			}
			count++;
		} 
		while (!finished);
		input.close();
	}
}
