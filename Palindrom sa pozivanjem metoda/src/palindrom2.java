
import java.util.Scanner;

public class palindrom2 {

	public static void main(String args[]) {
		String red;
		String re�enica; //preure�eni red
		Scanner tastatura = new Scanner(System.in);
		
		do {
			System.out.print("Unesite re�enicu (enter za kraj): ");
			red = tastatura.nextLine();
		re�enica = preuredi(red);
		
		System.out.print("Ta re�enica ");
		if (re�enica.equals(obrni(re�enica)))
			System.out.print("je ");
		else
			System.out.print("nije ");
		System.out.println("palindrom. ");
			
		}while ( red.length() != 0);
		
	}
	public static String preuredi(String niska) {
		
		String preure�enaNiska = "";
		niska = niska.toLowerCase();
		
		for (int i = 0; i < niska.length(); i++) {
			char znak = niska.charAt(i);
			if (Character.isLetter(znak))
				preure�enaNiska += znak;
			
		}return preure�enaNiska;
	}
	public static String obrni(String niska) {
		
		String obrnutaNiska = "";
		
		for (int i = niska.length() - 1; i >= 0; i--) {
			
			obrnutaNiska += niska.charAt(i);
			
			
		}
		
		return obrnutaNiska;
	}
}

