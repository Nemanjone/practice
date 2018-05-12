import java.util.Scanner;


public class Vektor1 {
	
	private double x, y;

	public double getX() {
		return x;
	}

	public void setX(double x) {
		this.x = x;
	}

	public double getY() {
		return y;
	}

	public void setY(double y) {
		this.y = y;
	}
		
	public Vektor1() {
		this.x = 0.0;
		this.y = 0.0;
		
	}

	public Vektor1(double x, double y) {
		super();
		this.x = x;
		this.y = y;
	}
	
	public void Saberi(Vektor1 v) {
		this.x+=v.getX();
		this.y+=v.getY();
	}
	public Vektor1 (Vektor1 v) {
		this.x = v.getX();
		this.y= v.getY();
	}
	
	@Override
	public String toString() {
		return "Vektor [x=" + x + ", y=" + y + "]";
	}
	
	public void Oduzmi(Vektor1 v) {
		this.x-=v.getX();
		this.y-=v.getY();
	}
	
	public void Skaliraj(double skalar) {
		this.x *=skalar;
		this.y*=skalar;
	}
	
	public double Intenzitet() {
		
		return Math.sqrt(Math.pow(this.x, 2.0) + Math.pow(this.y, 2.0));
	}
	
	public static Vektor1 UnosSaTastature() {
		Scanner s = new Scanner(System.in);
		System.out.println(" Unesite x i y odvojene razmacima: ");
		Vektor1 v = new Vektor1();
		
		
		v.setX(s.nextDouble());
		v.setY(s.nextDouble());
        	return v;
	}
	
	public static void zameni (Vektor1 a, Vektor1 b) {
		double privremenoX = a.getX();
		a.setX(b.getX());
		b.setX(privremenoX);
		
		double privremenoY = a.getY();
		a.setY(b.getY());
		b.setY(privremenoY);
	}
	
	public enum POREDAK{ OPADAJUÆI, RASTUÆI};
	
	
	
	public static void sort (Vektor1 [] niz, POREDAK poredak) {
		
		for ( int j = 0; j < niz.length - 1; j++ ) {
			for (int i = 0; i < niz.length; i++) {
				if (poredak == POREDAK.RASTUÆI) {
				if ( niz[i].Intenzitet()> niz[i +1].Intenzitet()) {
				Vektor1.zameni(niz[i], niz[i + 1]);
				}
				}else if (poredak == POREDAK.OPADAJUÆI) {
					if ( niz[i].Intenzitet()< niz[i +1].Intenzitet()) {
						Vektor1.zameni(niz[i], niz[i + 1]);	
				}
				}
			}
	}
	}
	public static void main(String[] args) {
		
		Vektor1 [] niz = new Vektor1 [3];
		
		for ( int i = 0; i < niz.length; i ++) {
		niz[i] = Vektor1.UnosSaTastature();
		}
		
	Vektor1.sort(niz, POREDAK.OPADAJUÆI);
	
	for ( int i = 0; i < niz.length - 1; i++ ) {
		System.out.println(niz[i] + ", intenzitet = " + niz[i].Intenzitet());
	
	    }
		
   }

}
