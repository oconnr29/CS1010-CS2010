import java.util.Scanner;

public class TestRational {
	public static void main(String[] args) {
		int numerator1 = 1;
		int denominator1 = 1;
		int numerator2 = 1;
		int denominator2 = 1;
		System.out.print("Enter the first faction you would like to evaluate e.g. '1/4':");
		Scanner input1 = new Scanner(System.in);
		input1.useDelimiter("/|| ");
		if (input1.hasNextInt())
			numerator1 = input1.nextInt();
		if (input1.hasNextInt())
			denominator1 = input1.nextInt();
		RationalNumbers rational1 = new RationalNumbers(numerator1, denominator1);
		System.out.print("Enter the second faction you would like to evaluate e.g. '1/2':");
		Scanner input2 = new Scanner(System.in);
		input2.useDelimiter("/|| ");
		if (input2.hasNextInt())
			numerator2 = input2.nextInt();
		if (input2.hasNextInt())
			denominator2 = input2.nextInt();
		if (denominator1 !=0 && denominator2 != 0) {
		RationalNumbers rational2 = new RationalNumbers(numerator2, denominator2);
		RationalNumbers add = rational1.add(rational2);
		System.out.print("The two fractions added equal: " + add.toString());
		RationalNumbers subtract = rational1.subtract(rational2);
		System.out.print("\nThe two fractions subtracted equal: " + subtract.toString());
		RationalNumbers multiply = rational1.multiply(rational2);
		System.out.print("\nThe two fractions multiplied equal: " + multiply.toString());
		RationalNumbers divide = rational1.divide(rational2);
		System.out.print("\nThe two fractions divided equal: " + divide.toString());
		if (rational1.equals(rational2))
			System.out
					.print("\n" + numerator1 + "/" + denominator1 + " equals " + numerator2 + "/" + denominator2 + ".");
		else
			System.out.print("\n" + numerator1 + "/" + denominator1 + " does not equal " + numerator2 + "/"
					+ denominator2 + ".");
		if (rational1.isLessThan(rational2))
			System.out.print(
					"\n" + numerator1 + "/" + denominator1 + " is less than " + numerator2 + "/" + denominator2 + ".");
		else
			System.out.print("\n" + numerator1 + "/" + denominator1 + " is not less than " + numerator2 + "/"
					+ denominator2 + ".");
		System.out.print("\n" + numerator1 + "/" + denominator1 + " simplifies to " + rational1.toString() + " and "
				+ numerator2 + "/" + denominator2 + " simplifies to " + rational2.toString() + ".");
		}
		else
			System.out.print("Error: Denominators cannot equal 0.");
		input1.close();
		input2.close();
	}
}
