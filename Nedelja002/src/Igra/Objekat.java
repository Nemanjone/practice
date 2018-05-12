package Igra;

import jedinica.Dužina;
import jedinica.Lokacija;

public abstract class Objekat {
	
	private Lokacija lokacija;
	private String slika;
	
	public Objekat(Lokacija lokacija, String slika) {
		super();
		this.lokacija = lokacija;
		this.slika = slika;
	}

	public Lokacija getLokacija() {
		return lokacija;
	}

	public String getSlika() {
		return slika;
	}
	
	
	
	
	
	

}
