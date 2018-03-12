
public class Ocenjivanje {

	 public static void main (String[] args) {
		 
		 Student s = new Student ("Pera", "Periæ ", "6565651651", "peraperiæ@gmail.com");
	 
		
		 
		 s.evidentirajTest(new Test("Programiranje1", "1. kolokvijum", 30, 20));
		 s.evidentirajTest(new Test("Programiranje1", "2. kolokvijum", 30, 16));
		 s.evidentirajTest(new Test("Programiranje1", "Završni ispit", 30, 10));
		 s.evidentirajTest(new Test("Baza podataka", "1. kolokvijum", 30, 17));
		 s.evidentirajTest(new Test("Baze podataka", "2. kolokvijum", 30, 11));
		 s.evidentirajTest(new Test("Baze podataka", "1. kolokvijum", 30, 11));
		 s.evidentirajTest(new Test("Programiranje1", "Završni projekat", 30, 18));

		 s.prikazRezultata();
		 
	 }
}
