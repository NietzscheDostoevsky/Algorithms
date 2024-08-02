import java.util.Random;

public class SortCompareTest {
    public static void main(String[] args) {
        int arraySize = 1000000;  // Size of array
        int numTrials = 100;      // Number of trials
        double quickSortTime = 0;
        double shellSortTime = 0;
        
        Random random = new Random();
        
        for (int t = 0; t < numTrials; t++) {
            Double[] array1 = new Double[arraySize];
            Double[] array2 = new Double[arraySize];
            
            for (int i = 0; i < arraySize; i++) {
                double value = random.nextDouble();
                array1[i] = value;
                array2[i] = value;
            }
            
            long startTime = System.nanoTime();
            quickSort(array1);
            long endTime = System.nanoTime();
            quickSortTime += (endTime - startTime) / 1e6; // Convert to milliseconds
            
            startTime = System.nanoTime();
            Shell.sort(array2);
            endTime = System.nanoTime();
            shellSortTime += (endTime - startTime) / 1e6; // Convert to milliseconds
        }
        
        System.out.println("Average time taken for Quick sort: " + (quickSortTime / numTrials) + " ms");
        System.out.println("Average time taken for Shell sort: " + (shellSortTime / numTrials) + " ms");
    }

    public static void quickSort(Double[] array) {
        quickSort(array, 0, array.length - 1);
    }

    private static void quickSort(Double[] array, int low, int high) {
        if (low < high) {
            int pi = partition(array, low, high);
            quickSort(array, low, pi - 1);
            quickSort(array, pi + 1, high);
        }
    }

    private static int partition(Double[] array, int low, int high) {
        Double pivot = array[high];
        int i = (low - 1);
        for (int j = low; j < high; j++) {
            if (array[j] <= pivot) {
                i++;
                swap(array, i, j);
            }
        }
        swap(array, i + 1, high);
        return i + 1;
    }

    private static void swap(Double[] array, int i, int j) {
        Double temp = array[i];
        array[i] = array[j];
        array[j] = temp;
    }
}

class Shell {
    @SuppressWarnings({ "rawtypes" })
    public static void sort(Comparable[] a) {
        int N = a.length;
        int h = 1;
        while (h < N / 3) {
            h = 3 * h + 1; // 1,4,13,40,121,364,1093.....
        }
        while (h >= 1) {
            // h-sort the array
            for (int i = h; i < N; i++) {
                // Insert a[i] among a[i-h], a[i-2*h], a[i-3*h]...
                for (int j = i; j >= h && less(a[j], a[j - h]); j -= h) {
                    exch(a, j, j - h);
                }
            }
            h = h / 3;
        }
    }

    private static boolean less(Comparable v, Comparable w) {
        return v.compareTo(w) < 0;
    }

    private static void exch(Comparable[] a, int i, int j) {
        Comparable temp = a[i];
        a[i] = a[j];
        a[j] = temp;
    }

    public static boolean isSorted(Comparable[] a) {
        for (int i = 1; i < a.length; i++)
            if (less(a[i], a[i - 1])) return false;
        return true;
    }
}
