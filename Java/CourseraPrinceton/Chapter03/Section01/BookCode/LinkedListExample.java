public class LinkedListExample<Item> {

    // Nested Node class
    private class Node {
        Item item;  // Data item
        Node next;  // Reference to the next node
    }

    private Node first;  // Reference to the first node in the list
    private int size;    // Track the size of the linked list

    // Constructor
    public LinkedListExample() {
        first = null;
        size = 0;
    }

    // Add an item to the front of the list
    public void addFront(Item item) {
        Node oldFirst = first;
        first = new Node();
        first.item = item;
        first.next = oldFirst;
        size++;
    }

    // Add an item to the end of the list
    public void addEnd(Item item) {
        Node newNode = new Node();
        newNode.item = item;
        if (first == null) {
            first = newNode;
        } else {
            Node current = first;
            while (current.next != null) {
                current = current.next;
            }
            current.next = newNode;
        }
        size++;
    }

    // Remove the first item from the list
    public Item removeFront() {
        if (first == null) return null;
        Item item = first.item;
        first = first.next;
        size--;
        return item;
    }

    // Print the linked list
    public void printList() {
        Node current = first;
        while (current != null) {
            System.out.print(current.item + " -> ");
            current = current.next;
        }
        System.out.println("null");
    }

    // Return the size of the linked list
    public int size() {
        return size;
    }

    public static void main(String[] args) {
        LinkedListExample<String> list = new LinkedListExample<>();

        // Add elements to the list
        list.addFront("First");
        list.addFront("Monkey");
        list.addEnd("Second");
        list.addEnd("Third");

        // Print the list
        list.printList();  // Output: First -> Second -> Third -> null

        // Remove the first element
        list.removeFront();
        list.printList();  // Output: Second -> Third -> null
    }
}
