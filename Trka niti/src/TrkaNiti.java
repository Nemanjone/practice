
public class TrkaNiti {

	public static void main (String [] args) {
		
		Brojaè b = new Brojaè();
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
		
		System.out.println("Ukkupna vrednost brojaèa: " + b.vrednost());
	}
}

class Dodavanje1 extends Thread implements Runnable {
	
	private Brojaè b;

	public Dodavanje1(Brojaè b) {
		super();
		this.b = b;
	}
	
	public void run () {
		b.dodaj1();	
	}
}

class Brojaè {
	
	private int brojaè = 0;
	
	public void dodaj1() {
		
		int n = brojaè;
		n = n + 1;
		
		if (Math.random() < 0.5) {
			try {
				Thread.sleep(1);
			}
			catch (InterruptedException ex) {
				
			}
		}
		
		brojaè = n;	
	}
	
	public int vrednost() {
		return brojaè;
	}
}


