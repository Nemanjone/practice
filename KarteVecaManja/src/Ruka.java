
import java.util.ArrayList;

public class Ruka {

    private ArrayList<Karta> ruka;  

    public Ruka() {
        ruka = new ArrayList<Karta>();
    }

    public void clear() {
        ruka.clear();
    }

    public void dodajKartu(Karta k) {
        if (k == null)
            throw new NullPointerException("Ne možete da dodate nulu.");
        ruka.add(k);
    }

    public void ukloniKartu(Karta k) {
        ruka.remove(k);
    }

    public void ukloniKartu(int pozicija) {
        if (pozicija < 0 || pozicija >= ruka.size())
            throw new IllegalArgumentException("Ne postoji karta na toj poziciji."
                    + pozicija);
        ruka.remove(pozicija);
    }

    public int getBrojKarte() {
        return ruka.size();
    }

    public Karta getKarta(int pozicija) {
        if (pozicija < 0 || pozicija >= ruka.size())
            throw new IllegalArgumentException("Ne postoji karta na toj poziciji."
                    + pozicija);
        return ruka.get(pozicija);
    }

    public void sortirajPremaBoji() {
        ArrayList<Karta> novaRuka = new ArrayList<Karta>();
        while (ruka.size() > 0) {
            int poz = 0;  
            Karta k = ruka.get(0);  
            for (int i = 1; i < ruka.size(); i++) {
                Karta k2 = ruka.get(i);
                if ( k2.getBoja() < k.getBoja() ||
                        (k2.getBoja() == k.getBoja() && k2.getVrednost() < k.getVrednost()) ) {
                    poz = i;
                    k = k2;
                }
            }
            ruka.remove(poz);
            novaRuka.add(k);
        }
        ruka = novaRuka;
    }

    public void sortirajPremaVrednosti() {
        ArrayList<Karta> novaRuka = new ArrayList<Karta>();
        while (ruka.size() > 0) {
            int poz = 0;  
            Karta k = ruka.get(0); 
            for (int i = 1; i < ruka.size(); i++) {
                Karta k1 = ruka.get(i);
                if ( k1.getVrednost() < k.getVrednost() ||
                        (k1.getVrednost() == k.getVrednost() && k1.getBoja() < k.getBoja()) ) {
                    poz = i;
                    k = k1;
                }
            }
            ruka.remove(poz);
            novaRuka.add(k);
        }
        ruka = novaRuka;
    }

}
