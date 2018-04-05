package jedinica;

public class Ugao {

	private double radijani;

	private Ugao(double radijani) {
		super();
		this.radijani = radijani;
	}
	
	public static Ugao fromRadians( double radijani) {
		return new Ugao(radijani);
	}
	
	public static Ugao fromDegrees(double stepeni) {
		return new Ugao(Math.toRadians(stepeni));
	}
	
	public double  toRadians() {
		return radijani;
	}
	
	public double toDegrees() {
	 return Math.toDegrees(radijani);
    }
	
	public void rotateLeft(Ugao ugao) {
	radijani= Math.toRadians(toDegrees() + ugao.toDegrees()); 
	
	}
	
	public void rotateRight(Ugao ugao) {
		radijani = Math.toRadians(toDegrees() - ugao.toDegrees());
	}
}





