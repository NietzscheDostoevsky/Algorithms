import edu.princeton.cs.algs4.*; 

public class Multiway {
	public static void merge(In[] streams) {
		int N = streams.length; 
		IndexMinPq<String> pq = new IndexMinPq<String>(N); 

		for (int i = 0; i < N; i++) 
			if (!streams[i].isEmpty())
				pq.insert(i, streams[i].readString());

		while (!pq.isEmpty()) {
			StdOut.println(pq.min());
			if (!streams[i].isEmpty())
				pq.insert(i, streams[i].readString());
		}		
	}

	public static void main(String[] args) {
		int N = args.length;
		In[] streams = new In[N];

		for (int i = 0; i < N; i++)
			streams[i] = new In(args[i]);
		merge(streams);
	}
}