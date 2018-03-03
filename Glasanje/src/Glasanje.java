import java.util.*;

public class Glasanje {

	public static void main(String []args) {
		
		Scanner tastatura = new Scanner(System.in);
		
		System.out.println("Unesite ukupan broj partija: ");
		int brojPartija = tastatura.nextInt();
		
		int [] partije = new int[brojPartija];
		
		for(;;) {
			System.out.print("Redni broj partije koja dobija glas: ");
			int p = tastatura.nextInt();
			if (p < 1 || p >brojPartija)
				break;
			else
				partije[p-1] = partije [p-1] + 1;
			
		}  System.out.println();
		
		for (int i = 0; i < partije.length; i++) {
			System.out.print("Partija pod rednim brojem " + (i+1));
			System.out.println(" ima " + partije[i] + " glasova.");
			
		}
	}
}
