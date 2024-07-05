import edu.princeton.cs.algs4.*;

public class FixedCapacityStackOfStrings {

	// implement a Stack ADT of fixed size which can save Strings 

	private String[] a; // Stack entries 
	private int N; // size 

	public FixedCapacityStackOfStrings(int cap) { // constructor
		a = new String[cap];
	}
	public boolean isEmpty() {
		return N == 0;
	}

	public int size() {
		return N;
	}

	public void push(String item) {
		a[N++] = item; 
	}

	public String pop() {
		return a[--N];
	}
}

class FixedCapacityStackofStringsDriver {
	// driver code for the stack 

	public static void main(String[] args) {
		
		FixedCapacityStackOfStrings s;
		s = new FixedCapacityStackOfStrings(100);// a stack that could store 100 strings
		while (!StdIn.isEmpty()) {
			String item = StdIn.readString();
			if (!item.equals("-")) {
				s.push(item);
				StdOut.println("Haha");
			} else if (!s.isEmpty()) {
				StdOut.print(s.pop() + " ");
			}
			StdOut.println("(" + s.size() + " left on stack");
		}
	}

}
