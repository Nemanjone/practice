import java.util.*;

public class ProstBroj {

	
	public static void main (String args[]) {
		
		int n;
		
		Scanner tastatura = new Scanner(System.in);
		
		System.out.println("Unesite ceo broj veæi od 1: ");
		n = tastatura.nextInt();
		
		int maxDelilac = (int)Math.sqrt(n); // najveæi delilac
		
		for (int k = 2; k <= maxDelilac; k++) {
			
			if (n%k == 0) {
				
				System.out.println("Taj broj nije prost.");
				System.out.println("Njegov delilac je " + k + ".");
			}
			else System.out.println("Taj broj je prost.");
			
		}
		
	}
	
}
