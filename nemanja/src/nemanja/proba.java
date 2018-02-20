package nemanja;

import java.util.Scanner;

public class proba {
	
	public static void main(String [] args) {

	double kateta1, kateta2, hipotenuza;//strane trougla
	long pocetnoVreme; //poèetak izvršavanja, milisekunde
	long zavrsnoVreme;//poèetak izvršavanja, milisekunde
	double protekloVreme; // razlika vremena, nilisekunde
	
	pocetnoVreme = System.currentTimeMillis();
	
	Scanner tastatura = new Scanner(System.in);
	System.out.print("Sistem raèuna hipotenuzu trougla");
	System.out.println(" za unete katete.");
	System.out.println();
	
	System.out.println("Unesite dužinu prve katete: ");
	kateta1 = tastatura.nextDouble();
	System.out.println("Unesite dužinu druge katete: ");
	kateta2 = tastatura.nextDouble();
	
	hipotenuza = Math.sqrt(kateta1*kateta1 + kateta2*kateta2); // formula za hipotenuzu
		
	System.out.print("Hipotenuza pravouglog trougla sa");
	System.out.print(" katetama " +kateta1 + "i " + kateta2);
	System.out.println("je: ");
	System.out.printf("%8.2f\n", hipotenuza);
	
	zavrsnoVreme = System.currentTimeMillis();
	
	protekloVreme = (zavrsnoVreme - pocetnoVreme)/1000.0;
	
	System.out.println();
	
	System.out.print("Vreme potrebno za izvršavanje programa ");
    System.out.println("je: " + protekloVreme + " sekundi");	
	
	
	}
}
