package org.example;

import java.util.Scanner;

public class App {
    public static void getGreeting() {
        System.out.println("Welcome to the app where you can check some random stuff with your grades! Woo!");
        System.out.println("-------------------");
    }

    public static String menu() {
        return """
                MENU
                1. Add new grade (1)
                2. Add new grades (few at once)
                3. Calculate average
                4. Find lowest grade
                5. Find best grade
                6. Exit
                """;
    }

    public static double input(Scanner reader) {
        if (reader.hasNextInt()) {
            return (double) reader.nextInt();
        }
        return reader.nextDouble();
    }

    public static Double[] inputList(Scanner reader) {
        System.out.println("How many elements do you want to input?: ");
        Double[] numbers = new Double[reader.nextInt()];

        for (int i = 0; i < numbers.length; i++) {
            System.out.println("Please enter number");
            numbers[i] = input(reader);
        }

        return numbers;

    }

    public static void noGrades() {
        System.out.println("No grades to work on, input some grades first");
    }

    public static void output(int number, GradeList gradeList) {
        double output = -1.0;
        switch (number) {
            case 3 -> output = gradeList.avg();
            case 4 -> output = gradeList.min();
            case 5 -> output = gradeList.max();
        }

        if (output < 0.0) {
            noGrades();
        }

        System.out.println(output);
    }

    public static void main(String[] args) {
        Scanner reader = new Scanner(System.in);
        GradeList gradeList = new GradeList();

        getGreeting();
        boolean running = true;

        while (running) {
            System.out.println(menu());
            switch (reader.nextInt()) {
                case 1 -> gradeList.addNew(input(reader));
                case 2 -> gradeList.addNew(inputList(reader));
                case 3 -> output(3, gradeList);
                case 4 -> output(4, gradeList);
                case 5 -> output(5, gradeList);
                case 6 -> running = false;
                default -> {
                }
            }
        }

    }
}
