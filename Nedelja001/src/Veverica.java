

public class Veverica {
	
	private String ime;
	private String boja;
	private Ruka levaRuka;
	private Ruka desnaRuka;
	private String štaDrži;
	
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
		this.štaDrži = "NIŠTA";
				
	}
	public String getŠtaDrži() {
		return štaDrži;
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
	
	public void ispružiLevuRuku() {
		levaRuka.ispruži();
		System.out.println(ime + ": je ispružila levu ruku.");
		
		if (desnaRuka.jeIspružena()) {
			System.out.println(ime + " je ispustila " +štaDrži);
			štaDrži = "NIŠTA";
		}
	}
	
	public void ispružiDesnuRuku() {
		desnaRuka.ispruži();
		System.out.println(ime + ": je ispružila desnu ruku.");
		
		if (levaRuka.jeIspružena()) {
			System.out.println(ime + ": je ispustila " + štaDrži);
			štaDrži = "NIŠTA";
		}
	}
	
	public void pridrži(String šta) {
		if (levaRuka.jeSavijena() || desnaRuka.jeSavijena()) {
		štaDrži = šta;	
		System.out.println(ime + ": pridržava " + šta);
	}
		else {
		System.out.println(ime + ": ne može da pridrži " + šta);
		}
	
      }
	
	private String vevericaObeRukeIspružene() {
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
		return vevericaObeRukeIspružene();
		
	}
	@Override
	public String toString() {
		
		String vevericaASCII = getVevericaASCIIArt();
		
		if (štaDrži.equals("NIŠTA")) {
			vevericaASCII = vevericaASCII.replace("@", " ");
		}
		return vevericaASCII;
	}
	
	
	
	
	
	
	
	
	
	
	}
