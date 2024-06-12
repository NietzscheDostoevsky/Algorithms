import edu.princeton.cs.algs4.StdIn;
import edu.princeton.cs.algs4.StdOut;
import edu.princeton.cs.algs4.StdRandom;

public class RandomWord {
	public static void main(String[] args) {
		// takes input from standard input and prints
		// one of those words uniformly at random.
		// Use Knuth's methodd
		// RESERVOIR SAMPLING

		int count = 0;
		String champion = null;
		String input = null;

		// initializing the loop to take inputs
		while (!StdIn.isEmpty()) {
			input = StdIn.readString();
			count++;

			// condition to assign the champion word to get selected
			if (StdRandom.random() < 1.0 / count) {
				champion = input;
			}
		}

		StdOut.println(champion);

	}
}