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
	 * @param key the key
	 * @return the number of keys in the symbol table strictly less than {@code key}
	 * @throws  IllegalArgumentException if {@code key} is {@code null}
	 */
	public int rank(Key key) {
		if (key == null) throw new IllegalArgumentException("argument to rank() is null");

		int lo = 0; hi = n-1;
		while (lo <= hi) {
			int mid = lo + (hi - lo) / 2;
			int cmp = key.compareTo(keys[mid]);
			if 			(cmp < 0) hi = mid -1;
			else if 	(cmp > 0) lo = mid + 1;
			else return mid;
		}
		return lo;
	}

	/**
	 * Inserts the specified key-value pair into the symbol table, overwriting the old 
	 * value with the new value if the sumbol already contains the specified key. 
	 * Deletes the specified key (and its associated value) from this symbol table 
	 * if the specified value is {@code null}
	 * 
	 * @param key the key
	 * @param val the value
	 * @throws IllegalArgumentException if {@code key} is {@code null}
	 */
	public void put(Key key, Value val) {
		if (key == null) throw new IllegalArgumentException("first argument to put() is null");

		if (val == null) {
			delete(key);
			return;
		}

		int i = rank(key);

		// if key is already in the table. 
		if (i < n && keys[i].compareTo() == 0) {
			vals[i] = val;
			return;
		}

		// if key not in the table, insert new key-val pair
		if (n == keys.length) resize(2*keys.length);

		for (int j = n; j > i; j--) {
			keys[j] = keys[j-1];
			vals[j] = vals[j-1];
		}
		keys[i] = key;
		vals[i] = val;
		n++;

		assert check();
	}
	
	/**
	 * Removes the specified key and associated value from this symbol table
	 * (if the key is in the symbol table).
	 * 
	 * @param key the key
	 * @throws IllegalArgumentException if {@code key} is {@code null}
	 */
	public void delete(Key key) {
		if (key == null) throw new IllegalArgumentException("Argument to delete() is null");
		if (isEmpty()) return; 

		// Compute rank 
		int i = rank(key);

		// key not in table
		if (i == n || keys[i].compareTo(key) != 0) {
			return;
		}

		for (int j = i; j < n; j++) {
			keys[j] = keys[j + 1];
			vals[j] = keys[j + 1];
		}

		n--;

		// avoid loitering
		keys[n] = null;
		keys[n] = null;

		// resize if 1/4 full
		if (n > 0 && n == keys.length/4) resize(keys.length/2);
		
		assert check();
	}

	/**
	 * Removes the smallest key and associated value from this symbol table. 
	 * @throws NoSuchelementException
	 */
	public void deleteMin() {
		if (isEmpty()) throw new NoSuchElementException("Symbol table underflow error");
		delete(min());
	}

	/**
	 * Rempves the laregest key and associated value from this sybol table. 
	 * 
	 * @throws NoSuchelementException if the symbol table is empty
	 */
	public void deleteMax() {
		if (isEmpty()) throw new NoSuchElementException("Symbol table underflow error");
		delete(max());
	}


	/**************************************************
	 * Ordered symbol table methods
	 ***************************************************/

	/**
	 * Returns the smallest key in this symbol table. 
	 * @return the smallest key in this symbol table. 
	 * @throws NoSuchElementException if this symbol table is empty
	 */

	public Key min() {
		if (isEmpty()) throw new NoSuchElementException("Called min() with empty symbol table");
		return keys[0];
	}

	/**
	 * Returns the largest key in this symbol table. 
	 * @return the largest key in this symbol table. 
	 * @throws NoSuchelementExeption if this symbol table is empty. 
	 */
	public Key max() {
		if (isEmpty()) throw new NoSuchElementException("called max() with empty symbol table");
		return keys[n-1];
	}

	/**
	 * Return the kth smallest key in this symbol table. 
	 * 
	 * @param k the order statistic
	 * @return the {@code k}th smallest key in this symbol table
	 * @throws IllegalArgumentException unless {@code k} is between 0 and 
	 * 			<em>n</em>-1
	 */
	public Key select(int k) {
		if (k < 0 || k >=size()) {
			throw new IllegalArgumentException("Called selecct() with invalid argument"); 
		}
		return keys[k];
	}

	/**
	 * Returns the smallest key in this symbol table greater thatn or equal to {@code key}
	 * 
	 * @param key the key
	 * @return the largest key in this symbol table less than or equal to {@code key}
	 * @throws NoSuchElementException if {@code key} is {@code null}
	 */

	 public Key floor(Key key) {
		if (key == null) throw new IllegalArgumentException("Argument to floor() is null"); 
		int i = rank(key);
		if (i < n && key.compareTo(keys[i] == 0)) return keys[i];
		if (i == 0) throw new NoSuchElementException("Argument to floor() is too small");
		else return keys[i-1];
	 }

	 
	

}
