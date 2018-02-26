import java.util.*;

public class fibonaèijevNiz {
	
	public static void main(String args []) {
		
		System.out.println("Ovaj program raèuna traženi broj Fibonaèijevog niza.");
		System.out.println();
		System.out.println("Unesite indeks broja: ");
		
		Scanner tastatura = new Scanner(System.in);
		int n = tastatura.nextInt();
		System.out.println("Na " + n + ". mestu Fibonaèijevog niza nalazi se broj " + fib(n) + ".");
		
	}

	 static int fib(int n) {
		if (n <= 2)
			return 1;
		else
			return fib(n-1) + fib(n-2);
	}
	
	
}
