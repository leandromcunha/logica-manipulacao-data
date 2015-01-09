package cunha.bean;

public class DateBean implements IBean {
	private static final long serialVersionUID = 1L;

	private static int DAY    = 0;
	private static int MONTH  = 1;
	private static int YEAR   = 2;
	private static int HOUR   = 3;
	private static int MINUTE = 4;
	
	private int year;
	private int month;
	private int day;
	private int hour;
	private int minute;

	public void setYear(int year) {
		this.year = year;
	}
	public int getYear() {
		return year;
	}
	public void setMonth(int month) {
		this.month = month;
	}
	public int getMonth() {
		return month;
	}
	public void setDay(int day) {
		this.day = day;
	}
	public int getDay() {
		return day;
	}
	public void setHour(int hour) {
		this.hour = hour;
	}
	public int getHour() {
		return hour;
	}
	public void setMinute(int minute) {
		this.minute = minute;
	}
	public int getMinute() {
		return minute;
	}

	public static DateBean getDateBean(String date) {
		String[] d = date.split( "[/ :]" );
		DateBean bean = new DateBean();
		bean.setDay ( Integer.parseInt( d[ DAY  ] ) );
		bean.setHour( Integer.parseInt( d[ HOUR ] ) );
		bean.setMinute( Integer.parseInt( d[ MINUTE ] ) );
		bean.setMonth( Integer.parseInt( d[ MONTH] ) );
		bean.setYear( Integer.parseInt( d[ YEAR ] ) );
		return bean;
	}
}
