import java.util.*;

public class najveciBrojDelilaca {

	public static void main(String args[]) {
		
		Scanner tastatura = new Scanner(System.in);
		System.out.println("Program izraèunava koji broj izmeðu broja 1 i broja koja vi unesete ima najveæi broj delilaca.");
		System.out.println("Unesite broj veæi od jedan: ");
		
		int n = tastatura.nextInt();
		
		int brojSaNBD = 1;
		int najveciBrojDelilaca = 1;// broja NBD
		int brojDelilaca = 0;// aktuelnog broja u petlji
		
		
		for (int i = 1; i <= n ; i++) {             
			brojDelilaca = 0;
			for (int j = 1; j <= i; j++) {           
				if (i % j == 0) {                    
					brojDelilaca++;                     
				}if (najveciBrojDelilaca < brojDelilaca) {
					najveciBrojDelilaca = brojDelilaca;
					brojSaNBD = i;
				}
			}
				
			} 
			System.out.println(
					"Broj sa najveæim brojem delilaca je: " + brojSaNBD);
			System.out.println("broj delilaca tog broja je " + najveciBrojDelilaca);
		
		
		
	}
	
	
	
}
