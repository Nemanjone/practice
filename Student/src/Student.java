
public class Student {

	private String ime, prezime, jmbg, indeks;

	public Student(String ime, String prezime, String jmbg, String indeks) {
		super();
		this.ime = ime;
		this.prezime = prezime;
		this.jmbg = jmbg;
		this.indeks = indeks;
	}

	public String getIme() {
		return ime;
	}

	public String getPrezime() {
		return prezime;
	}

	public String getJmbg() {
		return jmbg;
	}

	public String getIndeks() {
		return indeks;
	}

	@Override
	public String toString() {
		return "Student [ime=" + ime + ", prezime=" + prezime + ", jmbg=" + jmbg + ", indeks=" + indeks + "]";
	}

	
	
	
}
