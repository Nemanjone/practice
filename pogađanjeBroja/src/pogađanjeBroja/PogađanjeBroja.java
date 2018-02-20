package pogaðanjeBroja;

import java.util.*;

public class PogaðanjeBroja {

	public static void main(String args[]) {
		
		int zamišljenBroj;
		int pokušanBroj;
		boolean pogodak;
		
		Scanner tastatura = new Scanner(System.in);
		
		zamišljenBroj = (int)(100*Math.random()) +1;
		pogodak = false; // mora da se inicijaluzuje
		
		System.out.println("Zamislio sam ceo broj izmeðu 1 i 100. ");
		System.out.println("Pokušaj da ga pogodiš.\n");
		
		while (!pogodak) {
			
			System.out.println("Pogodi broj> ");
			pokušanBroj = tastatura.nextInt();
			if (pokušanBroj < zamišljenBroj)
				System.out.println("Zamislio sam veæi broj :-(");
			else if (pokušanBroj > zamišljenBroj)
				System.out.println("Zamislio sam manji broj :-(");
			else {
				System.out.println("Bravo, pogodio si broj :-)");
				pogodak = true;
			}
				
			
		}
		
		
	}
	
	
}
