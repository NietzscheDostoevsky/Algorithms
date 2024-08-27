package section01.bookCode;

import java.util.NoSuchElementException;

import edu.princeton.cs.algs4.Bag;
import edu.princeton.cs.algs4.In;
import edu.princeton.cs.algs4.StdOut;

@SuppressWarnings("unchecked")
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
	
	/**
     * Initializes a graph from the specified input stream.
     * The format is the number of vertices <em>V</em>,
     * followed by the number of edges <em>E</em>,
     * followed by <em>E</em> pairs of vertices, with each entry separated by whitespace.
     *
     * @param  in the input stream
     * @throws IllegalArgumentException if {@code in} is {@code null}
     * @throws IllegalArgumentException if the endpoints of any edge are not in prescribed range
     * @throws IllegalArgumentException if the number of vertices or edges is negative
     * @throws IllegalArgumentException if the input stream is in the wrong format
     */
	
	public Graph(In in) {
		if (in == null) throw new IllegalArgumentException("argumetn is null");
		try {
			this.V = in.readInt();
			if (V < 0) throw new IllegalArgumentException("number of vertices in a Graph must be non-negative");
			adj = (Bag<Integer>[]) new Bag[V];
			for (int v = 0; v < V; v++) 
				adj[v] = new Bag<Integer>();
			int E = in.readInt();
			if (E < 0) throw new IllegalArgumentException("number of edges in a Graph must be non-negative");
			for (int i = 0; i < E; i++) {
				int v = in.readInt();
				int w = in.readInt();
				validateVertex(v);
				validateVertex(w);
				addEdge(v, w);
			}
		} catch (NoSuchElementException e) {
			throw new IllegalArgumentException("invalid input format in Graph constructor", e);
		}
	}
	
	public static void main(String[] args) {
		StdOut.println("Hello");
	}
}





































