package nemanja;

import java.util.Scanner;

public class Proba2 {

	public static void main(String[] args) {
	
	Scanner tastatura = new Scanner(System.in);
	
	double[] niz = new double[10];
	
	
	
	
	for (int i = 0; i<niz.length; i++){
		System.out.print("Unesite sledeæi broj: ");
		niz [i] = tastatura.nextDouble();
					
	}
	
	double najmanji = Double.MAX_VALUE; 
	double najveci = Double.MIN_VALUE;
	
	
	for (int i = 0; i<niz.length; i++){
		if(niz[i] < najmanji) {
			najmanji = niz[i];
			
		}
		if (niz [i]> najveci) {
			najveci = niz [i];
		}
	}
	
	System.out.println("Najmanja vrednost u nizu je: " + najmanji);
	System.out.println("Najveca vrednost u nizu je: " + najveci);
}
}

