import java.util.Scanner;
import java.lang.Math;
public class bFormula
{
	public static void main(String[]ags)
	{
		boolean finished = false;
		 while (!finished);
		{
			Scanner input=new Scanner(System.in);
			System.out.println("Enter the coefficients of your second order polynomial seperated by spaces (or enter quit):");
			if (input.hasNextDouble())
			{
				double a = input.nextDouble();
				double b = input.nextDouble();
				double c = input.nextDouble();
				double x1=((-b+Math.sqrt((b*b)-(4*a*c)))/(2*a));
				double x2=((-b-Math.sqrt((b*b)-(4*a*c)))/(2*a));
				System.out.println("The roots to this equation are x="+x1+" and x="+x2);
			}
			else if (input.hasNext("exit"))
			{
				finished=true;
			}
			else { System.out.println("Error: No valid digits entered.");
			finished=true;}
			input.close();
		}
	}
}
