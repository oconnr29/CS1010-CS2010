import java.util.Scanner;

public class tut {
	public static void main(String[] args){
		
		System.out.print("Input number of participants: ");
		Scanner in = new Scanner(System.in);
		int input =0;
		
		if(in.hasNextInt())
		{
			input = in.nextInt();
			
			if(input > 0)
			{
				System.out.println("Prizes sould be given to the:");
				System.out.print("1st, 2nd");
			}
			else
			{
				System.out.print("Not a valid input, please inly input positive whole numbers");
				input = 0;
			}

		}
		else
		{
			System.out.print("Not a valid input, please only input whole numbers");
		}
		for(int count = 0; (count < input); count++)
		{
			int div = 2;
			
			for(div = 2; (div < count); div++)
			{
				if(count%div == 0)
				{
					div = count + 1; 
				}
				else if(div == count-1)
				{
					int remainder = count%10;
					int remainderTwo = count%100;

					if(remainder == 1 && remainderTwo == 11)
					{
						System.out.print(", " + count + "th");
					}
					else if(remainder == 3 && remainderTwo == 13)
					{
						System.out.print(", " + count + "th");
					}
					else
					{
						switch(remainder)
						{
						case 1:
							System.out.print(", " + count + "st");
							break;
						case 3:
							System.out.print(", " + count + "rd");
							break;
						default:
							System.out.print(", " + count + "th");
						}
					}
				}
			}
		}
		System.out.print(".");
		in.close();
	}
}
