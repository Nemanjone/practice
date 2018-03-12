
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
	
	public void štampajStavku(int širinaRaèuna) {
		int širinaZaNaziv = širinaRaèuna - 13; 
		
		String nazivZaIspis = getNaziv();
		
		if (getNaziv().length() > širinaZaNaziv ) {
			nazivZaIspis = getNaziv().substring(0, širinaZaNaziv -3) + "...";
			
		}
		
		String format1 = "%%-%ds%%12.2f\n";
		String format2 = String.format(format1, širinaZaNaziv);
		
		System.out.printf(format2, nazivZaIspis, getCena());
		
	}
}
