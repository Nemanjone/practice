import java.util.*;

public class Niz {
	
	public static void main (String []args) {
		
		Scanner t = new Scanner(System.in);
		
		double[] niz = new double[10];
	
		
		for ( int i = 0; i < niz.length; i++){
			System.out.println(" Unesite slede�i broj:" );
			niz[i] =  t.nextDouble();
		}

		double najmanji = Double.MAX_VALUE;
		double najve�i= Double.MIN_VALUE;
		
		for ( int i = 0; i < niz.length; i++) {
			if ( niz[i]< najmanji) {
				najmanji = niz[i];
				
			}
			if (niz[i]>najve�i) {
				najve�i = niz[i];
			}
			
		}
		System.out.println();
		System.out.println(" Najmanja vrednost: " + najmanji);
		System.out.println("Najve�a vrednost: " + najve�i);
		
	}

}
