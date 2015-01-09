package cunha.date;

import cunha.bean.DateBean;
import cunha.constants.BiggestDayMonth;
import cunha.constants.MinutesEachTime;

public abstract class AbstractDate implements IDate<DateBean> {
	private static final long serialVersionUID = 1L;

	protected DateBean bean;
	protected int minute;
	protected ManageChangeDate changeDate;

	protected AbstractDate( DateBean bean, int minute ){
		this.minute = ( minute < 0 ? minute * -1 : minute );
		this.bean = bean;
		this.changeDate = ManageChangeDate.newInstance( bean );
	}

	protected String formattedDate(){
		return String.format("%02d/%02d/%04d %02d:%02d", bean.getDay(), bean.getMonth() , bean.getYear() , bean.getHour(), bean.getMinute() );
	}

	protected int minuteMonth() throws Exception {
		return MinutesEachTime.MONTH.getMinute() * BiggestDayMonth.getBiggestDayMonth( bean.getMonth() ).getMaxDay();
	}
	
	public String getDate() throws Exception {
		if( this.minute > MinutesEachTime.YEAR.getMinute() ){
			this.minute -= MinutesEachTime.YEAR.getMinute();
			this.changeYear();
			return getDate();
		}else if( this.minute > minuteMonth() ){
			this.minute -= minuteMonth();
			this.changeMonth();
			return getDate();
		}else if( this.minute > MinutesEachTime.DAY.getMinute() ){
			this.minute -= MinutesEachTime.DAY.getMinute();
			this.changeDay();
			return getDate();
		}else if( this.minute > MinutesEachTime.HOUR.getMinute() ){
			this.minute -= MinutesEachTime.HOUR.getMinute();
			this.changeHour();
			return getDate();
		}else if( this.minute >= 1 ) {
			this.minute--;
			this.changeMinute();
			return getDate();
		}
		return formattedDate();
	}

	protected abstract void changeYear();
	protected abstract void changeMonth();
	protected abstract void changeDay()throws Exception;
	protected abstract void changeHour()throws Exception;
	protected abstract void changeMinute()throws Exception;
}