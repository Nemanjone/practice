import java.util.*;

public class Niz {
	
	public static void main (String []args) {
		
		Scanner t = new Scanner(System.in);
		
		double[] niz = new double[10];
	
		
		for ( int i = 0; i < niz.length; i++){
			System.out.println(" Unesite sledeæi broj:" );
			niz[i] =  t.nextDouble();
		}

		double najmanji = Double.MAX_VALUE;
		double najveæi= Double.MIN_VALUE;
		
		for ( int i = 0; i < niz.length; i++) {
			if ( niz[i]< najmanji) {
				najmanji = niz[i];
				
			}
			if (niz[i]>najveæi) {
				najveæi = niz[i];
			}
			
		}
		System.out.println();
		System.out.println(" Najmanja vrednost: " + najmanji);
		System.out.println("Najveæa vrednost: " + najveæi);
		
	}

}
