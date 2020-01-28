import java.util.Scanner;
public class primeCompetitors 
{
	public static void main(String[] args)
	{
		Scanner userInput = new Scanner(System.in);
		System.out.print("How many competitors?");
		int input = userInput.nextInt();
		System.out.println("Prizes should be given to the competitors who came");
		for (int place = 1; place <= input; place++)
		{
				int divisor = place/2;
				
			  boolean isPrimeNumber = true;
			  while ((divisor > 1) && (isPrimeNumber))
			  {
			    if (place % divisor-- == 0)
			      isPrimeNumber = false;
			  }
				if (isPrimeNumber)
				{
					int ending = 0;
					int remainingNumber = place/10;
					if (place%10 == 1 && remainingNumber%10 != 1)
					{
						ending = 1;
					}
					else if (place%10 == 2 && remainingNumber%10 != 1)
					{
						ending = 2;
					}
					else if (place%10 == 3 && remainingNumber%10 != 1)
					{
						ending = 3;
					}
					switch (ending)
					{
						case 1: System.out.print(place+"st, ");
						break;
						case 2: System.out.print(place+"nd, ");
						break;
						case 3: System.out.print(place+"rd, ");
						break;
						default: System.out.print(place+"th, ");
						break;
					}
				}
			}
		userInput.close();
	}
}	
