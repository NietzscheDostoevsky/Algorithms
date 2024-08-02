import edu.princeton.cs.algs4.In;
import edu.princeton.cs.algs4.StdOut;
import edu.princeton.cs.algs4.StdRandom;

@SuppressWarnings({"unchecked", "rawtypes","deprecation"})
public class Quick3way {
	
	
	public static void sort(Comparable[] a) {
		StdRandom.shuffle(a); // eliminate dependence on input. 
		sort(a, 0, a.length -1); 
	}
	
	// Recursive quicksort algo
	private static void sort(Comparable[] a, int lo, int hi) {
		
		if (hi <= lo) return ; 
		int lt = lo
		int i = lo + 1;
		int gt = hi; 

		Comparable v = a[lo]; 
		while (i <= gt) {
			int cmp = a[i].compareTo(v); 
			if 		(cmp < 0) exch(a, lt++, i++); 
			else if (cmp > 0) exch(a, i, gt--); 
			else 	i++; 
		}
		
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
