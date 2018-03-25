
public class Pravougaonik {

	private double a,b;

	public Pravougaonik(double a, double b) {
		super();
		this.a = a;
		this.b = b;
	}

	public double getA() {
		return a;
	}

	public double getB() {
		return b;
	}

	@Override
	public String toString() {
		return "Pravougaonik [a=" + a + ", b=" + b + "]";
	}
	public double getPovršina () {
		return a*b;
	}
	
	public double getObim() {
		return 2*(a+b);
	}
	
}
