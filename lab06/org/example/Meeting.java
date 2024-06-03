package org.example;

import java.time.LocalTime;

enum Priority {
	NORMAL, HIGH, HIGHEST
}

public final class Meeting extends CalendarObject {
	private Priority priority;

	public Meeting(String description, LocalTime startTime, LocalTime endTime, Priority priority) {
		this.description = description;
		this.startTime = startTime;
		this.endTime = endTime;
		this.priority = priority;
	}

	@Override
	public String toString() {
		return startTime + " - " + endTime + " | MEETING: " + description + " | " + priority;
	}

	public Priority getPriority() {
		return priority;
	}

	public void setPriority(Priority priority) {
		this.priority = priority;
	}

	public boolean isCollision(CalendarObject otherMeeting) {
		if (otherMeeting instanceof Meeting) {
			return this.startTime.isBefore(otherMeeting.endTime)
					&& this.endTime.isAfter(otherMeeting.startTime);
		}
		return false;
	}
}
