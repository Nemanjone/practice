import java.util.*;

public class poga�anjeBroja {

	public static void main (String args[]) {
		
		String ponovo; // indikator nastavka igre
		Scanner tastatura = new Scanner(System.in);
		
		System.out.println("Ovo je igra poga�anja broja. ");
		System.out.println("Zamisli�u broj izme�u 1 i 100,");
		System.out.println("a vi treba da ga pogodite.\n");
		
		do {
			pogodiBroj();
			System.out.println("�elite li da ponovo igrate(d/n)? ");
			ponovo = tastatura.next();
			
			
			
		}while (ponovo.equals("d"));
		System.out.println("Hvala i do vi�enja...");
	}
		public static void  pogodiBroj() {
			
			int zami�ljenBroj;
			int poku�anBroj;
			
			Scanner tastatura = new Scanner(System.in);
			zami�ljenBroj = (int)(100*Math.random()) + 1;
			
			
			do {
				System.out.println("Pogodite broj> ");
				poku�anBroj = tastatura.nextInt();
				if(poku�anBroj < zami�ljenBroj)
					System.out.println("Zamislio sam ve�i broj.");
				else if(poku�anBroj > zami�ljenBroj)
					System.out.println("Zamislio sam manji broj.");
				else
					System.out.println("Bravo, pogodili ste broj!");
				
			}while (poku�anBroj != zami�ljenBroj);
		
		
	}
}

