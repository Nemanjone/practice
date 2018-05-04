import java.util.Scanner;
import java.util.concurrent.ConcurrentLinkedQueue;
import java.util.concurrent.LinkedBlockingQueue;

public class NBDViseNitiRestyle {      //Najveci broj delilaca sa vise niti

	private static int MAX = 100000;

	private static ConcurrentLinkedQueue<Task> taskQueue;

	private static LinkedBlockingQueue<Result> resultQueue; 


	private static class Task  {

		int min, max;

		public Task(int min, int max) {
			this.min = min;
			this.max = max;
		}

		public void izracunaj() {

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
			resultQueue.add((Result) new Result (najveciBrojDelilaca, brojSaNBD));
		}

	}

	private static class Result {
		
		int najveciBrojDelilacaOdTask;
		int brojSaNBDOdTask;
		
		Result(int najveciBrojDelilaca, int brojSaNBD) {
			najveciBrojDelilacaOdTask = najveciBrojDelilaca;
			brojSaNBDOdTask = brojSaNBD;
		}

	}

	private static class BrojacDelilacaSaNitima extends Thread {
		public void run() {
			while(true) {
				Task task = (Task) taskQueue.poll();
				if(task == null)
					break;
				task.izracunaj();
			}
		}
	}


	private static void brojacDelilacaSaNitima(int brojNiti) {

		System.out.println("\nBrojim delioce. Koristim " +  brojNiti + " niti.");
		System.out.println();

		long poèetnoVreme = System.currentTimeMillis();
		
		resultQueue = new LinkedBlockingQueue<Result>();

		taskQueue = new ConcurrentLinkedQueue<Task>();
		
		BrojacDelilacaSaNitima [] radnici = new BrojacDelilacaSaNitima[brojNiti];
		
		for (int i = 0; i < radnici.length; i++) {
			radnici[i] = new BrojacDelilacaSaNitima();
		}

		int brojZadataka = (MAX + 999) / 1000;
		
		for (int i = 0; i < brojZadataka; i++) {
			int pocetak = i * 1000 + 1;
			int kraj = (i + 1) * 1000;
			if (kraj > MAX)
				kraj = MAX;
			System.out.println(pocetak + " " + kraj);
			taskQueue.add(new Task(pocetak, kraj));
		}

		for (int i = 0; i < brojNiti; i++) {
			radnici[i].start();
		}
		int brojSaNBD = 0;
		int najveciBrojDelilaca = 0;
		for (int i = 0; i < brojZadataka; i++) {
			try {
				Result rezultat = resultQueue.take();
				if (rezultat.najveciBrojDelilacaOdTask > najveciBrojDelilaca) {
					najveciBrojDelilaca = rezultat.najveciBrojDelilacaOdTask;
					brojSaNBD = rezultat.brojSaNBDOdTask;
				}
			}
			catch (InterruptedException e) {

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
		tastatura.close();
	}

}








