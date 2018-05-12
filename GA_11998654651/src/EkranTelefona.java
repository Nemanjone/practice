
public class EkranTelefona {

	private double �irina, visina;

	public double get�irina() {
		return �irina;
	}

	public double getVisina() {
		return visina;
	}

	public EkranTelefona(double �irina, double visina) {
		super();
		this.�irina = �irina;
		this.visina = visina;
	}

	public double getDijagonala() {
		return Math.sqrt(Math.pow(�irina, 2) + Math.pow(visina, 2));
	}

	
	public static void zameniMesta(EkranTelefona a, EkranTelefona b) {
		
		double temp = a.�irina;
		a.�irina = b.�irina;
		b.�irina = temp;
		
		temp = a.visina;
		a.visina = b.visina;
		b.visina = temp;
	}
	
	
	
}
