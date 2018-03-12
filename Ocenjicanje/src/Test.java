

public class Test {

	private String Predmet;
	private String nazivTesta;
	private int brojPitanja;
	private double brojTaènihOdgovora;
	
	public String getPredmet() {
		return Predmet;
	}

	public String getNazivTesta() {
		return nazivTesta;
	}
	
	public int getBrojPitanja() {
		return brojPitanja;
	}
	
	public double getBrojTaènihOdgovora() {
		return brojTaènihOdgovora;
	}
	
	public double getBrojNetaènihOdgovora() {
		return brojPitanja = (int) brojTaènihOdgovora;
		
	}

	public Test(String predmet, String nazivTesta, int brojPitanja, double brojTaènihOdgovora) {
		super();
	    this.Predmet = predmet;
		this.nazivTesta = nazivTesta;
		this.brojPitanja = brojPitanja;
		this.brojTaènihOdgovora = brojTaènihOdgovora;
	}
	
	public double getBrojPoena() {
		return 30. * getBrojTaènihOdgovora()/getBrojPitanja();
	}
	
	public enum REZULTAT_TESTA {PAO, USLOVNO_POLOŽIO, POLOŽIO};
	
	public REZULTAT_TESTA oceniTest() {
		double poeni = getBrojPoena();
		if ( poeni < 11) {
			return REZULTAT_TESTA.PAO;
		}
		else if (poeni >= 11 && poeni < 17) {
			return REZULTAT_TESTA.USLOVNO_POLOŽIO;
		}else {
			return REZULTAT_TESTA.POLOŽIO;	
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
		case USLOVNO_POLOŽIO:
		opisnaOcena = "Uslovno položio";
		break;
		case POLOŽIO:
		opisnaOcena = "Položio";
		break;
		default:
			
		}
		
		
		return String.format("%-20s\t%-20s\t%6.2f / %3d\t%.2f\t%s",getPredmet(), getNazivTesta(),
				getBrojTaènihOdgovora(),getBrojPitanja(), getBrojPoena(),opisnaOcena);
		
	}	
}