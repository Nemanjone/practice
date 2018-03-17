

public class KošarkaškaUtakmica {
	
	public static void main (String[] args) {
		
		Zapisnik z = new Zapisnik();
		Semafor s = new Semafor();
		MobilniTelefon m = new MobilniTelefon();
		
		System.out.println("Poèinje derbi...");
		Utakmica derbi = new Utakmica("Partizan", "Zvezda");
		
		derbi.dodajPrenosnikUtakmice(z);
		derbi.dodajPrenosnikUtakmice(s);
		derbi.dodajPrenosnikUtakmice(m);
		
		System.out.println("Simulacija košarkaške utakmice...");
		derbi.domaæiPostigliKoš(3);
		derbi.gostiPostigliKoš(2);
		derbi.krajÈetvrtine(1);
		
		derbi.krajÈetvrtine(3);
		
		derbi.domaæiPostigliKoš(3);
		derbi.gostiPostigliKoš(3);
		derbi.domaæiPostigliKoš(3);
		
		derbi.krajÈetvrtine(3);
		
		derbi.domaæiPostigliKoš(2);
		derbi.gostiPostigliKoš(2);
		derbi.krajÈetvrtine(4);
		
		System.out.println();
		System.out.println("Završen derbi...");
		z.prikažiRezultat();
		
	}

}
