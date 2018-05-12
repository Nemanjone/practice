
 abstract class GeometrijskiOblik {
	
	protected Taèka referentnaTaèka;
		
	public GeometrijskiOblik(Taèka referentnaTaèka) {
		super();
		this.referentnaTaèka = referentnaTaèka;
	}
	
	

	public Taèka getReferentnaTaèka() {
		return referentnaTaèka;
	}

	public abstract void transliraj(Taèka novaReferentnaTaèka);
	
	public abstract double obim();
	
	public abstract double površina();
	
	public static void main (String [] args) {
		
		Krug k = new Krug (new Taèka(0,0),1);
		System.out.println("Krug: " + k);
		k.transliraj(new Taèka(1,1));
		System.out.println("Krug: " + k);
		System.out.println("Obim: " + k.obim());
		System.out.println("Površina: " + k.površina());
		
		System.out.println();
		
		Pravougaonik p = new Pravougaonik(new Taèka(1,2), new Taèka(3,5));
		System.out.println("Pravougaonik: " + p);
		System.out.println("Obim: " + p.obim());
		System.out.println("Površina: " + k.površina());
		
		
	}
	
 }
	
	
	
	
	
	
	
	
	
	
	
	


