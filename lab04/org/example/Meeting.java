package org.example;

import java.time.LocalTime;

enum Priority {
	NORMAL, HIGH, HIGHEST
}

class Meeting {
	public static final LocalTime earliestTime = LocalTime.of(8, 0);
	private String description;
	private LocalTime startTime;
	private LocalTime endTime;
	private Priority priority;

	public Meeting(String description, LocalTime startTime, LocalTime endTime, Priority priority) {
		this.description = description;
		this.startTime = startTime;
		this.endTime = endTime;
		this.priority = priority;
	}

	public String getDescription() {
		return description;
	}

	public LocalTime getStartTime() {
		return startTime;
	}

	public LocalTime getEndTime() {
		return endTime;
	}

	public Priority getPriority() {
		return priority;
	}

	public boolean isCollision(Meeting otherMeeting) {
		return this.startTime.isBefore(otherMeeting.endTime)
				&& this.endTime.isAfter(otherMeeting.startTime);
	}

	public String toString() {
		return startTime + " - " + endTime + " " + description + " | " + priority;
	}
}
