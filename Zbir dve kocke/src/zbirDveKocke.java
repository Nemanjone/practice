import java.util.*;

public class zbirDveKocke {
	
	public static void main(String [] args) {
		
		System.out.println("Zbir dve kocke       " +
				"Proseèan broj bacanja");
				System.out.println();
				
		for (int i=2; i < 13;i++ ) {
			prosekZaZbir(i);
		System.out.printf("%7d %25.2f\n", i, prosekZaZbir(i));
		}
	}
	
	public static double prosekZaZbir(int zbirBacanja) {
		int ukupnoBacanja = 0;
		for (int i = 0; i < 1001; i++) 
		   ukupnoBacanja = ukupnoBacanja +  baciZaZbir(zbirBacanja);
		   double proseèanBrojBacanja = (double)ukupnoBacanja/1000;
		   return proseèanBrojBacanja;	
	}
	
public	static int baciZaZbir( int zbirBacanja ) {

		int brojBacanja = 0;
		int prvaKocka;
		int drugaKocka;
		
		do {
			prvaKocka = (int)(6*Math.random()+1);
			drugaKocka = (int)(6*Math.random()+1);
		    brojBacanja++;	
		} while ((prvaKocka + drugaKocka) != zbirBacanja);
		return brojBacanja;
	}
	
}
