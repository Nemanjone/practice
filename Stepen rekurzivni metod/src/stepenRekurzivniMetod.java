import java.util.*;

public class stepenRekurzivniMetod {
	
	public static void main (String args[]) {
		
		Scanner tastatura = new Scanner(System.in);
		System.out.println("Unesite realan broj: ");
		double x = tastatura.nextDouble();
		System.out.println("Unesite ceo broj veæi od jedan: ");
		int n = tastatura.nextInt();
		System.out.println("Broj " + x + " na " + n + " je " + stepen (x,n) + ".");
		
	}

	static double  stepen (double x, int n) {
		if (n == 0)
			return 1;
		else 
			return x*stepen(x,n-1);
		
	}
	
	
}
