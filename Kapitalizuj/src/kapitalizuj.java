import java.util.*;

public class kapitalizuj {

	public static void main(String [] args) {
		
		
		System.out.println("Unesite ulazni red teksta: ");
		Scanner tastatura = new Scanner(System.in);
		String red = tastatura.nextLine();
		System.out.println();
		System.out.println("Sve reèi sa velikim poèetnim slovom su: ");
		System.out.println(kapitalizuj(red));
		
	}
	

	public static String kapitalizuj (String S) {
		
		String  t = "";
		boolean izvanReèi = true;
		
		for (int i = 0; i < S.length(); i++) {
			char znak = S.charAt(i);
			if(Character.isLetter(znak)) {
				if (izvanReèi)//poèetak reèi
					t = t + Character.toUpperCase(znak);
				else
					t = t + znak;
				izvanReèi = false;
				
				}	else {
					t = t + znak;
				    izvanReèi = true;
				}	
		
			
		} 
		return(t);
		
	}}
	

