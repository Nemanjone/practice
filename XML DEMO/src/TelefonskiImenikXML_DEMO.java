import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Map;
import java.util.Scanner;
import java.util.TreeMap;
import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import org.w3c.dom.*;

public class TelefonskiImenikXML_DEMO {

	private static String DATA_FILE_NAME = ".telefonskiImenik_XML_DEMO";

	public static void main(String[] args) {

		String broj, ime;

		TreeMap<String, String> telefonskiImenik;
		telefonskiImenik = new TreeMap<String, String>();

		File maticniDirektorijum = new File(System.getProperty("user.home"));
		File datoteka = new File(maticniDirektorijum, DATA_FILE_NAME);

		if(!datoteka.exists()) {
			System.out.println("Telefonski imenik nije nadjen.");
			System.out.println("Bice kreiran novi, ako unesete podatke.");
			System.out.println("Datoteka: " + datoteka.getAbsolutePath());
		}
		else {
			System.out.println("Ucitavam telefonski imenik..." );
			try {
				DocumentBuilder dokumentCitac = 
						DocumentBuilderFactory.newInstance().newDocumentBuilder();
				org.w3c.dom.Document xmlDokument = dokumentCitac.parse(datoteka);
				org.w3c.dom.Element koren = xmlDokument.getDocumentElement();
				if (!koren.getTagName().equals("telefonskiImenik"))
					throw new Exception();
				NodeList nodes = koren.getChildNodes();
				for (int i = 0; i < nodes.getLength(); i++) {
					if (nodes.item(i) instanceof org.w3c.dom.Element) {
						org.w3c.dom.Element ulaz = (org.w3c.dom.Element) nodes.item(i);
						if (! ulaz.getTagName().equals("ulaz"))
							throw new Exception();
						String ulazIme = ulaz.getAttribute("ime");
						String ulazBroj = ulaz.getAttribute("broj");
						if (ulazIme.length() == 0 || ulazBroj.length() == 0)
							throw new Exception();
						telefonskiImenik.put(ulazIme, ulazBroj);
					}

				}

			}
			catch (Exception e) {
				System.out.println("Greska prilikom ucitavanja podataka iz telefonskog imenika.");
				System.out.println("Ime datoteke: " + datoteka.getAbsolutePath());
				System.out.println("Program prekida rad.");
				System.exit(-1);
			} 

		}

		Scanner tastatura = new Scanner(System.in);
		boolean promena = false;

		glavnaPetlja: while (true) {
			System.out.println("\n Izaberite jednu od ponudjenih opcija: ");
			System.out.println("   1. Nadji broj telefona.");
			System.out.println("   2. Dodaj ili promeni telefonski broj.");
			System.out.println("   3. Izbrisi kontakt iz imenika.");
			System.out.println("   4. Prikazi sadrzaj imenika.");
			System.out.println("   5. Izadji iz programa.");
			System.out.println("Unesite broj izabrane opcije(1-5): ");

			int brojOopcije;
			if (tastatura.hasNextInt()) {
				brojOopcije = tastatura.nextInt();
				tastatura.nextLine();
			}
			else {
				System.out.println("\nNEDOZVOLJEN UNOS. MORATE UNETI BROJ.");
				tastatura.nextLine();
				continue;
			}
			switch (brojOopcije) {
			case 1:
				System.out.print("\nUnesite ime osobe ciji broj trazite: ");
				ime = tastatura.nextLine().trim().toLowerCase();
				broj = telefonskiImenik.get(ime);
				if (broj == null)
					System.out.println("\nNIJEDAN BROJ NIJE NADJEN ZA IME: " + ime);
				else
					System.out.println("\nBROJ ZA KONTAKT " + ime + ": " + broj);
				break;
			case 2:
				System.out.print("\n Unesite ime: ");
				ime = tastatura.nextLine().trim().toLowerCase();
				if (ime.length() == 0)
					System.out.println("\n IME NE MOZE BITI PRAZAN UNOS.");
				else if (ime.indexOf('%') >= 0)
					System.out.println("\n IME NE SME DA SADRZI KARAKTER \"%\".");
				else {
					System.out.print("Unesite broj telefona: ");
					broj = tastatura.nextLine().trim();
					if (broj.length() == 0)
						System.out.println("\nBROJ NE MOZE DA BUDE PRAZAN UNOS.");
					else {
						telefonskiImenik.put(ime, broj);
						promena = true;
					}
				}
				break;
			case 3:
				System.out.print("\nUnesite ime koje zelite da uklonite: ");
				ime = tastatura.nextLine().trim().toLowerCase();
				broj = telefonskiImenik.get(ime);
				if (broj == null)
					System.out.println("\nNIJEDAN BROJ NIJE NADJEN ZA IME: " + ime);
				else {
					telefonskiImenik.remove(ime);
					promena = true;
					System.out.println("\nUKLONJENI PODACI ZA IME " + ime);
				}
				break;
			case 4:
				System.out.println("\nLISTA KONTAKATA U VASEM IMENIKU:\n ");
				for ( Map.Entry<String, String> unos : telefonskiImenik.entrySet()) {
					System.out.println("   " + unos.getKey() + ": " + unos.getValue());
					break;	
				}
			case 5:
				System.out.println("\n Izlaz iz programa.");
				break glavnaPetlja;
			default:
				System.out.println("\n Nedozvoljena opcija!");
			}
		}

		if (promena) {
			System.out.println("Sacuvacemo izmene u imeniku u datoteci " +
					datoteka.getAbsolutePath() + "...");
			PrintWriter izlaz;
			try {
				izlaz = new PrintWriter(new FileWriter(datoteka));
			}
			catch (IOException e) {
				System.out.println("Greska: Datoteka za unos ne moze da se otvori:");
				return;
			}
			System.out.println("<?xml verzija =\"1.0\"?>");
			System.out.println("<telefonski imenik>");
			for (Map.Entry<String , String> ulaz : telefonskiImenik.entrySet()) {
				System.out.print(" <ulaz ime = '");
				System.out.printf("%-10s",ulaz.getKey());
				System.out.print("' broj =' ");
				System.out.print(ulaz.getValue());
				System.out.println("'/>");
			}
			System.out.println("<telefonski imenik>");
			System.out.close();
			if (System.out.checkError())
				System.out.println("Greska prilikom upisivanja datoteke!");
			else
				System.out.println("Sacuvano.");
			
			izlaz.close();
			tastatura.close();
		}

	}

}
