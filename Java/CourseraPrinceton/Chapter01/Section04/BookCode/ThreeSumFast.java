import java.util.Arrays; 
import edu.princeton.cs.algs4.*;

public class ThreeSumFast {
	// faster three sum algo 

	public static int count(int[] a) {
		// Count triples taht sum to 0 

		Arrays.sort(a); 
		int N = a.length;
		int cnt = 0;
		for(int i = 0; i < N; i++) {
			for(int j = i + 1; j < N; j++) {
				if (BinarySearch.rank(-a[i]-a[j],a) > j)
					cnt++;
			}
		}
		return cnt; 
	}

	public static void main(String[] args) {
		int[] a = In.readInts(args[0]);
		StdOut.println(count(a));
	}
}