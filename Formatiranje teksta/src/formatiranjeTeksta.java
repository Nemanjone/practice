
public class formatiranjeTeksta {

	public static void main(String [] args) {
		
	Ra�un r = new Ra�un("Radnja Rozela", "Ugrinova�ki put 3", "Beograd", "16:00:00","13.3.2018","Milan");
	
	r.dodajStavku(new Stavka("Olovka Piner", 99.95));
	r.dodajStavku(new Stavka("Kokice - slane", 120));
	r.dodajStavku(new Stavka("Napolitanke ", 2300));
	r.dodajStavku(new Stavka ("Stavka sa duga�kim imenom koja �e morati da bude  skra�ena", 351.34));
	
	r.�tampajRa�un(40);
	
	}
	

}
