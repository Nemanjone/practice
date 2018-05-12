


public class Igrac {

	String poeni, skokovi, asistencije, ukradeneLopte, blokade;

	public Igrac(String poeni, String skokovi, String asistencije, 
			String ukradeneLopte, String blokade) {
		super();
		this.poeni = poeni;
		this.skokovi = skokovi;
		this.asistencije = asistencije;
		this.ukradeneLopte = ukradeneLopte;
		this.blokade = blokade;
	}

	public String getPoeni() {
		return poeni;
	}

	public String getSkokovi() {
		return skokovi;
	}
	
	public String getAsistencije() {
		return asistencije;
	}
	
	public String getUkradeneLopte() {
		return ukradeneLopte;
	}

	public String getBlokade() {
		return blokade;
	}
	
	@Override
	public String toString() {
		return "[poeni=" + poeni + ", skokovi=" + skokovi + ", asistencije =" + asistencije + ", ukradeneLopte ="
				+ ukradeneLopte + ", blokade =" + blokade + "]";
	}




}

