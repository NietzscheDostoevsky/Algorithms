/* *****************************************************************************
 *  Name:              Saurabh Kumar Singh
 *  Title: Top down mergesort algorithm
 *  Source: Algorithms, by Sedgewick
 **************************************************************************** */

package Section02.BookCode;
import edu.princeton.cs.algs4.In;

public class Merge {

    private staic Comparable[] aux; // auxillary array for merges.

    // Merge a[lo...mid] with a[mid+1...hi]
    public static void merge(Comparable[] a, int lo, int mid, int hi) {

        int i = lo; // starting index of first array
        int j = mid + 1; // starting index of seconds array

        // copying the array into an auxiliary array
        for (int k = lo; k <= hi; k++)
            aux[k] = a[k];

        // Merging back the two Disjoint Ordered Arrays
        for (int k = lo; k <= hi; k++) { // outer loop to iterate through the array
            if                       (i > mid) a[k] = aux[j++]; // left half exhausted, take from the right
            else if                   (j > hi) a[k] = aux[i++]; // right half exhausted, take from the left
            else if (less(aux[j], aux[i]))     a[k] = aux[j++]; // current key on right less than current key on left,take from the right
            else                               a[k] = aux[i++]; // current key on the right greater than or equal to current key on left take from the left.
        }
    }

    private static boolean less(Comparable v, Comparable w) {
        return v.compareTo(w) < 0; 
    }

    public static boolean isSorted(Comparable[] a) {
        // tests weather the entries in an array are sorted or not.
        for (int i = 1; i < a.length; i++)
            if (less(a[i], a[i - 1]))
                return false;
        return true;
    }

    

    // sort array a in ascending order
    public static void sort(Comparable[] a) {
        int N = a.length;
        aux = new Comparable[N]; // Allocating space just once.
        sort(a, 0, N-1);
    }

    // Overload the sort method with Top Down mergesort algo
    private static void sort(Comparable[] a, int lo, int hi) {
        // Sort a[lo...hi]
        if (hi <= lo) return; // base case
        int mid = lo + (hi - lo) / 2;
        sort(a, lo, mid); // sort the left half
        sort(a, mid + 1, hi); // sort the right half
        merge(a, lo, mid, hi); // merge results
    }

    

    public static void main(String[] args) {
        // Read strings from standard input, sort them, and print.

        String[] a = In.readStrings();
        sort(a);
        assert isSorted(a);
        show(a);
    }

}
