
public class Automobil {

	private double rezervoar = 0.0; 
	private double pre�enaKilometra�a = 0.0;
		
	private double pre�enaKilometra�aKodPoslednjeDopune = 0;
	private double stanjeRezervoaraKodPoslednjeDopune = 0;
	private double iznosPoslednjeDopune = 0;
	
	public double getRezervoar() {
		return rezervoar;
	}
	
	public double getPre�enaKilometra�a() {
		return pre�enaKilometra�a;
	}
	
	
	public void dopuniGorivo(double koli�ina) {
		System.out.println("Do sad je prose�na potro�nja bila " + this.prose�naPotro�njaOdPoslednjeDopune());
		stanjeRezervoaraKodPoslednjeDopune = rezervoar;
		pre�enaKilometra�aKodPoslednjeDopune = pre�enaKilometra�a;
		
		rezervoar+= koli�ina;
		iznosPoslednjeDopune = koli�ina;
	}
	
	public void voziPoGradu(double put) {
		pre�enaKilometra�a+=put;
		rezervoar-=(put/100)*7;
	}
	
	public void voziNaOtvorenom(double put) {
		pre�enaKilometra�a = put;
		rezervoar -= (put/100)*5.6;
	}
	
	public double prose�naPotro�njaOdPoslednjeDopune() {
		double pre�eniPut, potro�enoGorivo;
		pre�eniPut = pre�enaKilometra�a - pre�enaKilometra�aKodPoslednjeDopune;
		
		potro�enoGorivo = (stanjeRezervoaraKodPoslednjeDopune +iznosPoslednjeDopune) - rezervoar;
		
		return (potro�enoGorivo*100)/pre�eniPut;
	}
	
		
	
}
