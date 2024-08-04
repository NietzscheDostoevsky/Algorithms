public interface Date extends Comparable<Date> {

    // Methods to implement in the class
    int month(); // return month
    int day(); // return day
    int year(); // return year

    String toString(); // String representation
    boolean equals(Object that); // is this the same date as that?
    int compareTo(Date that); // compare this date to that
    int hashCode(); // hash code
}

/*
 * Implementation details (not part of the interface, but to be implemented in the class):
 *
 * // Constructor Date
 * // Date (int month, int day, int year) create a date
 * // Date (String date) // create a date parse constructor
 */
