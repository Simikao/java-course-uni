package lab02.org;

import java.util.Scanner;

import lab02.org.Walec;

public class App {
	public static double input(Scanner reader, String variable) {
		System.out.println(String.format("Enter %s", variable));

		return reader.nextDouble();
	}

	public static void menu() {
		System.out.println("""
				Select mode:
				1. Show values
				2. Give new values
				3. Calculate base area
				4. Calculate lateral surface area
				5. Calculate total surface area
				6. Calculate volume
				0. Exit""");
	}

	public static void getCylinder(Walec cylinder) {
		System.out.println("Height: " + cylinder.getHeight());
		System.out.println("Radius: " + cylinder.getRadius());
	}

	public static void setCylinder(Scanner reader, Walec cylinder) {
		cylinder.setRadius(input(reader, "radius"));
		cylinder.setHeight(input(reader, "height"));
	}

	public static void greeting() {
		System.out.println("This porgram is used to calculate various properties of a cylinder");
		System.out.println("-------------");
	}

	public static void main(String[] args) {
		Scanner reader = new Scanner(System.in);
		greeting();
		boolean running = true;

		Walec cylinder = new Walec();

		while (running) {
			menu();
			switch (reader.nextInt()) {
				case 1 -> getCylinder(cylinder);
				case 2 -> setCylinder(reader, cylinder);
				case 3 -> System.out.println("Base area: " + cylinder.baseArea());
				case 4 -> System.out.println("Lateral surface area: " + cylinder.latSurfaceArea());
				case 5 -> System.out.println("Total surface area: " + cylinder.totSurfaceArea());
				case 6 -> System.out.println("Volume of the cylinder: " + cylinder.volume());
				case 0 -> running = false;
				default -> {
				}

			}
		}
		reader.close();
	}
}
