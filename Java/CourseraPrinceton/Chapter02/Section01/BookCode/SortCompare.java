import edu.princeton.cs.algs4.*; 

public class SortCompare {

    public static double time(String algo, Double[] a) {
        Stopwatch timer = new Stopwatch();
        if (algo.equals("Insertion")) Insertion.sort(a); 
        if (algo.equals("Selection")) Selection.sort(a); 
        if (algo.equals("Shell ")) Shell.sort(a); 
        if (algo.equals("Merge")) Merge.sort(a); 
        if (algo.equals("Quick")) Quick.sort(a); 
        if (algo.equals("Heap")) Heap.sort(a); 

        return timer.elapsedTime();

    }
    public static double timeRandomInput(String algo, int N, int T) {
        // Use algo to sort T random arrays of length N. 
        double total = 0.0 ; 
        Double[] a = new Double[N]; 

        
        for (int t = 0; t < T; t++) {
            // Perform one experiment ( generate and sort an array)
            for (int i = 0; i < N; i++)
                a[i] = StdRandom.uniform();
            total += time(algo, a); 
        }
        return total ; 
    }

    public static void main(String[] args) {
        String algo1 = args[0];
        String algo2 = args[1];
        int N = Integer.parseInt(args[2]);
        int T = Integer.parseInt(args[3]);
        double t1 = timeRandomInput(algo1, N, T);// total for algo1
        double t2 = timeRandomInput(algo2, N, T); // total for algo2

        StdOut.printf("For %d random Double \n %s is ", N, algo1); 
        StdOut.printf(" %.1f times faster than %s \n", t2/t1, algo2); 
    }
}