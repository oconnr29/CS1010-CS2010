import static org.junit.Assert.assertEquals;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.Arrays;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.JUnit4;

//-------------------------------------------------------------------------
/**
 * Test class for SortComparison.java
 *
 * @author Ruairí O'Connor
 * @version HT 2019
 */
@RunWith(JUnit4.class)
public class SortComparisonTest {
	// ~ Constructor ........................................................
	@Test
	public void testConstructor() {
		new SortComparison();
	}

	// ~ Public Methods ........................................................

	// ----------------------------------------------------------
	/**
	 * Check that the methods work for empty arrays
	 */
	@Test
	public void testEmpty() {
		double[] a = new double[] {};
		double[] b = new double[] {};

		assertEquals("Checking empty array for selectionSort", Arrays.toString(a),
				Arrays.toString(SortComparison.selectionSort(b)));

		b = new double[] {};
		assertEquals("Checking empty array for mergeSortIterative", Arrays.toString(a),
				Arrays.toString(SortComparison.mergeSortIterative(b)));

		b = new double[] {};
		assertEquals("Checking empty array tree for mergeSortRecursive", Arrays.toString(a),
				Arrays.toString(SortComparison.mergeSortRecursive(b)));

		b = new double[] {};
		assertEquals("Checking empty array tree for quickSort", Arrays.toString(a),
				Arrays.toString(SortComparison.quickSort(b)));

		b = new double[] {};
		assertEquals("Checking empty array tree for insertionSort", Arrays.toString(a),
				Arrays.toString(SortComparison.insertionSort(b)));
	}

	@Test
	public void testSort() {
		double[] a = new double[] { 71.9, 1, 5, 4, 2, 8, 2, 65, 3 };
		double[] b = new double[] { 1, 2, 2, 3, 4, 5, 8, 65, 71.9 };

		assertEquals("Checking normal array for insertionSort", Arrays.toString(b),
				Arrays.toString(SortComparison.insertionSort(a)));

		a = new double[] { 71.9, 1, 5, 4, 2, 8, 2, 65, 3 };
		assertEquals("Checking normal array for selectionSort", Arrays.toString(b),
				Arrays.toString(SortComparison.selectionSort(a)));

		a = new double[] { 71.9, 1, 5, 4, 2, 8, 2, 65, 3 };
		assertEquals("Checking normal array for mergeSortIterative", Arrays.toString(b),
				Arrays.toString(SortComparison.mergeSortIterative(a)));

		a = new double[] { 71.9, 1, 5, 4, 2, 8, 2, 65, 3 };
		assertEquals("Checking normal array for mergeSortRecursive", Arrays.toString(b),
				Arrays.toString(SortComparison.mergeSortRecursive(a)));

		a = new double[] { 71.9, 1, 5, 4, 2, 8, 2, 65, 3 };
		assertEquals("Checking normal array for quickSort", Arrays.toString(b),
				Arrays.toString(SortComparison.quickSort(a)));

	}

	@Test
	public void testAlreadySorted() {
		double[] a = new double[] { 1, 2, 2, 3, 4, 5, 8, 65, 71.9 };
		double[] b = new double[] { 1, 2, 2, 3, 4, 5, 8, 65, 71.9 };

		assertEquals("Checking sorted array for insertionSort", Arrays.toString(b),
				Arrays.toString(SortComparison.insertionSort(a)));

		a = new double[] { 1, 2, 2, 3, 4, 5, 8, 65, 71.9 };
		assertEquals("Checking sorted array for selectionSort", Arrays.toString(b),
				Arrays.toString(SortComparison.selectionSort(a)));

		a = new double[] { 1, 2, 2, 3, 4, 5, 8, 65, 71.9 };
		assertEquals("Checking sorted array for mergeSortIterative", Arrays.toString(b),
				Arrays.toString(SortComparison.mergeSortIterative(a)));

		a = new double[] { 1, 2, 2, 3, 4, 5, 8, 65, 71.9 };
		assertEquals("Checking sorted array for mergeSortRecursive", Arrays.toString(b),
				Arrays.toString(SortComparison.mergeSortRecursive(a)));

		a = new double[] { 1, 2, 2, 3, 4, 5, 8, 65, 71.9 };
		assertEquals("Checking sorted array for quickSort", Arrays.toString(b),
				Arrays.toString(SortComparison.quickSort(a)));
	}

