package poga�anjeBroja;

import java.util.*;

public class Poga�anjeBroja {

	public static void main(String args[]) {
		
		int zami�ljenBroj;
		int poku�anBroj;
		boolean pogodak;
		
		Scanner tastatura = new Scanner(System.in);
		
		zami�ljenBroj = (int)(100*Math.random()) +1;
		pogodak = false; // mora da se inicijaluzuje
		
		System.out.println("Zamislio sam ceo broj izme�u 1 i 100. ");
		System.out.println("Poku�aj da ga pogodi�.\n");
		
		while (!pogodak) {
			
			System.out.println("Pogodi broj> ");
			poku�anBroj = tastatura.nextInt();
			if (poku�anBroj < zami�ljenBroj)
				System.out.println("Zamislio sam ve�i broj :-(");
			else if (poku�anBroj > zami�ljenBroj)
				System.out.println("Zamislio sam manji broj :-(");
			else {
				System.out.println("Bravo, pogodio si broj :-)");
				pogodak = true;
			}
				
			
		}
		
		
	}
	
	
}
