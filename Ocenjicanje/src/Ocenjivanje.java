
public class Ocenjivanje {

	 public static void main (String[] args) {
		 
		 Student s = new Student ("Pera", "Peri� ", "6565651651", "peraperi�@gmail.com");
	 
		
		 
		 s.evidentirajTest(new Test("Programiranje1", "1. kolokvijum", 30, 20));
		 s.evidentirajTest(new Test("Programiranje1", "2. kolokvijum", 30, 16));
		 s.evidentirajTest(new Test("Programiranje1", "Zavr�ni ispit", 30, 10));
		 s.evidentirajTest(new Test("Baza podataka", "1. kolokvijum", 30, 17));
		 s.evidentirajTest(new Test("Baze podataka", "2. kolokvijum", 30, 11));
		 s.evidentirajTest(new Test("Baze podataka", "1. kolokvijum", 30, 11));
		 s.evidentirajTest(new Test("Programiranje1", "Zavr�ni projekat", 30, 18));

		 s.prikazRezultata();
		 
	 }
}
