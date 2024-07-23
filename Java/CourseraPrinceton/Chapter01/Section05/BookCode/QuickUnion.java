import edu.princeton.cs.algs4.*;

public class QuickUnion implements UFI {



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
