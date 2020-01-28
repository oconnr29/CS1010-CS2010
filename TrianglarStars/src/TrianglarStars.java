/* SELF ASSESSMENT
 1. Did I use easy-to-understand meaningful variable names formatted properly (in lowerCamelCase)?
       Mark out of 5: 5
   	   Comment:I used easy-to-understand meaningful variable names formatted properly.
 2. Did I indent the code appropriately?
       Mark out of 5: 5
       Comment: I indented the code appropriately.
 3. Did I write the determineStarNumber or determineTriangleNumber function correctly (parameters, return type and function body) and invoke it correctly?
       Mark out of 20: 20
       Comment:I wrote the determineTriangleNumber function correctly.
 4. Did I write the isStarNumber function correctly (parameters, return type and function body) and invoke it correctly?
       Mark out of 20: 20
       Comment: I wrote the isStarNumber function correctly.
 5. Did I calculate and/or check triangle numbers correctly?
       Mark out of 15: 15         
       Comment:I calculated and checked triangle numbers correctly.
 6. Did I loop through all possibilities in the program using system defined constants to determine when to stop?
       Mark out of 10: 10         
       Comment: I looped through all possibilities in the program using system defined constants to determine when to stop
 7. Does my program compute and print all the correct triangular star numbers?
       Mark out of 20: 20
       Comment: My program computes and prints all the correct triangular star numbers.
 8. How well did I complete this self-assessment?
        Mark out of 5:5
        Comment: I completed the self-assessment to the best of my ability. 
 Total Mark out of 100 (Add all the previous marks):100
*/ 
public class TrianglarStars
{
	public static final int MAX_VALUE = 100000;
	//Raise or lower the MAX_VALUE to change the range checked.
	public static void main(String[] args)
	{
		System.out.print("These are the only triangular star numbers:");
		for(int count = 1; count <= MAX_VALUE; count++)
		{
			int triangleNumber = determineTriangleNumber(count);
			if (isStarNumber(triangleNumber))
			{
				System.out.print("\n" + triangleNumber);
			}
		}
	}
	public static boolean isStarNumber(int triangleNumber)
	{
		boolean isItStarNumber = false;
		for(int count = 1; count <= MAX_VALUE; count++)
		{
			int starNumber = 6*count*(count-1) + 1;
			if (triangleNumber == starNumber)
			{
				isItStarNumber = true;
			}
		}
		return isItStarNumber;
	}
	public static int determineTriangleNumber(int number)
	{
		int triangleNumber = 0;
		for(int count = 1; count <= number; count++)
		{
			triangleNumber = triangleNumber + count;
		}
		return triangleNumber;
	}
}