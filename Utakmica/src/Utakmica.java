import java.util.ArrayList;

public class Utakmica {
	
	private String  imeGosti;
	private String imeDomaæi;
	private ArrayList prenosi;
	public Utakmica(String gosti, String domaæi) {
		super();
		this.imeGosti = gosti;
		this.imeDomaæi = domaæi;
		prenosi = new ArrayList();
	}
	public void dodajPrenosnikUtakmice(PrenosnikUtakmice p) {
		p.domaæi(imeDomaæi);
		p.gosti(imeGosti);
		
		prenosi.add(p);
	}
	public void domaæiPostigliKoš(int poeni) {
		for ( int i = 0; i < prenosi.size(); i++) {
			PrenosnikUtakmice p = (PrenosnikUtakmice) prenosi.get(i);
			p.domaæiPoentirali(poeni);
		}
	}
	
	public void gostiPostigliKoš(int poeni) {
		for(int i =0; i < prenosi.size(); i++) {
			PrenosnikUtakmice p = (PrenosnikUtakmice) prenosi.get(i);
			p.gostiPoentirali(poeni);
		}
	}
	
	public void krajÈetvrtine ( int èetvrtina) {
		for (int i =0; i < prenosi.size(); i++) {
			PrenosnikUtakmice p = (PrenosnikUtakmice)prenosi.get(i);
			p.završenaÈetvrtina(èetvrtina);
		}
	}
}

class Semafor implements PrenosnikUtakmice 	{
	
	String domaæi, gosti;
	int rezultat = 0;
	int brojPoenaDomaæi;
	int brojPoenaGosti;
	int èetvrtinaUtakmice;
	
	public Semafor() {
		System.out.println("Pali se semafor...");
		èetvrtinaUtakmice = 1;
	}
	
	public void prikažiRezultat () {
		System.out.println("****************************");
		System.out.print(domaæi + " " + brojPoenaDomaæi + "--");
		System.out.println(gosti + " " + brojPoenaGosti);
		prikažiÈetvrtinu();
		System.out.println("*****************************");	
	}
	
	public void prikažiÈetvrtinu () {
		
		if (èetvrtinaUtakmice <= 4)
				System.out.println("Èetvrtina: " + èetvrtinaUtakmice);
		else
			System.out.println("Utakmica je završena.");
		}
	
	public void domaæiPoentirali(int poeni) {
		
		System.out.println();
		System.out.println("Domaæi tim " + domaæi + " postigao je " + poeni + " poena.");
		brojPoenaDomaæi+=poeni;
		prikažiRezultat();
		
	}

	public void gostiPoentirali(int poeni) {
		System.out.println();
		System.out.println("Gosti " + gosti + " postigli su " + poeni + " poena");
		brojPoenaGosti+= poeni;
		prikažiRezultat();
		
	}
	
	public void završenaÈetvrtina(int èetvrtina) {
		System.out.println();
		System.out.println(èetvrtina + ". èetvrtina se upravo završila.");
		prikažiRezultat();
		
	}

	public void domaæi(String ime) { domaæi = ime;}
	
	public void gosti(String ime) {gosti = ime;}
	
}

class Zapisnik implements PrenosnikUtakmice {
	
	private String domaæi, gosti;
	private int rezultatDomaæina, rezultatGosta;
	private int èetvrtinaUtakmice;
	
	public Zapisnik () {
		System.out.println("Otvara se zapisnik...");
		èetvrtinaUtakmice = 1;
		
	}
	
	public void domaæiPoentirali(int poeni) {
	  rezultatDomaæina+=poeni;
	}
	
	public void gostiPoentirali(int poeni) {
		rezultatGosta+= poeni;
	}
	
	public void završenaÈetvrtina(int èetvrtina) {
		èetvrtinaUtakmice++;
	}
	
	public void domaæi(String ime) {
		domaæi = ime;
	}
	
	public void gosti(String ime) {
		gosti = ime;
	}
	
	public void prikažiRezultat() {
		System.out.println("Rezultat utakmice: ");
		System.out.println(domaæi + ":" + rezultatDomaæina);
		System.out.println(gosti + ":" + rezultatGosta);
		prikažiÈetvrtinu();
	}
	
	public void prikažiÈetvrtinu() {
		if (èetvrtinaUtakmice<=4)
			System.out.println("Èetvrtina:"  + èetvrtinaUtakmice);
		else
			System.out.println("Završena utakmica");
	  }
  }

class MobilniTelefon implements PrenosnikUtakmice {
	
	private String domaæi, gosti;
	private int rezultatDomaæina, rezultatGosta;
	private int èetvrtinaUtakmice;
	
	public MobilniTelefon () {
		System.out.println("SMS poruka: poèinje prenos utakmice: ");
		èetvrtinaUtakmice = 1;
	}
	
	public void prikažiRezultat() {
		System.out.print(domaæi + " " + rezultatDomaæina + "--");
		System.out.println(gosti + " " + rezultatGosta + "--");
		prikažiÈetvrtinu();
	}
	
	public void prikažiÈetvrtinu() {
		if(èetvrtinaUtakmice <=4)
			System.out.println("Èetvrtina: " + èetvrtinaUtakmice);
		else
			System.out.println("Završena utakmica");
	}
	
	public void domaæiPoentirali(int poeni) {
		System.out.println();
		System.out.println("Poèetak SMS poruke");
		System.out.println("Domaæi tim " + domaæi + " postigao " + poeni + " poena");
		rezultatDomaæina+=poeni;
		prikažiRezultat();
		System.out.println("Kraj SMS poruke");
		
	}
	
	public void gostiPoentirali(int poeni) {
		System.out.println();
		System.out.println("Poèetak SMS poruke");
		System.out.println("Gostujuæi tim " + gosti + " postigao " + poeni + " poena");
		rezultatGosta+=poeni;
		prikažiRezultat();
		System.out.println("Kraj SMS poruke");
	}
	
	public void završenaÈetvrtina(int èetvrtina) {
		System.out.println();
		System.out.println("Poèetak SMS poruke");
		System.out.println(èetvrtina + " èetvrtina se upravo završila.");
		èetvrtinaUtakmice++;
		prikažiRezultat();
		System.out.println("Kraj SMS poruke");
	}
	
    
    public void domaæi(String ime) {
	domaæi = ime;
    }

   
    public void gosti(String ime) {
	gosti = ime;
	
		}
	}



