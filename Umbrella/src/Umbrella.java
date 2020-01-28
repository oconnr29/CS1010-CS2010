/* SELF ASSESSMENT 
   1. Did I use easy-to-understand meaningful variable names? 
       Mark out of 10: 10
   2. Did I format the variable names properly (in lowerCamelCase)? 
       Mark out of 10: 10
   3. Did I indent the code appropriately? 
       Mark out of 10: 10
   4. Did I read the input correctly from the user using appropriate questions? 
       Mark out of 20: 18
   5. Did I use an appropriate (i.e. not more than necessary) series of if statements? 
       Mark out of 30: 28
   6. Did I output the correct answer for each possibility in an easy to read format? 
       Mark out of 15: 15
   7. How well did I complete this self-assessment? 
       Mark out of 5: 4
   Total Mark out of 100 (Add all the previous marks): 95 
*/
import javax.swing.JOptionPane;
public class Umbrella {
public static void main(String[]args) {
	int answer1 = JOptionPane.showConfirmDialog(null,"Do you need to stay dry?");
	boolean safe = (answer1 == JOptionPane.YES_OPTION);
	if (safe)
	{
		JOptionPane.showMessageDialog(null, "Bring an umbrella just incase.");
	}
	else
	{
		int answer2 = JOptionPane.showConfirmDialog(null,"Is it raining?");
		boolean rain = (answer2 == JOptionPane.YES_OPTION);
		if (rain)
		{
			JOptionPane.showMessageDialog(null, "Bring an umbrella.");
		}
		else
		{
			int answer3 = JOptionPane.showConfirmDialog(null,"Are there dark clouds?");
			boolean clouds = (answer3 == JOptionPane.YES_OPTION);
			if (clouds)
			{
				JOptionPane.showMessageDialog(null, "Better safe then sorry, bring an umbrella.");
			}
			else
			{
				int answer4 = JOptionPane.showConfirmDialog(null,"Are you going to be out of the house for more then 8 hours?");
				boolean time = (answer4 == JOptionPane.YES_OPTION);
				if (time)
				{
					JOptionPane.showMessageDialog(null,"Unless you are confident it will not rain it would be a good idea to bring an umbrella.");
				}
				else
				{
					JOptionPane.showMessageDialog(null,"I'm sure it'll be ok you can leave the umbrella at home.");
				}
				
			}
		}
	}
}
}
