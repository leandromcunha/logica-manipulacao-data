package cunha.date;

import cunha.bean.DateBean;

public class DateSubtract extends AbstractDate {
	public DateSubtract(DateBean bean, int minute) {
		super(bean, minute);
	}

	private static final long serialVersionUID = 1L;

	@Override
	protected void changeYear() {
		this.changeDate.previousYear();
	}

	@Override
	protected void changeMonth() {
		this.changeDate.previousMonth();
	}

	@Override
	protected void changeDay() throws Exception{
		this.changeDate.previousDay();
	}

	@Override
	protected void changeHour() throws Exception {
		this.changeDate.previousHour();
	}

	@Override
	protected void changeMinute() throws Exception {
		this.changeDate.previousMinute();
	}
}