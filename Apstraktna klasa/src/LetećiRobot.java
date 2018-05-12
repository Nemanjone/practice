
 final public class  LeteæiRobot extends Robot {

	private double maksimalnaVisina;

	public LeteæiRobot(double težinaKG, String ime, String lozinka, double maksimalnaVisina) {
		super(težinaKG, ime, lozinka);
		this.maksimalnaVisina = maksimalnaVisina;
	}

	public double getMaksimalnaVisina() {
		return maksimalnaVisina;
	}

	@Override
	protected void izvršenjeNaredbe(String nareðenje) {
		// TODO Auto-generated method stub
		
		if (nareðenje.equals("POLETI")) {
			System.out.println(getIme() + " je poleteo.");
		}else if (nareðenje.equals("SLETI")) {
		System.out.println(getIme() + " je sleteo.");
		}
		else
			System.out.println(getIme() + " ne prepoznaje nareðenje.");
	}

	@Override
	final public double getTežinaKG() {
		// TODO Auto-generated method stub
		return super.getTežinaKG();
	};
	
	
	
}
