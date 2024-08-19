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
        while (x != null) {
            int cmp = key.compareTo(x.key);
            if      (cmp < 0) x = x.left;
            else if (cmp > 0) x = x.right;
            else              return x.val;
        }
        return null;
    }

}












































































