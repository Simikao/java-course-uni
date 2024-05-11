package calculus;

public class Calculations {
    
	public static long iteratePower(int number) {
		long result = 1;

		for (int i = 1; i <= number; i++) {
			result *= 2;
		}

		return result;
	}

	public static int rangeSum(int number1, int number2) {
		int min = number1 > number2 ? number2 : number1;
		int max = number1 > number2 ? number1 : number2;

		int sum = 0;
		for (int i = min; i <= max ; i++) {
			sum += i;
		}

		return sum;
	}

}
