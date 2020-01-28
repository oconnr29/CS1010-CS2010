import java.util.Scanner;

import javax.swing.JOptionPane;

public class Factorial
{
	public static void main(String[] args)
	{
		String input = JOptionPane.showInputDialog("Enter the number you want know is a factorian:");
		Scanner scanner = new Scanner( input );
		int number = scanner.nextInt();
		//if (isFactorian(number)==true)
		{
			int factorial = 0;
			int number2 = number;
			while (number>0)
			{
				factorial = number%10;
				number2 = number2%10;
				JOptionPane.showMessageDialog(null,number + "is a Factorian because " + number2 + "+ " + factorial +"!");
				
			}
		}
		scanner.close();
	}
	public static int computeFactorial(int input)
	{
		int answer= 1;
		if (input>0)
		{
			answer = computeFactorial(input-1)*input;
		}		
		return answer;
	}
	public static boolean isFactorian(int input)
	{
		int factorian= 0;
		while (input>0)
		{
			int factorial = input%10;
			input = input%10;
			factorian = factorian + computeFactorial(factorial);
		}
		return (factorian == input);
	}
}
