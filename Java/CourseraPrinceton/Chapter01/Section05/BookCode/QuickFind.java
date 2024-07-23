import edu.princeton.cs.algs4.*; 

// implementing the simple QuickFind algorithm
// for Dynamic Connectivity problem
// Source code form Coursera video 
//  on quick find. 

public class QuickFind implements UFI {
    private int[] id;
    
    public QuickFind(int N) {
        id = new int[N];
        for (int i = 0; i < N; i++) {
            id[i] = i;
        } 
    }

    public boolean connected(int p, int q) {
        return id[p] == id[q]; 
    }
    
    public void union(int p, int q) {
        int pid = id[p];
        int qid = id[q]; 
        for (int i = 0; i < id.length; i++) {
            if (id[i] == pid) {
                id[i] = qid; 
            }
        }
    }
} 
