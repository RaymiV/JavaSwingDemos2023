
public class LoopCountingTest {

	public static void doCount(int n) {
		System.out.printf("n = %d, ", n);
		int count = 5; 
		int i = 0;
		while (count < n) 
		{  
			i++;
			count = count + 3; 
		}
		System.out.printf("inside the loop %d times. ", i);
		System.out.printf("ceil(n - 5)/3 = %d%n", 
				(int)Math.ceil((n - 5.0)/(3.0)));
		
	}
	
	public static void main(String[] args) {
		for (int n = 0; n < 30; n++) doCount(n);
	}

}
