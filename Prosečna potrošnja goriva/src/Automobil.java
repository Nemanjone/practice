
public class Automobil {

	private double rezervoar = 0.0; 
	private double pređenaKilometraža = 0.0;
		
	private double pređenaKilometražaKodPoslednjeDopune = 0;
	private double stanjeRezervoaraKodPoslednjeDopune = 0;
	private double iznosPoslednjeDopune = 0;
	
	public double getRezervoar() {
		return rezervoar;
	}
	
	public double getPređenaKilometraža() {
		return pređenaKilometraža;
	}
	
	
	public void dopuniGorivo(double količina) {
		System.out.println("Do sad je prosečna potrošnja bila " + this.prosečnaPotrošnjaOdPoslednjeDopune());
		stanjeRezervoaraKodPoslednjeDopune = rezervoar;
		pređenaKilometražaKodPoslednjeDopune = pređenaKilometraža;
		
		rezervoar+= količina;
		iznosPoslednjeDopune = količina;
	}
	
	public void voziPoGradu(double put) {
		pređenaKilometraža+=put;
		rezervoar-=(put/100)*7;
	}
	
	public void voziNaOtvorenom(double put) {
		pređenaKilometraža = put;
		rezervoar -= (put/100)*5.6;
	}
	
	public double prosečnaPotrošnjaOdPoslednjeDopune() {
		double pređeniPut, potrošenoGorivo;
		pređeniPut = pređenaKilometraža - pređenaKilometražaKodPoslednjeDopune;
		
		potrošenoGorivo = (stanjeRezervoaraKodPoslednjeDopune +iznosPoslednjeDopune) - rezervoar;
		
		return (potrošenoGorivo*100)/pređeniPut;
	}
	
		
	
}
