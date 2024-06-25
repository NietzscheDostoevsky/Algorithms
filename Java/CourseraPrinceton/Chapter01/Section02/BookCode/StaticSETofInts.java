import java.util.Arrays;
import edu.princeton.cs.algs4.*;

class StaticSETofInts {
	private int[] a;
	public StaticSETofInts(int[] keys) { // constructor
		a = new int[keys.length];
		for( int i = 0; i < keys.length ; i++) {
			a[i] = keys[i]; // defensive copy
		}
		Arrays.sort(a);
	}

	public boolean contains(int key) {
		return rank(key) != -1;
	}

	int rank(int key) {
		int lo = 0;
		int hi = a.length -1;
		while(lo <= hi) {
			// key is in a[lo...hi] or not present
			int mid = lo + ((hi - lo)) / 2;
			if(key < a[mid]) {
				hi = mid - 1;
			} else if(key > a[mid]) {
				lo = mid + 1;
			} else {
				return mid;
			}
		}
		return -1;
	}
}

class Whitelist {
	public static void main(String[] args) {
		int[] w = In.readInts(args[0]);
		StaticSETofInts set = new StaticSETofInts(w);
		while (!StdIn.isEmpty()) {
			int key = StdIn.readInt();
			if(set.rank(key) == -1) {
				StdOut.println(key);
			}
		}
	}
}