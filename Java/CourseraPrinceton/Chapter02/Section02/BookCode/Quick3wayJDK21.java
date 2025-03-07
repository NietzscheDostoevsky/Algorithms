import java.util.Arrays;
import java.util.Collections;

public class Quick3wayJDK21 {

    public static void sort(Comparable[] a) {
        //Collections.shuffle(Arrays.asList(a)); // eliminate dependence on input.
        sort(a, 0, a.length - 1);
    }

    // Recursive quicksort algorithm
    private static void sort(Comparable[] a, int lo, int hi) {
        /* Single left-to-right pass through the array
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
        String[] a = { "R", "B", "W", "W", "R", "W", "B", "R", "R", "W", "B", "R" };
        sort(a);
        assert isSorted(a);
        show(a);
    }

    public static boolean less(Comparable v, Comparable w) {
        return v.compareTo(w) < 0;
    }

    public static boolean isSorted(Comparable[] a) {
        // tests whether the entries in an array are sorted or not.
        for (int i = 1; i < a.length; i++)
            if (less(a[i], a[i - 1])) return false;
        return true;
    }

    private static void show(Comparable[] a) {
        for (int i = 0; i < a.length; i++)
            System.out.print(a[i] + " ");
        System.out.println();
    }
}
