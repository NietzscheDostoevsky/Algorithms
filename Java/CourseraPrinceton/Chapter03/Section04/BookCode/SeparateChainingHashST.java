// Complete implementation of Symbol Table using Separate Chaining Hash Table
// The key type MUST override equals() and hashcode() methods.

import edu.princeton.cs.algs4.SequentialSearchST;

@SuppressWarnings("unchecked")
public class SeparateChainingHashST<Key, Value> {
    private static final int INIT_CAPACITY = 4;

    private int n;                               // number of key-value pairs
    private int m;                               // hash table size
    private SequentialSearchST<Key, Value>[] st; // array of linked-list symbol tables

    /**
     * Initializes an empty symbol table.
     */
    public SeparateChainingHashST() {
        this(INIT_CAPACITY);
    }

    /**
     * Initializes an empty symbol table with {@code m} chains.
     * @param m the initial number of chains
     */
    public SeparateChainingHashST(int m) {
        this.m = m;
        st = (SequentialSearchST<Key, Value>[]) new SequentialSearchST[m];
        for (int i = 0; i < m; i++)
            st[i] = new SequentialSearchST<Key, Value>();
    }



}
