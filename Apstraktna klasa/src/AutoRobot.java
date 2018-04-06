
public class AutoRobot extends Robot {

	private double brzinaKPH;

	public AutoRobot(double te�inaKG, String ime, String lozinka, double brzinaKPH) {
		super(te�inaKG, ime, lozinka);
		this.brzinaKPH = brzinaKPH;
	}

	@Override
	protected void izvr�enjeNaredbe(String nare�enje) {
		// TODO Auto-generated method stub
		
		if(nare�enje.equals("POKRENI SE")) {
			System.out.println(getIme() + " se pokrenuo.");
		} else if (nare�enje.equals("ZAUSTAVI SE")) {
			System.out.println(getIme() + " se zaustavio.");
		}else {
			System.out.println("Auto robot ne prepoznaje nare�enje.");
		
		}
		
	}
	
	
	
}
