
public class U�enik extends Dete {

	private String �kola, razred;


	public U�enik(String ime, String uzrast, String �kola, String razred) {
		super(ime, uzrast);
		this.�kola = �kola;
		this.razred = razred;
	}

	public String get�kola() {
		return �kola;
	}

	public String getRazred() {
		return razred;
	}
	
	public void prika�i() {
		super.prika�i(
				);
		System.out.println("�kola: " + �kola);
		System.out.println("Razred: " + razred);
		
		
	}
}
