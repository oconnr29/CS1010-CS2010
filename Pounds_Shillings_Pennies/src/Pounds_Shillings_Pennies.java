/*  SELF ASSESSMENT
   1. Did I use appropriate CONSTANTS instead of numbers within the code?
       Mark out of 10:   10
   2. Did I use easy-to-understand, meaningful CONSTANT names?
       Mark out of 5:  10
    3. Did I format the CONSTANT names properly (in UPPERCASE)?
       Mark out of 5:  10
   4. Did I use easy-to-understand meaningful variable names?
       Mark out of 10:  9
   5. Did I format the variable names properly (in lowerCamelCase)?
       Mark out of 10:  10
   6. Did I indent the code appropriately?
       Mark out of 10:  8
   7. Did I read the input correctly from the user using (an) appropriate question(s)?
       Mark out of 10:  8
   8. Did I compute the answer correctly for all cases?
       Mark out of 20: 10 
   9. Did I output the correct answer in the correct format (as shown in the examples)?
       Mark out of 10:  10
   10. How well did I complete this self-assessment?
       Mark out of 10:  9
   Total Mark out of 100 (Add all the previous marks): 94 
*/
import java.text.DecimalFormat;
import java.util.Scanner;

import javax.swing.JOptionPane;
public class Pounds_Shillings_Pennies {
		public static final int NEW_PENNIES_PER_OLD_PENNIES = 67;
		public static final int NEW_PENNIES_PER_OLD_SHILLINGS = 804;
		public static final int NEW_PENNIES_PER_OLD_POUNDS = 16080;
		public static final int NEW_PENNIES_PER_NEW_POUNDS =100;
		public static void main(String[]args)
		{
		String input = JOptionPane.showInputDialog("Input amount in Pounds, Shillings and Pennies in format Pounds:Shillings:Pennies");
		Scanner inputScanner = new Scanner(input);
		inputScanner.useDelimiter(":");
		Double oldPound = inputScanner.nextDouble();
		Double shillings = inputScanner.nextDouble();
		Double oldPennies = inputScanner.nextDouble();
		inputScanner.close();
		Double pounds = Math.abs((oldPound*NEW_PENNIES_PER_OLD_POUNDS+shillings*NEW_PENNIES_PER_OLD_SHILLINGS+oldPennies*NEW_PENNIES_PER_OLD_PENNIES)/100.0);
		DecimalFormat twoDecimalPoint = new DecimalFormat("0.00");
		JOptionPane.showInputDialog("You have £"+twoDecimalPoint.format(pounds));
}
}