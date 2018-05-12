
 abstract class GeometrijskiOblik {
	
	protected Ta�ka referentnaTa�ka;
		
	public GeometrijskiOblik(Ta�ka referentnaTa�ka) {
		super();
		this.referentnaTa�ka = referentnaTa�ka;
	}
	
	

	public Ta�ka getReferentnaTa�ka() {
		return referentnaTa�ka;
	}

	public abstract void transliraj(Ta�ka novaReferentnaTa�ka);
	
	public abstract double obim();
	
	public abstract double povr�ina();
	
	public static void main (String [] args) {
		
		Krug k = new Krug (new Ta�ka(0,0),1);
		System.out.println("Krug: " + k);
		k.transliraj(new Ta�ka(1,1));
		System.out.println("Krug: " + k);
		System.out.println("Obim: " + k.obim());
		System.out.println("Povr�ina: " + k.povr�ina());
		
		System.out.println();
		
		Pravougaonik p = new Pravougaonik(new Ta�ka(1,2), new Ta�ka(3,5));
		System.out.println("Pravougaonik: " + p);
		System.out.println("Obim: " + p.obim());
		System.out.println("Povr�ina: " + k.povr�ina());
		
		
	}
	
 }
	
	
	
	
	
	
	
	
	
	
	
	


