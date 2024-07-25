import edu.princeton.cs.algs4.*; 

public class Selection  {

	
	public void sort(Comparable[] a) {
		// sort a[] into increasin order. 
		int N = a.length;  // array length 
		for (int i = 0; i < N; i++) {
			// this loop iterates through the array
			// Exchange a[i] with the smallest entry in a[i + 1 ... N]
			int min = i; // index of minimal entry. 
			for (int j = i+1; j < N; j++) {
				// this loop compares the element to find the min value in the entire 
				// array from i onwards.
				// finds the smallest element's index, and sets it to min.  
				if (less(a[j], a[min])) { // less returns true if a[j] < a[min]
					min = j;
				}				
			}
			// after finding the smallest index, exchange the current object 
			// 	selected by the outer loop to the smallest object found
			// 	found by the inner loop. 
			exch(a, i, min); 
		}
	}

	public static void main(String[] args) {
		// Read strings from standard input, sort them, and print. 

		String[] a = In.readStrings();
		sort(a); 
		assert isSorted(a); 
		show(a);
	}
}

