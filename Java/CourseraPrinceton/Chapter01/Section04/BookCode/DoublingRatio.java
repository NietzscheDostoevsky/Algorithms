
import edu.princeton.cs.algs4.*;
public class DoublingRatio {
	@SuppressWarnings("deprecation")
	
		public static double timeTrial(int N) {
			int MAX = 1000_1000; 
			int[] a = new int[N];
			for(int i = 0; i < N; i++)
				a[i] = StdRandom.uniform(-MAX, MAX);

			Stopwatch timer = new Stopwatch();
			int cnt = ThreeSumFast.count(a);
			return timer.elapsedTime(); 
		}

		public static void main(String[] args) {
			double prev = timeTrial(125); 
			for (int N = 250; true; N+=N) {
				double time = timeTrial(N);
				StdOut.printf("%6d %7.1f ", N, time);
				StdOut.printf("%5.2f\n", time / prev);
				prev = time; 
			}
		}

}