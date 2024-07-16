import edu.princeton.cs.algs4.*; 

public class Stopwatch {
	private final long start; 
	public Stopwatch() {
		// constructor 
		start = System.currentTimeMillis();
	}

	public double elapsedTime() {
		long now = System.currentTimeMillis();
		return (now - start) / 1000.0 ; 
	}
}

