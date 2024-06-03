package org.example;

import java.time.DayOfWeek;
import java.time.LocalTime;
import java.util.ArrayList;
import java.util.Scanner;

class App {
	public static void menu() {
		System.out.println("--- Menu ---");
		System.out.println("1. Add event");
		System.out.println("2. Remove event");
		System.out.println("3. Show events for day");
		System.out.println("4. Show events for day with priority/status");
		System.out.println("5. Show events for day starting after time");
		System.out.println("6. Clear whole day");
		System.out.println("7. Show events for day between times");
		System.out.println("8. Show events for day with priority/status based on time");
		System.out.println("0. Exit");

		System.out.print("Enter option: ");
	}

	public static void newEvent(Calendar calendar, Scanner reader) {
		int result = 4;
		System.out.println("Enter day (1-7)");
		int day = reader.nextInt();
		reader.nextLine();
		System.out.println("Enter description: ");
		String description = reader.nextLine();
		System.out.println("Enter start time (HH:mm)");
		String startTime = reader.nextLine();
		System.out.println("Enter end time (HH:mm)");
		String endTime = reader.nextLine();
		System.out.println("Enter type (1. meeting/2. task)");
		int type = reader.nextInt();
		reader.nextLine();
		if (type == 1) {
			System.out.println("Enter priority (1-3)");
			int priority = reader.nextInt();
			result = calendar.addEvent(DayOfWeek.of(day),
					new Meeting(description, LocalTime.parse(startTime),
							LocalTime.parse(endTime), Priority.values()[priority - 1]));
		} else {
			System.out.println("Enter status (1-4)");
			int status = reader.nextInt();
			result = calendar.addEvent(DayOfWeek.of(day),
					new Task(description, LocalTime.parse(startTime), LocalTime.parse(endTime),
							Status.values()[status - 1]));
		}

		switch (result) {
			case 0 -> System.out.println(type + " added successfully!");
			case 1 -> System.out.println("There is a collision with another event!");
			case 2 -> System.out.println("End time is before start time!");
			case 3 -> System.out.println("Start time is before 8:00!");
			case 4 -> System.out.println("Something went wrong!");
		}

	}

	public static void removeEvent(Calendar calendar, Scanner reader) {
		System.out.println("Enter day (1-7)");
		int day = reader.nextInt();
		reader.nextLine();
		System.out.println("Start time (HH:mm)");
		String startTime = reader.nextLine();
		ArrayList<CalendarObject> eventsForDay = calendar.getEvents(DayOfWeek.of(day),
				e -> e.getStartTime().equals(LocalTime.parse(startTime)));

		if (eventsForDay.isEmpty()) {
			System.out.println("No events found!");
		} else if (eventsForDay.size() == 1) {
			calendar.removeEvent(DayOfWeek.of(day), eventsForDay.get(0));
		} else {
			System.out.println("Select event to remove:");
			int index = 1;
			for (CalendarObject event : eventsForDay) {
				System.out.println(index + ". " + event);
				index++;
			}
			int selected = reader.nextInt();
			calendar.removeEvent(DayOfWeek.of(day), eventsForDay.get(selected - 1));
		}

	}

	public static void showEvents(Calendar calendar, Scanner reader) {
		System.out.println("Enter day (1-7)");
		int day = reader.nextInt();
		System.out.println("Enter type (0. all/1. meeting/2. task)");
		int type = reader.nextInt();
		reader.nextLine();

		if (type == 1) {
			ArrayList<CalendarObject> meetingsForDay = calendar.getEvents(DayOfWeek.of(day),
					e -> e instanceof Meeting);
			System.out.println("Meetings for " + DayOfWeek.of(day));
			if (meetingsForDay.isEmpty()) {
				System.out.println("You're free!");
			} else {
				meetingsForDay.forEach(m -> System.out.println(m));
			}
		} else if (type == 2) {
			ArrayList<CalendarObject> tasksForDay = calendar.getEvents(DayOfWeek.of(day),
					e -> e instanceof Task);

			System.out.println("Tasks for " + DayOfWeek.of(day));
			if (tasksForDay.isEmpty()) {
				System.out.println("You're free!");
			} else {
				tasksForDay.forEach(e -> System.out.println(e));
			}
		} else {
			ArrayList<CalendarObject> eventsForDay = calendar.getEvents(DayOfWeek.of(day), e -> true);

			System.out.println("Events for " + DayOfWeek.of(day));
			if (eventsForDay.isEmpty()) {
				System.out.println("You're free!");
			} else {
				eventsForDay.forEach(e -> System.out.println(e));
			}

		}
	}

