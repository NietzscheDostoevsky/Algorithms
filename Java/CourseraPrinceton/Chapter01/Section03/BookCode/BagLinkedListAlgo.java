// Linked List implementaton of Bag. 
// Book page 155 of book. 

import java.util.Iterator; 
import edu.priceton.cs.algs4.*; 

public class Bag<Item> implements Iterable<Item> {
	private Node first; // first node in the list

	private class Node {
		Item item; 
		Node next; 
	}

	public void add(Item item) {
		// same as push() in stack 
		Node oldfirst = first; 
		first = new Node(); 
		first.item = item; 
		first.next = oldfirst; 
	}

	public Iterator<Item> iterator() {
		// geenric method 
		return new ListIterator();
	}

	private class ListIterator implements Iterator<Item> {
		private Node current = first; 
		public boolean hasNext() {
			return != null; 
		}
		public void remove() {

		}
		public Item next() {
			Item item = current.next;
			current = current.next; 
			return item; 
		}
	}

}