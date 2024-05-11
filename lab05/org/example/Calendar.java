package org.example;

import java.time.DayOfWeek;
import java.time.LocalTime;
import java.util.ArrayList;
import java.util.Map;
import java.util.function.Predicate;

class Calendar {
	private Map<DayOfWeek, ArrayList<Meeting>> meetings;

	public Calendar() {
		meetings = new java.util.HashMap<>();
		for (DayOfWeek day : DayOfWeek.values()) {
			meetings.put(day, new ArrayList<>());
		}
	}

	public int addMeeting(DayOfWeek day, Meeting meeting) {
		ArrayList<Meeting> meetingsForDay = meetings.get(day);

		if (meeting.getStartTime().isBefore(Meeting.EARLIEST_TIME)) {
			return 3;
		}
		if (meeting.getEndTime().isBefore(meeting.getStartTime())) {
			return 2;
		}
		if (meetingsForDay.stream().noneMatch(m -> m.isCollision(meeting))) {
			meetingsForDay.add(meeting);
			return 0;
		} else {
			return 1;
		}
	}

	public void removeMeeting(DayOfWeek day, LocalTime startTime) {
		ArrayList<Meeting> meetingsForDay = meetings.get(day);
		meetingsForDay.removeIf(m -> m.getStartTime().equals(startTime));
	}

	public void clearDay(DayOfWeek day) {
		meetings.get(day).clear();
	}

	public ArrayList<Meeting> getMeetings(DayOfWeek day, Predicate<Meeting> predicate) {
		var meetingsForDay = meetings.get(day);
		var result = new ArrayList<Meeting>();
		for (Meeting meeting : meetingsForDay) {
			if (predicate.test(meeting)) {
				result.add(meeting);
			}
		}
		return result;
	}
}
