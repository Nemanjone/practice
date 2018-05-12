
public class UËenik extends Dete {

	private String ökola, razred;


	public UËenik(String ime, String uzrast, String ökola, String razred) {
		super(ime, uzrast);
		this.ökola = ökola;
		this.razred = razred;
	}

	public String getäkola() {
		return ökola;
	}

	public String getRazred() {
		return razred;
	}
	
	public void prikaûi() {
		super.prikaûi(
				);
		System.out.println("äkola: " + ökola);
		System.out.println("Razred: " + razred);
		
		
	}
}
