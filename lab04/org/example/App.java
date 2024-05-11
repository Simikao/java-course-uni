package org.example;

import java.time.DayOfWeek;
import java.time.LocalTime;
import java.util.ArrayList;
import java.util.Scanner;

class App {
	public static void menu() {
		System.out.println("--- Menu ---");
		System.out.println("1. Add meeting");
		System.out.println("2. Remove meeting");
		System.out.println("3. Show meetings for day");
		System.out.println("4. Show meetings for day with priority");
		System.out.println("5. Show meetings for day starting after time");
		System.out.println("6. Clear whole day");
		System.out.println("0. Exit");
	}

	public static void newMeeting(Calendar calendar, Scanner reader) {
		System.out.println("Enter day (1-7)");
		int day = reader.nextInt();
		reader.nextLine();
		System.out.println("Enter description: ");
		String description = reader.nextLine();
		System.out.println("Enter start time (HH:mm)");
		String startTime = reader.nextLine();
		System.out.println("Enter end time (HH:mm)");
		String endTime = reader.nextLine();
		System.out.println("Enter priority (1-3)");
		int priority = reader.nextInt();

		calendar.addMeeting(DayOfWeek.of(day),
				new Meeting(description, LocalTime.parse(startTime), LocalTime.parse(endTime),
						Priority.values()[priority - 1]));
	}

	public static void removeMeeting(Calendar calendar, Scanner reader) {
		System.out.println("Enter day (1-7)");
		int day = reader.nextInt();
		reader.nextLine();
		System.out.println("Start time (HH:mm)");
		String startTime = reader.nextLine();
		calendar.removeMeeting(DayOfWeek.of(day), LocalTime.parse(startTime));

	}

	public static void showMeetings(Calendar calendar, Scanner reader) {
		System.out.println("Enter day (1-7)");
		int day = reader.nextInt();
		ArrayList<Meeting> meetingsForDay = calendar.getMeetings(DayOfWeek.of(day), m -> true);

		System.out.println("Meetings for " + DayOfWeek.of(day));
		if (meetingsForDay.isEmpty()) {
			System.out.println("You're free!");
		} else {
			meetingsForDay.forEach(m -> System.out.println(m));
		}

	}

	public static void showByPriority(Calendar calendar, Scanner reader) {
		System.out.println("Enter day (1-7)");
		int day = reader.nextInt();
		reader.nextLine();
		System.out.println("Enter priority (1-3)");
		int priority = reader.nextInt();
		reader.nextLine();

		System.out.println("Meetings for " + DayOfWeek.of(day));
		ArrayList<Meeting> meetingsForDay = calendar.getMeetings(DayOfWeek.of(day),
				m -> m.getPriority() == Priority.values()[priority - 1]);
		meetingsForDay.forEach(m -> System.out.println(m));
	}

	public static void showByTime(Calendar calendar, Scanner reader) {
		System.out.println("Enter day (1-7)");
		int day = reader.nextInt();
		reader.nextLine();
		System.out.println("Enter start time (HH:mm)");
		String startTime = reader.nextLine();
		ArrayList<Meeting> meetingsForDay = calendar.getMeetings(DayOfWeek.of(day),
				m -> m.getStartTime().isAfter(LocalTime.parse(startTime))
						|| m.getStartTime().equals(LocalTime.parse(startTime)));

		System.out.println("Meetings for " + DayOfWeek.of(day));
		meetingsForDay.forEach(m -> System.out.println(m));
	}

	public static void populateCalendar(Calendar calendar) {
		calendar.addMeeting(DayOfWeek.MONDAY, new Meeting("Meeting 1", LocalTime.of(8, 0), LocalTime.of(9, 0),
				Priority.NORMAL));
		calendar.addMeeting(DayOfWeek.MONDAY, new Meeting("Meeting 2", LocalTime.of(9, 0), LocalTime.of(10, 0),
				Priority.HIGH));
		calendar.addMeeting(DayOfWeek.TUESDAY, new Meeting("Meeting 3", LocalTime.of(8, 0), LocalTime.of(9, 0),
				Priority.HIGHEST));
		calendar.addMeeting(DayOfWeek.TUESDAY, new Meeting("Meeting 4", LocalTime.of(9, 0), LocalTime.of(10, 0),
				Priority.NORMAL));
		calendar.addMeeting(DayOfWeek.WEDNESDAY,
				new Meeting("Meeting 5", LocalTime.of(8, 0), LocalTime.of(9, 0),
						Priority.HIGH));
		calendar.addMeeting(DayOfWeek.WEDNESDAY,
				new Meeting("Meeting 6", LocalTime.of(9, 0), LocalTime.of(10, 0),
						Priority.HIGHEST));
		calendar.addMeeting(DayOfWeek.THURSDAY, new Meeting("Meeting 7", LocalTime.of(8, 0), LocalTime.of(9, 0),
				Priority.NORMAL));
		calendar.addMeeting(DayOfWeek.THURSDAY,
				new Meeting("Meeting 8", LocalTime.of(9, 0), LocalTime.of(10, 0),
						Priority.HIGH));
		calendar.addMeeting(DayOfWeek.FRIDAY, new Meeting("Meeting 9", LocalTime.of(8, 0), LocalTime.of(9, 0),
				Priority.HIGHEST));
		calendar.addMeeting(DayOfWeek.FRIDAY, new Meeting("Meeting 10", LocalTime.of(9, 0), LocalTime.of(10, 0),
				Priority.NORMAL));
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
				case 1 -> newMeeting(calendar, reader);
				case 2 -> removeMeeting(calendar, reader);
				case 3 -> showMeetings(calendar, reader);
				case 4 -> showByPriority(calendar, reader);
				case 5 -> showByTime(calendar, reader);
				case 6 -> clearDay(calendar, reader);
				case 7 -> populateCalendar(calendar);
				case 0 -> exit = true;
			}
		}
		reader.close();
	}
}
