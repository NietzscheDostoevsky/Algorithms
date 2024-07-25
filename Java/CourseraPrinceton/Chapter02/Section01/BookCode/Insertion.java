import edu.princeton.cs.algs4.*; 

public class Insertion  {

	
	public static void sort(Comparable[] a) {
		
	}

	private static boolean less (Comparable v, Comparable w) {
		// Returns true if v is less than w
		return v.compareTo(w) < 0; 
	}

	private static void exch (Comparable[] a, int i, int j) {
		// input a Comparable[] a, index i, index j
		// exchanges objects at index i, j in array a;

		Comparable temp = a[i];
		a[i] = a[j];
		a[j] = temp; 
	}

	private static void show(Comparable[] a) {
		// prints array on a single line. 

		for (int i = 0; i < a.length; i++) {
			StdOut.print(a[i] + " ");
		}
		StdOut.println();
	}

	public static boolean isSorted(Comparable[] a) {
		// tests weather the entries in an array are sorted or not. 
		for (int i = 1; i < a.length; i++) {
			if (less(a[i], a[i-1])) { 
				// less returns t if v < w
				// In an sorted array in asc order, 
				// 		this condition should always remain false. 
				// 		this condition would become true if 
				// 		a[i-1] > a[i], ie the next element is greater than the 
				// 		previous element. 
				return false; 
			}
		}
		return true; 
	}

	public static void main(String[] args) {
		// Read strings from standard input, sort them, and print. 

		String[] a = In.readStrings();
		sort(a); 
		assert isSorted(a); 
		show(a);
	}
}

