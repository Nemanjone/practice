import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;

public class KopiranjeDatoteke {

	public static void main (String [] args) {
		
		String imeOriginala;
		String ImeKopije;
		InputStream original;
		OutputStream kopija;
		
		boolean uvek = false;
		int brojbajtova;
		
		if ( args.length == 3 && args[0].equalsIgnoreCase("-u")) {
			imeOriginala = args[1];
			ImeKopije = args[2];
			uvek = true;
		}
		else if (args.length == 2) {
			imeOriginala = args[0];
			ImeKopije = args[1];
			
		}
		else {
			System.out.println("Upotreba: java KopiranjeDatoteke <original> <kopija>");
			System.out.println(" ili java KopiranjeDatoteke -u <original> <kopija>");
			return;
		}
		try {
			original = new FileInputStream(imeOriginala);	
		}
		catch (FileNotFoundException e) {
			System.out.print("Ulazna datoteka \"" + imeOriginala);
			System.out.println("\" ne postoji.");
			return;
		}
		
		File datoteka = new File (ImeKopije);
		if (datoteka.exists() && uvek == false) {
			System.out.print("Izlazna datoteka veæ postoji.");
			System.out.println("Koristite opciju -u za njenu zamenu.");
			return;
		}
		try {
			kopija = new FileOutputStream(ImeKopije);	
		}
		catch (IOException e) {
			System.out.print("Izlazna datoteka \"" + ImeKopije);
			System.out.println("\" ne može se otvoriti");
			return;
		}
		
		brojbajtova = 0;
		
		try {
			int b = original.read();
			while ( b >= 0) {
				kopija.write(b);
				brojbajtova++;
				b = original.read();
			}
			
			System.out.println("Kopiranje završeno: kopirano " + brojbajtova + "bajtova");
			
		}
		catch (Exception e) {
			System.out.println("Neuspešno kopiraje: kopirano " + brojbajtova + " bajtova");
			System.out.println("Greška. " + e);
		}
		
	   finally {
		   try {
			   original.close();
			   kopija.close();
		   }
		   catch (IOException e) {}
	   }
			
	}
}
