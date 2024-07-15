// FIFO Queue implementation using 
// Linked List ADT 
// Page 151 of the book 

import java.util.Iterable; 
import edu.princeton.cs.algs4.*;

public class QueueLinkedListAlgo<Item> {
	// implements Iterable <Item> 

	private Node first; // link to the least recently added Node
	private Node last; // link to the most recently added Node
	private int N; // Number of items on the Queue

	private class Node {
		// Nested class to define Node 
		Item item; 
		Node next; 
	}

	public boolean isEmpty() {
		// checks if the queue is empty or not. 
		return first == null; 
	}

	public int size() {
		// returns the size of the queue. 
		return N; 
	}

	public void enqueue(Item item) {
		// add item to the end of the queue. 
		Node oldlast = last; 
		last = new Node(); 
		last.item = item; 
		last.next = null; 
		if(isEmpty()) {
			first = last; 
		} else {
			oldlast.next = last; 
		}
		N++;
	}

	public Item dequeue() {
		// remove item from the beginning of the stack ;
		Item item = first.item;
		first = first.next; 
		if (isEmpty()) {
			last = null; 
		}
	}

	// Iterator Implementation 
		// to be implemented later. 
}

// Test client 
	// to be implemented. 