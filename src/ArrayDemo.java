public class ArrayDemo {
	public static void main(String[] args) {
		double result1 = max(5.5, 6.7);
		System.out.printf("Max of 5.5 and 6.7 is %.2f%n", result1);
		double result2 = max(7.2, 1.9, -4.5);
		System.out.printf("Max of 7.2, 1.9, and -4.5 is %.2f%n", result2);
		double [] test_arr = {4, 6, 42, 43, 21, 83.78723, 10.3, 25.23, 18.23, 1.32};
		System.out.printf(
				"Max of {4, 6, 42, 43, 21, 83.78723, 10.3, 25.23, 18.23, 1.32} is %.4f%n", 
				max(test_arr));
		
	}

	public static double max(double num1, double num2) {
		if (num1 >= num2) {
			return num1;
		}
		return num2;
	}

	public static double max(double num1, double num2, double num3) {
		if (num1 >= num2 && num1 >= num3) {
			return num1;
		} else if (num2 >= num3) {
			return num2;
		}
		return num3;
	}
	
	public static double max(double [] arr) {
		double m = arr[0];
		for (int i = 1; i < arr.length; i++) {
			if (m < arr[i]) m = arr[i];
		}
		return m;
	}
}
