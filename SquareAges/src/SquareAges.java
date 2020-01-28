public class SquareAges {
	public static final int MIN_YEAR = 1894;
	public static final int CURRENT_YEAR = 2017;
	public static void main(String[] args) {
	for (int age = 1;age<123; age++)
	{
		int ageSquared = age*age;
		if (ageSquared-age<=CURRENT_YEAR && ageSquared-age>=MIN_YEAR)
		{
			System.out.println("If you're age is " +age+ " in the year "+ageSquared+ " it is the square of the year. ");
		}
	}
	}
}