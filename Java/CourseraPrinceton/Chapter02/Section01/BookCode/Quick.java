package sorting;

import edu.princeton.cs.algs4.In;
import edu.princeton.cs.algs4.StdOut;
import edu.princeton.cs.algs4.StdRandom;

@SuppressWarnings({"unchecked", "rawtypes","deprecation"})
public class Quick {
	
	
	public static void sort(Comparable[] a) {
		StdRandom.shuffle(a); // eliminate dependence on input. 
		sort(a, 0, a.length -1); 
	}
	
	// Recursive quicksort algo
	private static void sort(Comparable[] a, int lo, int hi) {
		if (hi <= lo) return ; // base case. 
		int j = partition(a, lo, hi); // Partition the array, put element a[j] in its right place in the final array. 
		sort(a, lo, j - 1) ; // sort the left side of element a[j]
		sort(a, j+1, hi); // Sort the right side of element a[j]
		
	}


	private static int partition(Comparable[] a, int lo, int hi) {
		// partition a[] into a[lo...i -1] , a[i+1...hi] 
		
		/*
		 * The crux of the sort method is the partitioning process,
		    It rearranges the array to
			make the following three conditions hold:
			■ The entry a[j] is in its final place in the array, for some j.
			■ No entry in a[lo] through a[j-1] is greater than a[j].
			■ No entry in a[j+1] through a[hi] is less than a[j].
		 * */
		
		int i = lo, j = hi + 1; // left and right scan
		Comparable v = a[lo]; // partitioning item, or the pivot item. 
		while (true) {
			// Scan right, scan left, check for scan complete, and exchange. 
			while (less(a[++i], v)) if (i == j) break; 
			while (less(v, a[--j])) if (i > j) break; 
			if (i >=j) break; 
			exch(a, i, j); 
		}
		exch(a, lo, j); 
		return j;
	}
	
	private static void exch(Comparable[] a, int i, int j) {
		Comparable temp = a[i]; 
		a[i] = a[j]; 
		a[j] = temp; 
		
	}

	private static boolean less(Comparable v, Comparable w) {
		
		return v.compareTo(w) < 0;
	}

	

	
	public static void main(String[] args) {
		String[] a = In.readStrings();
		sort(a); 
		assert isSorted(a); 
		show(a); 		
	}
	
	public static boolean isSorted(Comparable[] a) {
        // tests weather the entries in an array are sorted or not.
        for (int i = 1; i < a.length; i++) 
            if (less(a[i], a[i - 1]))  return false;
        return true;
    }
	private static void show(Comparable[] a) {
        for (int i = 0; i < a.length; i++)
            StdOut.print(a[i] + " ");
        StdOut.println();
    }
}
