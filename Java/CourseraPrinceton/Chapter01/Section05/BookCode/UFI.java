public interface UFI {
    // Initialize N sites with integer names (0 to N-1)
    // int N; 

    // Add connection betweeen p and q
    void union(int p, int q);

    // component identifier for p (0 to N-1)
    int find(int p);

    //return true if p and q are in the same component
    boolean connected(int p, int q);

    //Number of components 
    int count(); 
}
