
import java.util.*;

public class problem3n1 {

	public static  void main(String args[]) {
		
		Scanner tastatura = new Scanner(System.in);
		
		System.out.println("Unesite celi broj: ");
		int n = tastatura.nextInt();
		triN1(n);
	}
		
	public	static void triN1 (int N) {  
		System.out.println();
		
		
       while (N != 1) {  
			if (N%2 == 0) 
				N = N/2;
		 else 
				N = 3*N +1;
			System.out.printf("%4d", N);;
		}
	
	 
		
	}
}