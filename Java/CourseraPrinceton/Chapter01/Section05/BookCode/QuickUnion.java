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

    public int count() {return count;}

    
    public boolean connected(int p, int q) {
        return find(p) == find(q) ;
    }

    public int find(int p) {
        // find component name; 
        while(p != id[p]) {
            p = id[p];
        }
        return p;
    }

    public void union(int p, int q) {
        // Give p and q the same root. 
        int pRoot = find(p); 
        int qRoot = find(q); 
        if (pRoot == qRoot) {
            return;
        }
        id[pRoot] = qRoot; 
        count--;
    }

    public static void main(String[] args) {
       // main driver method 
       int N = StdIn.readInt();
       QuickUnion qu = new QuickUnion(N);
       Stopwatch timer = new Stopwatch();

       while (!StdIn.isEmpty()) {
           int p = StdIn.readInt();
           int q = StdIn.readInt();

           if(qu.connected(p, q)) continue;
           qu.union(p, q);
           StdOut.println(p + " " + q);
       }
        StdOut.println("Elapsed Time: " + timer.elapsedTime()); 
        StdOut.println(qu.count() + " components");

    }
}
