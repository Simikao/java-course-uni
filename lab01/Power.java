import java.util.Scanner;
import calculus.Calculations;


public class Power {

	public static int input(Scanner reader) {
		System.out.print("Enter a number: ");

		return reader.nextInt();
	}

	public static void main(String[] args) {
		Scanner reader = new Scanner(System.in);
		System.out.println("The program is used to calculate n power of 2, where n is a natural number");
		System.out.println("-----------------");
		boolean running = true;

		while (running) {
			System.out.println("Select mode:\n1. Power of 2\n2. Sum in range");
			int selection = input(reader);

			switch(selection) {
			  case 1:
				int number = input(reader);
				long resultPow = Calculations.iteratePower(number);
				System.out.println(resultPow);
				break;
			  case 2:
				System.out.println("Enter the first number");
				int number1 = input(reader);
				System.out.println("Enter the second number");
				int number2 = input(reader);
				int resultSum = Calculations.rangeSum(number1, number2);
				System.out.println(resultSum);
				break;
			  default:
				break;
			}
			System.out.println();
			System.out.println("-----------------");
			System.out.println("1. Try another\n0. Exit");
			int selection2 = reader.nextInt();

			if (selection2 == 0) {
				running = false;
			}

		}
		reader.close();
	}
}
