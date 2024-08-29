package section01.bookCode;
// Implements the Graph API using Adjacency Matrix representation. 

import java.util.Iterator;

import edu.princeton.cs.algs4.StdRandom;

public class AdjacencyMatrixGraph {
	//system independant line - seaprator 
	private static final String NEWLINE = System.getProperty("line.separator");
	
	private final int V; // no of vertex in the graph. 
	private int E; // No of edges, dependant on the graph, can be changed. 
	private boolean[][] adj; // adjacency matrix to store graph. 
	
	// Empty graph with V vertices constructor 
	public AdjacencyMatrixGraph(int V) {
		if (V < 0) throw new IllegalArgumentException("Too few vertices"); 
		this.V = V; 
		this.E = 0; 
		this.adj = new boolean[V][V];// A VxV matrix of T/F values. 
	}
	
	// random graph with V vertices and E edges constructor. 
	public AdjacencyMatrixGraph(int V, int E) {
		this(V);
		if (E > (long) V*(V-1)/2 + V) throw new IllegalArgumentException("Too many edges");
		if (E < 0) 					  throw new IllegalArgumentException("Too few edges");
		
		// can be inefficient. 
		//The loop might run many times, especially as the graph becomes more fully connected (since finding a pair of vertices that aren't already connected can become increasingly difficult).
		//This inefficiency arises because the constructor might repeatedly attempt to add edges between vertices that are already connected, requiring additional iterations to reach the desired number of edges.
		
		while (this.E != E) {
			int v = StdRandom.uniformInt(V);
			int w = StdRandom.uniformInt(V);
			addEdge(v, w);
		}
	}
	
	//Number of vertices and edges. 
	public int V() {return V;}
	public int E() {return E;}
	
	//add undirected edge v-w
	public void addEdge(int v, int w) {
		if (!adj[v][w]) E++;
			adj[v][w] = true;
			adj[w][v] = true; 
	}
	
	// Does the graph contain the edge v-w? 
	public boolean contains(int v, int w) {
		return adj[v][w];
	}
	
	//Return list of neighbours of v
	public Iterable<Integer> adj(int v) {
		return new AdjIterator(v);
	}
	
	// support iteration over graph vertices. 
	private class AdjIterator implements Iterator<Integer>, Iterable<Integer>{
		private int v; 
		private int w = 0;
		
		AdjIterator(int v) {
			this.v = v; 
		}
		
		
	}
	
}









































