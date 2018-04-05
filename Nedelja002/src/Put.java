
public class Put {
	
	private double metri;

	private Put(double metri) {
		super();
		this.metri = metri;
	}
	
	public static Put fromMeters (double metri) {
		return new Put (metri);
	} 
	
	public static Put fromKilometres (double kilometri) {
		return new Put (kilometri * 1000);
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
	
	

}
