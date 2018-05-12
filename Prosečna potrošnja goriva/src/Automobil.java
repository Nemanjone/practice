
public class Automobil {

	private double rezervoar = 0.0; 
	private double preðenaKilometraža = 0.0;
		
	private double preðenaKilometražaKodPoslednjeDopune = 0;
	private double stanjeRezervoaraKodPoslednjeDopune = 0;
	private double iznosPoslednjeDopune = 0;
	
	public double getRezervoar() {
		return rezervoar;
	}
	
	public double getPreðenaKilometraža() {
		return preðenaKilometraža;
	}
	
	
	public void dopuniGorivo(double kolièina) {
		System.out.println("Do sad je proseèna potrošnja bila " + this.proseènaPotrošnjaOdPoslednjeDopune());
		stanjeRezervoaraKodPoslednjeDopune = rezervoar;
		preðenaKilometražaKodPoslednjeDopune = preðenaKilometraža;
		
		rezervoar+= kolièina;
		iznosPoslednjeDopune = kolièina;
	}
	
	public void voziPoGradu(double put) {
		preðenaKilometraža+=put;
		rezervoar-=(put/100)*7;
	}
	
	public void voziNaOtvorenom(double put) {
		preðenaKilometraža = put;
		rezervoar -= (put/100)*5.6;
	}
	
	public double proseènaPotrošnjaOdPoslednjeDopune() {
		double preðeniPut, potrošenoGorivo;
		preðeniPut = preðenaKilometraža - preðenaKilometražaKodPoslednjeDopune;
		
		potrošenoGorivo = (stanjeRezervoaraKodPoslednjeDopune +iznosPoslednjeDopune) - rezervoar;
		
		return (potrošenoGorivo*100)/preðeniPut;
	}
	
		
	
}
