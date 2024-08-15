import java.util.NoSuchElementException; 

public class BinarySearchST<Key extends Comparable<Key>, Value> {
	private static final int INIT_CAPACITY = 2; 
	private Key[] keys;
	private Value[] vals;
	private int n = 0;

	/**
	 *Iniatialize an empty symbol table. 
	 */
	public BinarySearchST() {
		this(INIT_CAPACITY);
	}

	/** 
	 * Iniatializes an empty symbol table with the specified initial capacity. 
	 * @param capacity the maximum capacity. 
	 */
	public BinarySearchST(int capacity) {
		keys = (Keys[]) new Comparable[capacity];
		vals = (Vals[]) new Comparable[capacity];
	}

	// Resize the underlying arrays
	private void resize(int capacity) {
		assert capacity >= n;
		Key[] tempk = (Key[]) new Comparable[capacity];
		Value[] tempv = (Value[]) new Comparable[capacity];
		for (int i = 0; i < n; i++) {
			tempk[i] = keys[i];
			tempv[i] = vals[i];
		}
		vals = tempv;
		keys = tempk; 
	}

	/**
	 * Returns the number of key-value pairs in this symbol table. 
	 * 
	 * @return the number of key-value paris in this symbol table. 
	 */ 
	public int size() {
		return n; 
	}

	/**
	 * Returns true if this symbol table is empty. 
	 * @return {@code true} if this symbol table is empty;
	 * 		   {@code false} otherwise
	 */
	public boolean isEmpty() {
		return size() == 0; 
	}

	/** 
	 * Does this symbol table contain the given key? 
	 * @param key the key
	 * @return {@code true} if this symbol table contains {@code key} and 
	 * 		   {@code false} otherwise
	 * @throws IllegalArgumentException if {@code key} is {@code null}
	 */ 
	public boolean contains(Key key) {
		if (key == null) throw new IllegalArgumentException("argument to contains() is null");
		return get(key) != null;
	}

	/**
	 * Returns the value associated with the given key in this symbol table. 
	 * 
	 * @param key the key
	 * @return the value associated with the given key if the key is in the symbol table.
	 * 			and {@code null} if the key is not in the symbol table. 
	 * @throws IllegalArgumentException if {@code key} is {@code null}
	 */
	public Value get(Key key) {
		if (key == null) throw new IllegalArgumentException("argument to rank() is null");
		if (isEmpty()) return null; 
		int i = rank(key); 
		if (i < n && keys[i].compareTo(key) == 0) return vals[i]; 
		return null;
	}

	/**
	 * Returns the number of keys in this symbol table strictky less than {@code key}.
	 * 
	 * @param 
}
