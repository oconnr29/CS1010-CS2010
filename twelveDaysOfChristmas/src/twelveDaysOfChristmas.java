/* SELF ASSESSMENT 
   1. Did I use appropriate CONSTANTS instead of numbers within the code? 
       Mark out of 5: 5
       Comment: Code did not need constants.
   2. Did I use easy-to-understand, meaningful CONSTANT names formatted correctly in UPPERCASE? 
       Mark out of 5: 5
       Comment: Code did not need constants.
   3. Did I use easy-to-understand meaningful variable names formatted properly (in lowerCamelCase)? 
       Mark out of 10: 10
       Comment: I used easy-to-understand meaningful variable names formatted properly.
   4. Did I indent the code appropriately? 
       Mark out of 10: 10
       Comment: I indented the code appropriately.
   5. Did I use an appropriate loop (or loops) to produce the different verses? 
       Mark out of 20:  I used an appropriate loop to produce the different verses.
   6. Did I use a switch to build up the verses? 
       Mark out of 25: 25
       Comment: I used 2 switches to build up the verses.
   7. Did I avoid duplication of code and of the lines which make up the verses (each line should be referred to in the code only once (or twice))? 
       Mark out of 10: 10 
       Comment: I avoided duplication of code and of the lines which make up the verses.
   8. Does the program produce the correct output? 
       Mark out of 10:  10
      Comment: The program produces the correct output.
   9. How well did I complete this self-assessment? 
       Mark out of 5: 5
       Comment: I complete this self-assessment to the best of my ability.
   Total Mark out of 100 (Add all the previous marks): 100
*/
public class twelveDaysOfChristmas
{
	public static void main(String[] args)
	{
		System.out.print("12 Days of Christmas:");
		for (int verse=1; verse<=12;verse++)
		{
			System.out.print("\n\nOn the ");
			switch (verse)
			{
			case 1:
				System.out.print("first day");
				break;
			case 2:
				System.out.print("second");
				break;
			case 3:
				System.out.print("third");
				break;
			case 4:
				System.out.print("forth");
				break;
			case 5:
				System.out.print("fifth");
				break;
			case 6:
				System.out.print("sixth");
				break;
			case 7:
				System.out.print("seventh");
				break;
			case 8:
				System.out.print("eighth");
				break;
			case 9:
				System.out.print("ninth");
				break;
			case 10:
				System.out.print("tenth");
				break;
			case 11:
				System.out.print("eleventh");
				break;
			case 12:
				System.out.print("twelfth");
				break;
			}
			System.out.print(" day of Christmas\nmy true love sent to me:\n");
			switch (verse)
			{
			case 12:
				System.out.println("12 Drummers Drumming,");
			case 11:
				System.out.println("11 Pipers Piping");
			case 10:
				System.out.println("10 Lords a Leaping,");
			case 9:
				System.out.println("9 Ladies Dancing,");
			case 8:
				System.out.println("8 Maids a Milking,");
			case 7:
				System.out.println("7 Swans a Swimming,");
			case 6:
				System.out.println("6 Geese a laying,");
			case 5:
				System.out.println("5 Gold Rings,");
			case 4:
				System.out.println("4 Calling Birds,");
			case 3:
				System.out.println("3 French Hens,");
			case 2:
				System.out.print("2 Turtle Doves \nand ");
			case 1:
				System.out.print("a Partridge in a Pear Tree.");
			}
		}	
	}
}