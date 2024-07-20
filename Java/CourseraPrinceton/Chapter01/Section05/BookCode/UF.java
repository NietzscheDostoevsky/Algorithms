// Book Page 221 

import edu.princeton.cs.algs4.*;

public class UF {
	private int[] id; // access to component id (side indexed)
	private int count; // number of components

	public UF(int N) {
		// Initialize component id array. 
		count = N; 
		id = new int[N];
		for (int i = 0; i < N; i++) {
			id[i] = i;
		}
	}

	public int count() {
		return count; 
	}

	public boolean connected(int p, int q) {
		return find(p) == find(q); 
	}

	public int find(int p) {
		// Book Page 222

	}

	public staic void union(int p, int q) {
		// implemented later
	}

	public static void main(String[] args) {
		// Solve dynamic connectivity problem on StdIn. 
		
		int N = StdIn.readInt(); 	 // Read number of sites. 
		UF uf = new UF(N); 
		while (!StdIn.isEmpty()) {
			int p = StdIn.readInt(); 
			int q = StdIn.readInt(); // Read pairs to connect. 
			if (uf.connected(p, q)) {
				continue; 			 // ignore if connected. 
			}
			uf.union(p, q);
			StdOut.println(p + " " + q) ; 
		}
		StdOut.println(uf.count() + " components");
	}
}