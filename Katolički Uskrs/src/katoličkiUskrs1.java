import java.util.*;

public class katoličkiUskrs1 {
	
	public static void main(String args[]) {
		
		Scanner tastatura = new Scanner(System.in);
		
		System.out.println("Unesite godinu između 1982 i 2048: ");
		
		int god = tastatura.nextInt();
		
		int a = god%19;
		int b = god%4;
		int c = god%7;
		int d = (19*a + 24)%30;
		int e = (2*b + 4*c + 6*d + 5)%7;
		
		
		int f = (22 + d + e);
		int f1 = (22 + d + e - 31);
		
		if ( god == 1954 ||   god == 1981 || god == 2049 || god == 2076)  {
			
		if ( f < 31 ) {
		    System.out.println("Uskrs godine "+ god + "." + " pada " + (f -7) + "." + "3.");
		}else {
			System.out.println("Uskrs godine " + god + "." + " pada " + (f1-7) + "." + "4.");
		}
		}
		else if ( f < 31 ) {
		    System.out.println("Uskrs godine "+ god + "." + " pada " + f + "." + "3.");
		}else {
			System.out.println("Uskrs godine " + god + "." + " pada " + f1 + "." + "4.");
		}
		
	}

}
