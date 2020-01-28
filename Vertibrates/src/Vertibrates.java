import javax.swing.JOptionPane;
public class Vertibrates {
public static void main(String[]args) {
	int answer1 = JOptionPane.showConfirmDialog(null,"Does it have fins?");
	boolean fish = (answer1 == JOptionPane.YES_OPTION);
	if (fish)
	{
		JOptionPane.showMessageDialog(null, "You got a fish there.");
	}
	else
	{
		int answer2 = JOptionPane.showConfirmDialog(null,"Does it have scales?");
		boolean reptile = (answer2 == JOptionPane.YES_OPTION);
		if (reptile)
		{
			JOptionPane.showMessageDialog(null, "You got a reptile there.");
		}
		else
		{
			int answer3 = JOptionPane.showConfirmDialog(null,"Is it cold blooded?");
			boolean amphibian = (answer3 == JOptionPane.YES_OPTION);
			if (amphibian)
			{
				JOptionPane.showMessageDialog(null, "You got an amphibian there.");
			}
			else
			{
				int answer4 = JOptionPane.showConfirmDialog(null,"Does it have feathers?");
				boolean feathers = (answer4 == JOptionPane.YES_OPTION);
				if (feathers)
				{
					JOptionPane.showMessageDialog(null,"You got a bird there.");
				}
				else
				{
					JOptionPane.showMessageDialog(null,"This is not a vertebrate.");
				}
				
			}
		}
	}
}
}

