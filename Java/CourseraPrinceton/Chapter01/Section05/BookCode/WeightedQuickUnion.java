// implementing weighted quick-union 

import edu.princeton.cd.algs4.*; 

public class WeightedQuickUnion implements UFI {




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
