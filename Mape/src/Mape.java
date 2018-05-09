import java.util.ArrayList;
import java.util.List;

public class Mape {

	public static void main(String[] args) {

		List<Kandidat> kandidati = new ArrayList<>();

		KandidatFilter programeri = kandidat -> {
			if(kandidat.getBrojMeseciRadnogIskustava("programiranje") < 12) {	
				return false;
			}
			if (kandidat.getBrojMeseciRadnogIskustava("baze podataka") < 12) {
				return false;
			}
			if (kandidat.getBrojMeseciRadnogIskustava("engleski") < 24) {
				return false;
			}
			return true;
		};

		KandidatFilter menad�eri = kandidat -> {
			if (kandidat.getBrojMeseciRadnogIskustava("menad�ment") < 24) {
				return false;
			}
			if (kandidat.getBrojMeseciRadnogIskustava("marketing") < 12) {
				return false;
			}
			if (kandidat.getBrojMeseciRadnogIskustava("engleski") < 36) {
				return false;
			}
			return true;
		};


		kandidati.add
		(new Kandidat("A", "B", "a&b.com")
				.dodajZnanje("engleski", 24)
				.dodajZnanje("programiranje", 67 )
				.dodajZnanje("dizajn", 34)
				.dodajZnanje("poslovna korespondencija", 45)
				.dodajZnanje("baze podataka", 25)

				);		

		kandidati.add
		(new Kandidat("E", "F", "e&f.com")
				.dodajZnanje("nema�ki", 78)
				.dodajZnanje("menad�ment", 56 )
				.dodajZnanje("marketing", 4)
				.dodajZnanje("poslovna korespondencija", 57)
				.dodajZnanje("engleski", 21)

				);		

		kandidati.add
		(new Kandidat("C", "D", "c&d.com")
				.dodajZnanje("engleski", 26)
				.dodajZnanje("programiranje", 67 )
				.dodajZnanje("poslovna korespondencija", 14)
				.dodajZnanje("baze podataka", 31)
				.setAdresa("Adresa1")
				);	

		kandidati.stream()
		.filter(k -> programeri.odgovara(k) )
		.forEach(k -> {
			System.out.println(k);
		});
	}
}


