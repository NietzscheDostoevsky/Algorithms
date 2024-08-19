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

    
}

