import edu.princeton.cs.algs4.*; 
// removed comments to make code shorter. 
// for complete implementation with comments, see 
// selection.java

public class Insertion  {

	
	public static void sort(Comparable[] a) {
		
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

