
import edu.princeton.cs.algs4.*;

class VisualAccumulatorDriver {
	public static void main(String[] args) {
		
		int T = Integer.parseInt(args[0]);
		VisualAccumulator obj = new VisualAccumulator(T, 1.0); 
		for(int t = 0; t < T; t++) {
			obj.addDataValue(StdRandom.random());
		}
		StdOut.println(obj);
	}
}

class VisualAccumulator {
	private double total; 
	private int N;

	public VisualAccumulator(int trials, double max) {
		StdDraw.setXscale(0, trials);
		StdDraw.setYscale(0, max);
		StdDraw.setPenRadius(0.005);
	}

	public void addDataValue(double val) {
		N++;
		total += val;
		StdDraw.setPenColor(StdDraw.DARK_GRAY);
		StdDraw.point(N, val);
		StdDraw.setPenColor(StdDraw.RED);
		StdDraw.point(N, total/N);
	}

	public double mean() {
		return total/N;
	}

	public String toString() {
		return "Mean (" + N + " values): " + String.format("%7.5f", mean());
	}
}