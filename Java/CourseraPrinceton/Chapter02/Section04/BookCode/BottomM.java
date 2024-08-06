package Section04.BookCode;

import edu.princeton.cs.algs4.MaxPQ;
import edu.princeton.cs.algs4.Stack;
import edu.princeton.cs.algs4.StdIn;
import edu.princeton.cs.algs4.StdOut;
import edu.princeton.cs.algs4.Transaction;

public class BottomM {

        public static void main(String[] args) {
            // Print the top M lines in the input stream.
            int M = Integer.parseInt(args[0]);
            MaxPQ<Transaction> pq = new MaxPQ<Transaction>(M + 1);
            while (StdIn.hasNextLine()) {
                // Create an entry from the next line and put on the PQ.
                pq.insert(new Transaction(StdIn.readLine()));
                if (pq.size() > M)
                    pq.delMax(); // Remove maximum if M+1 entries on the PQ.
            } // Top M entries are on the PQ

            Stack<Transaction> stack = new Stack<Transaction>();
            while (!pq.isEmpty()) stack.push(pq.delMax());
            for (Transaction t : stack) StdOut.println(t);

        }


}
