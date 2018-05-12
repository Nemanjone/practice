
  public class ElementListe {

	private Object sadržaj;
	private ElementListe sledeæi;
	
	public Object getSadržaj() {
		return sadržaj;
	}

	public ElementListe getSledeæi() {
		return sledeæi;
	}
	
	public void setSledeæi(ElementListe elem) {
		sledeæi = elem;
	}
	

	public ElementListe(Object o) {
		super();
		 sadržaj = o;
	}

	@Override
	public String toString() {
		return "ElementListe [sadržaj=" + sadržaj + "]";
	}
	
}