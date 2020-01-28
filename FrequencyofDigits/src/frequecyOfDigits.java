import java.util.Scanner;

public class frequecyOfDigits {
	public static void main(String[] args)
	{
		int [] frequencies = new int[10];
		while (true)
		{
			System.out.print("Enter a number>");
			Scanner input = new Scanner(System.in);
			if (input.hasNextInt())
			{
			
				int number = input.nextInt();
				countDigitFrequencies(number, frequencies);
				printDigitFrequencies(frequencies);
			}
			else
			{
				System.out.print("Error: Invalid input, must be an integer e.g. '5'.\n");
			}
		}
	}
	public static void countDigitFrequencies(int number, int [] frequencies)
	{
		int input = 0;
		do
		{
			number = Math.abs(number);
			input = number%10;
			number = number/10;
			frequencies [input] = frequencies [input]+1;
		}
		while (number != 0);
			
	}
	public static void printDigitFrequencies(int [] frequencies)
	{
		System.out.print("Digit frequencies:");
		for (int index=0; index < frequencies.length;index++)
		{
			if (frequencies [index] != 0)
			{
				System.out.print(index + "(" + frequencies[index] + ") ");
			}
		}
		System.out.print("\n");
	}
}
