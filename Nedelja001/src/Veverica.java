

public class Veverica {
	
	private String ime;
	private String boja;
	private Ruka levaRuka;
	private Ruka desnaRuka;
	private String �taDr�i;
	
	public void setIme(String ime) {
		this.ime = ime;
	}
	public void setBoja(String boja) {
		this.boja = boja;
	}
	public Veverica(String ime, String boja) {
		super();
		this.ime = ime;
		this.boja = boja;
		this.levaRuka = new Ruka();
		this.desnaRuka = new Ruka();
		this.�taDr�i = "NI�TA";
				
	}
	public String get�taDr�i() {
		return �taDr�i;
	}

	
	public String getIme() {
		return ime;
	}
	public String getBoja() {
		return boja;
	}
	
	public void savijLevuRuku() {
	levaRuka.savij();
	System.out.println(ime + ": je savila levu ruku.");
	}
	
	public void savijDesnuRuku() {
		desnaRuka.savij();
		System.out.println(ime + ": je savila desnu ruku.");
	}
	
	public void ispru�iLevuRuku() {
		levaRuka.ispru�i();
		System.out.println(ime + ": je ispru�ila levu ruku.");
		
		if (desnaRuka.jeIspru�ena()) {
			System.out.println(ime + " je ispustila " +�taDr�i);
			�taDr�i = "NI�TA";
		}
	}
	
	public void ispru�iDesnuRuku() {
		desnaRuka.ispru�i();
		System.out.println(ime + ": je ispru�ila desnu ruku.");
		
		if (levaRuka.jeIspru�ena()) {
			System.out.println(ime + ": je ispustila " + �taDr�i);
			�taDr�i = "NI�TA";
		}
	}
	
	public void pridr�i(String �ta) {
		if (levaRuka.jeSavijena() || desnaRuka.jeSavijena()) {
		�taDr�i = �ta;	
		System.out.println(ime + ": pridr�ava " + �ta);
	}
		else {
		System.out.println(ime + ": ne mo�e da pridr�i " + �ta);
		}
	
      }
	
	private String vevericaObeRukeIspru�ene() {
		return "       |\\_/|\n" +
	           "      ( ^ ^ )\n" +
			   "    ___\\ Y /__ __\n" +
	           "   O___     __O/  |\n" +
			   "       \\   /  / _/\n" +
	           "       /   \\_/ /\n" +
			   "     _/ /\\\\ \\_/\n" +
	           "    /__/   \\__\\\n";
			
	}
	
	private String vevericaDesnaRukaSavijena() {
		return 
				"       |\\_/|\n" +
		        "      ( ^ ^ )\n" +
		        "     __\\ Y /__ __\n" +
		        "    /       __O/  |\n" +
	       	    "    \\   \\@  / _/\n" +
		        "     \\_/   \\_/ /\n" +
	            "     _/ /\\\\ \\_/\n" +
		        "    /__/    \\__\\";
			
	}
	
	private String vevericaLevaRukaSavijena() {
		return 
				"       |\\_/|\n" +
		        "      ( ^ ^ )\n" +
				"    ___\\ Y /_    __\n" +
		        "   O___      \\  /  |\n" +
				"       \\ @/  / /  _/\n" +
		        "       /  \\_/__/ /\n" +
				"     _/ /\\\\ \\_/\n" +
		        "    /__/   \\__\\n";
	} 
	
	private String vevericaObeRukeSavijene() {
		return 
				"       |\\_/|\n" +
		        "      ( ^ ^ )\n" +
				"      _\\ Y /_   ___\n" +
		        "     /      \\  /   |\n" +
				"     \\  \\ @/ /  /_/\n" +
		        "      \\  /\\_/__/ /\n" +
				"     _/ /\\\\ \\_/\n" +
		        "    /__/   \\__\\n";
		
	}
	
	private String getVevericaASCIIArt() {
		
		if(levaRuka.jeSavijena() && desnaRuka.jeSavijena()) {
			return vevericaObeRukeSavijene();
		}
		if(levaRuka.jeSavijena()) {
			return vevericaLevaRukaSavijena();
		}
		if (desnaRuka.jeSavijena()) {
			return vevericaDesnaRukaSavijena();
		}
		return vevericaObeRukeIspru�ene();
		
	}
	@Override
	public String toString() {
		
		String vevericaASCII = getVevericaASCIIArt();
		
		if (�taDr�i.equals("NI�TA")) {
			vevericaASCII = vevericaASCII.replace("@", " ");
		}
		return vevericaASCII;
	}
	
	
	
	
	
	
	
	
	
	
	}
