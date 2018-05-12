
public class AutoRobot extends Robot {

	private double brzinaKPH;

	public AutoRobot(double težinaKG, String ime, String lozinka, double brzinaKPH) {
		super(težinaKG, ime, lozinka);
		this.brzinaKPH = brzinaKPH;
	}

	@Override
	protected void izvršenjeNaredbe(String nareðenje) {
		// TODO Auto-generated method stub
		
		if(nareðenje.equals("POKRENI SE")) {
			System.out.println(getIme() + " se pokrenuo.");
		} else if (nareðenje.equals("ZAUSTAVI SE")) {
			System.out.println(getIme() + " se zaustavio.");
		}else {
			System.out.println("Auto robot ne prepoznaje nareðenje.");
		
		}
		
	}
	
	
	
}
