package sorting;

import edu.princeton.cs.algs4.StdOut;
import edu.princeton.cs.algs4.StdRandom;

@SuppressWarnings("rawtypes")
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
		/*
		 * The crux of the method is the partitioning process,
		    which rearranges the array to
			make the following three conditions hold:
			■ The entry a[j] is in its final place in the array, for some j.
			■ No entry in a[lo] through a[j-1] is greater than a[j].
			■ No entry in a[j+1] through a[hi] is less than a[j].
		 * */
		return 0;
	}

	public static void main(String[] args) {
		
	}
}
