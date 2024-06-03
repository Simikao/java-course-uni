package org.example;

import java.time.DayOfWeek;
import java.util.ArrayList;
import java.util.Map;
import java.util.function.Predicate;

class Calendar {
	private final Map<DayOfWeek, ArrayList<CalendarObject>> events;

	public Calendar() {
		events = new java.util.HashMap<>();
		for (DayOfWeek day : DayOfWeek.values()) {
			events.put(day, new ArrayList<>());
		}
	}

	public int addEvent(DayOfWeek day, CalendarObject event) {
		var eventsForDay = events.get(day);

		for (CalendarObject otherEvent : eventsForDay) {
			if (event.isCollision(otherEvent)) {
				return 1;
			}
		}
		if (event.getEndTime().isBefore(event.getStartTime())) {
			return 2;
		}
		if (event.getStartTime().isBefore(CalendarObject.EARLIEST_TIME)) {
			return 3;
		}
		eventsForDay.add(event);
		return 0;
	}

	public void removeEvent(DayOfWeek day, CalendarObject event) {
		events.get(day).remove(event);
	}

	public ArrayList<CalendarObject> getEvents(DayOfWeek day, Predicate<CalendarObject> predicate) {
		var eventsForDay = events.get(day);
		var result = new ArrayList<CalendarObject>();
		for (CalendarObject event : eventsForDay) {
			if (predicate.test(event)) {
				result.add(event);
			}
		}
		return result;
	}

	public void clear() {
		for (DayOfWeek day : DayOfWeek.values()) {
			events.get(day).clear();
		}
	}

	public void clearDay(DayOfWeek day) {
		events.get(day).clear();
	}

}
