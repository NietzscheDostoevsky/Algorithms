package section01.bookCode;

import java.util.NoSuchElementException;

import edu.princeton.cs.algs4.Bag;
import edu.princeton.cs.algs4.In;
import edu.princeton.cs.algs4.Stack;
import edu.princeton.cs.algs4.StdOut;

/**
 * This Graph implementation maintains a vertex-indexed array of lists of integers. Every edge appears
twice: if an edge connects v and w, then w appears in v’s list and v appears in w’s list. The second con-
structor reads a graph from an input stream, in the format V followed by E followed by a list of pairs
of int values between 0 and V-1
*/
@SuppressWarnings("unchecked")
public class Graph {
	
	private static final String NEWLINE = System.getProperty("line.separator");
	
	// Total vertices
	private final int V; // No of vertex's can't be changed later, once graph is created.
	// Total edges. 
	private int E; // more edges can be added later for given vertices. 
	
	// Adjacency list of
	private Bag<Integer>[] adj; // Bag object to store list of vertices adjacent to a vertex.
	
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
	
	/**
	 * Initializes a new graph that is deep copy of {@code G} is {@code null}.
	 * 
	 * @param IllegalArgumentExceptino if {@code G} is {@code null}
	 */
	public Graph(Graph G) {
		this.V = G.V();
		this.E = G.E();
		if (V < 0) throw new IllegalArgumentException("Number of vertices must be non-negative");
		
		// Initialize adjacency lists. 
		adj = (Bag<Integer>[]) new Bag[V];
		
		//Add a bag object at each index for V
		for (int v = 0; v < V; v++)
			adj[v]= new Bag<Integer>();
		
		//Copy the actual data. 
		for (int v = 0; v < G.V(); v++) {
			// reverse so that the adjacency list is in same order as original. 
			// Reverse is necessary here because the Bag implementation is LIFO. 
			Stack<Integer> reverse = new Stack<Integer>();
			for (int w : G.adj[v]) // for each bag at index i in G.adj[i]
				reverse.push(w);
			for (int w : reverse) // add each vertex to the bag at index i in new Graph
				adj[v].add(w); 
		}
	}
	
	/**
     * Returns the number of vertices in this graph.
     *
     * @return the number of vertices in this graph
     */
    public int V() {
        return V;
    }

    /**
     * Returns the number of edges in this graph.
     *
     * @return the number of edges in this graph
     */
    public int E() {
        return E;
    }
    
    // throw an IllegalArgumentException unless {@code 0 <= v <V}
    private void validateVertex(int v) {
    	if (v < 0 || v >= V)
    		throw new IllegalArgumentException("veretx " + v + " is not between 0 and " + (V-1));
    }
    
    /**
     * Adds the undirected edge v-w to this graph.
     *
     * @param  v one vertex in the edge
     * @param  w the other vertex in the edge
     * @throws IllegalArgumentException unless both {@code 0 <= v < V} and {@code 0 <= w < V}
     */
    public void addEdge(int v, int w) {
    	validateVertex(v);
    	validateVertex(w);
    	E++; // increment the number of edges
    	
    	// Add vertex w to the adjacency list of vertex v.
        // This step makes vertex v adjacent to vertex w.
    	// update the bag of a particular vertex, adding a edge is equivalent to making the vertices adjacent.
    	adj[v].add(w);  
    	
    	// Add vertex v to the adjacency list of vertex w.
        // Since the graph is undirected, we must add the edge in both directions
    	// bags of both vertices have to be added each other's value, since v -> w === w -> v
    	adj[w].add(v);
    }
    
    /**
     * Returns the vertices adjacent to vertex {@code v}.
     *
     * @param  v the vertex
     * @return the vertices adjacent to vertex {@code v}, as an iterable
     * @throws IllegalArgumentException unless {@code 0 <= v < V}
     */
    public Iterable<Integer> adj(int v) {
    	validateVertex(v);
    	return adj[v]; // return the bag object containing the vertices.
    }
    
    /**
     * Returns the degree of vertex {@code v}.
     *
     * @param  v the vertex
     * @return the degree of vertex {@code v}
     * @throws IllegalArgumentException unless {@code 0 <= v < V}
     */
    public int degree(int v) {
    	validateVertex(v);
    	return adj[v].size(); // return the size of the bag
    }
    
    /**
     * Returns a string representation of this graph.
     *
     * @return the number of vertices <em>V</em>, followed by the number of edges <em>E</em>,
     *         followed by the <em>V</em> adjacency lists
     */
    @Override
    public String toString() {
    	StringBuilder s = new StringBuilder();
    	s.append(V + " vertices, " + E + " edges " + NEWLINE);
    	for (int v = 0; v < V; v++) {
    		s.append(v + ": ");
    		for (int w : adj[v])
    			s.append(w + " ");
    		s.append(NEWLINE);
    	}
    	return s.toString();
    }
    
    /**
     * Unit tests the {@code Graph} data type.
     *
     * @param args the command-line arguments
     */	
	public static void main(String[] args) {
		StdOut.println("Hello, testing Graph DS");
		
		In in = new In(args[0]);
		Graph graph = new Graph(in);
		StdOut.println(graph);
	}
}