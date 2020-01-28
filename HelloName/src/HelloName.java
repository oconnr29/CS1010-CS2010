//import javax.swing.JOptionPane;
import java.util.Scanner;

public class HelloName {
	private static Scanner input;

	public static void main(String[] args) {

		//String name = JOptionPane.showInputDialog("What is your name?");
		//JOptionPane.showMessageDialog(null, "Hello " + name);
		
		System.out.print("What is your name? ");
		input = new Scanner( System.in );
		String name = input.next();
		System.out.println("Hello " + name);

	}

}
