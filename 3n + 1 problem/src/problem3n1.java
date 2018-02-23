import java.util.*;

public class problem3n1 {

	public static void main(String args[]) {
		
		Scanner tastatura = new Scanner(System.in);
		
		System.out.println("Unesite celi broj: ");
		
		int n = tastatura.nextInt();
		System.out.print("Niz brojeva je: ");
		do {  
			if (n%2 == 0) {
				n = n/2;
		
			} else {
				n = 3*n +1;
			}
			
			System.out.printf("%4d",n);
			
		} while (n != 1);
		
		
	}
	
	
}
