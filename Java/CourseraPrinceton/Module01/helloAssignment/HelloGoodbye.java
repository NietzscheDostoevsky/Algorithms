import edu.princeton.cs.algs4.StdIn;
import edu.princeton.cs.algs4.StdOut;
import edu.princeton.cs.algs4.StdRandom;

public class HelloGoodbye {

	public static void main(String[] args) {
		String firstName = args[0];
		String secondName = args[1];

		StdOut.printf("Hello %s and %s.\n", firstName, secondName);
		StdOut.printf("Goodbye %s and %s.\n", secondName, firstName);
	}
}