	public static void showByPriority(Calendar calendar, Scanner reader) {
		System.out.println("Enter day (1-7)");
		int day = reader.nextInt();
		reader.nextLine();
		System.out.println("Enter type (1. meeting/2. task)");
		int type = reader.nextInt();
		reader.nextLine();
		switch (type) {
			case 1 -> {
				System.out.println("Enter priority (1-3)");
				int priority = reader.nextInt();
				reader.nextLine();

				System.out.println("Meetings for " + DayOfWeek.of(day));
				ArrayList<CalendarObject> meetingsForDay = calendar.getEvents(DayOfWeek.of(day),
						m -> m instanceof Meeting && ((Meeting) m)
								.getPriority() == Priority.values()[priority - 1]);
				meetingsForDay.forEach(m -> System.out.println(m));
			}
			case 2 -> {
				System.out.println("Enter status (1-4)");
				int status = reader.nextInt();
				reader.nextLine();

				System.out.println("Tasks for " + DayOfWeek.of(day));
				ArrayList<CalendarObject> tasksForDay = calendar.getEvents(DayOfWeek.of(day),
						t -> t instanceof Task && ((Task) t)
								.getStatus() == Status.values()[status - 1]);
				tasksForDay.forEach(t -> System.out.println(t));
			}
		}
	}

	public static void showByTime(Calendar calendar, Scanner reader) {
		System.out.println("Enter day (1-7)");
		int day = reader.nextInt();
		reader.nextLine();
		System.out.println("Enter start time (HH:mm)");
		String startTime = reader.nextLine();
		System.out.println("Enter type (0. all/1. meeting/2. task)");
		int type = reader.nextInt();
		reader.nextLine();

		switch (type) {
			case 0 -> {
				ArrayList<CalendarObject> eventsForDay = calendar.getEvents(DayOfWeek.of(day),
						e -> e.getStartTime().isAfter(LocalTime.parse(startTime))
								|| e.getStartTime().equals(LocalTime.parse(startTime)));

				System.out.println("Events for " + DayOfWeek.of(day));
				eventsForDay.forEach(e -> System.out.println(e));
			}
			case 1 -> {
				ArrayList<CalendarObject> meetingsForDay = calendar.getEvents(DayOfWeek.of(day),
						m -> m instanceof Meeting
								&& (m.getStartTime().isAfter(LocalTime.parse(startTime))
										|| m.getStartTime().equals(LocalTime
												.parse(startTime))));

				System.out.println("Meetings for " + DayOfWeek.of(day));
				meetingsForDay.forEach(m -> System.out.println(m));
			}
			case 2 -> {
				ArrayList<CalendarObject> tasksForDay = calendar.getEvents(DayOfWeek.of(day),
						t -> t instanceof Task
								&& (t.getStartTime().isAfter(LocalTime.parse(startTime))
										|| t.getStartTime().equals(LocalTime
												.parse(startTime))));

				System.out.println("Tasks for " + DayOfWeek.of(day));
				tasksForDay.forEach(t -> System.out.println(t));
			}
		}
	}

