import edu.princeton.cs.algs4.StdOut;
// Complete implementation of Symbol Table using Linear Probing Hash Table
// The key type MUST override equals() and hashcode() methods.

public class LinearProbingHashST<Key, Value> {

    private static final int INIT_CAPACITY = 4; // must be a power of 2

    private int n;          // number of key-value pairs in the symbol table
    private int m;          // size of linear probing table
    private Key[] keys;     // the keys
    private Value[] vals;   // the values
}
