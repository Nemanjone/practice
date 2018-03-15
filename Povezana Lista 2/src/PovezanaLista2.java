
public class PovezanaLista2 {
	
	private ElementListe prvi;
	private ElementListe poslednji;
	private ElementListe teku�i;
	private int n;
	
	public PovezanaLista2() {}
	
	public int du�ina() {
		return n;
	}
	
	public boolean praznaLista () {
		return n == 0;
	}
	
	public ElementListe teku�iPrvi() {
		teku�i = prvi;
		return teku�i;
	}
	
	public ElementListe teku�iSlede�i() {
		if (teku�i != poslednji) {
			teku�i = teku�i.getSlede�i();
			return teku�i;
		}
		else 
			return null;
	}
	
	public Object teku�iSadr�aj () {
		return teku�i.getSadr�aj();
	}
	
	public void dodaj(Object o)	{
		
		ElementListe noviElement = new ElementListe(o);
		
		if (praznaLista())
			prvi = poslednji = teku�i = noviElement;
		else {
			poslednji.setSlede�i(noviElement);
			poslednji = teku�i = noviElement;
		} n++;
	}
	
	public void dodajTeku�i(Object o) {
		ElementListe noviElem = new ElementListe(o);
		
		ElementListe prethodni = null;
		for (ElementListe elem = prvi; elem != teku�i; elem = elem.getSlede�i())
			prethodni = elem;
		if (prethodni == null) {
			noviElem.setSlede�i(prvi);
			if (du�ina() == 0)
				poslednji = noviElem;	
		}
		else {
			prethodni.setSlede�i(noviElem);
			noviElem.setSlede�i(teku�i);
			teku�i = noviElem;
		}n++; 
	}
	
	public void ukloniTeku�i () {
		if (praznaLista()) return;
		ElementListe prethodni = null;
		for (ElementListe elem = prvi; elem != teku�i; elem.getSlede�i())
			prethodni = elem;
		if (prethodni == null) {
			prvi = prvi.getSlede�i();
			teku�i = prvi;
			if (du�ina() == 1)
				poslednji =null;
		}
		else {
			ElementListe noviSlede�i = teku�i.getSlede�i();
			if (noviSlede�i == null)
				poslednji = teku�i = prethodni;
			else
				teku�i = noviSlede�i;
			prethodni.setSlede�i(noviSlede�i);
		}	n--;
	}
	
		public ElementListe na�i(Object o) {
			ElementListe elem;
			for ( elem = prvi; elem != null; elem = elem.getSlede�i()) {
				if (elem.getSadr�aj().equals(o)) {
					break; }}
			
			if (elem != null)
				teku�i = elem;
			return elem;
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
		
		public static void main (String []args) {
			
			PovezanaLista2 lista = new PovezanaLista2();
			
			Object o = new Integer(17);
			lista.dodaj(o);
			lista.dodaj(23);
			lista.dodaj(31);
			lista.dodaj(47);
			
			System.out.println("Sadr�aj liste: ");
			System.out.println(lista);
			System.out.println("Du�ina liste: " + lista.du�ina());
			
			lista.ukloniTeku�i();
			lista.teku�iPrvi();
			lista.ukloniTeku�i();
			lista.teku�iSlede�i();
			lista.teku�iSlede�i();
			lista.ukloniTeku�i();
			
			System.out.println("Sadr�aj liste: ");
			System.out.println(lista);
			System.out.println("Du�ina liste: " + lista.du�ina());
			
			int x = 31;
			
			System.out.println();
			if (lista.na�i((Integer)x) == null)
				System.out.println(" Objekat " + x + " nije na listi.");
			else
				System.out.println("Objekat " + x + " je na listi.");
			
			lista.ukloniTeku�i();
			
			System.out.println("Sadr�aj liste: ");
			System.out.println(lista);
			System.out.println("Du�ina liste: " + lista.du�ina());
			
		}
		
	}


