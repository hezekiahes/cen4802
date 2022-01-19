
public class Mcclure_ModuleTwoFib {

	/**
	 * Method to calculate the nth term of the fibonacci sequence
	 * @param n  
	 * @return nth term of fibonacci sequence
	 */
	public static int fib(int n) {
		
		if (n <= 1) 
			return n;
		
		return fib(n - 1) + fib(n - 2);  
	}
	
	/**
	 * Main method 
	 * @param args
	 */
	public static void main(String[] args) {
		
		int n = 10;
		
		System.out.println("The " + n + "th term of the Fibonacci Sequence is " + fib(n));
		
	}
}
