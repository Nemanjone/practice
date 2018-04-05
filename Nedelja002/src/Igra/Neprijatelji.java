package Igra;

import jedinica.Brzina;
import jedinica.Lokacija;
import jedinica.Ugao;

public abstract class Neprijatelji extends PokretniObjekat {
	
	private double snaga = 0;
	private double �ivot = 0;
	public Neprijatelji(Lokacija lokacija, String slika, Brzina brzina, Ugao ugao) {
		super(lokacija, slika, brzina, Ugao.fromDegrees(0));
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
