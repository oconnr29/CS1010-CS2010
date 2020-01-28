import static org.junit.Assert.assertEquals;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.JUnit4;
import java.util.Arrays;

@RunWith(JUnit4.class)
public class CollinearTest {
	@Test
	public void testConstructor() {
		new Collinear();
	}

	@Test
	public void testEmpty() {
		int expectedResult = 0;
		assertEquals("countCollinear failed with 3 empty arrays", expectedResult,
				Collinear.countCollinear(new int[0], new int[0], new int[0]));
		assertEquals("countCollinearFast failed with 3 empty arrays", expectedResult,
				Collinear.countCollinearFast(new int[0], new int[0], new int[0]));
	}

	@Test
	public void testSingleFalse() {
		int[] a3 = { 15 };
		int[] a2 = { 5 };
		int[] a1 = { 10 };
		int expectedResult = 0;
		assertEquals("countCollinear({10}, {5}, {15})", expectedResult, Collinear.countCollinear(a1, a2, a3));
		assertEquals("countCollinearFast({10}, {5}, {15})", expectedResult, Collinear.countCollinearFast(a1, a2, a3));
	}

	@Test
	public void testSingleTrue() {
		int[] a3 = { 15, 5 };
		int[] a2 = { 5 };
		int[] a1 = { 10, 15, 5 };
		int expectedResult = 1;
		assertEquals(
				"countCollinear(" + Arrays.toString(a1) + "," + Arrays.toString(a2) + "," + Arrays.toString(a3) + ")",
				expectedResult, Collinear.countCollinear(a1, a2, a3));
		assertEquals("countCollinearFast(" + Arrays.toString(a1) + "," + Arrays.toString(a2) + "," + Arrays.toString(a3)
				+ ")", expectedResult, Collinear.countCollinearFast(a1, a2, a3));
	}

	@Test
	public void testDoubleTrue() {
		int[] a3 = { 1, 3, 10 };
		int[] a2 = { 1, 2, 5 };
		int[] a1 = { 1, 2 };
		int expectedResult = 2;
		assertEquals(
				"countCollinear(" + Arrays.toString(a1) + "," + Arrays.toString(a2) + "," + Arrays.toString(a3) + ")",
				expectedResult, Collinear.countCollinear(a1, a2, a3));
		assertEquals("countCollinearFast(" + Arrays.toString(a1) + "," + Arrays.toString(a2) + "," + Arrays.toString(a3)
				+ ")", expectedResult, Collinear.countCollinearFast(a1, a2, a3));
	}
	
	@Test
	public void testBinaryTrue() {
		int[] a3 = { 1, 3, 10 };
		int x = 3;
		boolean expectedResult = true;
		assertEquals("countCollinear(" + Arrays.toString(a3) + ")", expectedResult, Collinear.binarySearch(a3, x));
	}
}