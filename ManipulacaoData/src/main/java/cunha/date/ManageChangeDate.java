package cunha.date;

import cunha.bean.DateBean;
import cunha.constants.BiggestDayMonth;

public class ManageChangeDate {

	private static int MAX_MONTH   = 12;
	private static int MIN_MONTH   =  1;

	private static int MIN_DAY     =  1;
	
	private static int MIN_HOUR    =  0;
	private static int MAX_HOUR    = 23;
	
	private static int MIN_MINUTE  =  0;
	private static int MAX_MINUTE  = 59;
	
	private DateBean bean;
	
	public static ManageChangeDate newInstance( DateBean bean ){
		return new ManageChangeDate(bean);
	}
	
	private ManageChangeDate( DateBean bean  ){
		this.bean = bean;
	}
	
	public void nextYear(){
		this.bean.setYear( this.bean.getYear() + 1 );
	}
	
	public void previousYear(){
		this.bean.setYear( this.bean.getYear() - 1 );
	}
	
	public void nextMonth() {
		int month = this.bean.getMonth() + 1;
		if( month > MAX_MONTH ){
			month = MIN_MONTH;
			this.nextYear();
		}
		this.bean.setMonth(month);
	}
	
	public void previousMonth(){
		int month = this.bean.getMonth() - 1;
		if( month < MIN_MONTH ){
			month = MAX_MONTH;
			this.previousYear();
		}
		this.bean.setMonth(month);
	}

	public void nextDay()  throws Exception {
		BiggestDayMonth dayMonth = BiggestDayMonth.getBiggestDayMonth( this.bean.getMonth() );
		int day = this.bean.getDay()+1;
		if( day > dayMonth.getMaxDay() ){
			day = MIN_DAY;
			this.nextMonth();
		}
		this.bean.setDay(day);
	}

	public void previousDay() throws Exception {
		int day = this.bean.getDay()-1;
		if( day < MIN_DAY ){
			this.previousMonth();
			BiggestDayMonth dayMonth = BiggestDayMonth.getBiggestDayMonth( this.bean.getMonth() );
			day = dayMonth.getMaxDay();
		}
		this.bean.setDay(day);
	}
	
	public void nextHour()  throws Exception {
		int hour = this.bean.getHour()+1;
		if( hour > MAX_HOUR ){
			hour = MIN_HOUR;
			this.nextDay();
		}
		this.bean.setHour(hour);
	}

	public void previousHour() throws Exception {
		int hour = this.bean.getHour()-1;
		if( hour < MIN_HOUR ){
			this.previousDay();
			hour = MAX_HOUR;
		}
		this.bean.setHour(hour);
	}
	
	public void nextMinute()  throws Exception {
		int minute = this.bean.getMinute()+1;
		if( minute > MAX_MINUTE){
			minute = MIN_MINUTE;
			this.nextHour();
		}
		this.bean.setMinute(minute);
	}

	public void previousMinute() throws Exception {
		int minute = this.bean.getMinute()-1;
		if( minute < MIN_MINUTE ){
			this.previousHour();
			minute = MAX_MINUTE;
		}
		this.bean.setMinute(minute);
	}	
}