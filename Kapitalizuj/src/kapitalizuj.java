import java.util.*;

public class kapitalizuj {

	public static void main(String [] args) {
		
		
		System.out.println("Unesite ulazni red teksta: ");
		Scanner tastatura = new Scanner(System.in);
		String red = tastatura.nextLine();
		System.out.println();
		System.out.println("Sve re�i sa velikim po�etnim slovom su: ");
		System.out.println(kapitalizuj(red));
		
	}
	

	public static String kapitalizuj (String S) {
		
		String  t = "";
		boolean izvanRe�i = true;
		
		for (int i = 0; i < S.length(); i++) {
			char znak = S.charAt(i);
			if(Character.isLetter(znak)) {
				if (izvanRe�i)//po�etak re�i
					t = t + Character.toUpperCase(znak);
				else
					t = t + znak;
				izvanRe�i = false;
				
				}	else {
					t = t + znak;
				    izvanRe�i = true;
				}	
		
			
		} 
		return(t);
		
	}}
	

