public interface MaxPQ<Key extends Comparable<Key>> {
    
    /**
     * Inserts a key into the priority queue.
     *
     * @param v the key to insert
     */
    void insert(Key v);

    /**
     * Returns the largest key in the priority queue.
     *
     * @return the largest key
     * @throws NoSuchElementException if the priority queue is empty
     */
    Key max();

    /**
     * Removes and returns the largest key in the priority queue.
     *
     * @return the largest key
     * @throws NoSuchElementException if the priority queue is empty
     */
    Key delMax();

    /**
     * Checks if the priority queue is empty.
     *
     * @return true if the priority queue is empty; false otherwise
     */
    boolean isEmpty();

    /**
     * Returns the number of keys in the priority queue.
     *
     * @return the number of keys
     */
    int size();
}
