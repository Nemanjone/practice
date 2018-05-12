import java.util.Scanner;

public class Konvektor implements Pretvori {
	
	
	public  double pretvoriIn�e(double in�) {
		return in� *IN�_CENTIMETAR;			
	}
	
	public double pretvoriCentimetre(double centimetar) {
		return centimetar/CENTIMETAR_IN�;	
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
		
		System.out.println("Unesite te�inu u funtama:  ");
		double funta = tastatura.nextDouble();
		System.out.println(funta + " funti je " + konvektor.pretvoriFunte(funta) + " kilograma." );
		System.out.println();
		System.out.println("Unesite du�inu u in�ima: ");
		double in� = tastatura.nextDouble();
		System.out.println("U centimetrima bi to iznosilo: ");
		System.out.printf("%5.2f cm", konvektor.pretvoriIn�e(in�));
			
	}
}