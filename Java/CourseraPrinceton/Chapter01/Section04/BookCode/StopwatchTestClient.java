import edu.princeton.cs.algs4.*; 

public class StopwatchTestClient {
	public static void main(String[] args) {
		int N = Integer.parseInt(args[0]); 
		int[] a = new int[N]; 
		for (int i = 0; i < N; i++)
			a[i] = StdRandom.uniform(-1000_000, 1000_000);
		Stopwatch timer = new Stopwatch();
		int cnt = ThreeSum.count(a);
		double time = timer.elapsedTime();
		StdOut.println(cnt + " tiples " + time); 
	}
}

