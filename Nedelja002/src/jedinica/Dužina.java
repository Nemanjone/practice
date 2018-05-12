package jedinica;

public class Dužina {
	
	private double metri;
	
	

	private Dužina(double metri) {
		super();
		this.metri = metri;
	}
	
	public static Dužina fromMeters (double metri) {
		return new Dužina (metri);
	} 
	
	public static Dužina fromKilometres (double kilometri) {
		return new Dužina (kilometri * 1000);
	} 
	
	public double toMeters() {
		return this.metri;	
	}
	
	public double toKilometers() {
		return this.metri/1000;
	}
	
	public void addMetres(double metara) {
		this.metri+=metara;
	}
	
	public void addKilometres(double kilometara) {
		this.metri+=kilometara * 1000;
	}

	public void add(Dužina dužina) {
		// TODO Auto-generated method stub
		this.metri+=metri;
	}
	

	
		
}


