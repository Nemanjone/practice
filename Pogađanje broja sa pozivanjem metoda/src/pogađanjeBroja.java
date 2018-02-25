import java.util.*;

public class pogađanjeBroja {

	public static void main (String args[]) {
		
		String ponovo; // indikator nastavka igre
		Scanner tastatura = new Scanner(System.in);
		
		System.out.println("Ovo je igra pogađanja broja. ");
		System.out.println("Zamisliću broj između 1 i 100,");
		System.out.println("a vi treba da ga pogodite.\n");
		
		do {
			pogodiBroj();
			System.out.println("Želite li da ponovo igrate(d/n)? ");
			ponovo = tastatura.next();
			
			
			
		}while (ponovo.equals("d"));
		System.out.println("Hvala i do viđenja...");
	}
		public static void  pogodiBroj() {
			
			int zamišljenBroj;
			int pokušanBroj;
			
			Scanner tastatura = new Scanner(System.in);
			zamišljenBroj = (int)(100*Math.random()) + 1;
			
			
			do {
				System.out.println("Pogodite broj> ");
				pokušanBroj = tastatura.nextInt();
				if(pokušanBroj < zamišljenBroj)
					System.out.println("Zamislio sam veći broj.");
				else if(pokušanBroj > zamišljenBroj)
					System.out.println("Zamislio sam manji broj.");
				else
					System.out.println("Bravo, pogodili ste broj!");
				
			}while (pokušanBroj != zamišljenBroj);
		
		
	}
}

