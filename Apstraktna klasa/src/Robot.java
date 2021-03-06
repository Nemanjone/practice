
public abstract class Robot {

	private double težinaKG;
	private String ime;
	private String lozinka;
	
	public Robot(double težinaKG, String ime, String lozinka) {
		super();
		this.težinaKG = težinaKG;
		this.ime = ime;
		this.lozinka = lozinka;
	}

	public double getTežinaKG() {
		return težinaKG;
	}

	final public String getIme() {
		return ime;
	}

  final	public void izvršiNaređenje (String lozinka, String naređenje) {
		
		if (lozinka.equals(this.lozinka)) {
			izvršenjeNaredbe(naređenje);
			}else
				System.out.println("Lozinka za " + ime + " nije ispravna!");
		}
		
	abstract protected void izvršenjeNaredbe(String naređenje);
		
	
	
	
	
}
