import java.util.*;

public class fibona�ijevNiz {
	
	public static void main(String args []) {
		
		System.out.println("Ovaj program ra�una tra�eni broj Fibona�ijevog niza.");
		System.out.println();
		System.out.println("Unesite indeks broja: ");
		
		Scanner tastatura = new Scanner(System.in);
		int n = tastatura.nextInt();
		System.out.println("Na " + n + ". mestu Fibona�ijevog niza nalazi se broj " + fib(n) + ".");
		
	}

	 static int fib(int n) {
		if (n <= 2)
			return 1;
		else
			return fib(n-1) + fib(n-2);
	}
	
	
}
