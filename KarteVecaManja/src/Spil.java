
public class Spil {

	private Karta[] spil;

	private int koriscenjeKarte;

	public Spil() {
		this(false);  // Ima jos jedan konstruktor
		
	}

	public Spil(boolean ubaciDzokere) {
		if (ubaciDzokere)
			spil = new Karta[54];
		else
			spil = new Karta[52];
		int brojKreiranihKarata = 0; 
		for ( int boja = 0; boja <= 3; boja++ ) {
			for ( int vrednost = 1; vrednost <= 13; vrednost++ ) {
				spil[brojKreiranihKarata] = new Karta(vrednost,boja);
				brojKreiranihKarata++;
			}
		}
		if (ubaciDzokere) {
			spil[52] = new Karta(1,Karta.JOKER);
			spil[53] = new Karta(2,Karta.JOKER);
		}
		koriscenjeKarte = 0;
	}

	public void promesaj() {
		for ( int i = spil.length-1; i > 0; i-- ) {
			int rand = (int)(Math.random()*(i+1));
			Karta temp = spil[i];
			spil[i] = spil[rand];
			spil[rand] = temp;
		}
		koriscenjeKarte = 0;
	}

	public int karteKojeSuOstale() {
		return spil.length - koriscenjeKarte;
	}

	public Karta deliKarte() {
		if (koriscenjeKarte == spil.length)
			throw new IllegalStateException("Nema više karata u špilu.");
		koriscenjeKarte++;
		return spil[koriscenjeKarte - 1];
	}

	public boolean imaLiDzokera() {
		return (spil.length == 54);
	}
} 
