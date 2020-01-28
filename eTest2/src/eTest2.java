import java.util.Scanner;

public class eTest2
{
	public static void main(String[] args)
	{
		while (true)
		{	
			System.out.print("Enter the Arabic number to be converted>");
			Scanner input = new Scanner(System.in);
			int number = input.nextInt();
			if (canBeConvertedToRoman(number))
			{
				System.out.println(convertToRoman(number));
			}
			else
			{
				System.out.print("Error: Invalid input, enter positive whole number between 1 and 4,999");
			}
		}
	}
	public static boolean canBeConvertedToRoman(int number)
	{
		boolean canBeConverted = false;
		if (number>0 && number<5000)
		{
			canBeConverted = true;
		}
		return canBeConverted;
	}
	public static String convertToRoman(int number)
	{
		String roman = "";
		if (number%10>=4 && number%10<9)
		{
			roman = "V";
		}
		if (number%10 == 4)
		{
			roman = "I" + roman;
		}
		else if (number%10 == 9)
		{
			roman = "IX";
		}
		else
		{
			for (int index=1; index<=number%5; index++)
			{
				roman = "I" + roman;
			}
		}
		number = number/10;
		if (number%10>=4 && number%10<9)
		{
			roman = "L" + roman;
		}
		if (number%10 == 4)
		{
			roman = "X" + roman;
		}
		else if (number%10 == 9)
		{
			roman = "XC" + roman;
		}
		else
		{
			for (int index=1; index<=number%5; index++)
			{
				roman ="X" + roman;
			}
		}
		number = number/10;
		if (number%10>=4 && number%10<9)
		{
			roman = "D" + roman;
		}
		if (number%10 == 4)
		{
			roman = "C" + roman;
		}
		else if (number%10 == 9)
		{
			roman = "CM" + roman;
		}
		else
		{
			for (int index=1; index<=number%5; index++)
			{
				roman ="C" + roman;
			}
		}
		number = number/10;
		for (int index=1; index<=number%5; index++)
		{
			roman ="M" + roman;
		}
		return roman;
	}
}

