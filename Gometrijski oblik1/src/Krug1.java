

 class Krug1 extends GeometrijskiOblik1{
	
	
	private double  poluprečnik;                        
	private  Tačka centar;
	

	public Krug1( Tačka centar, double poluprečnik) {
		super(centar);
		this.poluprečnik = poluprečnik;
		this.centar = centar;
	}

	public void transliraj(Tačka novaReferentnaTačka) {
		referentnaTačka = novaReferentnaTačka;
		centar = novaReferentnaTačka;
	}
	
	public double obim() {
		return 2*Math.PI* poluprečnik;
	}
	
	public double površina() {
		return poluprečnik*poluprečnik*Math.PI;
	}
	
	public String toString() {
		return "<" + centar + "," + poluprečnik + ">";	
	}
 }
 
class Pravougaonik extends GeometrijskiOblik1 {
	
	private Tačka dlt,gdt;

	public Pravougaonik(Tačka dlt, Tačka gdt) {
		super(dlt);
		this.dlt = dlt;
		this.gdt = gdt;
	}
	
	public void transliraj(Tačka novaReferentnaTačka) {
		referentnaTačka = novaReferentnaTačka;
		double širina = gdt.getX() - dlt.getX();
		double visina = gdt.getY() - dlt.getY();
		dlt = novaReferentnaTačka;
		gdt = new Tačka(novaReferentnaTačka.getX() + širina, 
				novaReferentnaTačka.getY() + visina);
	}
	
	public double obim () {
		double širina = gdt.getX() - dlt.getX();
		double visina = gdt.getY() - dlt.getY();
		return 2*(širina + visina);
		
	}
	
	public double površina() {
		double širina = gdt.getX() - dlt.getX();
		double visina = gdt.getY() - dlt.getY();
		return širina*visina;
		
	}
	
	public String toString() {
		return "<" + dlt + "," + gdt + ">";
	}
}
	
class Tačka {
	
	private double x,y;

	public Tačka(double x, double y) {
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


