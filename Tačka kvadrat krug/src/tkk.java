
public class tkk {
	public static void main(String [] args) {
		Krug k1 = new Krug(new Taèka(0,0),1);
		System.out.println("Krug:" + k1);
		System.out.println("Obim: " + k1.obim());
		System.out.println("Površina: " + k1.površina());
		System.out.println();
		
	}
}

class Taèka {
	private double x,y;// koordinate taèke
	
	public Taèka(double x, double y) {
		this.x = x;
		this.y = y;
	}
	public double getX() {
		return x;
	}
	public double getY() {
		return y;
	}
	public double rastojanjeOdPoèetka() {
		return Math.sqrt(x*x + y*y);
	}
}

class Kvadrat {
	private Taèka teme; //donje levo teme
	private double strana; // stranica
	
	public Kvadrat (Taèka teme, double strana) {
		this.teme = teme;
		this.strana = strana;
	}
	public Taèka getTeme() {
		return teme;
	}
	public double getStrana() {
		return strana;
	}
	public double obim() {
		return 4 * strana;
	}
	public double površina() {
		return strana*strana;
	}
	public String toString() {
		return "A=("+teme.getX()+", "+teme.getY()+"), a ="+strana;
	}
}

class Krug{
	
	private Taèka centar; // centar kruga
	private double polupreènik;
	
	public Krug (Taèka centar, double polupreènik) {
		this.centar = centar;
		this.polupreènik = polupreènik;
	}
	public Taèka getCentar () {
		return centar;
	}
	public double getPolupreènik () {
		return polupreènik;
	}
	public double obim() {
		return polupreènik*Math.PI*2;
	}
	public double površina() {
		return polupreènik*polupreènik*Math.PI;
	}
	
	public boolean sadržiTaèku(Taèka A) {
	double cx = centar.getX(); // koordinatecentra kruga
	double cy = centar.getY();
	
	double ax = A.getX(); //koordinate date taèke
	double ay = A.getY();
	
	double d = Math.sqrt((cx - ax)*(cx - ax)*(cy*ay)*(cy-ay));
	
	if (d > polupreènik)
		return false;
	else
		return true;
	}
	public Kvadrat opisanKvadrat() {
		double cx = centar.getX();
		double cy = centar.getY();
		
		double ax = cx - polupreènik; // koordinate donjeg levog temena kvadrata
		double ay = cy - polupreènik;
		double d = 2*polupreènik; //dužina stranice kvadrata
		
		return new Kvadrat (new Taèka(ax, ay), d);
	}
	public String toString() {
		return "C=("+centar.getX()+","+centar.getY()+"), r="+polupreènik;
	}
}