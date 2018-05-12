import java.util.*;

public class Niz1 {
	
	public enum Poredak{ RASTUÆI, OPADAJUÆI};
	
	public static void sortirajNiz (double[] niz, Poredak p) {
		for ( int a = 0; a < niz.length; a++){
			for ( int i = 0; i < niz.length; i++) {
			if ( p == Poredak.RASTUÆI) {
				if (niz[i] > niz[i+1]) {
					double privremeno = niz[i];
					niz[i] = niz[i+1];
					niz[i +1] = privremeno;
				  }
				}else if
			     ( p == Poredak.OPADAJUÆI) {
				   if (niz[i] < niz[i+1]) {
					double privremeno = niz[i];
					niz[i] = niz[i+1];
					niz[i +1] = privremeno;
				   }
				}   
			}
		}	
		
	}
	public static void main (String []args) {
		
		Scanner t = new Scanner(System.in);
		
		double[] niz = {3.6,7.8,1.5};
		System.out.println("Niz je bio: " + Arrays.toString(niz));
		sortirajNiz(niz,Poredak.RASTUÆI);

		System.out.println(" Niz je sada: " + Arrays.toString(niz));
			
	}
}

