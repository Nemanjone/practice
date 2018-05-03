import java.util.Scanner;

public class NBDViseNiti {                      //Najveci broj delilaca sa vise niti

	private static int MAX = 100000;

	private volatile static int najveciBrojDelilaca = 0;

	private volatile static int brojSaNBD;

	synchronized private static void izvestaj(int najveciBrojDelilacaNiti, int brojSaNBDNiti) {
		if (najveciBrojDelilacaNiti > najveciBrojDelilaca) {
			najveciBrojDelilaca = najveciBrojDelilacaNiti;
			brojSaNBD = brojSaNBDNiti;

		}
	}

	private static class NBD_Niti extends Thread {
		
		int min, max;

		public NBD_Niti(int min, int max) {
			this.min = min;
			this.max = max;
		}

		public void run() {

			System.out.println("Nit " + this + " traži broj u rasponu od " + min + " do " + max + ".");

			long poèetnoVreme = System.currentTimeMillis();

			int brojSaNBD = 0;
			int najveciBrojDelilaca = 0;
			int brojDelilaca;

			for (int i = min; i < max; i++) {
				brojDelilaca = 0;
				for (int j = 1; j <= i; j++) {
					if (i % j == 0) {
						brojDelilaca++;
					}
					if (najveciBrojDelilaca < brojDelilaca) {
						najveciBrojDelilaca = brojDelilaca;
						brojSaNBD = i;
					}
				}
			}

			long ukupnoVreme = System.currentTimeMillis() - poèetnoVreme;
			System.out.println("Nit " + this + " je radila " + (ukupnoVreme / 1000) + " sekundi.");
			izvestaj(najveciBrojDelilaca, brojSaNBD);
		}	
	}

	private static void brojacDelilacaSaNitima( int brojNiti) {

		System.out.println("\nBrojim delioce. Koristim " +  brojNiti + " niti.");
		System.out.println();
		long poèetnoVreme = System.currentTimeMillis();
		NBD_Niti [] radnici = new NBD_Niti[brojNiti];
		int integeraPoNiti = MAX / brojNiti;
		int pocetak = 1;
		int kraj = pocetak + integeraPoNiti - 1;
		for (int i = 0; i < brojNiti; i++) {
			if(i == brojNiti -1) {
				kraj = MAX;
			}
			radnici[i] = new NBD_Niti(pocetak, kraj);
			pocetak = kraj + 1;
			kraj = pocetak + integeraPoNiti -1;
		}
	
		for (int i = 0; i < brojNiti; i++) 
			radnici[i].start();

		for (int i = 0; i < brojNiti; i++) {
			while(radnici[i].isAlive()) {
				try {
					radnici[i].join();
				}
				catch (InterruptedException e) {

				}
			}
		}
		long ukupnoVreme = System.currentTimeMillis() - poèetnoVreme;
		System.out.println("\nNajveæi broj delilaca za brojeve od 1 do " + MAX + " je " + najveciBrojDelilaca + ".");
		System.out.println("Broj sa najvecim brojem delilaca je: " + brojSaNBD);
		System.out.println("Ukupno vreme je: " + (ukupnoVreme / 1000) + " sekundi.\n");
	}

	public static void main(String[] args) {

		Scanner tastatura = new Scanner(System.in);

		int brojNiti = 0;
		while (brojNiti < 1 || brojNiti > 10) {
			System.out.print("Koliko niti zelite da koristite (1 -10)? ");
			brojNiti = tastatura.nextInt();
			if (brojNiti < 1 || brojNiti > 10)
				System.out.println("Morate da uneset broj od 1 do 10!");
		}
		brojacDelilacaSaNitima(brojNiti);
	}



}


