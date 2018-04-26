
public class RernaNaGas extends Rerna {

	private boolean ventilOtvoren = false;
	
	public void zatvoriVentilZaGas() {
		this.ventilOtvoren = false;
	}
	
	public void otvoriVentil() {
		this.ventilOtvoren = true;	
	}
	
	public boolean isVentilOtvoren() {
		return ventilOtvoren;
	}

	@Override
	public String toString() {
		return "RernaNaGas " + super.toString() + "[ventilOtvoren=" + ventilOtvoren + "]";
	}
	
}
