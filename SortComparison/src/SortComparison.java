// -------------------------------------------------------------------------

/**
 * This class contains static methods that implementing sorting of an array of
 * numbers using different sort algorithms.
 *
 * @author Ruairí O'Connor
 * @version HT 2019
 */

class SortComparison {

	/**
	 * Sorts an array of doubles using InsertionSort. This method is static, thus it
	 * can be called as SortComparison.sort(a)
	 * 
	 * @param a:
	 *            An unsorted array of doubles.
	 * @return array sorted in ascending order.
	 *
	 */
	static double[] insertionSort(double a[]) {
		double temp;
		for (int i = 1; i < a.length; i++) {
			for (int j = i-1; j >= 0; j--) {
				if (a[j+1] < a[j]) {
					temp = a[j+1];
					a[j+1] = a[j];
					a[j] = temp;
				} else
					j = -1;
			}
		}
		return a;
	}

	/**
	 * Sorts an array of doubles using Quick Sort. This method is static, thus it
	 * can be called as SortComparison.sort(a)
	 * 
	 * @param a:
	 *            An unsorted array of doubles.
	 * @return array sorted in ascending order
	 *
	 */
	static double[] quickSort(double a[]) {
		double[] left;
		double[] right;
		int nleft = 0;
		int nright = 0;
		double pivot;
		int i;
		int j;
		int k;
		if (a.length <= 1)
			return a;
		pivot = a[a.length - 1];
		for (i = 0; i < a.length - 1; i++) {
			if (a[i] <= pivot)
				nleft++;
			else
				nright++;
		}
		left = new double[nleft];
		right = new double[nright];
		i = 0;
		j = 0;
		for (k = 0; k < a.length - 1; k++) {
			if (a[k] <= pivot)
				left[i++] = a[k];
			else
				right[j++] = a[k];
		}
		SortComparison.quickSort(left);
		SortComparison.quickSort(right);
		k = 0;
		for (i = 0; i < left.length; i++) {
			a[k++] = left[i];
		}
		a[k++] = pivot;
		for (j = 0; j < right.length; j++) {
			a[k++] = right[j];
		}
		return a;
	}

	/**
	 * Sorts an array of doubles using Merge Sort. This method is static, thus it
	 * can be called as SortComparison.sort(a)
	 * 
	 * @param a:
	 *            An unsorted array of doubles.
	 * @return array sorted in ascending order
	 *
	 */
	/**
	 * Sorts an array of doubles using iterative implementation of Merge Sort. This
	 * method is static, thus it can be called as SortComparison.sort(a)
	 *
	 * @param a:
	 *            An unsorted array of doubles.
	 * @return after the method returns, the array must be in ascending sorted
	 *         order.
	 */

	static double[] mergeSortIterative(double a[]) {
		for (int size = 1; size <= a.length-1; size = 2 * size) {
			for (int nleft = 0; nleft < a.length - size; nleft += 2 * size) {
				int mid = nleft + size - 1;
				int nright = Math.min(nleft + 2 * size - 1, a.length - 1);
				int i;
				int j;
				int k;
				int n1 = mid - nleft + 1;
				int n2 = nright - mid;
				double left[] = new double[n1];
				double right[] = new double[n2];
				for (i = 0; i < n1; i++)
					left[i] = a[nleft + i];
				for (j = 0; j < n2; j++)
					right[j] = a[mid + 1 + j];
				i = 0;
				j = 0;
				k = nleft;
				while (i < n1 && j < n2) {
					if (left[i] <= right[j]) {
						a[k] = left[i];
						i++;
					} else {
						a[k] = right[j];
						j++;
					}
					k++;
				}
				while (i < n1) {
					a[k] = left[i];
					i++;
					k++;
				}
				while (j < n2) {
					a[k] = right[j];
					j++;
					k++;
				}
			}
		}
		return a;
	}

	/**
	 * Sorts an array of doubles using recursive implementation of Merge Sort. This
	 * method is static, thus it can be called as SortComparison.sort(a)
	 *
	 * @param a:
	 *            An unsorted array of doubles.
	 * @return after the method returns, the array must be in ascending sorted
	 *         order.
	 */
	static double[] mergeSortRecursive(double a[]) {
		if (a.length <= 1)
			return a;
		int mid = a.length / 2;
		double[] left = new double[mid];
		for (int i = 0; i < mid; i++) {
			left[i] = a[i];
		}
		double[] right = new double[a.length - mid];
		for (int i = mid; i < a.length; i++) {
			right[i - mid] = a[i];
		}
		SortComparison.mergeSortRecursive(left);
		SortComparison.mergeSortRecursive(right);
		int i = 0;
		int j = 0;
		int k = 0;
		while (i < left.length && j < right.length) {
			if (left[i] < right[j]) {
				a[k] = left[i];
				i++;
			} else {
				a[k] = right[j];
				j++;
			}
			k++;
		}
		while (i < left.length) {
			a[k] = left[i];
			i++;
			k++;
		}
		while (j < right.length) {
			a[k] = right[j];
			j++;
			k++;
		}
		return a;
	}

	/**
	 * Sorts an array of doubles using Selection Sort. This method is static, thus
	 * it can be called as SortComparison.sort(a)
	 * 
	 * @param a:
	 *            An unsorted array of doubles.
	 * @return array sorted in ascending order
	 *
	 */
	static double[] selectionSort(double a[]) {
		for (int i = 0; i < a.length - 1; i++) {
			double j = Integer.MAX_VALUE;
			int k = i + 1;
			for (int check = i; check < a.length; check++) {
				if (a[check] < j) {
					k = check;
					j = a[check];
				}
			}
			double temp = a[i];
			a[i] = a[k];
			a[k] = temp;
		}
		return a;
	}

//	public static void main(String[] args) {
//		SortComparisonTest.testInsertionSort();
//		SortComparisonTest.testQuickSort();
//		SortComparisonTest.testMergeSortIterative();
//		SortComparisonTest.testMergeSortRecursice();
//		SortComparisonTest.testSelectionSort();
//	}

}