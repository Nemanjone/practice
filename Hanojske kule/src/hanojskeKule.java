import java.util.*;

public class hanojskeKule {

	public static void main(String args[]) {
		
		int n; // broj diskova
		Scanner tastatura = new Scanner (System.in);
		System.out.println("Unesite broj diskova Hanojske kule> ");
		n = tastatura.nextInt();
		System.out.println("\nRešenje igre za " + n + " diskova je:");
		System.out.println();
		premestiDiskove(n, 'A', 'B', 'C');
	}
	
	static void premestiDiskove(int n, char a, char b, char c) {
		if (n == 1) 
			premestiDisk(a,c);
		else {
			premestiDiskove (n-1, a,c,b);
			premestiDisk(a,c);
			premestiDiskove(n-1, b, a, c);
		}
			
		
	}
	static void premestiDisk(char x, char y) {
		System.out.print("Disk na vrhu stuba " + x);
		System.out.println(" premestiti na vrh stuba " + y);
	}
}
