
public class tkk {
	public static void main(String [] args) {
		Krug k1 = new Krug(new Ta�ka(0,0),1);
		System.out.println("Krug:" + k1);
		System.out.println("Obim: " + k1.obim());
		System.out.println("Povr�ina: " + k1.povr�ina());
		System.out.println();
		
	}
}

class Ta�ka {
	private double x,y;// koordinate ta�ke
	
	public Ta�ka(double x, double y) {
		this.x = x;
		this.y = y;
	}
	public double getX() {
		return x;
	}
	public double getY() {
		return y;
	}
	public double rastojanjeOdPo�etka() {
		return Math.sqrt(x*x + y*y);
	}
}

class Kvadrat {
	private Ta�ka teme; //donje levo teme
	private double strana; // stranica
	
	public Kvadrat (Ta�ka teme, double strana) {
		this.teme = teme;
		this.strana = strana;
	}
	public Ta�ka getTeme() {
		return teme;
	}
	public double getStrana() {
		return strana;
	}
	public double obim() {
		return 4 * strana;
	}
	public double povr�ina() {
		return strana*strana;
	}
	public String toString() {
		return "A=("+teme.getX()+", "+teme.getY()+"), a ="+strana;
	}
}

class Krug{
	
	private Ta�ka centar; // centar kruga
	private double polupre�nik;
	
	public Krug (Ta�ka centar, double polupre�nik) {
		this.centar = centar;
		this.polupre�nik = polupre�nik;
	}
	public Ta�ka getCentar () {
		return centar;
	}
	public double getPolupre�nik () {
		return polupre�nik;
	}
	public double obim() {
		return polupre�nik*Math.PI*2;
	}
	public double povr�ina() {
		return polupre�nik*polupre�nik*Math.PI;
	}
	
	public boolean sadr�iTa�ku(Ta�ka A) {
	double cx = centar.getX(); // koordinatecentra kruga
	double cy = centar.getY();
	
	double ax = A.getX(); //koordinate date ta�ke
	double ay = A.getY();
	
	double d = Math.sqrt((cx - ax)*(cx - ax)*(cy*ay)*(cy-ay));
	
	if (d > polupre�nik)
		return false;
	else
		return true;
	}
	public Kvadrat opisanKvadrat() {
		double cx = centar.getX();
		double cy = centar.getY();
		
		double ax = cx - polupre�nik; // koordinate donjeg levog temena kvadrata
		double ay = cy - polupre�nik;
		double d = 2*polupre�nik; //du�ina stranice kvadrata
		
		return new Kvadrat (new Ta�ka(ax, ay), d);
	}
	public String toString() {
		return "C=("+centar.getX()+","+centar.getY()+"), r="+polupre�nik;
	}
}