import java.util.*;
import java.lang.*;
import java.util.stream.Collector.Characteristics;

public class podelaTeksta {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		System.out.println("Unesite jedan red teksta: ");
		
		Scanner tastatura = new Scanner(System.in);
		String redTeksta = tastatura.nextLine();
		
		for ( int i = 0; i < redTeksta.length(); i++) {
			char znak = redTeksta.charAt(i);
			if (Character.isLetter(znak) ) 
				System.out.print(redTeksta.charAt(i));
			else
				System.out.println();
			
			
		} 
	}

}
