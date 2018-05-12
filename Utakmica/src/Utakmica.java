import java.util.ArrayList;

public class Utakmica {
	
	private String  imeGosti;
	private String imeDoma�i;
	private ArrayList prenosi;
	public Utakmica(String gosti, String doma�i) {
		super();
		this.imeGosti = gosti;
		this.imeDoma�i = doma�i;
		prenosi = new ArrayList();
	}
	public void dodajPrenosnikUtakmice(PrenosnikUtakmice p) {
		p.doma�i(imeDoma�i);
		p.gosti(imeGosti);
		
		prenosi.add(p);
	}
	public void doma�iPostigliKo�(int poeni) {
		for ( int i = 0; i < prenosi.size(); i++) {
			PrenosnikUtakmice p = (PrenosnikUtakmice) prenosi.get(i);
			p.doma�iPoentirali(poeni);
		}
	}
	
	public void gostiPostigliKo�(int poeni) {
		for(int i =0; i < prenosi.size(); i++) {
			PrenosnikUtakmice p = (PrenosnikUtakmice) prenosi.get(i);
			p.gostiPoentirali(poeni);
		}
	}
	
	public void kraj�etvrtine ( int �etvrtina) {
		for (int i =0; i < prenosi.size(); i++) {
			PrenosnikUtakmice p = (PrenosnikUtakmice)prenosi.get(i);
			p.zavr�ena�etvrtina(�etvrtina);
		}
	}
}

class Semafor implements PrenosnikUtakmice 	{
	
	String doma�i, gosti;
	int rezultat = 0;
	int brojPoenaDoma�i;
	int brojPoenaGosti;
	int �etvrtinaUtakmice;
	
	public Semafor() {
		System.out.println("Pali se semafor...");
		�etvrtinaUtakmice = 1;
	}
	
	public void prika�iRezultat () {
		System.out.println("****************************");
		System.out.print(doma�i + " " + brojPoenaDoma�i + "--");
		System.out.println(gosti + " " + brojPoenaGosti);
		prika�i�etvrtinu();
		System.out.println("*****************************");	
	}
	
	public void prika�i�etvrtinu () {
		
		if (�etvrtinaUtakmice <= 4)
				System.out.println("�etvrtina: " + �etvrtinaUtakmice);
		else
			System.out.println("Utakmica je zavr�ena.");
		}
	
	public void doma�iPoentirali(int poeni) {
		
		System.out.println();
		System.out.println("Doma�i tim " + doma�i + " postigao je " + poeni + " poena.");
		brojPoenaDoma�i+=poeni;
		prika�iRezultat();
		
	}

	public void gostiPoentirali(int poeni) {
		System.out.println();
		System.out.println("Gosti " + gosti + " postigli su " + poeni + " poena");
		brojPoenaGosti+= poeni;
		prika�iRezultat();
		
	}
	
	public void zavr�ena�etvrtina(int �etvrtina) {
		System.out.println();
		System.out.println(�etvrtina + ". �etvrtina se upravo zavr�ila.");
		prika�iRezultat();
		
	}

	public void doma�i(String ime) { doma�i = ime;}
	
	public void gosti(String ime) {gosti = ime;}
	
}

class Zapisnik implements PrenosnikUtakmice {
	
	private String doma�i, gosti;
	private int rezultatDoma�ina, rezultatGosta;
	private int �etvrtinaUtakmice;
	
	public Zapisnik () {
		System.out.println("Otvara se zapisnik...");
		�etvrtinaUtakmice = 1;
		
	}
	
	public void doma�iPoentirali(int poeni) {
	  rezultatDoma�ina+=poeni;
	}
	
	public void gostiPoentirali(int poeni) {
		rezultatGosta+= poeni;
	}
	
	public void zavr�ena�etvrtina(int �etvrtina) {
		�etvrtinaUtakmice++;
	}
	
	public void doma�i(String ime) {
		doma�i = ime;
	}
	
	public void gosti(String ime) {
		gosti = ime;
	}
	
	public void prika�iRezultat() {
		System.out.println("Rezultat utakmice: ");
		System.out.println(doma�i + ":" + rezultatDoma�ina);
		System.out.println(gosti + ":" + rezultatGosta);
		prika�i�etvrtinu();
	}
	
	public void prika�i�etvrtinu() {
		if (�etvrtinaUtakmice<=4)
			System.out.println("�etvrtina:"  + �etvrtinaUtakmice);
		else
			System.out.println("Zavr�ena utakmica");
	  }
  }

class MobilniTelefon implements PrenosnikUtakmice {
	
	private String doma�i, gosti;
	private int rezultatDoma�ina, rezultatGosta;
	private int �etvrtinaUtakmice;
	
	public MobilniTelefon () {
		System.out.println("SMS poruka: po�inje prenos utakmice: ");
		�etvrtinaUtakmice = 1;
	}
	
	public void prika�iRezultat() {
		System.out.print(doma�i + " " + rezultatDoma�ina + "--");
		System.out.println(gosti + " " + rezultatGosta + "--");
		prika�i�etvrtinu();
	}
	
	public void prika�i�etvrtinu() {
		if(�etvrtinaUtakmice <=4)
			System.out.println("�etvrtina: " + �etvrtinaUtakmice);
		else
			System.out.println("Zavr�ena utakmica");
	}
	
	public void doma�iPoentirali(int poeni) {
		System.out.println();
		System.out.println("Po�etak SMS poruke");
		System.out.println("Doma�i tim " + doma�i + " postigao " + poeni + " poena");
		rezultatDoma�ina+=poeni;
		prika�iRezultat();
		System.out.println("Kraj SMS poruke");
		
	}
	
	public void gostiPoentirali(int poeni) {
		System.out.println();
		System.out.println("Po�etak SMS poruke");
		System.out.println("Gostuju�i tim " + gosti + " postigao " + poeni + " poena");
		rezultatGosta+=poeni;
		prika�iRezultat();
		System.out.println("Kraj SMS poruke");
	}
	
	public void zavr�ena�etvrtina(int �etvrtina) {
		System.out.println();
		System.out.println("Po�etak SMS poruke");
		System.out.println(�etvrtina + " �etvrtina se upravo zavr�ila.");
		�etvrtinaUtakmice++;
		prika�iRezultat();
		System.out.println("Kraj SMS poruke");
	}
	
    
    public void doma�i(String ime) {
	doma�i = ime;
    }

   
    public void gosti(String ime) {
	gosti = ime;
	
		}
	}



