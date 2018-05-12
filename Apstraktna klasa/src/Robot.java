
public abstract class Robot {

	private double te�inaKG;
	private String ime;
	private String lozinka;
	
	public Robot(double te�inaKG, String ime, String lozinka) {
		super();
		this.te�inaKG = te�inaKG;
		this.ime = ime;
		this.lozinka = lozinka;
	}

	public double getTe�inaKG() {
		return te�inaKG;
	}

	final public String getIme() {
		return ime;
	}

  final	public void izvr�iNare�enje (String lozinka, String nare�enje) {
		
		if (lozinka.equals(this.lozinka)) {
			izvr�enjeNaredbe(nare�enje);
			}else
				System.out.println("Lozinka za " + ime + " nije ispravna!");
		}
		
	abstract protected void izvr�enjeNaredbe(String nare�enje);
		
	
	
	
	
}
