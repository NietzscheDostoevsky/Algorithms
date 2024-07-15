import edu.princeton.cs.algs4.*;
import java.util.Iterator;

class StackLinkedListAlgo<Item> implements Iterable<Item> {

	private Node first; // top of the stack
						// most recently added node. 
	private int N; // number of items. 

	private class Node {
		// nested class to define node. 
		Item item; 
		Node next; 
	}

	public boolean isEmpty() {
		return first == null; // or N==0; 
	}
	public int size() {
		return N; 
	}

	public void push(Item item) {
		// adding item at the top of the stack 
		Node oldfirst = first;
		first = new Node(); 
		first.item = item; 
		first.next = oldfirst;
		N++;
	}

	public Item pop() {
		// remove item from the top of the stack 
		Item item = first.item; 
		first = first.next; 
		N--;
		return item;
	}

	public Iterator<Item> iterator() {
		return ListIterator();
	}

	private class ListIterator implements Iterator<Item> {
		private Node current = first; 

		public boolean hasNext() {
			return current != null; 
		}
		public void remove() { }
		public Item next() {
			Item item = current.item; 
			current = current.next;
			return item; 
		}
	}
}

public class StackLinkedListAlgoDriver {
	// creating a stack and push/pop strings as directed on StdIn
	public static void main(String[] args) {
		
		StackLinkedListAlgo<String> s = new StackLinkedListAlgo<String>(); 
		while (!StdIn.isEmpty()) {
			String item = StdIn.readString();
			if(!item.equals("-"))
				s.push(item);
			else if (!s.isEmpty())
				StdOut.print(s.pop() + " ");
		}
		StdOut.println("(" + s.size() + s.size() + " left on stack)");
	}
}