import java.util.NoSuchElementException;
import edu.princeton.cs.algs4.StdOut;

// Complete implementation of red-black BST

public class RedBlackBST<Key extends Comparable<Key>, Value> {

    private static final boolean RED = true;
    private static final boolean BLACK = false;

    private Node root; // root of the BST

    // BST helper Node data type
    private class Node {
        private Key key;        // key
        private Value val;      // associated data
        private Node left;      // link to left subtree, parent > child
        private Node right;     // link to right subtree, parent < child
        private boolean color;  // color of parent link
        private int size;       // subtree count;

        public Node(Key key, Value val, boolean color, int size) {
            this.key = key;
            this.val = val;
            this.color = color;
            this.size = size;
        }
    }

    /**
     * Initializes an empty symbol table.
     */
    public RedBlackBST() {
        // no argument constructor
    }

    /*******************************************************************
     *  Node helper methods
     ****************************************************/
    // is node x re; false if x is null?
    private boolean isRed(Node x) {
        if (x == null) return false;
        return x.color == RED;
    }

    // number of node in subtree rooted at x; 0 if x is null;
    private int size(Node x) {
        if (x == null) return 0;
        return x.size;
    }

    /**
     * Returns the number of key-value paris in this symbol table.
     * @return the number of key-value pairs in this symbol table.
     */
    public int size() {
        return size(root);
    }

    /**
     * Is this symbol table empty?
     * @return {@code true} if this symbol table is empty and {@code false} otherwise
     */
    public boolean isEmpty() {
        return root == null;
    }

    /***************************************************************************
     *  Standard BST search.
     ***************************************************************************/

    /**
     * Returns the value associated with the given key.
     * @param key the key
     * @return the value associated with the given key if the key is in the symbol table
     *     and {@code null} if the key is not in the symbol table
     * @throws IllegalArgumentException if {@code key} is {@code null}
     */
    public Value get(Key key) {
        if (key == null) throw new IllegalArgumentException("argument to get() is null");
        return get(root, key);
    }

    // value associated with the given key in a subtree rooted at x, null if no such key
    private Value get(Node x, Key key) {
        //Iterative approach

        while (x != null) {
            int cmp = key.compareTo(x.key);
            if      (cmp < 0) x = x.left;
            else if (cmp > 0) x = x.right;
            else              return x.val;
        }
        return null;
    }

    /**
     * Does this symbol table contain the given key?
     * @param key the key
     * @return {@code true} if this symbol table contains {@code key} and
     *     {@code false} otherwise
     * @throws IllegalArgumentException if {@code key} is {@code null}
     */
    public boolean contains(Key key) {
        return get(key) != null;
    }

    /****************************************************************
            *  Red-black tree insertion.
    ****************************************************************/

    /**
     * Inserts the specified key-value pair into the symbol table, overwriting the old
     * value with the new value if the symbol table alrady contains the specified key.
     * Deletes the specified key (and its associated value) from this symbol table
     * if the specified value is {@code null}.
     *
     * @param key the key
     * @param val the value
     * @throws IllegalArgumentException if {@code key} is {@code null}.
     */
    public void put(Key key, Value val) {
        if (key == null) throw new IllegalArgumentException("First argument to put() is null");
        if (val == null) {
            delete(key);
            return;
        }

        root = put(root, key, val);
        root.color = BLACK;
        // assert check();
    }

    // insert the key value pair in the subtree rooted at h
    private Node put(Node h, Key key, Value val) {
        // The method ensures that the Red-Black Tree remains balanced and maintains its properties:
        // No red node has a red child.
        // Every path from the root to a leaf has the same number of black nodes.
        // Red nodes lean left.

        if (h == null) return new Node(key, val, RED, 1); // base case

        int cmp = key.compareTo(h.key);
        if      (cmp < 0) h.left  = put(h.left,  key, val);
        else if (cmp > 0) h.right = put(h.right, key, val);
        else              h.val   = val;

        // fix-up any right-leaning links

        // If the right child is red and the left child is not,
        // a left rotation is performed to ensure that red links lean left.
        if (isRed(h.right) && !isRed(h.left))      h = rotateLeft(h);
        // If both the left child and its left child are red,
        // a right rotation is performed to balance the tree.
        if (isRed(h.left)  &&  isRed(h.left.left)) h = rotateRight(h);
        // If both the left and right children are red,
        // the colors are flipped (i.e., the current node becomes red, and both children become black).
        if (isRed(h.left)  &&  isRed(h.right))     flipColors(h);
        h.size = size(h.left) + size(h.right) + 1;

        return h;
    }

    /***************************************************************************
     *  Red-black tree deletion.
     ***************************************************************************/

    /**
     * Removes the smallest key and associated value from the symbol table.
     * @throws NoSuchElementException if the symbol table is empty
     */
    public void deleteMin() {
        if (isEmpty()) throw new NoSuchElementException("BST underflow");

        // if both children of root are black, set root to red.
        if (!isRed(root.left) && !isRed(root.right))
            root.color = RED;

        root = deleteMin(root);
        if (!isEmpty()) root.color = BLACK;
        // assert check();
    }

    // delete the key-val pair with the minimum key rooted at h
    private Node deleteMin(Node h) {
        if (h.left == null) return null;
        if (!isRed(h.left) && !isRed(h.left.left))
            h = moveRedLeft(h);

        h.left = deleteMin(h.left);
        return balance(h);
    }

}












































































