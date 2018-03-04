import java.util.*;

public class heksSistem {
	
	public static void main (String args []) {

	final String HEKS_CIFRE = "0123456789aAbBcCdDeEfF";
	
	Scanner tastatura = new Scanner(System.in);
	System.out.println("Unesite heksadekadni broj: ");
	String h = tastatura.nextLine();
	
	for (int i = 0; i < h.length(); i++) {
		if (HEKS_CIFRE.indexOf(h.charAt(i)) == -1) {
			System.out.println("Greška! Uneti broj nije heksadekadni!");
			System.exit(-1);
		}
		
	}
	System.out.println("Njegova dekadna vrednost je " + heksBroj(h) + ".");
	}
	
	private static int heksVrednost(char z) {
		
		switch (z){
		
		case '0': return 0;
		case '1': return 1;
		case '2': return 2;
		case '3': return 3;
		case '4': return 4;
		case '5': return 5;
		case '6': return 6;
		case '7': return 7;
		case '8': return 8;
		case '9': return 9;
		case 'a': case 'A' :return 10;
		case 'b': case 'B': return 11;
		case 'c': case 'C': return 12;
		case 'd': case 'D': return 13;
		case 'e': case 'E': return 14;
		case 'f': case 'F':   return 15;
		default:return -1;	
	}
	
}	
	public static long heksBroj(String s) {
		
		long d = 0;
		for(int i = 0; i < s.length(); i++)
			d = d  * 16 + heksVrednost(s.charAt(i));
		return d;
		
		}
	
}
