import java.io.FileInputStream;
import java.util.Scanner;

public class Datoteka1 {

	public static void main (String [] args) {
		
		try {
			FileInputStream fis =  new FileInputStream("C:\\Users\\Marko\\Desktop\\Preuzimanja\\eclipse-jee-oxygen-2-win32\\eclipse\\eclipse source\\Datoteka1\\src\\Ulaz.txt");
			Scanner Tastatura = new Scanner(fis);
			
			String ime = Tastatura.nextLine();
			String prezime = Tastatura.nextLine();
			String indeks = Tastatura.nextLine();
			String kategorija = Tastatura.nextLine();
			
			Tastatura.close();
			fis.close();
			
			System.out.println("Ime je : " + ime + " " + prezime);
			System.out.println("Indeks je: " + indeks + " " + kategorija);
			
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
		
	}
	
}
