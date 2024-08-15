/*
 * This ST implementation keeps the keys and values in parallel arrays. 
 * The put() implementation moves larger keys one position to the right before 
 *      growing the table as in the array-based stack implmentation. 
 * Array-resizing code is omitted here 
 */

 // Complete implementation of an ordered Symbol Table.

 // BINARY SEARCH SYMBOL TABLE (ORDERED)

import java.util.Queue;

@SuppressWarnings("unchecked")
public class BinarySearchST<Key extends Comparable<Key>, Value> {
    private Key[] keys; 
    private Value[] vals; 
    private int N; 

    public BinarySearchST(int capacity) {
        // Standard array resizing code to be updated later .
        
        keys = (Key[]) new Comparable[capacity]; // can'tmake generic arrays
        vals = (Value[]) new Object[capacity];
    }

    public int size() {return N;};
    
    
    public Value get(Key key) {
        if (isEmpty()) return null; 

        // the rank tells us precisely where the key is
        // to be found if it is in the table (and, if it is not there, 
        // that it is not in the table).
        int i = rank(key); 
        if (i < N && keys[i].compareTo(key) == 0) return vals[i];
        else                                      return null; 
    }

    // The heart of this implementation is this rank() method, 
    // which returns the number
    // of keys smaller than a given key.
    public int rank(Key key) {
        int lo = 0; 
        int hi = N -1; 

        while (lo <= hi) {
            int mid = lo + (hi - lo) / 2; 
            int cmp = key.compareTo(keys[mid]);
            if      (cmp < 0) hi = mid - 1; 
            else if (cmp > 0) lo = mid + 1;
            else return mid;  
        }
        return lo; 
    }

     // Search for key. Update value if found; grow table if new. 
    public void put(Key key, Value val) {

       // the rank tells us precisely where to update the 
       // value when the key is in the
       // table, and precisely where to put the key when the key is not in the table. 
       int i = rank(key); 
       if (i < N && keys[i].compareTo(key) == 0) {
            vals[i] = val; 
            return ;
       }
       for (int j = N; j > i; j--) {
            keys[j] = key; 
            vals[j] = val;
            N++;
       }
    }

    public Key min() {
        return keys[0];
    }

    public Key max() {
        return keys[N-1];
    }

    public Key select(int k) {
        return keys[k];
    }

    public Key ceiling(Key key) {
        int i = rank(key);
        return keys[i];
    }

    public Key floor(Key key) {
        // Exercise 3.1.17

    }

    public Key delete(Key key) {
        // Exercise 3.1.16
    }

    public Iterable<Key> keys(Key lo, Key hi) {
        Queue<Key> q = new Queue<Key>(); 
        for (int i = rank(lo); i < rank(hi); i++) 
            q.enqueue(keys[i]);
        if (contains(hi))
            q.enqueue(keys[rank(hi)]);
        return q;
    }

    // Defalut implementatios of redundant order-based symbol-table methods. 
    public void deleteMin() {
        delete(min());
    }

    public void deleteMax() {
        delete(max());
    }

    public int size(Key lo, Key hi) {
        if (hi.compareTo(lo) < 0)
            return 0;
        else if (contains(hi))
            return rank(hi) - rank(lo) + 1;
        else 
            return rank(hi) - rank(lo);
    }

    public boolean contains(Key key) {
        return get(key) != null; 
    }

}
