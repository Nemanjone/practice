
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

  final	public void izvršiNareðenje (String lozinka, String nareðenje) {
		
		if (lozinka.equals(this.lozinka)) {
			izvršenjeNaredbe(nareðenje);
			}else
				System.out.println("Lozinka za " + ime + " nije ispravna!");
		}
		
	abstract protected void izvršenjeNaredbe(String nareðenje);
		
	
	
	
	
}
