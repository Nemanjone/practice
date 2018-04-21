
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.HashMap;
import java.util.Scanner;

public class NBA  {           


	public static HashMap<String, Igrac> ucitajIgraca(String imeDatoteke) {

		HashMap<String, Igrac> mapa = new HashMap<String, Igrac>();

		try {

			FileInputStream fis = new FileInputStream(imeDatoteke);
			Scanner tastatura = new Scanner(fis);


			while (tastatura.hasNextLine()) {

				String red = tastatura.nextLine();

				if (red.startsWith("name")) {	         
				}
				else  {
					String igracPodaci = red ;

					String [] deo = igracPodaci.split(",");

					String ime = deo[0];
					String poeni = deo[1]; 
					String skokovi = deo [2];
					String asistencije = deo [3];
					String ukradeneLopte = deo [4];
					String blokade = deo [5];

					Igrac igrac = new Igrac(poeni, skokovi, asistencije, ukradeneLopte, blokade);

					mapa.put(ime, igrac);

				}	
			}


			tastatura.close();
			try {
				fis.close();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}

		catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		return mapa;

	}


	public  static void sacuvajIgraca(HashMap<String, Igrac> mapa, String imeDatoteke) {

		try {

			PrintWriter pw = new PrintWriter(imeDatoteke);
			pw.println(mapa);
			pw.flush();
			pw.close();
		}
		catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}


	public static void main(String[] args) {



		HashMap<String, Igrac> mapa = ucitajIgraca("C:\\Users\\Marko\\Desktop\\srpski_igraci_nba_2017_18 (1).csv");


		Scanner tastatura = new Scanner(System.in);

		System.out.println("Statistika: ");
		System.out.println();


		for (String kljuc : mapa.keySet()) {
			Igrac vrednost = mapa.get(kljuc);
			System.out.println(kljuc + " " + vrednost);                           
		}

		System.out.println();

		System.out.println("Unesite ime igraca koji Vas zanima: ");

		String imeIgraca = tastatura.nextLine();

		for (String kljuc : mapa.keySet()) {
			if (imeIgraca.equalsIgnoreCase(kljuc)) {
				Igrac vrednost = mapa.get(kljuc);
				System.out.println("Statistika: " + kljuc + " " + vrednost);
			}
		}

		System.out.println();

		System.out.println("Unesite ime igraca i kategoriju koja Vas zanima: ");

		String podatak = tastatura.nextLine();
		String [] deoPodatka = podatak.split(",");
		String ime = deoPodatka[0];
		String kategorija = deoPodatka[1];

		for (String kljuc : mapa.keySet()) {
			if (ime.equalsIgnoreCase(kljuc) && kategorija.equalsIgnoreCase("asistencije".trim())) {        // ovo ne radi kako treba;
				System.out.println(mapa.get(kljuc).getAsistencije());									   // prepoznaje ime, ali ne i kategoriju;
				break;																					   // pomagaj!!!				
			}else if (ime.equalsIgnoreCase(kljuc) && kategorija.equalsIgnoreCase("poeni".trim())) {
				System.out.println(mapa.get(kljuc).getPoeni());
				break;
			}else if (ime.equalsIgnoreCase(kljuc) && kategorija.equalsIgnoreCase("skokovi".trim())) {
				System.out.println(mapa.get(kljuc).getSkokovi());
				break;
			}else if (ime.equalsIgnoreCase(kljuc) && kategorija.equalsIgnoreCase("blokade".trim())) {
				System.out.println(mapa.get(kljuc).getBlokade());
				break;
			}else if (ime.equalsIgnoreCase(kljuc) && kategorija.equalsIgnoreCase("ukradene lopte".trim())) {
				System.out.println(mapa.get(kljuc).getUkradeneLopte());
				break;
			}
		}

		System.out.println("Unesite novog igraca na listu.");

		System.out.println("Unesite  ime igraca: ");
		String imeIgracaNovo = tastatura.next();
		System.out.println("Unesite broj poena: ");
		String brojPoena = tastatura.next();
		System.out.println("Unestite broj skokova: ");
		String brojSkokova = tastatura.next();
		System.out.println("Unesite broj asistencija: ");
		String brojAsistencija = tastatura.next();
		System.out.println("Unesite broj ukradenih lopti: ");
		String ukradeneLopteIgraca = tastatura.next();
		System.out.println("Unesite broj blokada: ");
		String brojBlokada = tastatura.next();

		mapa.put(imeIgracaNovo, new Igrac(brojPoena, brojSkokova, brojAsistencija, ukradeneLopteIgraca, brojBlokada));

		sacuvajIgraca(mapa, "izabrana_datoteka.txt");

		System.out.println("Lista je sacuvana.");

		tastatura.close();
	}

}















