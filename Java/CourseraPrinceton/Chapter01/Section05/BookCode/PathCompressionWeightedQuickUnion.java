// implementing weighted quick-union 

import edu.princeton.cs.algs4.*; 

public class PathCompressionWeightedQuickUnion implements UFI {

    private int[] id; // parent link (site indexed)
    private int[] sz; // size of component for roots (site indexed)
    private int count; // number of components
    
    
    public PathCompressionWeightedQuickUnion(int N) { // constructor
        count = N; 
        id = new int[N]; 

        for (int i = 0; i < N; i++) {
            id[i] = i; 
        }
        sz = new int[N];
        for (int i = 0; i < N; i++) {
            sz[i] = 1; 
        }
    }

    public int count() {
        return count; 
    }

    public boolean connected(int p, int q) {
        return find(p) == find(q); 
    }

    public int find(int p) {
        // follow links to find a root
        while(p != id[p]) {
            p = id[p];
        }
        return p;
    }

    public void union(int p, int q) {
         // implement later,
        
    }

    public static void main(String[] args) {
        
        int N = StdIn.readInt(); 
        PathCompressionWeightedQuickUnion pcwqf = new PathCompressionWeightedQuickUnion(N); 
        Stopwatch timer = new Stopwatch();
        while (!StdIn.isEmpty()) {
            int p = StdIn.readInt(); 
            int q = StdIn.readInt(); 
            if (pcwqf.connected(p, q)) {
                continue;
            }
            wqf.union(p, q);
            StdOut.println(q + " " + q); 
        }
        double time = timer.elapsedTime();
        StdOut.println(pcwqf.count() + " components");
        StdOut.println("Elapsed Time: " + time);

    }
}
