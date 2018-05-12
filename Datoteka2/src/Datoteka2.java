
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Datoteka2 {

	public static void main (String [] args)  {
		
		List<Pravougaonik> pravougaonici = new ArrayList<>();
		
		try {
			FileInputStream fis = new FileInputStream("C:\\Users\\Marko\\git\\vezbe\\Datoteka2\\pravougaonici.txt");
			
			Scanner tastatura = new Scanner(fis);
			tastatura.locale();
			
		while(tastatura.hasNext()) {
				
			double a = tastatura.nextDouble();
			double b = tastatura.nextDouble();
			tastatura.nextLine();
			
			Pravougaonik p = new Pravougaonik(a, b);
			
			pravougaonici.add(p);
			
			}
			
				
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}
		
		for (Pravougaonik p : pravougaonici)	{
				System.out.println(p);
				System.out.println("Površina i obim su: " + p.getPovršina() + " i " + p.getObim());
				}
	
		
		

	}
	
}

