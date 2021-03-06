import java.util.ArrayList;

public class Utakmica {
	
	private String  imeGosti;
	private String imeDomaći;
	private ArrayList prenosi;
	public Utakmica(String gosti, String domaći) {
		super();
		this.imeGosti = gosti;
		this.imeDomaći = domaći;
		prenosi = new ArrayList();
	}
	public void dodajPrenosnikUtakmice(PrenosnikUtakmice p) {
		p.domaći(imeDomaći);
		p.gosti(imeGosti);
		
		prenosi.add(p);
	}
	public void domaćiPostigliKoš(int poeni) {
		for ( int i = 0; i < prenosi.size(); i++) {
			PrenosnikUtakmice p = (PrenosnikUtakmice) prenosi.get(i);
			p.domaćiPoentirali(poeni);
		}
	}
	
	public void gostiPostigliKoš(int poeni) {
		for(int i =0; i < prenosi.size(); i++) {
			PrenosnikUtakmice p = (PrenosnikUtakmice) prenosi.get(i);
			p.gostiPoentirali(poeni);
		}
	}
	
	public void krajČetvrtine ( int četvrtina) {
		for (int i =0; i < prenosi.size(); i++) {
			PrenosnikUtakmice p = (PrenosnikUtakmice)prenosi.get(i);
			p.završenaČetvrtina(četvrtina);
		}
	}
}

class Semafor implements PrenosnikUtakmice 	{
	
	String domaći, gosti;
	int rezultat = 0;
	int brojPoenaDomaći;
	int brojPoenaGosti;
	int četvrtinaUtakmice;
	
	public Semafor() {
		System.out.println("Pali se semafor...");
		četvrtinaUtakmice = 1;
	}
	
	public void prikažiRezultat () {
		System.out.println("****************************");
		System.out.print(domaći + " " + brojPoenaDomaći + "--");
		System.out.println(gosti + " " + brojPoenaGosti);
		prikažiČetvrtinu();
		System.out.println("*****************************");	
	}
	
	public void prikažiČetvrtinu () {
		
		if (četvrtinaUtakmice <= 4)
				System.out.println("Četvrtina: " + četvrtinaUtakmice);
		else
			System.out.println("Utakmica je završena.");
		}
	
	public void domaćiPoentirali(int poeni) {
		
		System.out.println();
		System.out.println("Domaći tim " + domaći + " postigao je " + poeni + " poena.");
		brojPoenaDomaći+=poeni;
		prikažiRezultat();
		
	}

	public void gostiPoentirali(int poeni) {
		System.out.println();
		System.out.println("Gosti " + gosti + " postigli su " + poeni + " poena");
		brojPoenaGosti+= poeni;
		prikažiRezultat();
		
	}
	
	public void završenaČetvrtina(int četvrtina) {
		System.out.println();
		System.out.println(četvrtina + ". četvrtina se upravo završila.");
		prikažiRezultat();
		
	}

	public void domaći(String ime) { domaći = ime;}
	
	public void gosti(String ime) {gosti = ime;}
	
}

class Zapisnik implements PrenosnikUtakmice {
	
	private String domaći, gosti;
	private int rezultatDomaćina, rezultatGosta;
	private int četvrtinaUtakmice;
	
	public Zapisnik () {
		System.out.println("Otvara se zapisnik...");
		četvrtinaUtakmice = 1;
		
	}
	
	public void domaćiPoentirali(int poeni) {
	  rezultatDomaćina+=poeni;
	}
	
	public void gostiPoentirali(int poeni) {
		rezultatGosta+= poeni;
	}
	
	public void završenaČetvrtina(int četvrtina) {
		četvrtinaUtakmice++;
	}
	
	public void domaći(String ime) {
		domaći = ime;
	}
	
	public void gosti(String ime) {
		gosti = ime;
	}
	
	public void prikažiRezultat() {
		System.out.println("Rezultat utakmice: ");
		System.out.println(domaći + ":" + rezultatDomaćina);
		System.out.println(gosti + ":" + rezultatGosta);
		prikažiČetvrtinu();
	}
	
	public void prikažiČetvrtinu() {
		if (četvrtinaUtakmice<=4)
			System.out.println("Četvrtina:"  + četvrtinaUtakmice);
		else
			System.out.println("Završena utakmica");
	  }
  }

class MobilniTelefon implements PrenosnikUtakmice {
	
	private String domaći, gosti;
	private int rezultatDomaćina, rezultatGosta;
	private int četvrtinaUtakmice;
	
	public MobilniTelefon () {
		System.out.println("SMS poruka: počinje prenos utakmice: ");
		četvrtinaUtakmice = 1;
	}
	
	public void prikažiRezultat() {
		System.out.print(domaći + " " + rezultatDomaćina + "--");
		System.out.println(gosti + " " + rezultatGosta + "--");
		prikažiČetvrtinu();
	}
	
	public void prikažiČetvrtinu() {
		if(četvrtinaUtakmice <=4)
			System.out.println("Četvrtina: " + četvrtinaUtakmice);
		else
			System.out.println("Završena utakmica");
	}
	
	public void domaćiPoentirali(int poeni) {
		System.out.println();
		System.out.println("Početak SMS poruke");
		System.out.println("Domaći tim " + domaći + " postigao " + poeni + " poena");
		rezultatDomaćina+=poeni;
		prikažiRezultat();
		System.out.println("Kraj SMS poruke");
		
	}
	
	public void gostiPoentirali(int poeni) {
		System.out.println();
		System.out.println("Početak SMS poruke");
		System.out.println("Gostujući tim " + gosti + " postigao " + poeni + " poena");
		rezultatGosta+=poeni;
		prikažiRezultat();
		System.out.println("Kraj SMS poruke");
	}
	
	public void završenaČetvrtina(int četvrtina) {
		System.out.println();
		System.out.println("Početak SMS poruke");
		System.out.println(četvrtina + " četvrtina se upravo završila.");
		četvrtinaUtakmice++;
		prikažiRezultat();
		System.out.println("Kraj SMS poruke");
	}
	
    
    public void domaći(String ime) {
	domaći = ime;
    }

   
    public void gosti(String ime) {
	gosti = ime;
	
		}
	}



