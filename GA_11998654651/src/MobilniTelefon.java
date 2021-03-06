
public class MobilniTelefon {

	private String proizvođač, model;
	private int godProizvodnje, količinaRAM, količinaDisk;
	private EkranTelefona ekran;
	
	public String getProizvođač() {
		return proizvođač;
	}
	
	public String getModel() {
		return model;
	}
	
	public int getGodProizvodnje() {
		return godProizvodnje;
	}
	
	public int getKoličinaRAM() {
		return količinaRAM;
	}
	
	public int getKoličinaDisk() {
		return količinaDisk;
	}
	
	public EkranTelefona getEkran() {
		return ekran;
	}

	public MobilniTelefon(String proizvođač, String model, int godProizvodnje, int količinaRAM, int količinaDisk,
			EkranTelefona ekran) {
		super();
		this.proizvođač = proizvođač;
		this.model = model;
		this.godProizvodnje = godProizvodnje;
		this.količinaRAM = količinaRAM;
		this.količinaDisk = količinaDisk;
		this.ekran = ekran;
	}

	 public double ocenaPodobnosti() {
	    	
	    	if (ekran.getDijagonala() < 5.0) {
	    		return ekran.getDijagonala()*količinaRAM/
	    				(2020 - godProizvodnje);	
	    	}
	    	else  {
	    	return ekran.getDijagonala()*količinaDisk/
    				(2020 - godProizvodnje);
	    	}
	
	 }
	 
	 public static void zameniMesto(MobilniTelefon a, MobilniTelefon b) {
		 
		 EkranTelefona.zameniMesta(a.ekran, b.ekran);
		 
		 String temps = a.proizvođač;
		 a.proizvođač = b.proizvođač;
		 b.proizvođač = temps;
		 
		 temps = a.model;
		 a.model = b.model;
		 b.model = temps;
		 
		 int tempI = a.godProizvodnje;
		 a.godProizvodnje = b.godProizvodnje;
		 b.godProizvodnje = tempI;
		 
		 tempI = a.količinaRAM;
		 a.količinaRAM = b.količinaRAM;
		 b.količinaRAM = tempI;
		 
		 tempI = a.količinaDisk;
		 a.količinaDisk = b.količinaDisk;
		 b.količinaDisk = tempI;
	 }

	@Override
	public String toString() {
		String zaPrikaz = "";
		
		zaPrikaz+=String.format("%-24s%-17s%-20s%-19s\n", 
			    "Proizvođač: ",
				proizvođač,
				"Model:",
				model);
		
		zaPrikaz += String.format("%-24s%13d    %-20s%16.2f PP\n", 
				"Godina proizvodnje",
				godProizvodnje,
				"Ocena podobnosti",
				ocenaPodobnosti());
		
		zaPrikaz+= String.format("%-24s%5.2f X %5.2f in %-20s%16.2f in\n",
				"Širina i visina: ",
				ekran.getŠirina(),
				ekran.getVisina(),
				"Dijagonala ekrana: ",
				ekran.getDijagonala());
		
		zaPrikaz += String.format("%-24s%13.2f MB %-20s%16.2f MB\n", 
				"Količina RAM memorije: ",
				količinaRAM/(1024.*1024.),
				"Količina skladišta: ",
				količinaDisk/(1024.*1024.));
		
		return zaPrikaz;
	}
	 
	 
	 
	 
}
