package jedinica;

public class Brzina {

	private double mps;

	private Brzina(double mps) {
		super();
		this.mps = mps;
	}
	
	public static Brzina fromMetersPerSeconds (double mps) {
		return new Brzina(mps);
	}
	
	public static Brzina fromKilometersPerHour (double kmph) {
		return new Brzina(kmph /3.6);
	}
	
	public double toMetersPerSeconds() {
		return this.mps;
	}
	
	public double toKilometersPerHours() {
		return this.mps * 3.6;
	}
	
	public void addMetersPerSecond(double mps) {
		this.mps+=mps;
	}
	
	public void addKiloMetersPerHours(double kmph) {
		this.mps+=kmph / 3.6;
	}

	public void add(Brzina brzina) {
		this.mps+=brzina.toMetersPerSeconds();
	}
	
	public Dužina preðeniPut(Vreme vreme) {
		return Dužina.fromMeters(this.mps * vreme.toSeconds());
	}
	

}
