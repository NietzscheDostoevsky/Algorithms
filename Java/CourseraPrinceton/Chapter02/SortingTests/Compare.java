package SortingTests;

import edu.princeton.cs.algs4.Merge;
import edu.princeton.cs.algs4.Quick;
import edu.princeton.cs.algs4.StdOut;
import edu.princeton.cs.algs4.StdRandom;
import edu.princeton.cs.algs4.Stopwatch;

public class Compare {

    public static double time(String alg, Double[] a) {
        Stopwatch timer = new Stopwatch();
        if (alg.equals("ShellBook")) ShellBook.sort(a);
        if (alg.equals("ShellLib")) ShellLib.sort(a);
        if (alg.equals("Merge")) Merge.sort(a);
        if (alg.equals("Quick")) Quick.sort(a);

        return timer.elapsedTime();
    }

    public static double timeRandomInput(String alg, int N, int T) {
        // Use alg to sort T random arrays of length N.
        double total = 0.0;
        Double[] a = new Double[N];
        for (int t = 0; t < T; t++) {
            for (int i = 0; i < N; i++) {
                a[i] = StdRandom.uniform();
            }
            total += time(alg, a);
        }
        return total;
    }

    public static void main(String[] args) {
        String alg1 = args[0];
        String alg2 = args[1];
        int N = Integer.parseInt(args[2]);
        int T = Integer.parseInt(args[3]);
        double time1 = timeRandomInput(alg1, N, T);
        double time2 = timeRandomInput(alg2, N, T);
        StdOut.printf("Time taken for %s is : %.6f \n", alg1, time1);
        StdOut.printf("Time taken for %s is : %.6f \n", alg2, time2);
        StdOut.println("-----------------------------------------");
        StdOut.printf("For %d random Double\n", N);
        StdOut.printf("%s is %.1f times faster than %s\n", alg1, time2 / time1, alg2);
    }
}
