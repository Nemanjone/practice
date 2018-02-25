
import java.util.Scanner;

public class palindrom2 {

	public static void main(String args[]) {
		String red;
		String reèenica; //preureðeni red
		Scanner tastatura = new Scanner(System.in);
		
		do {
			System.out.print("Unesite reèenicu (enter za kraj): ");
			red = tastatura.nextLine();
		reèenica = preuredi(red);
		
		System.out.print("Ta reèenica ");
		if (reèenica.equals(obrni(reèenica)))
			System.out.print("je ");
		else
			System.out.print("nije ");
		System.out.println("palindrom. ");
			
		}while ( red.length() != 0);
		
	}
	public static String preuredi(String niska) {
		
		String preureðenaNiska = "";
		niska = niska.toLowerCase();
		
		for (int i = 0; i < niska.length(); i++) {
			char znak = niska.charAt(i);
			if (Character.isLetter(znak))
				preureðenaNiska += znak;
			
		}return preureðenaNiska;
	}
	public static String obrni(String niska) {
		
		String obrnutaNiska = "";
		
		for (int i = niska.length() - 1; i >= 0; i--) {
			
			obrnutaNiska += niska.charAt(i);
			
			
		}
		
		return obrnutaNiska;
	}
}

