import edu.princeton.cs.algs4.StdOut;
// Complete implementation of Symbol Table using Linear Probing Hash Table
// The key type MUST override equals() and hashcode() methods.

@SuppressWarnings("unchecked")
public class LinearProbingHashST<Key, Value> {

    private static final int INIT_CAPACITY = 4; // must be a power of 2

    private int n;          // number of key-value pairs in the symbol table
    private int m;          // size of linear probing table
    private Key[] keys;     // the keys
    private Value[] vals;   // the values

    /**
     * Initializes an empty symbol table.
     */
    public LinearProbingHashST() {
        this(INIT_CAPACITY);
    }

    /**
     * Initializes an empty symbol table with the specified initial capacity.
     *
     * @param capacity the initial capacity
     */
    public LinearProbingHashST(int capacity) {
        m = capacity;
        n = 0;
        keys = (Key[]) new Object[m];
        vals = (Value[]) new Object[m];
    }
}
