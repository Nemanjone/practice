import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.util.Scanner;

public class Datoteka {
	
	public static void main (String [] args) {
		
		Scanner Tastatura = new Scanner(System.in);
		System.out.println("Unesite neki tekstualni podatak: ");
		String tekst = Tastatura.nextLine();
		
		String imeDatoteke = "izlaz.txt";
		
		try {
			PrintWriter pw = new PrintWriter(imeDatoteke);
			pw.println("Korisnik je uneo tekst: ");
			pw.println(tekst);
			pw.flush(); //save
			pw.close();
			
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
		
	}

}
