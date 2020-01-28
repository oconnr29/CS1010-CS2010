/* SELF ASSESSMENT
 1. Did I use appropriate, easy-to-understand, meaningful CONSTANT names formatted correctly in UPPERCASE?
        Mark out of 5: 5
        comment: I used appropriate, easy-to-understand, meaningful CONSTANT names formatted correctly in UPPERCASE.
 2. Did I use easy-to-understand meaningful variable names formatted properly (in lowerCamelCase)?
        Mark out of 5: 5
        comment:I used easy-to-understand meaningful variable names formatted properly (in lowerCamelCase).
 3. Did I indent the code appropriately?
        Mark out of 5: 5
        comment: I indented the code appropriately.
 4. Did I define the required function correctly (names, parameters & return type) and invoke them correctly?
       Mark out of 20: 20
        comment: I defined the required function correctly (names, parameters & return type) and invoke them correctly. 
 5. Did I implement the dayOfTheWeek function correctly and in a manner that can be understood?
       Mark out of 20: 20
        comment:  I implemented the dayOfTheWeek function correctly and in a manner that can be understood.
 6. Did I implement the other functions correctly, giving credit for any code that you take from elsewhere?
       Mark out of 20: 20
        comment:  I implemented the other functions correctly, giving credit for any code that I take from elsewhere below e Sef Assessment.
 7. Did I obtain (and process) the input from the user in the correct format (dd/mm/yyyy), and deal with any invalid input properly?
 Mark out of 10:10
 comment: I obtained (and processed) the input from the user in the correct format (dd/mm/yyyy), and dealt with any invalid input properly.
 8. Does the program produce the output in the correct format (e.g. Monday, 25th December 2017)?
       Mark out of 10: 10
        comment:  the program produced the output in the correct format (e.g. Monday, 25th December 2017).
 9. How well did I complete this self-assessment?
        Mark out of 5: 5
        comment: I complete this self-assessment to the best of my ability.
 Total Mark out of 100 (Add all the previous marks):100
*/ 
//Some of this code has been taken and modified from the ValidDate.java code on blackboard.
import java.util.Scanner;
import javax.swing.JOptionPane;
public class DayOfTheWeek
{
	public static final int DAYS_IN_APRIL_JUNE_SEPT_NOV = 30;
	public static final int DAYS_IN_FEBRUARY_NORMALLY = 28;
	public static final int DAYS_IN_FEBRUARY_IN_LEAP_YEAR = 29;
	public static final int DAYS_IN_MOST_MONTHS = 31;
	public static final int NUMBER_OF_MONTHS = 12;
	public static void main(String[] args)
	{
		try
		{
			String input = JOptionPane.showInputDialog("Enter date (day/month/year):");
			Scanner scanner = new Scanner( input );
			scanner.useDelimiter("/");
			int day = scanner.nextInt();
			int month = scanner.nextInt();
			int year = scanner.nextInt();

			if (validDate( day, month, year))
			{
				JOptionPane.showMessageDialog(null, dayOfTheWeek(day,month,year) + " " + date(day) + monthName( month) + " " + year + " is a valid date.");
			}
			else
			{
				JOptionPane.showMessageDialog(null, "" + day + "/" + month + "/" + year + " is not a valid date.","Error", JOptionPane.ERROR_MESSAGE);
			}
			scanner.close();
		}
		catch (NullPointerException exception)
		{
		}
		catch (java.util.NoSuchElementException exception)
		{
			JOptionPane.showMessageDialog(null, "No number entered.","Error", JOptionPane.ERROR_MESSAGE);
		}
	}
	public static boolean validDate( int day, int month, int year)
	{
		int numberOfDaysInMonth = DAYS_IN_MOST_MONTHS;
		switch (month)
		{
		case 2:
			numberOfDaysInMonth = ((year%4 == 0) && (year%100 != 0)) || (year%400 == 0) ? DAYS_IN_FEBRUARY_IN_LEAP_YEAR : DAYS_IN_FEBRUARY_NORMALLY;
			break;
		case 4:
		case 6:
		case 9:
		case 11:
			numberOfDaysInMonth = DAYS_IN_APRIL_JUNE_SEPT_NOV;
			break;
		default:
			numberOfDaysInMonth = DAYS_IN_MOST_MONTHS;
			break;
		}
		return ((year >= 0) && (month >= 1) && (month <= NUMBER_OF_MONTHS) &&(day >= 1) && (day <= numberOfDaysInMonth));
	}
	public static String monthName( int month)
	{
		String monthTitle = ("January");
		switch (month)
		{
		case 1: 
			monthTitle = ("January");
			break;
		case 2:
			monthTitle = ("Febuary");
			break;
		case 3:
			monthTitle = ("March");
			break;
		case 4:
			monthTitle = ("April");
			break;
		case 5:
			monthTitle = ("May");
			break;
		case 6:
			monthTitle = ("June");
			break;
		case 7:
			monthTitle = ("July");
			break;
		case 8:
			monthTitle = ("August");
			break;
		case 9:
			monthTitle = ("September");
			break;
		case 10:
			monthTitle = ("October");
			break;
		case 11:
			monthTitle = ("November");
			break;
		case 12:
			monthTitle = ("December");
			break;
		}
		return monthTitle;
	}
	public static String dayOfTheWeek( int day, int month, int year)
	{
		int lastTwoDigitsOfYear = (year)%100;
		int fistTwoDigitsOfYear = (year)/100;
		if (month==1||month==2)
		{
			lastTwoDigitsOfYear = (year-1)%100;
			fistTwoDigitsOfYear = (year-1)/100;
		}
		int dayOrder = (int)(((day + Math.floor(2.6 * (((month + 9) % 12) + 1) - 0.2) + lastTwoDigitsOfYear + Math.floor(lastTwoDigitsOfYear/4) + Math.floor(fistTwoDigitsOfYear/4) 
																																					- (2*fistTwoDigitsOfYear))%7));
		String dayTitle = ("");
		switch (dayOrder)
		{
		case 0:
			dayTitle = ("Sunday");
			break;
		case 1: 
			dayTitle = ("Monday");
			break;
		case 2:
			dayTitle = ("Tuesday");
			break;
		case 3:
			dayTitle = ("Wednesday");
			break;
		case 4:
			dayTitle = ("Thursday");
			break;
		case 5:
			dayTitle = ("Friday");
			break;
		case 6:
			dayTitle = ("Saturday");
			break;
		}
		return dayTitle;
	}
	public static String date( int day )
	{
		String daysCardinalNumber = ("");
			switch (day)
			{
			case 1:
			case 21:
			case 31:
				daysCardinalNumber = (day+"st ");
				break;
			case 2:
			case 22:
				daysCardinalNumber = (day+"nd ");
				break;
			case 3:
			case 23:
				daysCardinalNumber = (day+"rd ");
				break;
			default:
				daysCardinalNumber = (day+"th ");
				break;
			}
		return daysCardinalNumber;
	}
}