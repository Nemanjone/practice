import java.util.*;

public class Poga�anjeBroja {

	static int brojPogodaka;
	final static int MAX_POKU�AJA = 5;
	static Scanner tastatura = new Scanner(System.in);
	
	public static void main (String   args []) {
	
      String ponovo;
      System.out.println("Ovo je igra poga�anja broja.");
      System.out.println("Ja �u zamisliti broj izme�u 1 i 100, ");
      System.out.println("a vi treba da ga pogodite iz ");
      System.out.println(MAX_POKU�AJA + " puta.\n" );
      
      do {
    	  pogodiBroj();
    	  System.out.println("�elite li ponovo da igrate? (da/ne)?");
    	  ponovo = tastatura.next();
      } while (ponovo.equals("da"));
      
      System.out.print("Pogodili ste ");
      if (brojPogodaka ==1)
    	  System.out.println("jedanput.");
      else
    	  System.out.println(brojPogodaka + " puta.");
      System.out.println("Hvala i do vi�enja.");
     }
 
	public static void pogodiBroj() {
		
		int zami�ljenBroj;
		int poku�anBroj;
		int brojPoku�aja;
		
		zami�ljenBroj = (int)(100*Math.random() + 1);
		brojPoku�aja = 0;
		
		for (;;) { //beskona�na petlja!
			System.out.print("Pogodite broj> ");
			poku�anBroj = tastatura.nextInt();
			brojPoku�aja++;
			
			if (poku�anBroj == zami�ljenBroj) {
				System.out.println("Bravo, pogodili ste broj!");
				brojPogodaka++;
				break;
			}
			else if (brojPoku�aja == MAX_POKU�AJA) {
				System.out.print("Niste pogodli broj iz ");
				System.out.println(MAX_POKU�AJA + " puta.");
				System.out.print("Zamislio sam broj ");
				System.out.println(zami�ljenBroj);
				break;	
			}
			else if (poku�anBroj < zami�ljenBroj)
				System.out.println("Zamislio sam ve�i broj.");
			else if(poku�anBroj > zami�ljenBroj)
				System.out.println("Zamislio sam manji broj.");
			else {
				System.out.println("Ovaj slu�aj nije mogu�."); //ovo se nikada ne�e dogoditi
			}
		}
		
	}
	
	
}
