
 final public class  Lete�iRobot extends Robot {

	private double maksimalnaVisina;

	public Lete�iRobot(double te�inaKG, String ime, String lozinka, double maksimalnaVisina) {
		super(te�inaKG, ime, lozinka);
		this.maksimalnaVisina = maksimalnaVisina;
	}

	public double getMaksimalnaVisina() {
		return maksimalnaVisina;
	}

	@Override
	protected void izvr�enjeNaredbe(String nare�enje) {
		// TODO Auto-generated method stub
		
		if (nare�enje.equals("POLETI")) {
			System.out.println(getIme() + " je poleteo.");
		}else if (nare�enje.equals("SLETI")) {
		System.out.println(getIme() + " je sleteo.");
		}
		else
			System.out.println(getIme() + " ne prepoznaje nare�enje.");
	}

	@Override
	final public double getTe�inaKG() {
		// TODO Auto-generated method stub
		return super.getTe�inaKG();
	};
	
	
	
}
