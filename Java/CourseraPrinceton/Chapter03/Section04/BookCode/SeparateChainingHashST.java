// Complete implementation of Symbol Table using Separate Chaining Hash Table
// The key type MUST override equals() and hashcode() methods.

import edu.princeton.cs.algs4.SequentialSearchST;

public class SeparateChainingHashST<Key, Value> {
    private static final int INIT_CAPACITY = 4;

    private int n;                               // number of key-value pairs
    private int m;                               // hash table size
    private SequentialSearchST<Key, Value>[] st; // array of linked-list symbol tables
    
}
