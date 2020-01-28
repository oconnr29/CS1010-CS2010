/* SELF ASSESSMENT 
   1. Did I use easy-to-understand meaningful variable names? 
       Mark out of 10: 10
   2. Did I format the variable names properly (in lowerCamelCase)? 
       Mark out of 5: 5
   3. Did I indent the code appropriately? 
       Mark out of 10: 10
   4. Did I input the numbers one at a time from the command line?
       Mark out of 10:  10
   5. Did I check the input to ensure that invalid input was handled appropriately?
       Mark out of 10: 10 
   6. Did I use an appropriate while or do-while loop to allow the user to enter numbers until they entered exit/quit?
       Mark out of 20:  20
   7. Did I implement the loop body correctly so that the average and variance were updated and output appropriately?
       Mark out of 30: 30 
   8. How well did I complete this self-assessment? 
       Mark out of 5: 5
   Total Mark out of 100 (Add all the previous marks): 100
*/
import java.util.Scanner;

public class IncrementalStatistics {
	public static void main(String[] args) {
		double oldAverage = 0;
		double variance = 0;
		int count = 0;
		double number = 0;
		double newAverage = 0;
		
		Scanner input = new Scanner( System.in );
		System.out.print("Enter a number (or type 'exit'):");
		if (input.hasNextDouble())
		{
			do
			{
				oldAverage = newAverage;
				count++;
				number = input.nextDouble();
				newAverage = oldAverage + ((number-oldAverage)) / count;
				variance = ((variance * (count-1)) + (number - oldAverage)*(number - newAverage))/count;
				System.out.println("The average so fare is " + newAverage + " and your variance is " + variance + ".");
				System.out.print("Enter a number (or type 'exit'):");
			}	
			while (input.hasNextDouble());
			input.close();
			}
		else if (input.hasNext("exit") || input.hasNext("'exit'"))
		{
			System.out.println("Goodbye.");
		}
		else System.out.println("Error: invalid input e.g. '5' or 'exit'.");
		input.close();
}
}