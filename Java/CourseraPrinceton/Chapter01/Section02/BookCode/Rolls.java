// Simulating rolling of a die.

import edu.princeton.cs.algs4.StdIn;
import edu.princeton.cs.algs4.StdOut;
import edu.princeton.cs.algs4.StdRandom;
import edu.princeton.cs.algs4.Counter;

public class Rolls {
	public static void main(String[] args) {
		int T = Integer.parseInt(args[0]);

		final int SIDES = 6; // dice has 6 sides
		Counter[] rolls = new Counter[SIDES + 1]; 
		for(int i = 1; i <= SIDES; i++){
			rolls[i] = new Counter(i + "'s"); // creating new counter for 
											  // each side 
		} 
		for(int t = 0; t < T ; t++){
			int result = StdRandom.uniform(1, SIDES+1); // a random no between 1and6
			rolls[result].increment();  
		}
		for(int i = 0; i <=SIDES; i++) {
			StdOut.println(rolls[i]);
		}
	}
}
