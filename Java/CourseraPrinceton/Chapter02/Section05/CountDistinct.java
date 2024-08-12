import edu.princeton.cs.algs4.Quick;
import edu.princeton.cs.algs4.StdOut;

public class CountDistinct {
    public static void main(String[] args) {
        Integer[] a = {
                2, 3, 4, 5, 4, 3, 2, 12, 3, 4, 5, 34, 1, 3, 32, 3, 43, 5, 5, 43, 3, 4, 56, 4, 3, 32,
                4, 23, 3, 34, 23
        };

        Quick.sort(a);
        int count = 0;
        for (int i = 1; i < a.length; i++)
            if (a[i].compareTo(a[i-1]) != 0)
                count++;
        StdOut.println("Distince elements : " + count );
    }
}
