package cunha.constants;

public enum MinutesEachTime {
	HOUR(60),
	DAY(1440),
	MONTH(1440), // Relativo a cada mês
	YEAR(525600),
	;
	private int minute;
	MinutesEachTime(int minute ){
		this.setMinute(minute);
	}
	public int getMinute() {
		return minute;
	}
	public void setMinute(int minute) {
		this.minute = minute;
	}
}
