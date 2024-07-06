// This implementation 
// 	automatically resizes the array, 
// 	Allows clients to make stacks for any tupe of data. 
// 	supports clied use of foreach to iterate over through the stack items in LIFO order. 

import edu.princeton.cs.algs4.*;
import java.util.Iterator;

public class ResizingArrayStack<Item> implements Iterable<Item> {
	private Item[] a = (Item[]) new Object[1]; // generic arrays not allowed in java
						   // stack items 
	private int N = 0; // number of items 
	public boolean isEmpty() {
		return N == 0;
	}

	public int size() {
		return N;
	}

	private void resize(int max) {
		// move stack to a new array of size max, when required. 
		Item[] temp = (Item[]) new Object[max];
		for (int i = 0; i < N; i++) {
			temp[i] = a[i];
		}
		a = temp; 
	}

	public void push(Item item) {
		// add item at the top of the stack 
		if (N == a.length) {
			resize(2*a.length); // double the array length if its full
		} 
		a[N++] = item; // add item to the array 
	}
	
	public Item pop() {
		// remove item from the top of the stack 
		Item item = a[--N];
		a[N] = null; // avoiding loitering, so orphaning the object at a[N] after dec
		if ( N > 0 && N == a.length/4 ) {
			// resizing the array 
			// to 1/2 its size when its 1/4 empty
			// so it always have half array to fill up 

			resize(a.length/2);
		}
		return item;
	}

	public Iterator<Item> iterator() {
	       // since interation has to be ireverse order 
		return new ReverseArrayIterator();
       	}
	
	private class ReverseArrayIterator implements Iterator<Item> {
		// reversing the iteration as per LIFO 
		private int i = N;
		public boolean hasNext() {
			return i > 0 ;
		}
		public Item next() {
			return a[--i];
		}
		public void remove() {
		}
	}
}

class ResizingArrayStackDriver {
	public static void main(String[] args) {
		
		ResizingArrayStack<String> s;
		s = new ResizingArrayStack<String>();
		while (!StdIn.isEmpty()) {
			String item = StdIn.readString();
			if (!item.equals("-"))
				s.push(item);
			else if (!s.isEmpty()) StdOut.print(s.pop() + " ");
		}
		StdOut.println("(" + s.size() + " left on stack)");

	}
}


