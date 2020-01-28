import java.util.Scanner;
public class eTest 
{
	public static void main(String[]args)
	{
		boolean finished = false;
		int input = 0;
		int newNumber = 1;
		int oldNumber = 0;
		System.out.print("What number would you like closest Fibonacci number for:");
		Scanner userInput = new Scanner(System.in);
		if (userInput.hasNextInt())
		{
		input = userInput.nextInt();
		}
		do
		{
			while (input>=newNumber)
			{
					oldNumber = oldNumber + newNumber;
					newNumber = oldNumber + newNumber;
			}
			if (newNumber-input == oldNumber-input)
			{
				System.out.println("The closest Fibonacci number to "+input+" are "+newNumber+" and"+oldNumber+".");
			}
			if (newNumber-input<oldNumber-input)
			{
				System.out.println("The closest Fibonacci number to "+input+" is "+newNumber+".");
			}
			else if (newNumber-input>oldNumber-input)
			{
				System.out.println("The closest Fibonacci number to "+input+" is "+oldNumber+".");
			}
			else if(userInput.next("Exit") != null)
			{
				finished = true;
			}
			else {System.out.print("Error: invalid input");}
			System.out.print("What number would you like closest Fibonacci number for:");
			userInput = new Scanner(System.in);
			if (userInput.hasNextInt())
			{
			input = userInput.nextInt();
			}
			newNumber = 1;
			oldNumber = 0;
		}
		while (!finished);
		userInput.close();
	}
}
