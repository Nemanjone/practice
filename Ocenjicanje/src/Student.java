
public class Student {

	private String ime, prezime, indeks, email;
	private int godinaUpisa;
	
	private final int MAX_BROJ_TESTOVA = 480;
	
	private Test[] testoviStudenta = new Test[MAX_BROJ_TESTOVA];
	
	private int indeksSlede�egTesta = 0;
	
	public void evidentirajTest(Test test){
		
		if (indeksSlede�egTesta < MAX_BROJ_TESTOVA) {
			testoviStudenta[indeksSlede�egTesta] =test;
			indeksSlede�egTesta++;
		}
	}
	
	public void prikazRezultata() {
		System.out.println("Rezultati testova studenta " + getIme() + " "+
				           getPrezime() + " (" + getIndeks() + ") ");
		System.out.println();
		for ( int i= 0; i < indeksSlede�egTesta; i++) {
			System.out.println(testoviStudenta[i]);
		}
	}

	public String getIme() {
		return ime;
	}

	public String getPrezime() {
		return prezime;
	}

	public String getIndeks() {
		return indeks;
	}

	public String getEmail() {
		return email;
	}

	public Student(String ime, String prezime, String indeks, String email) {
		super();
		this.ime = ime;
		this.prezime = prezime;
		this.indeks = indeks;
		this.email = email;
	

	if (indeks.length() == 10 && 
			Character.isDigit(indeks.charAt(0)) &&
	        Character.isDigit(indeks.charAt(1))&& 
	        Character.isDigit(indeks.charAt(2))&&
	        Character.isDigit(indeks.charAt(3)));
	        this.godinaUpisa = Integer.parseInt(indeks.substring(0,4));
	}
  
  }

