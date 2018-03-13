
public class MobilniTelefon {

	private String proizvo�a�, model;
	private int godProizvodnje, koli�inaRAM, koli�inaDisk;
	private EkranTelefona ekran;
	
	public String getProizvo�a�() {
		return proizvo�a�;
	}
	
	public String getModel() {
		return model;
	}
	
	public int getGodProizvodnje() {
		return godProizvodnje;
	}
	
	public int getKoli�inaRAM() {
		return koli�inaRAM;
	}
	
	public int getKoli�inaDisk() {
		return koli�inaDisk;
	}
	
	public EkranTelefona getEkran() {
		return ekran;
	}

	public MobilniTelefon(String proizvo�a�, String model, int godProizvodnje, int koli�inaRAM, int koli�inaDisk,
			EkranTelefona ekran) {
		super();
		this.proizvo�a� = proizvo�a�;
		this.model = model;
		this.godProizvodnje = godProizvodnje;
		this.koli�inaRAM = koli�inaRAM;
		this.koli�inaDisk = koli�inaDisk;
		this.ekran = ekran;
	}

	 public double ocenaPodobnosti() {
	    	
	    	if (ekran.getDijagonala() < 5.0) {
	    		return ekran.getDijagonala()*koli�inaRAM/
	    				(2020 - godProizvodnje);	
	    	}
	    	else  {
	    	return ekran.getDijagonala()*koli�inaDisk/
    				(2020 - godProizvodnje);
	    	}
	
	 }
	 
	 public static void zameniMesto(MobilniTelefon a, MobilniTelefon b) {
		 
		 EkranTelefona.zameniMesta(a.ekran, b.ekran);
		 
		 String temps = a.proizvo�a�;
		 a.proizvo�a� = b.proizvo�a�;
		 b.proizvo�a� = temps;
		 
		 temps = a.model;
		 a.model = b.model;
		 b.model = temps;
		 
		 int tempI = a.godProizvodnje;
		 a.godProizvodnje = b.godProizvodnje;
		 b.godProizvodnje = tempI;
		 
		 tempI = a.koli�inaRAM;
		 a.koli�inaRAM = b.koli�inaRAM;
		 b.koli�inaRAM = tempI;
		 
		 tempI = a.koli�inaDisk;
		 a.koli�inaDisk = b.koli�inaDisk;
		 b.koli�inaDisk = tempI;
	 }

	@Override
	public String toString() {
		String zaPrikaz = "";
		
		zaPrikaz+=String.format("%-24s%-17s%-20s%-19s\n", 
			    "Proizvo�a�: ",
				proizvo�a�,
				"Model:",
				model);
		
		zaPrikaz += String.format("%-24s%13d    %-20s%16.2f PP\n", 
				"Godina proizvodnje",
				godProizvodnje,
				"Ocena podobnosti",
				ocenaPodobnosti());
		
		zaPrikaz+= String.format("%-24s%5.2f X %5.2f in %-20s%16.2f in\n",
				"�irina i visina: ",
				ekran.get�irina(),
				ekran.getVisina(),
				"Dijagonala ekrana: ",
				ekran.getDijagonala());
		
		zaPrikaz += String.format("%-24s%13.2f MB %-20s%16.2f MB\n", 
				"Koli�ina RAM memorije: ",
				koli�inaRAM/(1024.*1024.),
				"Koli�ina skladi�ta: ",
				koli�inaDisk/(1024.*1024.));
		
		return zaPrikaz;
	}
	 
	 
	 
	 
}
