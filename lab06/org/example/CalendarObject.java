package org.example;

import java.time.LocalTime;

sealed abstract class CalendarObject permits Task, Meeting {
	public static final LocalTime EARLIEST_TIME = LocalTime.of(8, 0);
	protected String description;
	protected LocalTime startTime;
	protected LocalTime endTime;

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
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

	public abstract boolean isCollision(CalendarObject otherEvent);

}
