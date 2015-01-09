package cunha.constants;

public enum BiggestDayMonth {
	JANUARY(1,31),
	FEBRUARY(2,28),
	MARCH(3,31),
	APRIL(4,30),
	MAY(5,31),
	JUNE(6,30),
	JULY(7,31),
	AUGUST(8,31),
	SEPTEMBER(9,30),
	OCTOBER(10,31),
	NOVEMBER(11,30),
	DECEMBER(12,31),
	;
	private int month;
	private int maxDay;

	BiggestDayMonth(int month, int maxDay ){
		this.setMonth(month);
		this.setMaxDay(maxDay);
	}
	public void setMonth(int month) {
		this.month = month;
	}
	public int getMonth() {
		return month;
	}
	public void setMaxDay(int maxDay) {
		this.maxDay = maxDay;
	}
	public int getMaxDay() {
		return maxDay;
	}

	public static BiggestDayMonth getBiggestDayMonth( int month ) throws Exception {
		for ( BiggestDayMonth m : BiggestDayMonth.values() ) {
			if( m.getMonth() == month ){
				return m;
			}
		}
		throw new Exception( String.format( "Month does not exist [ %s ]!" , month ) );
	}
}