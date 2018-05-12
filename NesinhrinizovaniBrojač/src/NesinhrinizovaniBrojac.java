import java.util.Scanner;

public class NesinhrinizovaniBrojac {

	static class Brojac {
		int brojac;
		
		void uvecaj() {
			brojac = brojac +1;
		}
		
		int getBrojac() {
			return brojac;
		}
	}

	static Brojac brojac;
	static int brojPovecanja;

	static class NitKojaUvecava extends Thread {
		public void run() {
			for (int i = 0; i < brojPovecanja; i++) {
				brojac.uvecaj();	
			}
		}
	}

	public static void main(String[] args) {

		Scanner tastatura = new Scanner(System.in);

		while (true) {

			System.out.println();
			System.out.print("Koliko niti zelite da startujete (upisite 0 za kraj)? ");
			int brojNiti = tastatura.nextInt();
			if (brojNiti <= 0)
				break;

			do {
				System.out.println();
				System.out.println("Koliko puta svaka nit treba da poveca brojac?");
				brojPovecanja = tastatura.nextInt();
				if (brojPovecanja < 1) {
					System.out.println("Broj povacanja mora biti pozitivan!");
					brojPovecanja = 1;
				}
			}
			
			while (brojPovecanja <= 0);

			System.out.println();
			System.out.println(brojNiti + " niti  uvacavaju brojac " + brojPovecanja + " puta");

			System.out.println();
			System.out.println("Radim...");
			System.out.println();
			NitKojaUvecava[] radnici = new NitKojaUvecava[brojNiti];
			brojac = new Brojac();
			for (int i = 0; i < brojNiti; i++) 
				radnici[i] = new NitKojaUvecava();
			for (int i = 0; i < brojNiti; i++) 
				radnici[i].start();

			for (int i = 0; i < brojNiti; i++) {
				try {
					radnici[i].join();
				}
				catch (InterruptedException e) {}
			}

			System.out.println("Finalna vrednost brojaèa bi trebalo da bude: " +
					brojPovecanja * brojNiti);
			System.out.println("Aktuelna vrednost brojaèa je: " + brojac.getBrojac());
			System.out.println();
			System.out.println();

		}
		tastatura.close();
	}
}

