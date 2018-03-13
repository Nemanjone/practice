
public class MobilniTelefon {

	private String proizvoðaè, model;
	private int godProizvodnje, kolièinaRAM, kolièinaDisk;
	private EkranTelefona ekran;
	
	public String getProizvoðaè() {
		return proizvoðaè;
	}
	
	public String getModel() {
		return model;
	}
	
	public int getGodProizvodnje() {
		return godProizvodnje;
	}
	
	public int getKolièinaRAM() {
		return kolièinaRAM;
	}
	
	public int getKolièinaDisk() {
		return kolièinaDisk;
	}
	
	public EkranTelefona getEkran() {
		return ekran;
	}

	public MobilniTelefon(String proizvoðaè, String model, int godProizvodnje, int kolièinaRAM, int kolièinaDisk,
			EkranTelefona ekran) {
		super();
		this.proizvoðaè = proizvoðaè;
		this.model = model;
		this.godProizvodnje = godProizvodnje;
		this.kolièinaRAM = kolièinaRAM;
		this.kolièinaDisk = kolièinaDisk;
		this.ekran = ekran;
	}

	 public double ocenaPodobnosti() {
	    	
	    	if (ekran.getDijagonala() < 5.0) {
	    		return ekran.getDijagonala()*kolièinaRAM/
	    				(2020 - godProizvodnje);	
	    	}
	    	else  {
	    	return ekran.getDijagonala()*kolièinaDisk/
    				(2020 - godProizvodnje);
	    	}
	
	 }
	 
	 public static void zameniMesto(MobilniTelefon a, MobilniTelefon b) {
		 
		 EkranTelefona.zameniMesta(a.ekran, b.ekran);
		 
		 String temps = a.proizvoðaè;
		 a.proizvoðaè = b.proizvoðaè;
		 b.proizvoðaè = temps;
		 
		 temps = a.model;
		 a.model = b.model;
		 b.model = temps;
		 
		 int tempI = a.godProizvodnje;
		 a.godProizvodnje = b.godProizvodnje;
		 b.godProizvodnje = tempI;
		 
		 tempI = a.kolièinaRAM;
		 a.kolièinaRAM = b.kolièinaRAM;
		 b.kolièinaRAM = tempI;
		 
		 tempI = a.kolièinaDisk;
		 a.kolièinaDisk = b.kolièinaDisk;
		 b.kolièinaDisk = tempI;
	 }

	@Override
	public String toString() {
		String zaPrikaz = "";
		
		zaPrikaz+=String.format("%-24s%-17s%-20s%-19s\n", 
			    "Proizvoðaè: ",
				proizvoðaè,
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
				"Kolièina RAM memorije: ",
				kolièinaRAM/(1024.*1024.),
				"Kolièina skladišta: ",
				kolièinaDisk/(1024.*1024.));
		
		return zaPrikaz;
	}
	 
	 
	 
	 
}
