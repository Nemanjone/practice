
public class Karta {

	public final static int PIK = 0;  
	public final static int SRCE = 1;
	public final static int KOCKA = 2;
	public final static int TREF = 3;
	public final static int JOKER = 4;

	public final static int AS = 1;      
	public final static int ŽANDAR = 11;    
	public final static int KRALJICA = 12;   
	public final static int KRALJ = 13;

	private final int boja; 
	private final int vrednost;

	public Karta() {
		boja = JOKER;
		vrednost = 1;
	}

	public Karta(int novaVrednost, int novaBoja) {
		if (novaBoja != PIK && novaBoja != SRCE && novaBoja != KOCKA && 
				novaBoja != TREF && novaBoja != JOKER)
			throw new IllegalArgumentException("Nedozvoljena boja za kartu!");
		if (novaBoja != JOKER && (novaVrednost < 1 || novaVrednost > 13))
			throw new IllegalArgumentException("Nedozvoljena vrednost za kartu!");
		vrednost = novaVrednost;
		boja = novaBoja;
	}

	public int getBoja() {
		return boja;
	}

	public int getVrednost() {
		return vrednost;
	}

	public String getBojaString() {
		switch (boja) {
		case PIK:    return "Pik";
		case SRCE:   return "Srce";
		case KOCKA:  return "Kocka";
		case TREF:   return "Tref";
		default:     return "Joker";
		}
	}

	public String getVrednostString() {
		if (boja == JOKER)
			return "" + vrednost;
		else {
			switch (vrednost) {
			case 1:   return "As";
			case 2:   return "2";
			case 3:   return "3";
			case 4:   return "4";
			case 5:   return "5";
			case 6:   return "6";
			case 7:   return "7";
			case 8:   return "8";
			case 9:   return "9";
			case 10:  return "10";
			case 11:  return "Žandar";
			case 12:  return "Kraljica";
			default:  return "Kralj";
			}
		}
	}

	public String toString() {
		if (boja == JOKER) {
			if (vrednost == 1)
				return "Joker";
			else
				return "Joker #" + vrednost;
		}
		else
			return getVrednostString() + " " + getBojaString();
	}
} 
