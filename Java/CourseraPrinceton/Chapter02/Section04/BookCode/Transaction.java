import edu.princeton.cs.algs4.Date;

public interface Transaction extends Comparable<Transaction> {
  String who(); // customer name
  Date when(); // date
  double amount(); //  amount

  String toString();
  boolean equals(Object that);
  int compareTo(Transaction that);
  int hashCode();
}

/*
 * Implementation details (not part of the interface, but to be implemented in the class):
 *
 * // Constructor Transaction
 * Transaction(String who, Date when, double amount) create a transaction
 * Transaction(String transation) // create a transaction (parse constructor)
 */

