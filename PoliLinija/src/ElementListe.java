
  public class ElementListe {

	private Object sadr�aj;
	private ElementListe slede�i;
	
	public Object getSadr�aj() {
		return sadr�aj;
	}

	public ElementListe getSlede�i() {
		return slede�i;
	}
	
	public void setSlede�i(ElementListe elem) {
		slede�i = elem;
	}
	

	public ElementListe(Object o) {
		super();
		 sadr�aj = o;
	}

	@Override
	public String toString() {
		return "ElementListe [sadr�aj=" + sadr�aj + "]";
	}
	
}