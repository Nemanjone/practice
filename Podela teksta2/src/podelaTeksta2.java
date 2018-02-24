
import java.util.*;

import java.util.stream.Collector.Characteristics;

public class podelaTeksta2 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		System.out.println("Unesite jedan red teksta: ");
		
		Scanner tastatura = new Scanner(System.in);
	    String redTeksta = tastatura.nextLine();
		int r = 0;//indeks poèetka jedne reèi
		boolean izvanReèi = true;
		
		System.out.println("Sve reèi reda su: ");
		
		
		for ( int i = 0; i < redTeksta.length(); i++) {
			char znak = redTeksta.charAt(i);
			if (Character.isLetter(znak) ) {
			if (izvanReèi) //poèetak reèi
				r = i;
			izvanReèi = false;
			}
			else {
					if (!izvanReèi)//kraj reèi
						System.out.println(redTeksta.substring(r, i));
					izvanReèi = true;
			}
		}
		if(!izvanReèi)//poslednja reè
			System.out.println(redTeksta.substring(r, redTeksta.length()));
	}
}
