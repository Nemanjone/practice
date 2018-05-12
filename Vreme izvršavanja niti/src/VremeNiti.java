
public class VremeNiti {
	
	public static void main (String [] args) {
		
		Runnable java = new PrikazTeksta("Java", 20);
		Runnable cpp = new PrikazTeksta ("C++", 20);
		Runnable niz = new PrikazBrojeva(20);
		
		Thread nitJava = new Thread(java);
		Thread nitCpp = new Thread(cpp);
		Thread nitNiz = new Thread(niz);
		
		long poèetak = System.currentTimeMillis();
		
		nitJava.start();
		nitCpp.start();
		nitNiz.start();
	
	
	try {
		nitJava.join();
		nitCpp.join();
		nitNiz.join();
	}
	catch (InterruptedException e) {
		
	}

	long ukupnoVreme = System.currentTimeMillis() - poèetak;
	System.out.println("\n");
	System.out.print("Ukupno vreme izvršavanja tri niti: ");
	System.out.println(ukupnoVreme/1000.0 + " sekundi.");
	}
}

class PrikazTeksta implements Runnable {
	
	String tekst;
	private int n;
	public PrikazTeksta(String tekst, int n) {
		super();
		this.tekst = tekst;
		this.n = n;
	}
	
	public void run () {
		for (int i = 0; i < n; i++)
			System.out.print(tekst + " "); 		
	}		
}
 
class PrikazBrojeva implements Runnable {
	
	private int n;

	public PrikazBrojeva(int n) {
		super();
		this.n = n;
	}
	
	public void run () {
		for (int i = 0; i <= n; i++)
			System.out.print(i + " ");
	}	
}  