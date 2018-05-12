
public class PovezanaLista1 {

	private ElementListe prvi;
	private ElementListe poslednji;
	private int n;
	
	public PovezanaLista1() {}
	
	public int dužina() {
		return n;
	}
	
	public boolean praznaLista () {
		return prvi == null;
	}
	
	public void dodaj(Object o)	{
		
		ElementListe noviElement = new ElementListe(o);
		
		if (praznaLista())
			prvi = poslednji = noviElement;
		else {
			poslednji.setSledeæi(noviElement);
			poslednji = noviElement;
		} n++;
	}
	
		public boolean naði(Object o) {
			ElementListe elem;
			for ( elem = prvi; elem != null; elem = elem.getSledeæi()) {
				if (elem.getSadržaj().equals(o)) {
					break; }}
			
			return (elem != null);
		}
		
		public String toString() {
			String s = "";
			for (ElementListe elem = prvi; elem != null; elem = elem.getSledeæi()) {
				s = s + elem.toString() + ", ";
			}
			if (poslednji != null)
				s = s + poslednji.toString();
			return s;
		}
		
		public static void main (String []args) {
			
			PovezanaLista1 lista = new PovezanaLista1();
			
			Object o = new Integer(17);
			lista.dodaj(o);
			lista.dodaj(23);
			lista.dodaj(31);
			lista.dodaj(47);
			
			System.out.println("Sadržaj liste: ");
			System.out.println(lista);
			System.out.println("Dužina liste: " + lista.dužina());
			
			int x = 23;
			
			System.out.println();
			if (lista.naði((Integer)x) == false)
				System.out.println(" Objekat " + x + " nije na listi.");
			else
				System.out.println("Objekat " + x + " je na listi.");
			
			
		}
		
	}

