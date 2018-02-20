package pogađanjeBroja;

import java.util.*;

public class PogađanjeBroja {

	public static void main(String args[]) {
		
		int zamišljenBroj;
		int pokušanBroj;
		boolean pogodak;
		
		Scanner tastatura = new Scanner(System.in);
		
		zamišljenBroj = (int)(100*Math.random()) +1;
		pogodak = false; // mora da se inicijaluzuje
		
		System.out.println("Zamislio sam ceo broj između 1 i 100. ");
		System.out.println("Pokušaj da ga pogodiš.\n");
		
		while (!pogodak) {
			
			System.out.println("Pogodi broj> ");
			pokušanBroj = tastatura.nextInt();
			if (pokušanBroj < zamišljenBroj)
				System.out.println("Zamislio sam veći broj :-(");
			else if (pokušanBroj > zamišljenBroj)
				System.out.println("Zamislio sam manji broj :-(");
			else {
				System.out.println("Bravo, pogodio si broj :-)");
				pogodak = true;
			}
				
			
		}
		
		
	}
	
	
}
