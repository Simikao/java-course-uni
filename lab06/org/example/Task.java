package org.example;

import java.time.LocalTime;

enum Status {
	BEING_PLANNED, CONFIRMED, IN_PROGRESS, DONE
}

public final class Task extends CalendarObject {
	private Status status;

	public Task(String description, LocalTime startTime, LocalTime endTime, Status status) {
		this.description = description;
		this.startTime = startTime;
		this.endTime = endTime;
		this.status = status;
	}

	public Status getStatus() {
		return status;
	}

	public void setStatus(Status status) {
		this.status = status;
	}

	public boolean isCollision(CalendarObject otherTask) {
		if (otherTask instanceof Task) {
			return this.startTime.isBefore(otherTask.endTime)
					&& this.endTime.isAfter(otherTask.startTime);
		}
		return false;

	}

	@Override
	public String toString() {
		return startTime + " - " + endTime + " | TASK: " + description + " | " + status;
	}

}
