package Igra;

import jedinica.Brzina;
import jedinica.Lokacija;
import jedinica.Ugao;

public class Vuk extends Neprijatelji {
	
	private String boja;

	public Vuk(Lokacija lokacija, String slika, Brzina brzina, String boja) {
		super(lokacija, slika, brzina, Ugao.fromDegrees(0));
		this.boja = boja;
	}

	public String getBoja() {
		return boja;
	}
	
	

}
