/*
* Created By : Saurabh Singh
* Source: Algorithms, by Sedgewick
 */

public class MaxPQ<Key extends Comparable<Key>> implements MaxPQInterface {
    private Key[] pq; // heap-ordered complete binary tree
    private int N = 0; // in pq[1...N] with pq[0] unused

    public MaxPQ(int maxN) {
        pq = (Key[]) new Comparable[maxN + 1];
    }

    public boolean isEmpty() {
        return N == 0;
    }

    public int size() {
        return N;
    }

    public void insert(Key v) {
        pq[++N] = v;
        swim(N);
    }

    public Key delMax() {
        Key max = pq[1]; // Retrieve max key from top.
        exch(1, N--); // Exchange eith last item.
        pq[N+1] = null; // Avoid loitering
        sing(1); // Restore heap property
        return max;
    }


}
