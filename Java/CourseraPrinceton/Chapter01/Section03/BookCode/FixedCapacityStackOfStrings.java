import edu.princeton.cs.algs4.*;
public class FixedCapacityStackOfStrings {
	// implementing a fixed capacity stack ADT to store String data type in a Java array 

	private String[] a ; // Stack entries 
	private int N; // Sizer of stack  

	public FixedCapacityStackOfStrings(int cap) {
		a = new String[cap];
	}

	public boolean isEmpty() {
		return N == 0 ;
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

class FixedCapacityStringDriver {
	public static void main(String[] args) {
		
		FixedCapacityStackOfStrings s; 
		s = new FixedCapacityStackOfStrings(100);// fixed size stack of sieze 100
		while (!StdIn.isEmpty()) {
			String item = StdIn.readString();
			if( !item.equals("-")) {
				s.push(item);
			} else if (!s.isEmpty()){
				 StdOut.print(s.pop() + " ");
			}
		}
		StdOut.println("(" + s.size() + " left on stack)");
	}
}