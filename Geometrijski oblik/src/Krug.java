
 class Krug extends GeometrijskiOblik{
	
	
	private double  polupreènik;                        
	private  Taèka centar;
	

	public Krug( Taèka centar, double polupreènik) {
		super(centar);
		this.polupreènik = polupreènik;
		this.centar = centar;
	}

	public void transliraj(Taèka novaReferentnaTaèka) {
		referentnaTaèka = novaReferentnaTaèka;
		centar = novaReferentnaTaèka;
	}
	
	public double obim() {
		return 2*Math.PI* polupreènik;
	}
	
	public double površina() {
		return polupreènik*polupreènik*Math.PI;
	}
	
	public String toString() {
		return "<" + centar + "," + polupreènik + ">";	
	}
 }
 
class Pravougaonik extends GeometrijskiOblik {
	
	private Taèka dlt,gdt;

	public Pravougaonik(Taèka dlt, Taèka gdt) {
		super(dlt);
		this.dlt = dlt;
		this.gdt = gdt;
	}
	
	public void transliraj(Taèka novaReferentnaTaèka) {
		referentnaTaèka = novaReferentnaTaèka;
		double širina = gdt.getX() - dlt.getX();
		double visina = gdt.getY() - dlt.getY();
		dlt = novaReferentnaTaèka;
		gdt = new Taèka(novaReferentnaTaèka.getX() + širina, 
				novaReferentnaTaèka.getY() + visina);
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
	
class Taèka {
	
	private double x,y;

	public Taèka(double x, double y) {
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


