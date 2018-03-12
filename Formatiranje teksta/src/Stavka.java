
public class Stavka {

	private String naziv;
	private double cena;
	
	public String getNaziv() {
		return naziv;
	}
	
	public double getCena() {
		return cena;
	}

	public Stavka(String naziv, double cena) {
		super();
		this.naziv = naziv;
		this.cena = cena;
	}
	
	public void �tampajStavku(int �irinaRa�una) {
		int �irinaZaNaziv = �irinaRa�una - 13; 
		
		String nazivZaIspis = getNaziv();
		
		if (getNaziv().length() > �irinaZaNaziv ) {
			nazivZaIspis = getNaziv().substring(0, �irinaZaNaziv -3) + "...";
			
		}
		
		String format1 = "%%-%ds%%12.2f\n";
		String format2 = String.format(format1, �irinaZaNaziv);
		
		System.out.printf(format2, nazivZaIspis, getCena());
		
	}
}
