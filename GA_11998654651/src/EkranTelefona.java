
public class EkranTelefona {

	private double öirina, visina;

	public double getäirina() {
		return öirina;
	}

	public double getVisina() {
		return visina;
	}

	public EkranTelefona(double öirina, double visina) {
		super();
		this.öirina = öirina;
		this.visina = visina;
	}

	public double getDijagonala() {
		return Math.sqrt(Math.pow(öirina, 2) + Math.pow(visina, 2));
	}

	
	public static void zameniMesta(EkranTelefona a, EkranTelefona b) {
		
		double temp = a.öirina;
		a.öirina = b.öirina;
		b.öirina = temp;
		
		temp = a.visina;
		a.visina = b.visina;
		b.visina = temp;
	}
	
	
	
}
