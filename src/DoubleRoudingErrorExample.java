
public class DoubleRoudingErrorExample {

	public static void main(String[] args) {
		double item = 1;
		double sum = 0;
		double TOLERANCE = 1e-15;
		while (Math.abs(item) > TOLERANCE) 
		{ // No guarantee item will be 0  
			sum += item;  
			item -= 0.1; 
			} 
		System.out.println(sum);
	}

}

