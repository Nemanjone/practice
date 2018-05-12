
public class PovezanaLista {

	private ElementListe prvi;
	private ElementListe poslednji;
	private int n;
	
	public PovezanaLista() {}
	
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
		
	}