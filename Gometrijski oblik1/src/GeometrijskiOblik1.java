import java.util.Arrays;

abstract class GeometrijskiOblik1 implements Comparable<Object> {
	
	protected Ta�ka referentnaTa�ka;
		
	public GeometrijskiOblik1  (Ta�ka referentnaTa�ka) {
		super();
		this.referentnaTa�ka = referentnaTa�ka;
	}
	
	public Ta�ka getReferentnaTa�ka() {
		return referentnaTa�ka;
	}

	public abstract void transliraj(Ta�ka novaReferentnaTa�ka);
	
	public abstract double obim();
	
	public abstract double povr�ina();
	
	public int compareTo(Object o) {
		
		GeometrijskiOblik1 go = (GeometrijskiOblik1)o;
		if (this.povr�ina()<go.povr�ina())return -1;
		if (this.povr�ina()>go.povr�ina())return+1;
		return 0;
	}		

	
	
	public static void main (String [] args) {
		
		GeometrijskiOblik1 [] nizGO = new GeometrijskiOblik1[20];
		Ta�ka O = new Ta�ka(0,0);
		
		for (int i = 0; i < 20; i++) {
			if (Math.random()< 0.5) {
				double r = Math.random()*10;
				nizGO [i] = new Krug1(O,r);
			}
			else {
				double � = Math.random()*10;
				double v = Math.random()*10;
				nizGO[i] = new Pravougaonik(O, new Ta�ka(�,v));	
			}	
		}
		
		Arrays.sort(nizGO);
		
		System.out.println();
		
		System.out.println("Prikazivanje niza u rastu�em redosledu:\n");
		for (GeometrijskiOblik1 go: nizGO) {
			if (go instanceof Krug1)
				System.out.print("Krug,         P = ");
			else
				System.out.print("Pravougaonik, P = ");
			System.out.printf("%6.2f\n", go.povr�ina());
			
			
		}
		
		
	}
	
 }
	
	
	
	
	
	
	
	
	
	
	
	






