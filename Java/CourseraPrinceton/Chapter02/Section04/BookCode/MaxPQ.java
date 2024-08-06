/*
* Created By : Saurabh Singh
* Source: Algorithms, by Sedgewick
 */

public class MaxPQ<Key extends Comparable<Key>>  {
    // Heap of size N in private array pq[] of length 
    // N + 1, with pq[0] unueed, 
    // heap resides in pq[1] to pq[N]
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

    // We add the new key at the end of the array, increament the size 
    // of the heap, and then swim up through the heap with that key
    // to restore the heap condition.
    public void insert(Key v) {
        pq[++N] = v;
        swim(N);
    }

    // We take the largest key off the top, put the item from the end 
    // of the heap at the top, decrement the size of the heap
    // and then sink down throught the heap with that key to restore
    // the heap condition. 
    public Key delMax() {
        Key max = pq[1]; // Retrieve max key from top.
        exch(1, N--); // Exchange with last item.
        pq[N+1] = null; // Avoid loitering
        sink(1); // Restore heap property
        return max;
    }

    //*** Helper methods***
    private boolean less(int i, int j) {
       return pq[i].compareTo(pq[j]) < 0;
    }

    private void exch(int i, int j) {
        Key temp = pq[i];
        pq[i] = pq[j];
        pq[j] = temp;
    }

    /*
    * Bottom up reheapify (swim) 
    * Priority of some node is increased, or a new node is added 
    * at the bottom of a heap, we have to trave up the heap to restore
    * the heap order.

    * Invariant : the only place the heap order could be violated is when
    *   the node at position k might be larger than its parent. 
    */
    private void swim(int k) {
        // Moving up the heap until we reach a node with larger key, 
        // or the root. 
        while (k > 1 && less(k/2, k)) {
            exch(k/2, k);
            k = k/2;
        }
    }

    /*
    * Top-Down reheapify (sink)
    * When the priority of some node is decreased, for example, if we replace
    * the node at the root with a new node that has a smaller key, we have to 
    * travel down the heap to restore the heap order. 
    */
    private void sink(int k) {
        while (2 * k <= N) {
            int j = 2*k;
            if (j < N && less(j, j+ 1)) j++;
            if (!less(k, j)) break;
            exch(k, j);
            k = j;
        }
    }
}
