// test both the SnallSate and the BasicDate implementation 
// of the date class. 

import edu.princeton.cs.algs4.*;
class DateDriver {
	public static void main(String[] args) {
		
		
		int m = Integer.parseInt(args[0]);
		int d = Integer.parseInt(args[1]);
		int y = Integer.parseInt(args[2]);

		SmallDate date1 = new SmallDate(m, d, y);
		BasicDate date2 = new BasicDate(m, d, y);

		StdOut.println(date1);
		StdOut.println(date2);
	}
}