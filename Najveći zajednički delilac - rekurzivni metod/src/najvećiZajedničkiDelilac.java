import java.util.*;

public class najveæiZajednièkiDelilac {

	public static void main(String args[]) {
		Scanner tastatura = new Scanner(System.in);
		
		System.out.println("Unesite prvi broj: ");
		int x = tastatura.nextInt();
		System.out.println("Unesite drugi broj: ");
		int y = tastatura.nextInt();
		
		System.out.println("Najveæi zajednièki delilac broja " 
		+ x + " i broja " + y + " je " + nzd(x,y) + ".");
		
	    if ( y >= x ) {
	    	int a;
	    	a = y;
	    	y = x;
	    	x = a;
	    } 
		}
	
	static int nzd (int x, int y) {
		
		if (x % y == 0)
			return y;
		else
			return nzd(y, x % y);
	}
}