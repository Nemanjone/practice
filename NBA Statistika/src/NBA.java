import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class NBA  {            //name, pts, reb, ast, stl, blk



	public static List<Igrac> ucitajIgraca(String imeDatoteke) {

		List<Igrac> lista = new ArrayList<>();

		try {

			FileInputStream fis = new FileInputStream(imeDatoteke);
			Scanner tastatura = new Scanner(fis);


			while (tastatura.hasNextLine()) {
				if (tastatura.nextLine().startsWith("name")) {	           //da se resim prvog reda
				}
				else  {
					String igracPodaci = (String) tastatura.nextLine();
					String [] deo = igracPodaci.split(",");

					String ime = deo[0];
					double poeni = Double.parseDouble(deo[1]); 
					double skokovi = Double.parseDouble(deo [2]);
					double asistencije =Double.parseDouble(deo [3]);
					double ukradeneLopte = Double.parseDouble(deo [4]);
					double blokade =Double.parseDouble(deo [5]);

					Igrac igrac = new Igrac(ime, poeni, skokovi, asistencije, ukradeneLopte, blokade);

					lista.add(igrac);
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
		return lista;


	}

	public static void sacuvajIgraca(Igrac igrac, String imeDatoteke) {

		try {

			PrintWriter pw = new PrintWriter(imeDatoteke);
			pw.println(igrac);
			pw.flush();
			pw.close();
		}
		catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}





	public static void main(String[] args) {

		List<Igrac> lista = ucitajIgraca("srpski_igraci_nba_2017_18 (1).csv");

		Scanner tastatura = new Scanner(System.in);

		System.out.println("Unesite ime igraca koji vas zanima: ");

		String imeIgraca = tastatura.nextLine();

		System.out.println("Statisticki podaci koje imamo su: ");   //pts, reb, ast, stl, blk
		System.out.println("   1. Poeni ");
		System.out.println("   2. Skokovi");
		System.out.println("   3. Asistencije");
		System.out.println("   4. Ukradene lopte");
		System.out.println("   5. Blokade");
		System.out.println();
		System.out.println("Unesite broj opcije koju želite: ");

		int brojOpcije = tastatura.nextInt();

		for (Igrac igrac : lista) {
			if(igrac.getIme().toUpperCase() == imeIgraca.toUpperCase().trim()) {
				switch (brojOpcije) {
				case 1:
					System.out.println(igrac.getIme() + " proseèno ostvaruje " + igrac.getPoeni() + " poena po utakmici.");
					break;
				case 2:
					System.out.println(igrac.getIme() + " proseèno ostvaruje " + igrac.getSkokovi() + " skokova po utakmici.");
					break;
				case 3:
					System.out.println(igrac.getIme() + " proseèno ostvaruje " + igrac.getAsistencije() + " asistencija po utakmici.");
					break;
				case 4:
					System.out.println(igrac.getIme() + " proseèno ostvaruje " + igrac.getUkradeneLopte() + " ukradene lopte po utakmici.");
					break;
				case 5:
					System.out.println(igrac.getIme() + " proseèno ostvaruje " + igrac.getBlokade() + " blokade po utakmici.");

					break;
				default:
					System.out.println("Greska: pogresna opcija!");
				}


			} else {
				System.out.println("Greska: igrac sa tim imenom nije na listi! ");
			}
		}

		System.out.println("Zelite da dodate igraca na listu? (D/N) ");

		String odgovor = tastatura.next();
		
		if (odgovor == "D" && odgovor == "d" ) {                          //pts, reb, ast, stl, blk
			System.out.println("Unesite  ime igraca: ");
			imeIgraca = tastatura.next();
			System.out.println("Unesite broj poena: ");
			double brojPoena = tastatura.nextDouble();
			System.out.println("Unestite broj skokova: ");
			double brojSkokova = tastatura.nextDouble();
			System.out.println("Unesite broj asistencija: ");
			double brojAsistencija = tastatura.nextDouble();
			System.out.println("Unesite broj ukradenih lopti: ");
			double ukradeneLopteIgraca = tastatura.nextDouble();
			System.out.println("Unesite broj blokada: ");
			double brojBlokada = tastatura.nextDouble();

			lista.add(new Igrac(imeIgraca, brojPoena, brojSkokova, brojAsistencija, ukradeneLopteIgraca, brojBlokada));

			System.out.println("Novi izgled liste: ");

			for (Igrac igrac : lista) {
				System.out.println(igrac);
			}



			Igrac igracSaNajviseAsistencija = lista.get(0);

			for (Igrac igrac2 : lista) {
				if (igrac2.getAsistencije() > igracSaNajviseAsistencija.getAsistencije()) {
					igracSaNajviseAsistencija = igrac2;
				}
			}

			sacuvajIgraca(igracSaNajviseAsistencija, "izabrana_datoteka.txt");         //Jokic

		}

	}

}


