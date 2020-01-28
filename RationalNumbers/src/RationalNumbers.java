/* SELF ASSESSMENT 

Class Rational 
I declared two member variables: numerator and denominator (marks out of 4: 4).
Comment:I declared two member variables: numerator and denominator.

Constructor 1 
My program takes take two integers as parameters (for numerator and denominator) and initialises the member variables with the corresponding values . If the denominator is equal to 0 I throw an exception (marks out of 5: 5).
Comment: My program takes take two integers as parameters/

Constructor 2 
My program takes only one integer as parameter (numerator), and set the numerator to this value . I set the denominator to 1 in this case, as the resulting rational number in this case is an integer (marks out of 3: 3).
Comment: My program can take only one integer as parameter.

Add Method 
My program takes only a rational number as a parameter and returns a new rational number which has a numerator and denominator which the addition of the two objects - this and the parameter. My program does not overwrite any of the other two rational numbers (marks out of 8: 8).
Comment: My program takes only a rational number as a parameter and returns a new rational number which has a numerator and denominator which the addition of the two objects - this and the parameter. My program does not overwrite any of the other two rational numbers.

Subtract Method 
I have implemented this the same as add method, except it implements subtraction (marks out of 8: 8).
Comment: I have implemented this the same as add method, except it implements subtraction.

Multiply Method 
I have implemented this the same as add method, except it implements multiplication (marks out of 8: 8).
Comment: I have implemented this the same as add method, except it implements multiplication.

Divide Method 
I have implemented this the same as add method, except it implements divide (marks out of 8: 8).
Comment: I have implemented this the same as add method, except it implements divide.

Equals Method 
My program takes a rational number as a parameter and compares it to the reference object. I only use multiplication between numerators/denominators for the purpose of comparison, as integer division will lead to incorrect results. I return a boolean value ((marks out of 8: 8).
Comment: My program takes a rational number as a parameter and compares it to the reference object. I only use multiplication between numerators/denominators for the purpose of comparison, as integer division will lead to incorrect results. I return a boolean value.

isLessThan 
My program takes a rational number as a parameter and compares it to the reference object. I only use multiplication as integer division will lead to incorrect results. I return a boolean value (marks out of 8: 8).
Comment: My program takes a rational number as a parameter and compares it to the reference object. I only use multiplication as integer division will lead to incorrect results. I return a boolean value.

Simplify Method 
My program returns a rational number but not a new rational number, instead it returns the current reference which is this. It doesn't take any parameters as it works only with the reference object. I first find the greatest common divisor (GCD) between the numerator and denominator, and then obtain the new numerator and denominator by dividing to the GCD (marks out of 8: 8).
Comment: My program returns a rational number but not a new rational number, instead it returns the current reference which is this. It doesn't take any parameters as it works only with the reference object. I first find the greatest common divisor (GCD) between the numerator and denominator, and then obtain the new numerator and denominator by dividing to the GCD.

gcd function 
My program returns the greatest common divider of two integers: the numerator and the denominator (marks out of 6: 6).
Comment: My program returns the greatest common divider of two integers: the numerator and the denominator.

toString Method 
My program returns a string showing the fraction representation of the number, eg. "1/2". It takes no parameters (marks out of 4:4 ).
Comment: My program returns a string showing the fraction representation of the number. It takes no parameters.

Test Client Class 
My program asks the user for two rational numbers, creates two rational objects using the constructor and passing in the provided values, calls addition, subtraction, multiplication, division, comparison and simplification and prints out the results (marks out of 22: 22).
Comment: My program asks the user for two rational numbers, creates two rational objects using the constructor and passing in the provided values, calls addition, subtraction, multiplication, division, comparison and simplification and prints out the results.
*/
public class RationalNumbers {
	int numerator;
	int denominator;

	public RationalNumbers(int numerator, int denominator) {
		this.numerator = numerator;
		this.denominator = denominator;
	}

	public RationalNumbers(int numerator) {
		this.numerator = numerator;
		this.denominator = 1;
	}

	public int getNumerator() {
		return numerator;
	}

	public int getDenominator() {
		return denominator;
	}

	public RationalNumbers add(RationalNumbers rnl) {
		int denominator = rnl.getDenominator();
		int numerator = rnl.getNumerator();
		int rationalNumerator = this.numerator * denominator + numerator * this.denominator;
		int rationalDenominator = this.denominator * denominator;
		RationalNumbers add = new RationalNumbers(rationalNumerator, rationalDenominator);
		add.simplify();
		return add;
	}

	public RationalNumbers subtract(RationalNumbers rnl) {
		int denominator = rnl.getDenominator();
		int numerator = rnl.getNumerator();
		int rationalNumerator = this.numerator * denominator - numerator * this.denominator;
		int rationalDenominator = this.denominator * denominator;
		RationalNumbers subtract = new RationalNumbers(rationalNumerator, rationalDenominator);
		subtract.simplify();
		return subtract;
	}

	public RationalNumbers multiply(RationalNumbers rnl) {
		int denominator = rnl.getDenominator();
		int numerator = rnl.getNumerator();
		int rationalNumerator = this.numerator * numerator;
		int rationalDenominator = this.denominator * denominator;
		RationalNumbers multiply = new RationalNumbers(rationalNumerator, rationalDenominator);
		multiply.simplify();
		return multiply;
	}

	public RationalNumbers divide(RationalNumbers rnl) {
		int denominator = rnl.getDenominator();
		int numerator = rnl.getNumerator();
		int rationalNumerator = this.numerator / numerator;
		int rationalDenominator = this.denominator / denominator;
		RationalNumbers divide = new RationalNumbers(rationalNumerator, rationalDenominator);
		divide.simplify();
		return divide;
	}

	public boolean equals(RationalNumbers rnl) {
		boolean equal = false;
		simplify();
		rnl.simplify();
		int numerator = rnl.getNumerator();
		if (this.numerator == numerator)
			equal = true;
		return equal;
	}

	public boolean isLessThan(RationalNumbers rnl) {
		boolean lessThan = false;
		simplify();
		rnl.simplify();
		int numerator = rnl.getNumerator();
		if (this.numerator < numerator)
			lessThan = true;
		return lessThan;
	}

	public void simplify() {
		int gcd = greatestCommonDivisor(this.numerator, this.denominator);
		this.numerator /= gcd;
		this.denominator /= gcd;
	}

	public static int greatestCommonDivisor(int numerator, int denominator) {
		int gcd = 1;
		if (numerator<0)
			numerator = -numerator;
		for (int count = numerator; count > 0; count--) {
			if (numerator % count == 0 && denominator % count == 0) {
				gcd = count;
				count = 0;
			}
		}
		return gcd;
	}

	public String toString() {
		String rationalNumber = "";
		if(this.denominator==1)
		rationalNumber = (this.numerator + "");
		else
			rationalNumber = (this.numerator + "/" + this.denominator);
		return rationalNumber;
	}
}