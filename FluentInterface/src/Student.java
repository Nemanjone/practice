
public class Student {

	private String ime, prezime, JMBG, indeks;

	public Student(String ime, String prezime, String jMBG, String indeks) {
		super();
		this.ime = ime;
		this.prezime = prezime;
		JMBG = jMBG;
		this.indeks = indeks;
	}

	public Student() {
		super();
	}

	public String getIme() {
		return ime;
	}

	public String getPrezime() {
		return prezime;
	}

	public String getJMBG() {
		return JMBG;
	}

	public String getIndeks() {
		return indeks;
	}

	public Student setIme(String ime) {
		this.ime = ime;
		return this;
	}

	public Student setPrezime(String prezime) {
		this.prezime = prezime;
		return this;
	}

	public Student setJMBG(String jMBG) {
		JMBG = jMBG;
		return this;
	}

	public Student setIndeks(String indeks) {
		this.indeks = indeks;
		return this;
	}

	@Override
	public String toString() {
		return "Student [ime=" + ime + ", prezime=" + prezime + ", JMBG=" + JMBG + ", indeks=" + indeks + "]";
	}

}
