import edu.princeton.cs.algs4.StdIn;
import edu.princeton.cs.algs4.StdOut; 

public class Average{
	public static void main(String[] args){
		// average the numbers in StdIn. 
		double sum = 0 ; 
		int count = 0 ; 

		while(!StdIn.isEmpty()){
			// read a number and cumulate the sum
			sum += StdIn.readDouble(); 
			count++ ; 
		}
		double avg = sum / count ; 
		StdOut.printf("Average is :  %.5f " , avg ) ; 
	}
}
