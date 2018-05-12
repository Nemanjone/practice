import java.util.*;

public class GA_16841316 {

	public static void main(String [] args) {
		
		System.out.println("Nemanja Balaban, 65656516419, 12.3.2018.");
		System.out.println();
		
		Scanner s = new Scanner(System.in);
		
		System.out.println("Koliko telefona želite da unesete? ");
		
		
		
		int broj = s.nextInt();
		
		if (broj < 1) {
			System.out.println("Broj koji ste uneli nije ispravan!");
			return;
		}
		
		MobilniTelefon[] niz = new MobilniTelefon [broj];
		
		for ( int i = 0; i < broj; i++) {
			
			System.out.println("Unesite ime proizvoðaèa: ");
			String proizvoðaè = s.next();	
			System.out.println("Unesite naziv modela: ");
			String model = s.next();
		    System.out.println("Unesite godinu proizvodnje: ");
			int godProizvodnje = s.nextInt();
			
			if (godProizvodnje < 1990 && godProizvodnje>2018) {
				System.out.println("Nije ispravna godina proizvodnje! ");
				return;
			}
			
			System.out.println("Unesite kolièinu RAM memorije: ");
			int kolièinaRAM = s.nextInt();
			
			if (kolièinaRAM < 1024) {
				System.out.println("Ne razmatramo te telefone! ");
				return;
			}
			
			System.out.println("Unesite kolièinu memorije na disku: ");
			int kolièinaDisk = s.nextInt();
			
			if (kolièinaDisk < 1024) {
				System.out.println("Ne razmatramo te telefone! ");
				return;
			}
			
			System.out.println("Unesite širinu ekrana u inèima: ");
			double širina = s.nextDouble();
			if ( širina < 2.0) {
				System.out.println("Ne razmatramo takve ureðaje! ");
				return;
			}
			System.out.println("Unesite visinu ekrana u inèima: ");
			double visina = s.nextDouble();
			if ( visina < 2.0){
				System.out.println("Ne razmatramo takve ureðaje! ");
				return;
		}
		
		
			niz[i] = new MobilniTelefon(
					proizvoðaè, 
					model, 
					godProizvodnje, 
					kolièinaRAM, 
					kolièinaDisk,
					new EkranTelefona(širina, visina));
		    }
		
		sortiraj(niz);
		MobilniTelefon najbolji = niz[0];
		
		System.out.println("Telefon koji ima najbolju ocenu je: " );
		System.out.println();
		System.out.println(najbolji);
		}
			
			public static void sortiraj (MobilniTelefon [] niz) {
				for ( int j = 0; j < niz.length -1; j++) {
					for ( int i  = 0; i<niz.length-1; i++) {
						
						if (niz[i].ocenaPodobnosti() < niz [i+1].ocenaPodobnosti()){
							MobilniTelefon.zameniMesto(niz[i], niz[i+1]);
						}
					}
				}
				
			}

}