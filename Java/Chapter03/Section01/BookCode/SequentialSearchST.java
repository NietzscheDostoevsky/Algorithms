/*
 * A simple implementation of Symbol Table using 
 *      Unordered list. 
 */

public class SequentialSearchST<Key, Value> {
    private Node first; // first node of the linked list.

    // Implementation of Node for Linked List
    private class Node {
        Key key;
        Value val;
        Node next;

        public Node(Key key, Value val, Node next) {
            this.key = key;
            this.val = val;
            this.next = next;
        }
    }

    // Search for key, return associated value.
    public Value get(Key key) {
        for (Node x = first; x != null; x = x.next)
            if (key.equals(x.key))
                return x.val; // search hit
        return null; // search miss.
    }

    // Search for key, Update value if found, grow table if new.
    public void put(Key key, Value val) {
        for (Node x = first; x != null; x = x.next) {
            if (key.equals(x.key)) {
                x.val = val; // search hits, update value
                return;
            }
        }
        first = new Node(key, val, first); // search miss, add new node
    }
}
