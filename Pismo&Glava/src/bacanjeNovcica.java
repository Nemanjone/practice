import java.util.*;
public class bacanjeNovcica {

	public static void main(String []args) {
		
		
		int brojBacanja;
		Brojac brojacPisama = new Brojac();
		Brojac brojGlava = new Brojac();
		
		System.out.println("Unesite broj bacanja: ");
		Scanner tastatura = new Scanner(System.in);
		brojBacanja = tastatura.nextInt();
		
		while (brojBacanja>0) {
			brojacPisama.reset();
			brojGlava.reset();
		for (int i =0; i < brojBacanja;i++) {
		    if (Math.random() > 0.5)
		    	brojacPisama.uvecaj();
		    else brojGlava.uvecaj();
		}
		System.out.println("Broj pisma: " + brojacPisama.getBroj());
		System.out.println("Broj glava: " + brojGlava.getBroj());
		System.out.println("Unesite broj bacanja: ");
		brojBacanja = tastatura.nextInt();
	}
	}
}

class Brojac {
	
	private int broj;
	
	public  void uvecaj() {
		broj++;
	}
	public  void reset() {
		broj = 0;
	}
	public int getBroj() {
		return broj;
	}
}