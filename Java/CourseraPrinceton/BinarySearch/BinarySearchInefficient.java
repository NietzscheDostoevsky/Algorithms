import edu.princeton.cs.algs4.StdIn ; 
import edu.princeton.cs.algs4.StdOut ; 
import edu.princeton.cs.algs4.In ;

class BinarySearchInefficient{

	public static int rank(int key, int[] a) {
		// returns key if it is found in the input array a 
		// the input array need not be sorted. 
		// using simply brute force to check and match all possible entries .

		for(int i = 0 ; i < a.length ; i++ ){
			if (a[i] == key){
				return i ; 
			}
		}
		return -1 ; // when the key is not found in the 
					// input array a 

	}

	public static void main(String[] args){

		int [] whitelist = In.readInts(args[0]); 
		// no need to sort the array here
		// we are bruteforce checking

		while(!StdIn.isEmpty()){
			// read key from stdinput and 
			// print key if it is not in the 
			// whitelist array 

			int key = StdIn.readInt(); 
			if(rank(key, whitelist) < 0 ){
				StdOut.println(key); 
			}
		}
	}

}