import java.util.Scanner;

public class SumAndAverage {

	public static void main(String[] args) {
		int total = 0;
		int numberCount = 0;
		boolean finished = false;
		do
		{
			Scanner input = new Scanner( System.in );
			System.out.print("Enter a whole number (or type 'exit'): ");
			if (input.hasNextInt())
			{
				total += input.nextInt();
				numberCount++;
				finished = true;
			}
			else if (input.hasNext("exit"))
			{
				finished = true;
			}
			else 
			{
				System.out.println("Not a valid whole number.  Try again.");
			}
			input.close();
		} while (!finished);
		
		if (numberCount > 0)
		{
			double average = ((double) total) / ((double) numberCount);
			System.out.println("Total is " + total + ".  Average is " + average);
		}
		else System.out.println("No numbers entered.");
	}

}