import java.util.*;

public class GA_16841316 {

	public static void main(String [] args) {
		
		System.out.println("Nemanja Balaban, 65656516419, 12.3.2018.");
		System.out.println();
		
		Scanner s = new Scanner(System.in);
		
		System.out.println("Koliko telefona �elite da unesete? ");
		
		
		
		int broj = s.nextInt();
		
		if (broj < 1) {
			System.out.println("Broj koji ste uneli nije ispravan!");
			return;
		}
		
		MobilniTelefon[] niz = new MobilniTelefon [broj];
		
		for ( int i = 0; i < broj; i++) {
			
			System.out.println("Unesite ime proizvo�a�a: ");
			String proizvo�a� = s.next();	
			System.out.println("Unesite naziv modela: ");
			String model = s.next();
		    System.out.println("Unesite godinu proizvodnje: ");
			int godProizvodnje = s.nextInt();
			
			if (godProizvodnje < 1990 && godProizvodnje>2018) {
				System.out.println("Nije ispravna godina proizvodnje! ");
				return;
			}
			
			System.out.println("Unesite koli�inu RAM memorije: ");
			int koli�inaRAM = s.nextInt();
			
			if (koli�inaRAM < 1024) {
				System.out.println("Ne razmatramo te telefone! ");
				return;
			}
			
			System.out.println("Unesite koli�inu memorije na disku: ");
			int koli�inaDisk = s.nextInt();
			
			if (koli�inaDisk < 1024) {
				System.out.println("Ne razmatramo te telefone! ");
				return;
			}
			
			System.out.println("Unesite �irinu ekrana u in�ima: ");
			double �irina = s.nextDouble();
			if ( �irina < 2.0) {
				System.out.println("Ne razmatramo takve ure�aje! ");
				return;
			}
			System.out.println("Unesite visinu ekrana u in�ima: ");
			double visina = s.nextDouble();
			if ( visina < 2.0){
				System.out.println("Ne razmatramo takve ure�aje! ");
				return;
		}
		
		
			niz[i] = new MobilniTelefon(
					proizvo�a�, 
					model, 
					godProizvodnje, 
					koli�inaRAM, 
					koli�inaDisk,
					new EkranTelefona(�irina, visina));
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