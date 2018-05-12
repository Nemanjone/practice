
public class PovezanaLista {

	private ElementListe prvi;
	private ElementListe poslednji;
	private int n;
	
	public PovezanaLista() {}
	
	public int du�ina() {
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
			poslednji.setSlede�i(noviElement);
			poslednji = noviElement;
		} n++;
	}
	
		public boolean na�i(Object o) {
			ElementListe elem;
			for ( elem = prvi; elem != null; elem = elem.getSlede�i()) {
				if (elem.getSadr�aj().equals(o)) {
					break; }}
			
			return (elem != null);
		}
		
		public String toString() {
			String s = "";
			for (ElementListe elem = prvi; elem != null; elem = elem.getSlede�i()) {
				s = s + elem.toString() + ", ";
			}
			if (poslednji != null)
				s = s + poslednji.toString();
			return s;
		}
		
	}