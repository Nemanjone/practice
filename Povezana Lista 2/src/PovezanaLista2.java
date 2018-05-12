
public class PovezanaLista2 {
	
	private ElementListe prvi;
	private ElementListe poslednji;
	private ElementListe tekuæi;
	private int n;
	
	public PovezanaLista2() {}
	
	public int dužina() {
		return n;
	}
	
	public boolean praznaLista () {
		return n == 0;
	}
	
	public ElementListe tekuæiPrvi() {
		tekuæi = prvi;
		return tekuæi;
	}
	
	public ElementListe tekuæiSledeæi() {
		if (tekuæi != poslednji) {
			tekuæi = tekuæi.getSledeæi();
			return tekuæi;
		}
		else 
			return null;
	}
	
	public Object tekuæiSadržaj () {
		return tekuæi.getSadržaj();
	}
	
	public void dodaj(Object o)	{
		
		ElementListe noviElement = new ElementListe(o);
		
		if (praznaLista())
			prvi = poslednji = tekuæi = noviElement;
		else {
			poslednji.setSledeæi(noviElement);
			poslednji = tekuæi = noviElement;
		} n++;
	}
	
	public void dodajTekuæi(Object o) {
		ElementListe noviElem = new ElementListe(o);
		
		ElementListe prethodni = null;
		for (ElementListe elem = prvi; elem != tekuæi; elem = elem.getSledeæi())
			prethodni = elem;
		if (prethodni == null) {
			noviElem.setSledeæi(prvi);
			if (dužina() == 0)
				poslednji = noviElem;	
		}
		else {
			prethodni.setSledeæi(noviElem);
			noviElem.setSledeæi(tekuæi);
			tekuæi = noviElem;
		}n++; 
	}
	
	public void ukloniTekuæi () {
		if (praznaLista()) return;
		ElementListe prethodni = null;
		for (ElementListe elem = prvi; elem != tekuæi; elem.getSledeæi())
			prethodni = elem;
		if (prethodni == null) {
			prvi = prvi.getSledeæi();
			tekuæi = prvi;
			if (dužina() == 1)
				poslednji =null;
		}
		else {
			ElementListe noviSledeæi = tekuæi.getSledeæi();
			if (noviSledeæi == null)
				poslednji = tekuæi = prethodni;
			else
				tekuæi = noviSledeæi;
			prethodni.setSledeæi(noviSledeæi);
		}	n--;
	}
	
		public ElementListe naði(Object o) {
			ElementListe elem;
			for ( elem = prvi; elem != null; elem = elem.getSledeæi()) {
				if (elem.getSadržaj().equals(o)) {
					break; }}
			
			if (elem != null)
				tekuæi = elem;
			return elem;
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
			
			PovezanaLista2 lista = new PovezanaLista2();
			
			Object o = new Integer(17);
			lista.dodaj(o);
			lista.dodaj(23);
			lista.dodaj(31);
			lista.dodaj(47);
			
			System.out.println("Sadržaj liste: ");
			System.out.println(lista);
			System.out.println("Dužina liste: " + lista.dužina());
			
			lista.ukloniTekuæi();
			lista.tekuæiPrvi();
			lista.ukloniTekuæi();
			lista.tekuæiSledeæi();
			lista.tekuæiSledeæi();
			lista.ukloniTekuæi();
			
			System.out.println("Sadržaj liste: ");
			System.out.println(lista);
			System.out.println("Dužina liste: " + lista.dužina());
			
			int x = 31;
			
			System.out.println();
			if (lista.naði((Integer)x) == null)
				System.out.println(" Objekat " + x + " nije na listi.");
			else
				System.out.println("Objekat " + x + " je na listi.");
			
			lista.ukloniTekuæi();
			
			System.out.println("Sadržaj liste: ");
			System.out.println(lista);
			System.out.println("Dužina liste: " + lista.dužina());
			
		}
		
	}


