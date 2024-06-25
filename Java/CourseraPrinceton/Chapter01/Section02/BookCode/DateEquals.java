import edu.princeton.cs.algs4.*;
class DateEquals {
	private final int month;
	private final int day;
	private final int year;

	public DateEquals(int month, int day, int year) {
		// constructor 

		this.month = month;
		this.day = day;
		this.year = year;
	}

	public int month() { 
		return month;
	}

	public int day() {
		return day;
	}

	public int year() {
		return year;
	}

	//overriding default toString() method
	public String toString() {
		return month() + "/" + day() + "/" + year();
	}

	// overriding default equals method 
	public boolean equals(Object x) {
		if(this == x) return true;
		if(x == null) return false;
		if (this.getClass() != x.getClass()) return false;
		DateEquals that = (DateEquals) x;
		if(this.day != that.day) return false;
		if(this.month != that.month) return false;
		if(this.year != that.year) return false;

		return true;
	}
}

// Date Equals driver 

class DateEqualsDriver {
	public static void main(String[] args) {
		
		DateEquals date1 = new DateEquals(6, 25, 2024);
		DateEquals date2 = new DateEquals(6, 25, 2024);
		DateEquals date3 = new DateEquals(7, 25, 2024);

		System.out.println("Date1 == Date2: " + (date1.equals(date2)));
		System.out.println("Date2 == Date3: " + (date2.equals(date3)));
		System.out.println("Date1 == Date3: " + (date1.equals(date3)));
		System.out.println("Date1 == Date1: " + (date1.equals(date1)));
	}
}