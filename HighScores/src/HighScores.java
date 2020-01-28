/* SELF ASSESSMENT
 1. Did I use easy-to-understand meaningful variable names formatted properly (in lowerCamelCase)?
        Mark out of 5: 5
        Comment: I used easy-to-understand meaningful variable names formatted properly.
 2. Did I indent the code appropriately?
        Mark out of 5: 5
        Comment: I indented the code appropriately.
 3. Did I write the initialiseHighScores function correctly (parameters, return type and function body) and invoke it correctly?
       Mark out of 15: 15
        Comment: I wrote the initialiseHighScores function correctly (parameters, return type and function body) and invoked it correctly.
 4. Did I write the printHighScores function correctly (parameters, return type and function body) and invoke it correctly?
       Mark out of 15: 15
        Comment: I wrote the printHighScores function correctly (parameters, return type and function body) and invoked it correctly.
 5. Did I write the higherThan function correctly (parameters, return type and function body) and invoke it correctly?
       Mark out of 15: 15
        Comment: I wrote the higherThan function correctly (parameters, return type and function body) and invoked it correctly.
 6. Did I write the insertScore function correctly (parameters, return type and function body) and invoke it correctly?
       Mark out of 20: 20
        Comment: I wrote the insertScore function correctly (parameters, return type and function body) and invoked it correctly.
 7. Did I write the main function body correctly (first asking for the number of scores to be maintained and then repeatedly asking for scores)?
       Mark out of 20: 20
        Comment: I write the main function body correctly.
 8. How well did I complete this self-assessment?
        Mark out of 5: 5
        Comment: I completed the self-assessment to the best of my ability.
 Total Mark out of 100 (Add all the previous marks): 100
*/ 
import java.util.Scanner;

public class HighScores
{
	public static void main(String[] args)
	{
		try
		{
			boolean finished = false;
			System.out.print("Enter how many scores you want to maintain:");
			Scanner input = new Scanner(System.in);
			int listLength = input.nextInt();
			int [] highScores = new int[listLength];
			initialiseHighScores (highScores);
			do
			{
				System.out.print("Enter a score or type 'exit' to exit:");
				Scanner userInput = new Scanner(System.in);
				int newScore = 0;
				if (userInput.hasNextInt())
				{
					newScore = userInput.nextInt();
					if (higherThan(highScores,newScore))
					{
						insertScore(highScores, newScore);
						System.out.print("Your new Scoreboard is: ");
						printHighScores(highScores);
					}
				}
				else if (userInput.hasNext("exit") || userInput.hasNext("'exit'"))
				{
					System.out.print("Your final Scoreboard is: ");
					printHighScores(highScores);
					System.out.println("Goodbye.");
					finished = true;
					userInput.close();
					input.close();
				}
				else
				{
					System.out.println("Error: invalid input, type a whole number e.g.'5'.");
				}
			}
			while (finished!= true);
		}
		catch (java.util.InputMismatchException exception)
		{
			System.out.println("Error: invalid input, must be a whole number e.g.'5'.");	
		}
		catch (java.lang.NegativeArraySizeException exception)
		{
			System.out.println("Error: invalid input, mucst be a positive number e.g.'5'.");
		}
		catch (java.lang.OutOfMemoryError exception)
		{
			System.out.println("Error: invalid input, cannot store that many scores.");
		}
	}
	public static void initialiseHighScores (int [] highScores)
	{
		for (int index=0; index<highScores.length; index++)
		{
			highScores[index] = 0 ;
		}
	}
	public static void printHighScores(int [] highScores)
	{
		for (int index=0; index<highScores.length; index++)
		{
			if (index==0)
			{
				System.out.print(highScores[index]);
			}
			else
			{
				System.out.print(", " + highScores[index]);
			}
		}
		System.out.print(".\n");
	}
	public static boolean higherThan(int [] highScores, int newScore)
	{
		boolean newHighScore = false;
			if (newScore > highScores[highScores.length-1])
			{
				newHighScore = true;
			}
		return newHighScore;
	}
	public static void insertScore(int [] highScores, int newScore)
	{
		int place = 0;
		while (newScore <= highScores[place])
		{
			place++;
		}
		for (int index=highScores.length-1; index>place; index--)
			{
				highScores[index] = highScores[index-1];
			}
		highScores[place] = newScore;
	}
}
