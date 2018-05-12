import java.io.File;
import java.util.Scanner;

public class ListaDir {

	public static void main (String [] args) {
		
		String imeDir;
		Scanner tastatura;
		File dir;
		String []  datoteke;
		tastatura = new Scanner(System.in);
		
		System.out.print("Unesite ime direktorijuma: ");
		imeDir = tastatura.nextLine().trim();
		
		dir = new File (imeDir);
		
		if (!dir.exists())
			System.out.println("Takav direktorijum ne postoji!");
		else if (!dir.isDirectory())
			System.out.println("To nije direktorijum!");
		else {
			datoteke = dir.list();
			System.out.print("Datoteke u direktorijumu \"");
			System.out.println(dir + "\" su:");
			for (int i = 0; i < dir.length(); i++)
				System.out.println("  " + datoteke[i]);
			
		}
			
			
			
		
		
	}
	
}
