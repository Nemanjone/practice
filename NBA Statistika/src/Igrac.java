

public class Igrac  {
	
	//name, pts, reb, ast, stl, blk
	
	String ime;
	double poeni, skokovi, asistencije, ukradeneLopte, blokade;

	public Igrac(String ime, double poeni, double skokovi, double asistencije, 
				double ukradeneLopte, double blokade) {
		super();
		this.ime = ime;
		this.poeni = poeni;
		this.skokovi = skokovi;
		this.asistencije = asistencije;
		this.ukradeneLopte = ukradeneLopte;
		this.blokade = blokade;
	}
	public String getIme() {
		return ime;
	}
	public void setIme(String ime) {                            //udario sam i setere, pa nek ide život...
		this.ime = ime;
	}
	public double getPoeni() {
		return poeni;
	}
	public void setPoeni(double poeni) {
		this.poeni = poeni;
	}
	public double getSkokovi() {
		return skokovi;
	}
	public void setSkokovi(double skokovi) {
		this.skokovi = skokovi;
	}
	public double getAsistencije() {
		return asistencije;
	}
	public void setAsistencije(double asistencije) {
		this.asistencije = asistencije;
	}
	public double getUkradeneLopte() {
		return ukradeneLopte;
	}
	public void setUkradeneLopte(double ukradeneLopte) {
		this.ukradeneLopte = ukradeneLopte;
	}
	public double getBlokade() {
		return blokade;
	}
	public void setBlokade(double blokovi) {
		this.blokade = blokovi;
	}

	


}