	public static void showByTimeFork(Calendar calendar, Scanner reader) {
		System.out.println("Enter day (1-7)");
		int day = reader.nextInt();
		reader.nextLine();
		System.out.println("Enter type (0. all/1. meeting/2. task)");
		int type = reader.nextInt();
		reader.nextLine();
		System.out.println("Enter start time (HH:mm)");
		String startTime = reader.nextLine();
		System.out.println("Enter end time (HH:mm)");
		String endTime = reader.nextLine();

		switch (type) {
			case 0 -> {
				ArrayList<CalendarObject> eventsForDay = calendar.getEvents(DayOfWeek.of(day),
						e -> (e.getStartTime().isAfter(LocalTime.parse(startTime))
								|| e.getStartTime().equals(LocalTime.parse(startTime)))
								&& (e.getEndTime().isBefore(LocalTime.parse(endTime))
										|| e.getEndTime().equals(LocalTime
												.parse(endTime))));

				System.out.println("Events for " + DayOfWeek.of(day));
				eventsForDay.forEach(e -> System.out.println(e));
			}
			case 1 -> {
				ArrayList<CalendarObject> meetingsForDay = calendar.getEvents(DayOfWeek.of(day),
						m -> m instanceof Meeting
								&& (m.getStartTime().isAfter(LocalTime.parse(startTime))
										|| m.getStartTime().equals(LocalTime
												.parse(startTime)))
								&& (m.getEndTime().isBefore(LocalTime.parse(endTime))
										|| m.getEndTime().equals(LocalTime
												.parse(endTime))));

				System.out.println("Meetings for " + DayOfWeek.of(day));
				meetingsForDay.forEach(m -> System.out.println(m));
			}
			case 2 -> {
				ArrayList<CalendarObject> tasksForDay = calendar.getEvents(DayOfWeek.of(day),
						t -> t instanceof Task
								&& (t.getStartTime().isAfter(LocalTime.parse(startTime))
										|| t.getStartTime().equals(LocalTime
												.parse(startTime)))
								&& (t.getEndTime().isBefore(LocalTime.parse(endTime))
										|| t.getEndTime().equals(LocalTime
												.parse(endTime))));

				System.out.println("Tasks for " + DayOfWeek.of(day));
				tasksForDay.forEach(t -> System.out.println(t));
			}
		}
	}

	public static void showByPriorityByTime(Calendar calendar, Scanner reader) {
		System.out.println("Enter day (1-7)");
		int day = reader.nextInt();
		reader.nextLine();
		System.out.println("Enter type (1. meeting/2. task)");
		int type = reader.nextInt();
		reader.nextLine();

		switch (type) {
			case 1 -> {
				System.out.println("Enter priority (1-3)");
				int priority = reader.nextInt();
				reader.nextLine();
				System.out.println("Enter start time (HH:mm)");
				String startTime = reader.nextLine();

				ArrayList<CalendarObject> meetingsForDay = calendar.getEvents(DayOfWeek.of(day),
						m -> m instanceof Meeting
								&& ((Meeting) m).getPriority() == Priority
										.values()[priority - 1]
								&& (m.getStartTime().isAfter(LocalTime.parse(startTime))
										|| m.getStartTime().equals(LocalTime
												.parse(startTime))));
				System.out.println("Meetings for " + DayOfWeek.of(day));
				meetingsForDay.forEach(m -> System.out.println(m));
			}
			case 2 -> {
				System.out.println("Enter status (1-4)");
				int status = reader.nextInt();
				reader.nextLine();
				System.out.println("Enter end time (HH:mm)");
				String endTime = reader.nextLine();

				ArrayList<CalendarObject> tasksForDay = calendar.getEvents(DayOfWeek.of(day),
						t -> t instanceof Task
								&& ((Task) t).getStatus() == Status.values()[status - 1]
								&& (t.getEndTime().isBefore(LocalTime.parse(endTime))
										|| t.getEndTime().equals(LocalTime
												.parse(endTime))));

				System.out.println("Tasks for " + DayOfWeek.of(day));
				tasksForDay.forEach(t -> System.out.println(t));
			}
		}
	}

