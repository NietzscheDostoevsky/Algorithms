public class MergeJDK21 {
	private static Comparable[] aux; 
	private static void merge(Comparable[] a, int lo, int mid, int hi) {
		int i = lo, j = mid + 1; // initial index of the two arrays to be merged 

		for (int k = lo; k <= hi; k++) 
			aux[k] = a[k]; 

		for (int k = lo; k <= hi; k++) { // outer loop to iterate through the array
            if                       (i > mid) a[k] = aux[j++]; // left half exhausted, take from the right
            else if                   (j > hi) a[k] = aux[i++]; // right half exhausted, take from the left
            else if (less(aux[j], aux[i]))     a[k] = aux[j++]; // current key on right less than current key on left,take from the right
            else                               a[k] = aux[i++]; // current key on the right greater than or equal to current key on left take from the left.
        }
    }

    public static void sort(Comparable[] a) {
    	int N = a.length;
    	aux = new Comparable[N]; 
    	sort(a, 0, N-1);
    }

    private static void sort(Comparable[] a, int lo, int hi) {

        if (hi <= lo) return; // base case. 
    	int mid = lo + (hi - lo) / 2; 
    	sort(a, lo, mid); // sorting the left half
    	sort(a, mid + 1, hi); // sorting the right half
    	merge(a, lo, mid, hi); 
    }

    // ******************************************************
    // Helper functions for main()

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

    private static void show(Comparable[] a) {
        for (int i = 0; i < a.length; i++)
            System.out.print(a[i] + " ");
        System.out.println();
    }

    public static void main(String[] args) {
        // Read strings from standard input, sort them, and print.

        Integer[] a = {9,8,7,6,5,4,3,2,1,0};
        sort(a);
        assert isSorted(a);
        show(a);
    }

}