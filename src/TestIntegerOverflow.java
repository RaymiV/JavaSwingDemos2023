
public class TestIntegerOverflow {

	public static void main(String[] args) {
		int x = 80000000; 
		while (x > 0)  x++; 
		System.out.println("x is " + x);
	}

}
