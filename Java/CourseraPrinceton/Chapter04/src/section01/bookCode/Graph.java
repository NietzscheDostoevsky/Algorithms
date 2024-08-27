package section01.bookCode;

// Usage :  java Graph tinyG.txt
//13 vertices, 13 edges
//*  0: 6 2 1 5
//*  1: 0
//*  2: 0
//*  3: 5 4
//*  4: 5 6 3
//*  5: 3 4 0
//*  6: 0 4
//*  7: 8
//*  8: 7
//*  9: 11 10 12
//*  10: 9
//*  11: 9 12
//*  12: 11 9

import java.util.NoSuchElementException;

import edu.princeton.cs.algs4.Bag;
import edu.princeton.cs.algs4.StdOut;

public class Graph {
	
	private static final String NEWLINE = System.getProperty("line.separator");
	
	private final int V;
	private int E; 
	private Bag<Integer>[] adj;
	
	/**
	 * Initializes an empty graph with {@code V} vertices and 0 edges. 
	 * param V the number of vertices
	 * 
	 * @param V number of vertices
	 * @throws IllegalArgumentException if {@code V < 0}
	 */
	public Graph(int V) {
		if (V < 0) throw new IllegalArgumentException("Number of vertices must be non-negative");
		this.V = V; 
		this.E = 0; 
		adj = (Bag<Integer>[]) new Bag[V];
		for (int v = 0; v < V; v++)
			adj[v]= new Bag<Integer>();
		
	}
	
	
	public static void main(String[] args) {
		StdOut.println("Hello");
	}
}





































