
public class Karta {
	
	private  final BojaKarte boja;
	private final  Vrednost vrednost;

	public Karta(BojaKarte boja, Vrednost vrednost) {
		super();
		this.boja = boja;
		this.vrednost = vrednost;
	}
		
	public BojaKarte getBoja() {
		return boja;
	}

	public Vrednost getVrednost() {
		return vrednost;
	}
	
	@Override
	public String toString() {
		return boja + " " + vrednost;
	}

	public enum BojaKarte { SRCE, KARO, PIK, TREF;
		
	public String toString() {	
	
	switch (this)	{
	
	case  KARO: return "Karo";
	case SRCE: return "Srce";
	case PIK: return "Pik";
	case TREF: return "Tref";
	default:
		System.out.println("Ovaj slu�aj nije mogu�!");
		return null;
	}
	}
	
	}
	
	public enum Vrednost { AS, DVOJKU,TROJKA, �ETVORKA, PETICA, �ESTICA,SEDMICA,
		OSMICA, DEVETKA, DESETKA, �ANDAR, DAMA, KRALJ;
		
	public int pravaVrednost() {
		
		switch(this) {
		
		case �ANDAR: case DAMA: case KRALJ:
			return   2 + ordinal();
			default:
				return 1 + ordinal();
		}	
	}
	
	public String toString() {
		return "" + pravaVrednost();
	}
	
	}

	public static void main (String [] args) {
		
		System.out.println("�pil od 52 karte: \n");
		for (BojaKarte b: BojaKarte.values())
			for (Vrednost v: Vrednost.values()) {
				Karta karta = new Karta(b,v);
				System.out.println(karta);
				
			}
		
		
		
	}
}
