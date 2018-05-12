

public class Test {

	private String Predmet;
	private String nazivTesta;
	private int brojPitanja;
	private double brojTa�nihOdgovora;
	
	public String getPredmet() {
		return Predmet;
	}

	public String getNazivTesta() {
		return nazivTesta;
	}
	
	public int getBrojPitanja() {
		return brojPitanja;
	}
	
	public double getBrojTa�nihOdgovora() {
		return brojTa�nihOdgovora;
	}
	
	public double getBrojNeta�nihOdgovora() {
		return brojPitanja = (int) brojTa�nihOdgovora;
		
	}

	public Test(String predmet, String nazivTesta, int brojPitanja, double brojTa�nihOdgovora) {
		super();
	    this.Predmet = predmet;
		this.nazivTesta = nazivTesta;
		this.brojPitanja = brojPitanja;
		this.brojTa�nihOdgovora = brojTa�nihOdgovora;
	}
	
	public double getBrojPoena() {
		return 30. * getBrojTa�nihOdgovora()/getBrojPitanja();
	}
	
	public enum REZULTAT_TESTA {PAO, USLOVNO_POLO�IO, POLO�IO};
	
	public REZULTAT_TESTA oceniTest() {
		double poeni = getBrojPoena();
		if ( poeni < 11) {
			return REZULTAT_TESTA.PAO;
		}
		else if (poeni >= 11 && poeni < 17) {
			return REZULTAT_TESTA.USLOVNO_POLO�IO;
		}else {
			return REZULTAT_TESTA.POLO�IO;	
	}	
 }

	@Override
	public String toString() {
		
		String opisnaOcena = null;
		
		REZULTAT_TESTA rezultat = oceniTest();
		
		switch (rezultat) {
		case PAO:
		opisnaOcena = "Pao";
		break;
		case USLOVNO_POLO�IO:
		opisnaOcena = "Uslovno polo�io";
		break;
		case POLO�IO:
		opisnaOcena = "Polo�io";
		break;
		default:
			
		}
		
		
		return String.format("%-20s\t%-20s\t%6.2f / %3d\t%.2f\t%s",getPredmet(), getNazivTesta(),
				getBrojTa�nihOdgovora(),getBrojPitanja(), getBrojPoena(),opisnaOcena);
		
	}	
}