

public class ElementListe {

	private String imeElementa;
	private int vrednostElementa;
	private String defElementa;
	
	public ElementListe(String imeElementa, int vrednostElementa, String defElementa) {
		super();
		this.imeElementa = imeElementa;
		this.vrednostElementa = vrednostElementa;
		this.defElementa = defElementa;
	}
	public String getImeElementa() {
		return imeElementa;
	}
	
	public int getVrednostElementa() {
		return vrednostElementa;
	}
	
	public String getDefElementa() {
		return defElementa;
	}
	
	
	@Override
	public String toString() {
		return "ElementListe [imeElementa=" + imeElementa + ", vrednostElementa=" + vrednostElementa + ", defElementa="
				+ defElementa + "]";
	}
	
	
	

		
}

