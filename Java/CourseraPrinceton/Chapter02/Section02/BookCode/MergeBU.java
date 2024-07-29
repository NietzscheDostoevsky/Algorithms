/* *****************************************************************************
 *  Name:              Saurabh Kumar Singh
 *  Title: Top down mergesort algorithm
 *  Source: Algorithms, by Sedgewick
 **************************************************************************** */

package Section02.BookCode;
import edu.princeton.cs.algs4.In;

public class MergeBU {
	private static Comparable[] aux; // auxilary array for merges. 

	// merge a[lo...mid] with a[mid+1...hi] to create a[lo...hi]
	public static void merge(Comparable[] a, int lo, int mid, int hi ) {

		int i = lo, j = mid + 1; 
		for (int k = lo; k <= hi; k++) {
			aux[k] = a[k]; 
		}

		for (int k = lo; k <= hi; k++) {
			if (i > mid) 				   a[k] = aux[j++];
			else if (j > hi) 			   a[k] = aux[i++]; 
			else if (less(aux[j], aux[i])) a[k] = a[j++];
			else 						   a[k] = aux[i++];
		}
	}

	
}