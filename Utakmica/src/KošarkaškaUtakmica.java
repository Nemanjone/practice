

public class Ko�arka�kaUtakmica {
	
	public static void main (String[] args) {
		
		Zapisnik z = new Zapisnik();
		Semafor s = new Semafor();
		MobilniTelefon m = new MobilniTelefon();
		
		System.out.println("Po�inje derbi...");
		Utakmica derbi = new Utakmica("Partizan", "Zvezda");
		
		derbi.dodajPrenosnikUtakmice(z);
		derbi.dodajPrenosnikUtakmice(s);
		derbi.dodajPrenosnikUtakmice(m);
		
		System.out.println("Simulacija ko�arka�ke utakmice...");
		derbi.doma�iPostigliKo�(3);
		derbi.gostiPostigliKo�(2);
		derbi.kraj�etvrtine(1);
		
		derbi.kraj�etvrtine(3);
		
		derbi.doma�iPostigliKo�(3);
		derbi.gostiPostigliKo�(3);
		derbi.doma�iPostigliKo�(3);
		
		derbi.kraj�etvrtine(3);
		
		derbi.doma�iPostigliKo�(2);
		derbi.gostiPostigliKo�(2);
		derbi.kraj�etvrtine(4);
		
		System.out.println();
		System.out.println("Zavr�en derbi...");
		z.prika�iRezultat();
		
	}

}
