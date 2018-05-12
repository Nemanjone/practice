import java.util.LinkedList;
import java.util.List;
import Igra.Igraè;
import Igra.NepokretanObjekat;
import Igra.Objekat;
import Igra.Vuk;
import jedinica.Brzina;
import jedinica.Dužina;
import jedinica.Lokacija;
import jedinica.Vreme;

public class Nedelja002 {

	public static void main (String[] args) {
		
		
	
		
		List<Objekat> listaObjekataIgre = new LinkedList<>();
		
		NepokretanObjekat d1 = new NepokretanObjekat(
				new Lokacija(
				   Dužina.fromMeters(10),         
				   Dužina.fromMeters(10)),
				   "slike/drvo.png",
				   "Drvo");
		
		Vuk v1 = new Vuk(
				new Lokacija(Dužina.fromMeters(10), 
						Dužina.fromMeters(12)),
				        "slike/vuk.png",
				        Brzina.fromKilometersPerHour(40),
				        "crna");
		
		Vuk v2 = new Vuk(
				new Lokacija(Dužina.fromMeters(10), 
						Dužina.fromMeters(13)),
				        "slike/vuk.png",
				        Brzina.fromKilometersPerHour(45),
				        "siva");
		
		Igraè i = new Igraè(
				new Lokacija(
						Dužina.fromMeters(30), Dužina.fromMeters(33)), 
				"slike/pacman.png", 
				Brzina.fromKilometersPerHour(30));
		
		listaObjekataIgre.add(d1);
		listaObjekataIgre.add(v1);
		listaObjekataIgre.add(v2);
		listaObjekataIgre.add(i);
		
		System.out.println(listaObjekataIgre.size());
		
		v1.move(Vreme.fromMinutes(2));
		v2.move(Vreme.fromMinutes(2));
		
		/*
		 * 2D (x,y)
		 *   - objekti (x, y, slika)
		 *     - nepokretni (naziv)
		 *     - pokretni   (brzina)  
		 *         -igraèi  (naziv, snaga, život) @ funkcije za kretanje
		 *         -neprijatelji  (snaga, život
		 *            -ork 
		 *            -vuk
		 *            -...
		 *   
		 *   
		 */  
		

	}
	
}
