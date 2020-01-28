import java.util.Scanner;

public class BMICalculator {
	public static void main(String[] ags) {
		Scanner inputScanner = new Scanner(System.in);
		System.out.print("How much do you weigh?(in kgs)");
		double weight = inputScanner.nextDouble();
		System.out.println("What is yur height?(in m)");
		double height = inputScanner.nextDouble();
		inputScanner.close();
		double BMI = weight / (height * height);
		System.out.print("Your BMI is:" + BMI);
	}
}
