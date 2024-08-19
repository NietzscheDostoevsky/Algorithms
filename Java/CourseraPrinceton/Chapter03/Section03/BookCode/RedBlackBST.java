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



}












































































