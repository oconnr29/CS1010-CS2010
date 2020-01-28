import java.util.Scanner;
public class ValidDate {
	public static final int DAYS_IN_APRIL_JUNE_SEPT_NOV = 30;
	public static final int DAYS_IN_FEBRUARY_NORMALLY = 28;
	public static final int DAYS_IN_FEBRUARY_IN_LEAP_YEAR = 29;
	public static final int DAYS_IN_MOST_MONTHS = 31;
	public static final int NUMBER_OF_MONTHS = 12;
	public static void main(String[]args )
	{
		System.out.print("Enter your date in the form(DD/MM/YYYY):");
		Scanner userInput = new Scanner(System.in);
		userInput.useDelimiter("/");
		int day = userInput.nextInt();
		int month = userInput.nextInt();
		int year = userInput.nextInt();
		boolean date = validDate(day, month, year);
		int dateInMonth  = daysInMonth(month, year);
		boolean leapYear = isLeapYear(year);
		if(date&&leapYear)
		{
			System.out.print("The date "+userInput+"is a valid date.");
		}
		else System.out.print("The date "+userInput+"is not a valid date.");
	}
	public static boolean validDate(int day, int month, int year)
	{
		return true;
	}
	public static int daysInMonth(int month, int year)
	{
		return 28;
	}
	public static boolean isLeapYear(int year)
	{
		return true;
	}
}
