
 class Krug extends GeometrijskiOblik{
	
	
	private double  polupre�nik;                        
	private  Ta�ka centar;
	

	public Krug( Ta�ka centar, double polupre�nik) {
		super(centar);
		this.polupre�nik = polupre�nik;
		this.centar = centar;
	}

	public void transliraj(Ta�ka novaReferentnaTa�ka) {
		referentnaTa�ka = novaReferentnaTa�ka;
		centar = novaReferentnaTa�ka;
	}
	
	public double obim() {
		return 2*Math.PI* polupre�nik;
	}
	
	public double povr�ina() {
		return polupre�nik*polupre�nik*Math.PI;
	}
	
	public String toString() {
		return "<" + centar + "," + polupre�nik + ">";	
	}
 }
 
class Pravougaonik extends GeometrijskiOblik {
	
	private Ta�ka dlt,gdt;

	public Pravougaonik(Ta�ka dlt, Ta�ka gdt) {
		super(dlt);
		this.dlt = dlt;
		this.gdt = gdt;
	}
	
	public void transliraj(Ta�ka novaReferentnaTa�ka) {
		referentnaTa�ka = novaReferentnaTa�ka;
		double �irina = gdt.getX() - dlt.getX();
		double visina = gdt.getY() - dlt.getY();
		dlt = novaReferentnaTa�ka;
		gdt = new Ta�ka(novaReferentnaTa�ka.getX() + �irina, 
				novaReferentnaTa�ka.getY() + visina);
	}
	
	public double obim () {
		double �irina = gdt.getX() - dlt.getX();
		double visina = gdt.getY() - dlt.getY();
		return 2*(�irina + visina);
		
	}
	
	public double povr�ina() {
		double �irina = gdt.getX() - dlt.getX();
		double visina = gdt.getY() - dlt.getY();
		return �irina*visina;
		
	}
	
	public String toString() {
		return "<" + dlt + "," + gdt + ">";
	}
}
	
class Ta�ka {
	
	private double x,y;

	public Ta�ka(double x, double y) {
		super();
		this.x = x;
		this.y = y;
	}

	public double getX() {
		return x;
	}

	public double getY() {
		return y;
	}
	
	public String toString() {
		
		return "(" + x + "," + y + ")";
	}	
  }


