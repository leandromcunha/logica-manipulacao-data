package cunha.date;

import cunha.bean.DateBean;

public class DateAdd extends AbstractDate {
	public DateAdd(DateBean bean, int minute) {
		super(bean, minute);
	}

	private static final long serialVersionUID = 1L;

	@Override
	protected void changeYear() {
		this.changeDate.nextYear();
	}

	@Override
	protected void changeMonth() {
		this.changeDate.nextMonth();
	}

	@Override
	protected void changeDay() throws Exception{
		this.changeDate.nextDay();
	}

	@Override
	protected void changeHour() throws Exception {
		this.changeDate.nextHour();
	}

	@Override
	protected void changeMinute() throws Exception {
		this.changeDate.nextMinute();
	}



}
