import edu.princeton.cs.algs4.In;
import edu.princeton.cs.algs4.StdOut;
import edu.princeton.cs.algs4.StdRandom;

/*
    Improvement over QuickSort for accounting for DUPLICATE KEYS
    - Partition the array into three parts compared with paritioning itme's key
        1. keys smaller than 
        2. Keys larger than 
        3. Keys equal to 

*/

@SuppressWarnings({ "unchecked", "rawtypes", "deprecation" })
public class Quick3way {


    public static void sort(Comparable[] a) {
        StdRandom.shuffle(a); // eliminate dependence on input.
        sort(a, 0, a.length - 1);
    }

    // Recursive quicksort algo
    private static void sort(Comparable[] a, int lo, int hi) {
        // for a single call to this method, the item is fixed. 
        // and by the end of this subroutine, it will be placed at its 
        // final position in the sorted array. 
        
        /* Single left to right pass through the array
        Maintain pointers such that 
            lt: a[lo...lt-1] is less than v
            gt: a[gt+1, hi] is greater than v
            i: a[lt...i-1] are equal to v and a[i...gt] not yet examined. 
        */


        if (hi <= lo) return; 
        int lt = lo;
        int i = lo + 1;
        int gt = hi;

        Comparable v = a[lo]; // Item v

        while (i <= gt) {
            // processing a[i] using comparable interface. 
            int cmp = a[i].compareTo(v);
            // a[i] is less than v
            // exchange a[lt] with a[i] and increment 
            // both lt and i
            if (cmp < 0) exch(a, lt++, i++);
            // a[i] greater than v: 
            // exchange a[i] with a[gt] and decrement gt
            else if (cmp > 0) exch(a, i, gt--);
            // a[i] equal to v: increment i
            else i++;
        }

        // Now a[lo..lt-1] < v = a[lt..gt] < a[gt+1..hi] 

        sort(a, lo, lt - 1);
        sort(a, gt + 1, hi);

    }

    private static void exch(Comparable[] a, int i, int j) {
        Comparable temp = a[i];
        a[i] = a[j];
        a[j] = temp;

    }

    public static void main(String[] args) {
        String[] a = In.readStrings();
        sort(a);
        assert isSorted(a);
        show(a);
    }

    public static boolean less(Comparable v, Comparable w) {
        return v.compareTo(w) < 0; 
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