	public static void populateCalendar(Calendar calendar) {
		calendar.addEvent(DayOfWeek.MONDAY, new Meeting("Meeting 1", LocalTime.of(8, 0), LocalTime.of(9, 0),
				Priority.HIGH));
		calendar.addEvent(DayOfWeek.MONDAY, new Meeting("Meeting 2", LocalTime.of(9, 0), LocalTime.of(10, 0),
				Priority.HIGHEST));
		calendar.addEvent(DayOfWeek.MONDAY, new Meeting("Meeting 3", LocalTime.of(10, 0), LocalTime.of(11, 0),
				Priority.NORMAL));
		calendar.addEvent(DayOfWeek.MONDAY, new Meeting("Meeting 4", LocalTime.of(11, 0), LocalTime.of(12, 0),
				Priority.HIGH));
		calendar.addEvent(DayOfWeek.MONDAY, new Meeting("Meeting 5", LocalTime.of(12, 0), LocalTime.of(13, 0),
				Priority.HIGHEST));
		calendar.addEvent(DayOfWeek.MONDAY, new Meeting("Meeting 6", LocalTime.of(13, 0), LocalTime.of(14, 0),
				Priority.NORMAL));
		calendar.addEvent(DayOfWeek.MONDAY, new Meeting("Meeting 7", LocalTime.of(14, 0), LocalTime.of(15, 0),
				Priority.HIGH));
		calendar.addEvent(DayOfWeek.MONDAY, new Meeting("Meeting 8", LocalTime.of(15, 0), LocalTime.of(16, 0),
				Priority.HIGHEST));
		calendar.addEvent(DayOfWeek.MONDAY, new Task("Task 1", LocalTime.of(11, 0), LocalTime.of(12, 0),
				Status.BEING_PLANNED));
		calendar.addEvent(DayOfWeek.MONDAY, new Task("Task 2", LocalTime.of(12, 0), LocalTime.of(13, 0),
				Status.CONFIRMED));
		calendar.addEvent(DayOfWeek.MONDAY, new Task("Task 3", LocalTime.of(13, 0), LocalTime.of(14, 0),
				Status.IN_PROGRESS));
		calendar.addEvent(DayOfWeek.MONDAY, new Task("Task 4", LocalTime.of(14, 0), LocalTime.of(15, 0),
				Status.DONE));

		calendar.addEvent(DayOfWeek.MONDAY, new Task("Task 5", LocalTime.of(8, 0), LocalTime.of(9, 0),
				Status.DONE));
		calendar.addEvent(DayOfWeek.MONDAY, new Task("Task 6", LocalTime.of(9, 0), LocalTime.of(10, 0),
				Status.IN_PROGRESS));
		calendar.addEvent(DayOfWeek.MONDAY, new Task("Task 7", LocalTime.of(10, 0), LocalTime.of(11, 0),
				Status.CONFIRMED));
	}

	public static void clearDay(Calendar calendar, Scanner reader) {
		System.out.println("Enter day (1-7)");
		int day = reader.nextInt();
		calendar.clearDay(DayOfWeek.of(day));
	}

	public static void greeting() {
		System.out.println("Welcome to the Calendar app!");
		System.out.println("You can add, remove, and view meetings for each day of the week.");
		System.out.println("You can also view meetings by priority and starting time.");
	}

	public static void main(String[] args) {
		Scanner reader = new Scanner(System.in);
		greeting();
		Calendar calendar = new Calendar();
		boolean exit = false;

		while (!exit) {
			menu();
			int option = reader.nextInt();
			switch (option) {
				case 1 -> newEvent(calendar, reader);
				case 2 -> removeEvent(calendar, reader);
				case 3 -> showEvents(calendar, reader);
				case 4 -> showByPriority(calendar, reader);
				case 5 -> showByTime(calendar, reader);
				case 6 -> clearDay(calendar, reader);
				case 7 -> showByTimeFork(calendar, reader);
				case 8 -> showByPriorityByTime(calendar, reader);
				case 99 -> populateCalendar(calendar);
				case 0 -> exit = true;
			}
		}
		reader.close();
	}
}
