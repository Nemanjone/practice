import java.util.Scanner;

public class Konvektor implements Pretvori {
	
	
	public  double pretvoriInèe(double inè) {
		return inè *INÈ_CENTIMETAR;			
	}
	
	public double pretvoriCentimetre(double centimetar) {
		return centimetar/CENTIMETAR_INÈ;	
	}
	
	public double pretvoriKilograme (double kilogram) {
		return kilogram/FUNTA_KILOGRAM;
	}
	
	public double pretvoriFunte(double funta) {
		return FUNTA_KILOGRAM*funta;
	}

	public static void main (String []args) {
		
		Scanner tastatura = new Scanner(System.in);
		
		Konvektor konvektor = new Konvektor();
		
		System.out.println("Unesite težinu u funtama:  ");
		double funta = tastatura.nextDouble();
		System.out.println(funta + " funti je " + konvektor.pretvoriFunte(funta) + " kilograma." );
		System.out.println();
		System.out.println("Unesite dužinu u inèima: ");
		double inè = tastatura.nextDouble();
		System.out.println("U centimetrima bi to iznosilo: ");
		System.out.printf("%5.2f cm", konvektor.pretvoriInèe(inè));
			
	}
}