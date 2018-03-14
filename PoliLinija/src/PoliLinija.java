
public class PoliLinija {

	private PovezanaLista listaTemena;
	
	public PoliLinija (double [][] koordTemena) {
		
		listaTemena = new PovezanaLista();
		
		for ( int i = 0; i < koordTemena.length; i++) {
			Taèka t = new Taèka (koordTemena[i][0], koordTemena[i][1]);
			listaTemena.dodaj(t);
			
		}
		
	}
	
	public PoliLinija(Taèka[] temena) {
		listaTemena = new PovezanaLista();
		for (Taèka t : temena)
			listaTemena.dodaj(t);
		
	}
	
	public void dodajTeme (double x, double y) {
		listaTemena.dodaj(new Taèka(x,y));
	}
	
	public void dodajTeme(Taèka t) {
		listaTemena.dodaj(t);
	}
	
	public boolean naðiTeme(Taèka t) {
		return listaTemena.naði(t);
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
	pl.dodajTeme(new Taèka(1,0));
	System.out.println(pl);
	
	Taèka t = new Taèka (0,0);
	System.out.println();
	System.out.print("Taèka " + t + " ");
	if ( pl.naðiTeme(t) == false)
		System.out.print("ni");
	System.out.println("je teme poligonalne linije");
	
	}
}

	class Taèka{
		
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

		public boolean equals(Object o) {
			Taèka t = (Taèka)o;
			return (this.x == t.x)&&(this.y == t.y);
		}
		
		public String toString () {
			return "(" + x +", " + y + ")";
		}
		
	}
	




	


