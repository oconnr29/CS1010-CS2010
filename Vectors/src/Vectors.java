import java.util.Vector;

public class Vectors {
	public static void main(String[] args)
	{
		double [] axisValues = {3.4, 8.27, 9};
		double magnitude = vectorMagnitude(axisValues);
		System.out.print(magnitude);
	}
	public static double vectorMagnitude (double [] axisValues)
	{
		double axisValuesSquared=0;
		if (axisValues != null)
		{
			for (int index = 0; index<axisValues.length; index++)
			{
				axisValuesSquared +=  axisValues[index]*axisValues[index];
			}
		}
		return Math.sqrt(axisValuesSquared);
	}
	public static Vector vectorMagnitude ()
	{
		
	}
}
