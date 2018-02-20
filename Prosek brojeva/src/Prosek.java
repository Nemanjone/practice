import java.util.*;

public class Prosek {
	
	public static void main(String args[]) {
		
		double broj; //uneti broj
		double suma; //uma
		int n;       // brojac
		double prosek; // prosek
	    
		suma = 0;
		n = 0;
		
		Scanner tastatura = new Scanner (System.in);
		System.out.println("Unesite 1. broj: ");
		
		while (tastatura.hasNextDouble()) {  //Kraj ulaznog niza je CRLR+Z
			broj = tastatura.nextDouble();
			suma+=broj;
			n++;
			System.out.println("Unesite " + (n+1) + ". broj: ");
			
		}
	 
		System.out.println();
		if (n == 0) 
			System.out.println("GREŠKA: uneto je nula brojeva.");
			else {
				System.out.println("Uneto je " + n + " brojeva.");
				System.out.println();
				System.out.print("Prosek tih brojeva je: ");
				System.out.printf( "%3.2f\n", suma/n);
			}
				
				
		
			
		}
		
		
	}

	          
	

