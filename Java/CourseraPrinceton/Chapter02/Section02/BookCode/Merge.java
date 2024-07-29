/* *****************************************************************************
 *  Name:              Saurabh Kumar Singh
 *  Email: dietzschenostoevsky@gmail.com
 *  Source: Algorithms, by Sedgewick
 **************************************************************************** */

package Section02.BookCode;

public class Merge {

    // Merge a[lo...mid] with a[mid+1...hi]
    public static void merge(Comparable[] a, int lo, int mid, int hi) {

        int i = lo; // starting index of first array
        int j = mid + 1; // starting index of seconds array

        // copying the array into an auxiliary array
        for (int k = lo; k <= hi; k++)
            aux[k] = a[k];

        // Merging back the two Disjoint Ordered Arrays
        for (int k = lo; k <= hi; k++) { // outer loop to iterate through the array
            if (i > mid) {
                a[k] = aux[j++]; // left half exhausted, take from the right
            }
            else if (j > hi) {
                a[k] = aux[i++]; // right half exhausted, take from the left
            }
            else if (less(aux[j], aux[i])) {
                a[k] = aux[j++]; // current key on right less than current key on left,
                                 // take from the right
            }
            else {
                a[k] = aux[i++]; // current key on the right greater than or equal to current key on left
                                 // take from the left.
            }
        }

        // for (int k = lo; k <= hi; k++) { // outer loop to iterate through the array
        //     if                       (i > mid) a[k] = aux[j++]; // left half exhausted, take from the right
        //     else if                   (j > hi) a[k] = aux[i++]; // right half exhausted, take from the left
        //     else if (less(aux[j], aux[i]))     a[k] = aux[j++]; // current key on right less than current key on left,
        //                                                     // take from the right
        //     else                               a[k] = aux[i++]; // current key on the right greater than or equal to current key on left
        //                                                     // take from the left.
        // }
    }

}
