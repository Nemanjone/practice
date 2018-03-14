
public class PoliLinija {

	private PovezanaLista listaTemena;
	
	public PoliLinija (double [][] koordTemena) {
		
		listaTemena = new PovezanaLista();
		
		for ( int i = 0; i < koordTemena.length; i++) {
			Ta�ka t = new Ta�ka (koordTemena[i][0], koordTemena[i][1]);
			listaTemena.dodaj(t);
			
		}
		
	}
	
	public PoliLinija(Ta�ka[] temena) {
		listaTemena = new PovezanaLista();
		for (Ta�ka t : temena)
			listaTemena.dodaj(t);
		
	}
	
	public void dodajTeme (double x, double y) {
		listaTemena.dodaj(new Ta�ka(x,y));
	}
	
	public void dodajTeme(Ta�ka t) {
		listaTemena.dodaj(t);
	}
	
	public boolean na�iTeme(Ta�ka t) {
		return listaTemena.na�i(t);
	}
	
	public String toString () {
		return listaTemena.toString();
	}
	
	public static void main (String []args){
		double [][]  koordTemena = {{2,2}, {1,2},{-2,3},
				                     {3,-4}, {-1,-1}, {0,0}};
		
		PoliLinija pl = new PoliLinija(koordTemena);
		System.out.println("Poligonalna linija: ");
		System.out.println(pl);
		
		
		
	pl.dodajTeme(0.0,1.0);
	pl.dodajTeme(new Ta�ka(1,0));
	System.out.println(pl);
	
	Ta�ka t = new Ta�ka (0,0);
	System.out.println();
	System.out.print("Ta�ka " + t + " ");
	if ( pl.na�iTeme(t) == false)
		System.out.print("ni");
	System.out.println("je teme poligonalne linije");
	
	}
}

	class Ta�ka{
		
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

		public boolean equals(Object o) {
			Ta�ka t = (Ta�ka)o;
			return (this.x == t.x)&&(this.y == t.y);
		}
		
		public String toString () {
			return "(" + x +", " + y + ")";
		}
		
	}
	




	


