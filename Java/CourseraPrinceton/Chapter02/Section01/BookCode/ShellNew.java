import java.util.Scanner;

@SuppressWarnings({"rawtypes", "deprecation"})
public class ShellNew {

    // Sort a[] into increasing order using ShellSort algorithm
    public static void sort(Comparable[] a) {
        int N = a.length;
        int h = 1;
        while (h < N / 3) {
            h = 3 * h + 1; // 1, 4, 13, 40, 121, 364, 1093, ...
        }
        while (h >= 1) {
            // h-sort the array
            for (int i = h; i < N; i++) {
                // Insert a[i] among a[i-h], a[i-2*h], a[i-3*h], ...
                for (int j = i; j >= h && less(a[j], a[j - h]); j -= h) {
                    exch(a, j, j - h);
                }
            }
            h /= 3;
        }
    }

    // Helper function to check if one Comparable is less than another
    private static boolean less(Comparable v, Comparable w) {
        return v.compareTo(w) < 0;
    }

    // Helper function to exchange elements in an array
    private static void exch(Comparable[] a, int i, int j) {
        Comparable temp = a[i];
        a[i] = a[j];
        a[j] = temp;
    }

    // Print the array to standard output
    private static void show(Comparable[] a) {
        for (Comparable item : a)
            System.out.print(item + " ");
        System.out.println();
    }

    // Check if the array is sorted
    public static boolean isSorted(Comparable[] a) {
        for (int i = 1; i < a.length; i++) 
            if (less(a[i], a[i - 1])) return false;
        return true;
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter the number of elements:");
        int n = scanner.nextInt();
        Integer[] a = new Integer[n];
        System.out.println("Enter the elements:");
        for (int i = 0; i < n; i++) {
            a[i] = scanner.nextInt();
        }
        scanner.close();
        
        sort(a);
        assert isSorted(a);
        show(a);
    }
}
