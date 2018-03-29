
public class TriNiti {
	
	public static void main (String [] args) {
		
		Runnable java = new PrikazTeksta ("Java", 20);
		Runnable cpp = new PrikazTeksta("C++", 20);
		Runnable niz = new PrikazBrojeva(20);
		
		Thread nitJava = new Thread(java);
		Thread nitCpp = new Thread(cpp);
		Thread nitNiz = new Thread(niz);
		
		nitJava.start();
		nitCpp.start();
		nitNiz.start();
	}
}

class PrikazTeksta implements Runnable {
	
	private String tekst;
	private int n;
	
	public PrikazTeksta(String tekst, int n) {
		super();
		this.tekst = tekst;
		this.n = n;
	}
	
	public void run() {
		for (int i = 0; i < n; i++) {
			System.out.print(tekst + " ");
		}	
	}
}

class PrikazBrojeva implements Runnable {
	
	private int n;

	public PrikazBrojeva(int n) {
		super();
		this.n = n;
	}
	
	public void run () {
		for (int i = 0; i < n; i++) {
		System.out.print(i + " ");
		
		}
	}
}

