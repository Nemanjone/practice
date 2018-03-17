import java.util.Arrays;

abstract class GeometrijskiOblik1 implements Comparable<Object> {
	
	protected Taèka referentnaTaèka;
		
	public GeometrijskiOblik1  (Taèka referentnaTaèka) {
		super();
		this.referentnaTaèka = referentnaTaèka;
	}
	
	public Taèka getReferentnaTaèka() {
		return referentnaTaèka;
	}

	public abstract void transliraj(Taèka novaReferentnaTaèka);
	
	public abstract double obim();
	
	public abstract double površina();
	
	public int compareTo(Object o) {
		
		GeometrijskiOblik1 go = (GeometrijskiOblik1)o;
		if (this.površina()<go.površina())return -1;
		if (this.površina()>go.površina())return+1;
		return 0;
	}		

	
	
	public static void main (String [] args) {
		
		GeometrijskiOblik1 [] nizGO = new GeometrijskiOblik1[20];
		Taèka O = new Taèka(0,0);
		
		for (int i = 0; i < 20; i++) {
			if (Math.random()< 0.5) {
				double r = Math.random()*10;
				nizGO [i] = new Krug1(O,r);
			}
			else {
				double š = Math.random()*10;
				double v = Math.random()*10;
				nizGO[i] = new Pravougaonik(O, new Taèka(š,v));	
			}	
		}
		
		Arrays.sort(nizGO);
		
		System.out.println();
		
		System.out.println("Prikazivanje niza u rastuæem redosledu:\n");
		for (GeometrijskiOblik1 go: nizGO) {
			if (go instanceof Krug1)
				System.out.print("Krug,         P = ");
			else
				System.out.print("Pravougaonik, P = ");
			System.out.printf("%6.2f\n", go.površina());
			
			
		}
		
		
	}
	
 }
	
	
	
	
	
	
	
	
	
	
	
	