	public static void testInsertionSort() {
		System.out.println("Insertion Sort:");
		long startTime = System.currentTimeMillis();
		SortComparison.insertionSort(readFile(10, ""));
		long finishTime = System.currentTimeMillis();
		System.out.println("n=10 takes: " + (finishTime - startTime) + "ms");

		startTime = System.currentTimeMillis();
		SortComparison.insertionSort(readFile(100, ""));
		finishTime = System.currentTimeMillis();
		System.out.println("n=100 takes: " + (finishTime - startTime) + "ms");

		startTime = System.currentTimeMillis();
		SortComparison.insertionSort(readFile(1000, ""));
		finishTime = System.currentTimeMillis();
		System.out.println("n=1000 takes: " + (finishTime - startTime) + "ms");

		startTime = System.currentTimeMillis();
		SortComparison.insertionSort(readFile(1000, "Duplicates"));
		finishTime = System.currentTimeMillis();
		System.out.println("n=1000 Duplicates takes: " + (finishTime - startTime) + "ms");

		startTime = System.currentTimeMillis();
		SortComparison.insertionSort(readFile(1000, "NearlyOrdered"));
		finishTime = System.currentTimeMillis();
		System.out.println("n=1000 NearlyOrdered takes: " + (finishTime - startTime) + "ms");

		startTime = System.currentTimeMillis();
		SortComparison.insertionSort(readFile(1000, "Reverse"));
		finishTime = System.currentTimeMillis();
		System.out.println("n=1000 Reverse takes: " + (finishTime - startTime) + "ms");

		startTime = System.currentTimeMillis();
		SortComparison.insertionSort(readFile(1000, "Sorted"));
		finishTime = System.currentTimeMillis();
		System.out.println("n=1000 Sorted takes: " + (finishTime - startTime) + "ms\n");
	}

	public static void testSelectionSort() {
		System.out.println("Selection Sort:");
		long startTime = System.currentTimeMillis();
		SortComparison.selectionSort(readFile(10, ""));
		long finishTime = System.currentTimeMillis();
		System.out.println("n=10 takes: " + (finishTime - startTime) + "ms");

		startTime = System.currentTimeMillis();
		SortComparison.selectionSort(readFile(100, ""));
		finishTime = System.currentTimeMillis();
		System.out.println("n=100 takes: " + (finishTime - startTime) + "ms");

		startTime = System.currentTimeMillis();
		SortComparison.selectionSort(readFile(1000, ""));
		finishTime = System.currentTimeMillis();
		System.out.println("n=1000 takes: " + (finishTime - startTime) + "ms");

		startTime = System.currentTimeMillis();
		SortComparison.selectionSort(readFile(1000, "Duplicates"));
		finishTime = System.currentTimeMillis();
		System.out.println("n=1000 Duplicates takes: " + (finishTime - startTime) + "ms");

		startTime = System.currentTimeMillis();
		SortComparison.selectionSort(readFile(1000, "NearlyOrdered"));
		finishTime = System.currentTimeMillis();
		System.out.println("n=1000 NearlyOrdered takes: " + (finishTime - startTime) + "ms");

		startTime = System.currentTimeMillis();
		SortComparison.selectionSort(readFile(1000, "Reverse"));
		finishTime = System.currentTimeMillis();
		System.out.println("n=1000 Reverse takes: " + (finishTime - startTime) + "ms");

		startTime = System.currentTimeMillis();
		SortComparison.selectionSort(readFile(1000, "Sorted"));
		finishTime = System.currentTimeMillis();
		System.out.println("n=1000 Sorted takes: " + (finishTime - startTime) + "ms\n");
	}

