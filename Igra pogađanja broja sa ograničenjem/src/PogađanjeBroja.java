import java.util.*;

public class PogaðanjeBroja {

	static int brojPogodaka;
	final static int MAX_POKUŠAJA = 5;
	static Scanner tastatura = new Scanner(System.in);
	
	public static void main (String   args []) {
	
      String ponovo;
      System.out.println("Ovo je igra pogaðanja broja.");
      System.out.println("Ja æu zamisliti broj izmeðu 1 i 100, ");
      System.out.println("a vi treba da ga pogodite iz ");
      System.out.println(MAX_POKUŠAJA + " puta.\n" );
      
      do {
    	  pogodiBroj();
    	  System.out.println("Želite li ponovo da igrate? (da/ne)?");
    	  ponovo = tastatura.next();
      } while (ponovo.equals("da"));
      
      System.out.print("Pogodili ste ");
      if (brojPogodaka ==1)
    	  System.out.println("jedanput.");
      else
    	  System.out.println(brojPogodaka + " puta.");
      System.out.println("Hvala i do viðenja.");
     }
 
	public static void pogodiBroj() {
		
		int zamišljenBroj;
		int pokušanBroj;
		int brojPokušaja;
		
		zamišljenBroj = (int)(100*Math.random() + 1);
		brojPokušaja = 0;
		
		for (;;) { //beskonaèna petlja!
			System.out.print("Pogodite broj> ");
			pokušanBroj = tastatura.nextInt();
			brojPokušaja++;
			
			if (pokušanBroj == zamišljenBroj) {
				System.out.println("Bravo, pogodili ste broj!");
				brojPogodaka++;
				break;
			}
			else if (brojPokušaja == MAX_POKUŠAJA) {
				System.out.print("Niste pogodli broj iz ");
				System.out.println(MAX_POKUŠAJA + " puta.");
				System.out.print("Zamislio sam broj ");
				System.out.println(zamišljenBroj);
				break;	
			}
			else if (pokušanBroj < zamišljenBroj)
				System.out.println("Zamislio sam veæi broj.");
			else if(pokušanBroj > zamišljenBroj)
				System.out.println("Zamislio sam manji broj.");
			else {
				System.out.println("Ovaj sluèaj nije moguæ."); //ovo se nikada neæe dogoditi
			}
		}
		
	}
	
	
}
