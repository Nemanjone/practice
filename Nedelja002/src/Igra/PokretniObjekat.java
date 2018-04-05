package Igra;

import jedinica.Brzina;
import jedinica.Du�ina;
import jedinica.Lokacija;
import jedinica.Ugao;
import jedinica.Vreme;

public  abstract class  PokretniObjekat extends Objekat {
	
	private Brzina brzina;
	private Ugao ugao;

	public PokretniObjekat(Lokacija lokacija, String slika, Brzina brzina, Ugao ugao) {
		super(lokacija, slika);
		this.brzina = brzina;
		this.ugao = ugao;
	}

	public Brzina getBrzina() {
		return brzina;
	}
	
	public Ugao getUgao() {
		return ugao;
	}
	
	public void move (Vreme vreme) {
		Du�ina du�inaPuta = brzina.pre�eniPut(vreme);
		getLokacija().move(ugao, du�inaPuta);
	}
	

}
