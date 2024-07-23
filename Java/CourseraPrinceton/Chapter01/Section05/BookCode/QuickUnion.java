import edu.princeton.cs.algs4.*;

public class QuickUnion implements UFI {

    private int[] id; 
    private int count; 

    public QuickUnion(int N) { // constructor 
        count = N; 
        id = new int[N]; 
        for (int i = 0; i < N; i++) {
            id[i] = i;
        }
    }

    public static void main(String[] args) {
       // main driver method 
       int N = StdIn.readInt();
       QuickUnion qu = new QuickUnion(N);

       while (!StdIn.isEmpty()) {
           int p = StdIn.readInt();
           int q = StdIn.readInt();

           if(qu.connected(p, q)) continue;
           qu.union(p, q);
           StdOut.println(p + " " + q);
       }
        StdOut.println(qu.count() + " components"); 
    }
}
