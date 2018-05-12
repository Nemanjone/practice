import java.util.ArrayList;

public class ProizvoðaèPotrošaè<TipRezultata> {
	
	private ArrayList<TipRezultata> rezultati = new ArrayList<TipRezultata>();
	
	public void dodaj (TipRezultata r) {
	
	synchronized (rezultati) {
		rezultati.add(r);
		rezultati.notify();		
	}
}

	public TipRezultata ukloni() {
		
		TipRezultata r;
		synchronized (rezultati) {
			while (rezultati.size() == 0) {
				try {
					rezultati.wait();
				}
				catch (InterruptedException e) {
					
				}
			}
			r = rezultati.remove(0);
		}
		return r;
	}
}
