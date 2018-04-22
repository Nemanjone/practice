
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

					mapa.put(ime.trim().toLowerCase(), igrac);

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

	public static void main(String[] args) {

		HashMap<String, Igrac> mapa = ucitajIgraca("srpski_igraci_nba_2017_18.csv");

		Scanner tastatura = new Scanner(System.in);

		System.out.println("Usage: nba ime [ -pts | -reb | -stl | -blk | -ast ]");
		String red = tastatura.nextLine();
		String[] deoPodataka = red.split("-");
		
		if (deoPodataka != null && deoPodataka.length > 0) {
			String imeIgraca = deoPodataka[0].trim().toLowerCase();
			
			if (mapa.containsKey(imeIgraca)) {
				
				Igrac igrac = mapa.get(imeIgraca);
				
				if (deoPodataka.length > 1) {
					switch (deoPodataka[1]) {
					
					case "pts":
						System.out.println(deoPodataka[0] + "je postizao " + igrac.getPoeni() + " poena!");
						break;
					case "reb":
						System.out.println(deoPodataka[0] + "je postizao " + igrac.getSkokovi() + " skokova!");
						break;
					case "ast":
						System.out.println(deoPodataka[0] + "je postizao " + igrac.getAsistencije() + " asistencija!");
						break;
					case "blk":
						System.out.println(deoPodataka[0] + "je postizao " + igrac.getBlokade() + " blokada!");
						break;
					case "stl":
						System.out.println(deoPodataka[0] + "je postizao " + igrac.getUkradeneLopte() + " ukrednih lopti!");
						break;
					
					}
					
					
				} else {
					System.out.println(igrac);
				}
				
				
			} else {
				System.out.println("Igrac nepoznat!");
				System.exit(-1);
			}
		}
			
			
		tastatura.close();
		System.exit(0);
	}
	

}















