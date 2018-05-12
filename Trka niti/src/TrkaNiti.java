
public class TrkaNiti {

	public static void main (String [] args) {
		
		Broja� b = new Broja�();
		Thread [] niti = new Thread[10];
		
		for (int i = 0; i < niti.length; i++) {
			niti[i] = new Dodavanje1(b);
			niti[i].start();
		}
		for (int i = 0; i < niti.length; i++) {
			try {
				niti[i].join();	
			}
			catch (InterruptedException e) {	
			}
		}
		
		System.out.println("Ukkupna vrednost broja�a: " + b.vrednost());
	}
}

class Dodavanje1 extends Thread implements Runnable {
	
	private Broja� b;

	public Dodavanje1(Broja� b) {
		super();
		this.b = b;
	}
	
	public void run () {
		b.dodaj1();	
	}
}

class Broja� {
	
	private int broja� = 0;
	
	public void dodaj1() {
		
		int n = broja�;
		n = n + 1;
		
		if (Math.random() < 0.5) {
			try {
				Thread.sleep(1);
			}
			catch (InterruptedException ex) {
				
			}
		}
		
		broja� = n;	
	}
	
	public int vrednost() {
		return broja�;
	}
}


