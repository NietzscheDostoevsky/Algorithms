public class Counter {

	private final String name;
	private int count;

	public counter(String id) { // constructor
		name = id;
	}

	public void increment() {
		count++; 
	}

	public int tally() {
		return count; 
	}

	public String toString() {
		return count + " " + name; 
	}
}

public class CounterDriver {
	public static void main(String[] args) {
		Counter heads = new Counter("heads");
		Counter tails = new Counter("tails");

		heads.increment();
		heads.increment();
		tails.increment();

		StdOut.println(heads + " " + tails);
		StdOut.println(heads.tally() + tails.tally());
	}
}