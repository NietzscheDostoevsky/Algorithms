// implementing weighted quick-union 

import edu.princeton.cd.algs4.*; 

public class WeightedQuickUnion implements UFI {

    private int[] id; // parent link (site indexed)
    private int[] sz; // size of component for roots (site indexed)
    private int count; // number of components
    
    
    public WeightedQuickUnion(int N) { // constructor
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

    private int find(int p) {
        // follow links to find a root


    }

    public static void main(String[] args) {
        
        int N = StdIn.readInt(); 
        WeightedQuickUnion wqf = new WeightedQuickUnion(N); 

        while (!StdIn.isEmpty()) {
            int p = StdIn.readInt(); 
            int q = StdIn.readInt(); 
            if (wqf.connected(p, q) {
                continue;
            }
            wqf.union(p, q);
            StdOut.println(q + " " + q); 
        }
        StdOut.println(wqf.count() + " components");

    }
}
