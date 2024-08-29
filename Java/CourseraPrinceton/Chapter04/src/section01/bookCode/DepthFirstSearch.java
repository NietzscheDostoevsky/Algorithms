package section01.bookCode;

import edu.princeton.cs.algs4.In;

public class DepthFirstSearch {
	private boolean[] marked; // marked[v] = is there an s-v path? 
	private int count;
	
	// Computes the vertices in graph that are connected 
	// to the source vertex. 
	public DepthFirstSearch(Graph G, int s) {
		marked = new boolean[G.V()];
		validateVertex(s);
		dfs(G, s);
	}
	
	// depth first search from v
	private void dfs(Graph G, int v) {
		count++;
		marked[v] = true;
		for (int w : G.adj(v)) 
			if (!marked[w])
				dfs(G, w);
	}
	
	//Is there is a path between source the source vertex s and vertex v
	public boolean marked(int v) {
		validateVertex(v);
		return marked[v];
	}
	
	//Returns the number of vertices connected to the source vertex.
	public int count() {
		return count;
	}
	
	// vertex validation. 
	private void validateVertex(int v) {
		int V = marked.length;
		if (v < 0 || v > V)
			throw new IllegalArgumentException("Vertex " + v + " is not between 0 and " + (V-1));
	}
	
	// Code to test 
	public static void main(String[] args) {
		In in = new In(args[0]);
		
	}
}
