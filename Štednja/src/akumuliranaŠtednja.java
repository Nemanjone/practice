import java.util.*;

public class akumulirana�tednja {
	
	public static void main(String args[]) {
		
		double stanje;
		double kamatnaStopa;
		int period;
		
		Scanner tastatura = new Scanner (System.in);
		
		System.out.println("Unesite po�etni depozit: ");
		stanje = tastatura.nextDouble();
		System.out.println("Unesite godi�nju kamatu: ");
		kamatnaStopa = tastatura.nextDouble();
		System.out.println("Unesite broj godina izve�taja; ");
		period = tastatura.nextInt();
		
		int godina = 1;
		
		while (godina <= period) {
			
			double kamata = stanje*kamatnaStopa;
			stanje += kamatnaStopa;

			System.out.println("Stanje nakon " + godina + ".god");
			System.out.printf("%1.2f\n", stanje);
			
			godina++;
			
		}
		
		
		
	}
	

}
