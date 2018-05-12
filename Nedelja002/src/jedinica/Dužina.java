package jedinica;

public class Du�ina {
	
	private double metri;
	
	

	private Du�ina(double metri) {
		super();
		this.metri = metri;
	}
	
	public static Du�ina fromMeters (double metri) {
		return new Du�ina (metri);
	} 
	
	public static Du�ina fromKilometres (double kilometri) {
		return new Du�ina (kilometri * 1000);
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

	public void add(Du�ina du�ina) {
		// TODO Auto-generated method stub
		this.metri+=metri;
	}
	

	
		
}


