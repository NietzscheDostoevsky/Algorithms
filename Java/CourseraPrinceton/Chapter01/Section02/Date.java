// basic date, takes larger data, but faster. 

class BasicDate {
	private final int month;
	private final int day;
	private final int year;

	public BasicDate(int m, int d, int y) { //constructor
		this.month = m;
		this.day = d;
		this.year = y;
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

class SmallDate{
	private final int value;

	public SmallDate(int m, int d, int y) {
		this.value = y*512 + m*32 + d;
	}

	public int month() {
		return (value / 32) % 16 ;
	}
	public int day() {
		return value % 32 ;
	}	
	public int year() {
		return value / 512 ; 
	}

	public String toString() {
		return month() + "/" + day() + "/" + year(); 
	}
}