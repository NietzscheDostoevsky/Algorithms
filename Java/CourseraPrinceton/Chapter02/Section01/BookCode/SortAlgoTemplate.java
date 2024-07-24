import edu.princeton.cs.algs4.*; 

public interface SortAlgoTemplate {

	// sorting algo to be implemented 
	abstract void sort(Comparable[] a) ; 

	// less method, which compares the key between two comparables 
	default boolean less(Comparable v, Comparable w) {
		return v.compareTo(w) < 0; 
	}

	// Exchange method, which exchanges the two objects. 
	default void exch(Comparable[] a, int i, int j) {
		Comparable temp = a[i]; 
		a[i] = a[j]; 
		a[j] = temp; 
	}

	// Method show, which shows the array 
	default void show(Comparable[] a) {
		// prints array on a single line. 

		for (int i = 0; i < a.length; i++) {
			StdOut.print(a[i] + " ");
		}
		StdOut.println(); 
	}

	default boolean isSorted(Comparable[] a) {
		// Test wheather the array entries are in order. 

		for (int i = 1; i < a.length; i++) {
			if (less(a[i], a[i - j])) {
				return false; 
			}
		}
		return true; 
	}
}