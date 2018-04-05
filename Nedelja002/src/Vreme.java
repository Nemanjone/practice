
public class Vreme {

	private double sekunde;

	private Vreme(double sekunde) {
		super();
		this.sekunde = sekunde;
	}
	
	public static Vreme fromSeconds(double sekunde) {
		return new Vreme(sekunde);
	}

	public static Vreme fromMinutes (double minute) {
	return new Vreme (minute *60);
	}
	
	public double toSeconds() {
	    return	this.sekunde;
	}
	
	public double toMinutes() {
	    return	this.sekunde/60;
	}
	
	public double toHours() {
	    return	this.sekunde/3600;
	}
	
	public double toMiliSeconds() {
		return this.sekunde * 1000;
	}
	
	public void addSeconds(double sekunde) {
		 this.sekunde+=sekunde;
	}
	
	public void addMinutes(double minute) {
		this.sekunde+=minute*60;
	}
	
	public void addHours(double sati) {
		this.sekunde+=sati * 3600;
	}
	
	
	
	
	
	
	
	
	
}
