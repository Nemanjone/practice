import java.util.*;

public class najveciZajednickiDelilac {

	public static void main(String args[]) {
		Scanner tastatura = new Scanner(System.in);
		
		System.out.println("Unesite prvi broj: ");
		int x = tastatura.nextInt();
		System.out.println("Unesite drugi broj: ");
		int y = tastatura.nextInt();
		
		int d; //najve�i zajedni�ki delilac
		
		d = x < y ? x : y; 
		
		
		while ((x%d != 0) || (y%d != 0) )  {
			d =d -1;
			
		}
			System.out.println("Najve�i zajedni�ki delilac brojeva " + x +
					" i " + y + " je: " + d );
		
	} 
	
}
