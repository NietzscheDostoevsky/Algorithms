// Complete implementation of Binary Search Tree Symbol Table.
import java.util.NoSuchElementException;

public class BST<Key extends Comparable<Key>, Value> {
    private Node root;              // root of the BST

    private class Node {
        private Key key;      // sorted by key.
        private Value val;    // associated data.
        private Node left;    // left subtrees. parent>child
        private Node right;   // right subtress. parent<child
        private int size;     // number of nodes in the subtree

        // Node constructor
        public Node(Key key, Value val, int size) {
            this.key = key;
            this.val = val;
            this.size = size;
        }
    }

    /**
     * Initializes an empty symbol table.
     */
    public BST() {
    }

    /**
     * Returns true if this symbol table is empty.
     * @return {@code true} if this symbol table is empty; {@code false} otherwise
     */
    public boolean isEmpty() {
        return size() == 0;
    }

    /**
     * Returns the number of key-value pairs in this symbol table.
     * @return the number of key-value pairs in this symbol table.
     */
    public int size() {
        return size(root);
    }

    // return the number of key-value pairs in BST rooted at x
    private int size(Node x) {
        if (x == null) return 0;
        else return x.size;
    }

    /**
     * Does this symbol table contain the given key?
     *
     * @param key the key
     * @return {@code true} if this symbol table contains {@code key} and
     *         {@code false} otherwise.
     * @throws IllegalArgumentException if {@code key} is {@code null}
     */
    public boolean contains(Key key) {
        
    }

}
