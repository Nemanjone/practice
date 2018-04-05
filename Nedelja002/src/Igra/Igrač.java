package Igra;

import jedinica.Brzina;
import jedinica.Lokacija;
import jedinica.Ugao;

public class Igra� extends PokretniObjekat {

	private String ime = "";
	private double snaga = 0;
	private double �ivot = 0;
	public Igra�(Lokacija lokacija, String slika, Brzina brzina) {
		super(lokacija, slika, brzina, Ugao.fromDegrees(0));
	}
	
	public String getIme() {
		return ime;
	}
	public void setIme(String ime) {
		this.ime = ime;
	}
	public double getSnaga() {
		return snaga;
	}
	public void setSnaga(double snaga) {
		this.snaga = snaga;
	}
	public double get�ivot() {
		return �ivot;
	}
	public void set�ivot(double �ivot) {
		this.�ivot = �ivot;
	}
	
	
	
	
}
