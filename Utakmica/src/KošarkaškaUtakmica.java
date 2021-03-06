

public class KošarkaškaUtakmica {
	
	public static void main (String[] args) {
		
		Zapisnik z = new Zapisnik();
		Semafor s = new Semafor();
		MobilniTelefon m = new MobilniTelefon();
		
		System.out.println("Počinje derbi...");
		Utakmica derbi = new Utakmica("Partizan", "Zvezda");
		
		derbi.dodajPrenosnikUtakmice(z);
		derbi.dodajPrenosnikUtakmice(s);
		derbi.dodajPrenosnikUtakmice(m);
		
		System.out.println("Simulacija košarkaške utakmice...");
		derbi.domaćiPostigliKoš(3);
		derbi.gostiPostigliKoš(2);
		derbi.krajČetvrtine(1);
		
		derbi.krajČetvrtine(3);
		
		derbi.domaćiPostigliKoš(3);
		derbi.gostiPostigliKoš(3);
		derbi.domaćiPostigliKoš(3);
		
		derbi.krajČetvrtine(3);
		
		derbi.domaćiPostigliKoš(2);
		derbi.gostiPostigliKoš(2);
		derbi.krajČetvrtine(4);
		
		System.out.println();
		System.out.println("Završen derbi...");
		z.prikažiRezultat();
		
	}

}
