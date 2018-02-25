import java.util.*;

public class prostBroj {

	public static void main(String args[]) {
		
		int n;
		
		System.out.println("Ovaj program odredjuje da li je dati broj prost.");
		
		Scanner tastatura = new Scanner(System.in);
		
		while(true) {
			System.out.println("Unesite broj veci od 1 ( nula za kraj): ");
			n = tastatura.nextInt();
			if (n ==0 )
				break;
			System.out.print("Taj broj ");
			if(jeProst(n))
				System.out.print( "je ");
			else
				System.out.print("nije");
			    System.out.println("prost.");
			}		
	}
	
	public static boolean jeProst(int n) {
		
		int maxDelilac = (int)Math.sqrt(n);
		for (int k = 2; k <= maxDelilac; k++) {
			if (n % k == 0 )
				return false;
		}
		return true;
		
		
	}
}
