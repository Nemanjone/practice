import java.util.*;

public class romb {

	public static void main(String args []) {
		
		Scanner tastatura = new Scanner(System.in);
		
		System.out.println("Unesite željeni broj redova romba: ");
		int brojRedova = tastatura.nextInt();
		int brojBlankova;
		int brojZvezdica;
		
		if (brojRedova%2 == 0) {
			brojRedova++;
		}
		
		for ( int i = 1; i <= brojRedova; i++) {
			brojBlankova = brojRedova/2 - i + 1;
			if (brojBlankova < 0)
				brojBlankova = - brojBlankova;
			brojZvezdica = 2*(brojRedova/2 - brojBlankova) + 1;
			//broj zvezdica u aktuelnom redu
			
		
			for (int j = 1; j <=brojBlankova; j++) 
				System.out.print(" ");//vodeæi blankovi u redu
			
			for(int j =1; j <= brojZvezdica; j++) 
				System.out.print("*");
				System.out.println();
		
			
		}	
	}
}