	public static void testMergeSortIterative() {
		System.out.println("Mergesort Iterative:");
		long startTime = System.currentTimeMillis();
		SortComparison.mergeSortIterative(readFile(10, ""));
		long finishTime = System.currentTimeMillis();
		System.out.println("n=10 takes: " + (finishTime - startTime) + "ms");

		startTime = System.currentTimeMillis();
		SortComparison.mergeSortIterative(readFile(100, ""));
		finishTime = System.currentTimeMillis();
		System.out.println("n=100 takes: " + (finishTime - startTime) + "ms");

		startTime = System.currentTimeMillis();
		SortComparison.mergeSortIterative(readFile(1000, ""));
		finishTime = System.currentTimeMillis();
		System.out.println("n=1000 takes: " + (finishTime - startTime) + "ms");

		startTime = System.currentTimeMillis();
		SortComparison.mergeSortIterative(readFile(1000, "Duplicates"));
		finishTime = System.currentTimeMillis();
		System.out.println("n=1000 Duplicates takes: " + (finishTime - startTime) + "ms");

		startTime = System.currentTimeMillis();
		SortComparison.mergeSortIterative(readFile(1000, "NearlyOrdered"));
		finishTime = System.currentTimeMillis();
		System.out.println("n=1000 NearlyOrdered takes: " + (finishTime - startTime) + "ms");

		startTime = System.currentTimeMillis();
		SortComparison.mergeSortIterative(readFile(1000, "Reverse"));
		finishTime = System.currentTimeMillis();
		System.out.println("n=1000 Reverse takes: " + (finishTime - startTime) + "ms");

		startTime = System.currentTimeMillis();
		SortComparison.mergeSortIterative(readFile(1000, "Sorted"));
		finishTime = System.currentTimeMillis();
		System.out.println("n=1000 Sorted takes: " + (finishTime - startTime) + "ms\n");
	}

	public static void testMergeSortRecursice() {
		System.out.println("Mergesort Recursive:");
		long startTime = System.currentTimeMillis();
		SortComparison.mergeSortRecursive(readFile(10, ""));
		long finishTime = System.currentTimeMillis();
		System.out.println("n=10 takes: " + (finishTime - startTime) + "ms");

		startTime = System.currentTimeMillis();
		SortComparison.mergeSortRecursive(readFile(100, ""));
		finishTime = System.currentTimeMillis();
		System.out.println("n=100 takes: " + (finishTime - startTime) + "ms");

		startTime = System.currentTimeMillis();
		SortComparison.mergeSortRecursive(readFile(1000, ""));
		finishTime = System.currentTimeMillis();
		System.out.println("n=1000 takes: " + (finishTime - startTime) + "ms");

		startTime = System.currentTimeMillis();
		SortComparison.mergeSortRecursive(readFile(1000, "Duplicates"));
		finishTime = System.currentTimeMillis();
		System.out.println("n=1000 Duplicates takes: " + (finishTime - startTime) + "ms");

		startTime = System.currentTimeMillis();
		SortComparison.mergeSortRecursive(readFile(1000, "NearlyOrdered"));
		finishTime = System.currentTimeMillis();
		System.out.println("n=1000 NearlyOrdered takes: " + (finishTime - startTime) + "ms");

		startTime = System.currentTimeMillis();
		SortComparison.mergeSortRecursive(readFile(1000, "Reverse"));
		finishTime = System.currentTimeMillis();
		System.out.println("n=1000 Reverse takes: " + (finishTime - startTime) + "ms");

		startTime = System.currentTimeMillis();
		SortComparison.mergeSortRecursive(readFile(1000, "Sorted"));
		finishTime = System.currentTimeMillis();
		System.out.println("n=1000 Sorted takes: " + (finishTime - startTime) + "ms\n");
	}

	public static void testQuickSort() {
		System.out.println("Quicksort:");
		long startTime = System.currentTimeMillis();
		SortComparison.quickSort(readFile(10, ""));
		long finishTime = System.currentTimeMillis();
		System.out.println("n=10 takes: " + (finishTime - startTime) + "ms");

		startTime = System.currentTimeMillis();
		SortComparison.quickSort(readFile(100, ""));
		finishTime = System.currentTimeMillis();
		System.out.println("n=100 takes: " + (finishTime - startTime) + "ms");

		startTime = System.currentTimeMillis();
		SortComparison.quickSort(readFile(1000, ""));
		finishTime = System.currentTimeMillis();
		System.out.println("n=1000 takes: " + (finishTime - startTime) + "ms");

		startTime = System.currentTimeMillis();
		SortComparison.quickSort(readFile(1000, "Duplicates"));
		finishTime = System.currentTimeMillis();
		System.out.println("n=1000 Duplicates takes: " + (finishTime - startTime) + "ms");

		startTime = System.currentTimeMillis();
		SortComparison.quickSort(readFile(1000, "NearlyOrdered"));
		finishTime = System.currentTimeMillis();
		System.out.println("n=1000 NearlyOrdered takes: " + (finishTime - startTime) + "ms");

		startTime = System.currentTimeMillis();
		SortComparison.quickSort(readFile(1000, "Reverse"));
		finishTime = System.currentTimeMillis();
		System.out.println("n=1000 Reverse takes: " + (finishTime - startTime) + "ms");

		startTime = System.currentTimeMillis();
		SortComparison.quickSort(readFile(1000, "Sorted"));
		finishTime = System.currentTimeMillis();
		System.out.println("n=1000 Sorted takes: " + (finishTime - startTime) + "ms\n");
	}

