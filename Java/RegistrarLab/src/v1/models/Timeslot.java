package v1.models;

import java.time.DayOfWeek;
import java.time.LocalTime;

public class Timeslot {
	private DayOfWeek weekday;
	private LocalTime startTime;
	private LocalTime endTime;
	
	public Timeslot(DayOfWeek weekday, LocalTime startTime, LocalTime endTime) {
		super();
		this.weekday = weekday;
		this.startTime = startTime;
		this.endTime = endTime;
	}
	
	public DayOfWeek getWeekday() {
		return weekday;
	}
	public void setWeekday(DayOfWeek weekday) {
		this.weekday = weekday;
	}
	public LocalTime getStartTime() {
		return startTime;
	}
	public void setStartTime(LocalTime startTime) {
		this.startTime = startTime;
	}
	public LocalTime getEndTime() {
		return endTime;
	}
	public void setEndTime(LocalTime endTime) {
		this.endTime = endTime;
	}
	
	public String toString(){
		return weekday.toString().toUpperCase() + ": " + startTime.toString() + "-" + 
				endTime.toString();
	}
}
