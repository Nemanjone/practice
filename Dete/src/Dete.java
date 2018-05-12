
public class Dete {

	private String ime, uzrast;

	
	public Dete(String ime, String uzrast) {
		super();
		this.ime = ime;
		this.uzrast = uzrast;
	}

	public String getIme() {
		return ime;
	}


	public String getUzrast() {
		return uzrast;
	}
	
	public void prikaži() {
		System.out.println("Ime:" + ime);
		System.out.println("Uzrast: " + uzrast);
			
	}
	
}
