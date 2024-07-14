import edu.princeton.cs.algs4.*;
import java.util.Iterator;

public class StackLinkedListAlgo<Item> implements Iterable<Item> {
	private Node first; // top of the stack
						// most recently added node. 
	private int N; // number of items. 

	private class Node {
		// nested class to define node. 
		Item item; 
		Node next; 
	}
}