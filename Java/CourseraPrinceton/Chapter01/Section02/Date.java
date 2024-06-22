// basic date, takes larger data, but faster. 

public class BasicDate {
	private final int month;
	private final int day;
	private final int year;

	public Date(int m, int d, int y) { //constructor
		month = m;
		day = d;
		year = y;
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

	public String toString() {
		return month() + "/" + day() + "/" + year();
	}
}

// implements date type which takes less data size in memory
// but takes cpu cycles to calculate the end date. 

