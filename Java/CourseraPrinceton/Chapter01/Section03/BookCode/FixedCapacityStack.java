// implementing Stack ADT of fixed size using generics so it could 
// store any data type . 
// using array for implementing stack 

public class FixedCapacityStack<Item> {

	private Item[] a; // stack entries 
	private int N; // size of the stack 

	public FixedCapacityStack(int cap) { // constructor with fixed capacity input para
		a = (Item[]) new Object[cap];
			// create an array of object type, and then typecast 
			// the array into Item adt 
			// GENERIC ARRAY CREATION IS DISALLOWED IN JAVA

		public boolean isEmpty() {
			return N == 0;
		}

		public void push(Item item) {
			a[N++] = item;
		}
		public Item pop() {
			return a[--N];
		}

	}
}

class FixedCapacityStackDriver {
	public static void main(String[] args) {
		FixedCapacityStack<String> s; // declaration
		s = new FixedCapacityStack<String>(100); //initializtoin
		
	}
}