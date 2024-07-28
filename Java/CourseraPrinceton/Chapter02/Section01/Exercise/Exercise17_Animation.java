/*
Question 

2.1.17 Animation. 
Add code to Insertion and Selection to make them draw the
array contents as vertical bars like the visual traces in this section, redrawing the bars
after each pass, to produce an animated effect, ending in a “sorted” picture where the
bars appear in order of their height.
Hint : Use a client like the one in the text that gener-
ates random Double values, insert calls to show() as appropriate in the sort code, and
implement a show() method that clears the canvas and draws the bars.
*/


import edu.princeton.cs.algs4.*; 

@SuppressWarnings({"unchecked", "rawtype"})
public class Exercise17_Animation {
	public static void main(String[] args) {
		
		int N = 20; // Array size
		Comparable[] array = new Comparable[N];

		// initizlise the array with random double values. 
		for (int i = 0; i < N; i++) {
			double value = StdRandom.uniform(); 
			array[i] = value; 
		}

		// Setting cavas size 
		StdDraw.setCanvasSize(30 * (N + 3), 90); 
		StdDraw.setXScale(-0.5, N/3 + 1); 
		StdDraw.setYScale(0, 2); 

		
	}
}