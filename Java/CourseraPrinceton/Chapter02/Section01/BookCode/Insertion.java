import edu.princeton.cs.algs4.*; 
// removed comments to make code shorter. 
// for complete implementation with comments, see 
// selection.java

public class Insertion  {

	
	public static void sort(Comparable[] a) {
		// sort a[] in ascending order. 
		int N = a.length;
		for (int i = 0; i < N; i++) {
			// Insert a[i] among a[i-1], a[i-2], a[i-3]... 
			for (int j = i; j > 0 && less(a[j], a[j-1]); j--) {
				exch(a, j, j-1);
			}
		}	
	}

	private static boolean less (Comparable v, Comparable w) {
		return v.compareTo(w) < 0; 
	}

	private static void exch (Comparable[] a, int i, int j) {
		Comparable temp = a[i];
		a[i] = a[j];
		a[j] = temp; 
	}

	private static void show(Comparable[] a) {
		for (int i = 0; i < a.length; i++)
			StdOut.print(a[i] + " ");
		StdOut.println();
	}

	public static boolean isSorted(Comparable[] a) {
		for (int i = 1; i < a.length; i++) 
			if (less(a[i], a[i-1])) return false; 
		return true; 
	}

	public static void main(String[] args) {
		String[] a = In.readStrings();
		sort(a); 
		assert isSorted(a); 
		show(a);
	}
}

