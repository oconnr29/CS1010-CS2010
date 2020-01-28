/* SELF ASSESSMENT 
   1. createSequence:
Did I use the correct method definition?
Mark out of 5: 5
Comment:I used the correct method definition.
Did I create an array of size n (passed as the parameter) and initialise it?
Mark out of 5:5
Comment:I created an array of size n (passed as the parameter) and initialised it.
Did I return the correct item?
Mark out of 5:5
Comment:I returned the correct item.
   2. crossOutMultiples
Did I use the correct method definition?
Mark out of 5:5
Comment:I used the correct method definition.
Did I ensure the parameters are not null and one of them is a valid index into the array?
Mark out of 2:2
Comment:I ensured the parameters are not null and one of them is a valid index into the array.
Did I loop through the array using the correct multiple?
Mark out of 5:5
Comment:I looped through the array using the correct multiple.
Did I cross out correct items in the array that were not already crossed out?
Mark out of 3:3
Comment:I crossed out correct items in the array that were not already crossed out.
   3. sieve   
Did I have the correct function definition?
Mark out of 5:5
Comment:I had the correct function definition.
Did I make calls to other methods?
Mark out of 5:5
Comment:I made calls to other methods.
Did I return an array with all non-prime numbers are crossed out?
Mark out of 2:2
Comment:I returned an array with all non-prime numbers are crossed out.
   4. sequenceTostring  
Did I have the correct function definition?
Mark out of 5:5
Comment:I had the correct function definition.
Did I ensure the parameter to be used is not null?
Mark out of 3:3
Comment: I ensured the parameter to be used is not null.
Did I Loop through the array updating the String variable with the non-crossed out numbers and the crossed numbers in brackets? 
Mark out of 10:10
Comment:I Looped through the array updating the String variable with the non-crossed out numbers and the crossed numbers in brackets.
   5. nonCrossedOutSubseqToString  
Did I have the correct function definition?
Mark out of 5:10
Comment:I had the correct function definition.
Did I ensure the parameter to be used is not null?  
Mark out of 3:3
Comment:I ensured the parameter to be used was not null.
Did I loop through the array updating the String variable with just the non-crossed out numbers? 
Mark out of 5:5
Comment:I looped through the array updating the String variable with just the non-crossed out numbers.
   6. main  
Did I ask the user for input n and handles input errors?  
Mark out of 5:5
Comments:I asked the user for input n and handles input errors
Did I make calls to other methods (at least one)?
Mark out of 5:5
Comment:  I made calls to other methods.
Did I print the output as shown in the question?  
Mark out of 5:5
Comment: I print the output as shown in the question.
   7. Overall
Is my code indented correctly?
Mark out of 4:4
Comments:my code is indented correctly.
Do my variable names make sense?
Mark out of 4:4
Comments:my variable names make sense.
Do my variable names, method names and class name follow the Java coding standard?
Mark out of 4:4
Comments:my variable names, method names and class name follow the Java coding standard.
      Total Mark out of 100 (Add all the previous marks): 100
*/
import java.util.Scanner;

public class SieveOfEratosthenes {
	public static final int FINAL_NUMBER_CORRECTOR = 1;
	public static void main(String[] args){
		System.out.print("Enter int >= 2 :");
		Scanner input = new Scanner(System.in);
		int finalNumber = input.nextInt()-FINAL_NUMBER_CORRECTOR;
		if (finalNumber>=1){
			String[] stringSequence = new String[finalNumber];
			int [] sequence = createSequence(finalNumber, stringSequence);
			crossOutHigherMultiples(sequence, stringSequence);
			String[] answer = nonCrossedOutSubseqToString(sequence);
			for (int count = 0; count < answer.length; count++){
				System.out.print(answer[count]);
			}
		}
		else{
			System.out.print("Error: Invalid input, input must be a whole number above 2.");
		}
		input.close();
	}
	public static int[] createSequence(int number, String[] stringSequence){
		int[] sequence = new int[number];
		for (int count = 0; count < sequence.length; count++){
				sequence [count]= count+2;
		}
		return sequence;
	}
	public static void crossOutHigherMultiples(int[] sequence, String[] stringSequence){
		for (int count = 0; count < sequence.length; count++){
			boolean numberChanged = sieve(sequence, count, stringSequence);
			if (numberChanged) {
				for (int index = 0; index < stringSequence.length; index++){
					System.out.print(stringSequence[index]);
				}
				System.out.print("\n");
			}
		}
	}
	public static boolean sieve(int[] sequence, int count, String[] stringSequence){
		boolean numberChanged = false;
		if (sequence[count]>0){
			for (int index = 0; index < sequence.length; index++){
				if (sequence[index]%sequence[count]==0&&
						sequence[index]!=sequence[count]&&sequence[index]>0){
					sequence[index]=sequence[index]*-1;
					sequenceToString(sequence, stringSequence);
					numberChanged=true;
				}
			}
		}
		return numberChanged;
	}
	public static void sequenceToString(int[] sequence, String[] stringSequence){
		for (int count = 0; count < stringSequence.length; count++){
			if(sequence[count]==sequence[sequence.length-1]&&sequence[count]>0){
				stringSequence[count] = (""+sequence[count]);
			}
			else if(sequence[count]==sequence[sequence.length-1]&&sequence[count]<0){
				sequence[count]=sequence[count]*-1;
				stringSequence[count] = ("["+sequence[count]+"]");
				sequence[count]=sequence[count]*-1;
			}
			else if(sequence[count]<0){
				sequence[count]=sequence[count]*-1;
				stringSequence[count] = ("["+sequence[count]+"], ");
				sequence[count]=sequence[count]*-1;
			}
			else{
				stringSequence[count] = (sequence[count]+", ");
			}
		}
	}
	public static String[] nonCrossedOutSubseqToString(int[] sequence) {
		int answerLength=0;
		for (int count = 0; count < sequence.length; count++){
			if(sequence[count]>0){
				answerLength++;
			}
		}
		String[] answer = new String[answerLength];
		int count = 0;
		for (int index = 0; index < sequence.length; index++){
			if(sequence[index]>0&&count!=answer.length-1){
				answer[count] = (sequence[index]+", ");
				count++;
			}
			if (count==answer.length-1) {
				answer[count] = (sequence[index-1]+".");
			}
		}
		return answer;
	}
}