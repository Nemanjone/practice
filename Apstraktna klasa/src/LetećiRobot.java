
 final public class  LetećiRobot extends Robot {

	private double maksimalnaVisina;

	public LetećiRobot(double težinaKG, String ime, String lozinka, double maksimalnaVisina) {
		super(težinaKG, ime, lozinka);
		this.maksimalnaVisina = maksimalnaVisina;
	}

	public double getMaksimalnaVisina() {
		return maksimalnaVisina;
	}

	@Override
	protected void izvršenjeNaredbe(String naređenje) {
		// TODO Auto-generated method stub
		
		if (naređenje.equals("POLETI")) {
			System.out.println(getIme() + " je poleteo.");
		}else if (naređenje.equals("SLETI")) {
		System.out.println(getIme() + " je sleteo.");
		}
		else
			System.out.println(getIme() + " ne prepoznaje naređenje.");
	}

	@Override
	final public double getTežinaKG() {
		// TODO Auto-generated method stub
		return super.getTežinaKG();
	};
	
	
	
}
