import java.util.*;

public class palindrom1 {

	public static void main(String args[]) {
		String red;
		String rečenica; //preurešeni red
		Scanner tastatura = new Scanner(System.in);
		
		do {
			System.out.print("Unesite rečenicu (enter za kraj): ");
			red = tastatura.nextLine();
		rečenica = preuredi(red);
		
		System.out.print("Ta rečenica ");
		if (rečenica.equals(obrni(rečenica)))
			System.out.print("je ");
		else
			System.out.print("nije ");
		System.out.println("palindrom. ");
			
		}while ( red.length() != 0);
		
	}
	public static String preuredi(String niska) {
		
		String preurešenaNiska = "";
		niska = niska.toLowerCase();
		
		for (int i = 0; i < niska.length(); i++) {
			char znak = niska.charAt(i);
			if (Character.isLetter(znak))
				preurešenaNiska += znak;
			
		}return preurešenaNiska;
	}
	public static String obrni(String niska) {
		
		String obrnutaNiska = "";
		
		for (int i = niska.length() - 1; i >= 0; i--) {
			
			obrnutaNiska += niska.charAt(i);
			
			
		}
		
		return obrnutaNiska;
	}
}
