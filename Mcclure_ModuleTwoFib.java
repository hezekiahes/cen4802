
public class Mcclure_ModuleTwoFib {

	
	public static int fib(int n) {
		
		if (n <= 1) 
			return n;
		
		return fib(n - 1) + fib(n - 2);  
	}
	
	
	public static void main(String[] args) {
		
		int n = 10;
		
		System.out.println("The nth term of the Fibonacci Sequence is " + fib(n));
		
	}
}
