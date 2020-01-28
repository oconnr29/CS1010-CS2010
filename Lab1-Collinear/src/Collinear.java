class Collinear {
	/*Order of Growth: N^3
    Explanation: Three linear for-loops.*/
	static int countCollinear(int[] a1, int[] a2, int[] a3) {
		int count = 0;
		for (int i = 0; i < a1.length; i++)
			for (int j = 0; j < a2.length; j++)
				for (int k = 0; k < a3.length; k++)
					if (a3[k] - a2[j] == a2[j] - a1[i])
						count++;
		return count;
	}
	/*Order of Growth: N^2
    Explanation: Two linear for-loops.*/
	static int countCollinearFast(int[] a1, int[] a2, int[] a3) {
		sort(a3);
		int count = 0;
		for (int i = 0; i < a1.length; i++)
			for (int j = 0; j < a2.length; j++) {
				int x = 2 * a2[j] - a1[i];
				if (binarySearch(a3, x))
					count++;
			}
		return count;
	}
	/*Order of Growth: N^2
    Explanation: Two linear for-loops.*/
	static void sort(int[] a) {
		for (int j = 1; j < a.length; j++) {
			int i = j - 1;
			while (i >= 0 && a[i] > a[i + 1]) {
				int temp = a[i];
				a[i] = a[i + 1];
				a[i + 1] = temp;
				i--;
			}
		}
	}
	/*Order of Growth: Log(N)
    Explanation: Mid is halved each time.*/
	static boolean binarySearch(int[] a, int x) {
		int lo = 0, hi = a.length - 1;
		while (lo <= hi) {
			int mid = lo + (hi - lo) / 2;
			if (x < a[mid])
				hi = mid - 1;
			else if (x > a[mid])
				lo = mid + 1;
			else
				return true;
		}
		return false;
	}

}