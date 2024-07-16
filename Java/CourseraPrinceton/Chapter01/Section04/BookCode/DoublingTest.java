import edu.princeton.cs.algs4.*;

public class DoublingTest {
	// Time ThreeSum.count() for N random 6-digit ints. 
	
	public static double timeTrial(int N) {
		int MAX = 1000_1000; 
		int[] a = new int[N];
		for(int i = 0; i < N; i++)
			a[i] = StdRandom.uniform(-MAX, MAX);

		Stopwatch timer = new Stopwatch();
		int cnt = ThreeSum.count(a);
		return timer.elapsedTime(); 

	}

	public static void main(String[] args) {
		// print table for running times. 
		for (int N = 250; true; N +=N) {
			// print time for problem size N. 
			double time = timeTrial(N); 
			StdOut.printf("%7d %5.1f\n", N, time);
		}
	}
}
