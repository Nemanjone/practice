
public class formatiranjeTeksta {

	public static void main(String [] args) {
		
	Raèun r = new Raèun("Radnja Rozela", "Ugrinovaèki put 3", "Beograd", "16:00:00","13.3.2018","Milan");
	
	r.dodajStavku(new Stavka("Olovka Piner", 99.95));
	r.dodajStavku(new Stavka("Kokice - slane", 120));
	r.dodajStavku(new Stavka("Napolitanke ", 2300));
	r.dodajStavku(new Stavka ("Stavka sa dugaèkim imenom koja æe morati da bude  skraæena", 351.34));
	
	r.štampajRaèun(40);
	
	}
	

}