	public static double[] readFile(int num, String type) {

		double[] a = new double[num];

		try {
			BufferedReader br = new BufferedReader(new FileReader("numbers" + type + num + ".txt"));
			String line = br.readLine();
			for (int i = 0; line != null; i++) {
				a[i] = Double.parseDouble(line);
				line = br.readLine();
			}
			br.close();
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
		return a;
	}

	/**
	 * Main Method. Use this main method to create the experiments needed to answer
	 * the experimental performance questions of this assignment.
	 *
	 */
	public static void main(String[] args) {
	}
	/*
	 * Performance Testing(time in MS)
	 *+----------------------------------------------------------------------------------------------------+
	 *|					   |Insert         |Quick          |Merge Iterative|merge recursive|Selection      |
	 *|--------------------+---------------+---------------+---------------+---------------+---------------|
	 *|10 random		   |1.667      	   |0.333          |1              |0.333          |1              |
	 *|--------------------+---------------+---------------+---------------+---------------+---------------|
	 *|100 random		   |1       	   |1              |0.333          |0.667          |0.667          |
	 *|--------------------+---------------+---------------+---------------+---------------+---------------| 
	 *|1000 random		   |10.333         |2              |1              |2              |5.666          |
	 *|--------------------+---------------+---------------+---------------+---------------+---------------|
	 *|1000 few unique	   |2.333          |1.333          |1.667          |1.333          |4              |
	 *|--------------------+---------------+---------------+---------------+---------------+---------------|
	 *|1000 nearly ordered |1.667          |4              |1.667          |1              |3.333          |
	 *|--------------------+---------------+---------------+---------------+---------------+---------------|
	 *|1000 reverse ordered|3              |12             |1              |1              |4              |
	 *|--------------------+---------------+---------------+---------------+---------------+---------------|
	 *|1000 sorted         |2.333          |10.667         |1.667          |1.667          |2.667          |
	 *|----------------------------------------------------------------------------------------------------+
	 */
	
	/*
	 * a. Which of the sorting algorithms does the order of input have an impact on?
	 * Why?
	 * QuickSort, it works by using a pivot point and putting the smaller data
	 * into a new array and the lager into another new array, when the data is in
	 * order/reversed and your pivot point is at the end of the array the data is
	 * all sorted into the same array every time since all the data will either be
	 * all larger or all smaller than the pivot point.
	 */

	/*
	 * b. Which algorithm has the biggest difference between the best and worst
	 * performance, based on the type of input, for the input of size 1000? Why?
	 * QuickSort, it works by using a pivot point and putting the smaller data into
	 * a new array and the lager into another new array, when the data is in
	 * order/reversed and your pivot point is at the end of the array the data is
	 * all sorted into the same array every time since all the data will either be
	 * all larger or all smaller than the pivot point.
	 * 
	 */

	/*
	 * c. Which algorithm has the best/worst scalability, i.e., the difference in
	 * performance time based on the input size? Please consider only input files
	 * with random order for this answer.
	 * Insertion Sort.
	 */
	
	/*
	 * d. Did you observe any difference between iterative and recursive
	 * implementations of merge sort? e. Which algorithm is the fastest for each of
	 * the 7 input files?
	 * A minimal difference but yes,
	 * They were the same for Reverse and sorted
	 * iterative was better for n=100 and n=1000
	 * recursive was better for n=10, few duplicates and nearlyOrdered.
	 */
}