
import java.util.*;

import java.util.stream.Collector.Characteristics;

public class podelaTeksta2 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		System.out.println("Unesite jedan red teksta: ");
		
		Scanner tastatura = new Scanner(System.in);
	    String redTeksta = tastatura.nextLine();
		int r = 0;//indeks po�etka jedne re�i
		boolean izvanRe�i = true;
		
		System.out.println("Sve re�i reda su: ");
		
		
		for ( int i = 0; i < redTeksta.length(); i++) {
			char znak = redTeksta.charAt(i);
			if (Character.isLetter(znak) ) {
			if (izvanRe�i) //po�etak re�i
				r = i;
			izvanRe�i = false;
			}
			else {
					if (!izvanRe�i)//kraj re�i
						System.out.println(redTeksta.substring(r, i));
					izvanRe�i = true;
			}
		}
		if(!izvanRe�i)//poslednja re�
			System.out.println(redTeksta.substring(r, redTeksta.length()));
	}
}
