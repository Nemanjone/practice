import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class IndustrijskiRobot {

	public enum VrstaPogona {
	MAGNETNI_LINEARNI_AKTUATOR,
	ELEKTROMAGNETNI_POGON,
	HIDRAULI�NI_POGON 
	}
	
	private String proizvo�a�;
	private String model;
	private long godinaProizvodnje, stepeniSlobodeKretanja, maxBrojSati;
	private double potro�nja;
	private VrstaPogona vrstaPogona;
	
	
	public String getProizvo�a�() {
		return proizvo�a�;
	}
	public String getModel() {
		return model;
	}
	public long getGodinaProizvodnje() {
		return godinaProizvodnje;
	}
	public long getStepeniSlobodeKretanja() {
		return stepeniSlobodeKretanja;
	}
	public long getMaxBrojSati() {
		return maxBrojSati;
	}
	public double getPotro�nja() {
		return potro�nja;
	}
	public VrstaPogona getVrstaPogona() {
		return vrstaPogona;
	}
	
	
	public IndustrijskiRobot(String proizvo�a�, String model, long godinaProizvodnje, long stepeniSlobodeKretanja,
			long maxBrojSati, double potro�nja, VrstaPogona vrstaPogona) {
		super();
		this.proizvo�a� = proizvo�a�;
		this.model = model;
		this.godinaProizvodnje = godinaProizvodnje;
		this.stepeniSlobodeKretanja = stepeniSlobodeKretanja;
		this.maxBrojSati = maxBrojSati;
		this.potro�nja = potro�nja;
		this.vrstaPogona = vrstaPogona;
	}
	
	public double getEfikasnost() {
		double L = 0;
		if(this.vrstaPogona == VrstaPogona.MAGNETNI_LINEARNI_AKTUATOR) {
			L = 2.0;
			if(this.vrstaPogona == VrstaPogona.ELEKTROMAGNETNI_POGON) {
			L = 1.0;	
			}
			else L = 0.33;
			
		}
		
		return this.potro�nja * Math.sqrt(maxBrojSati)/
				(this.stepeniSlobodeKretanja -2)*L;	
	}
	@Override
	public String toString() {
		String rezultat = "";
		
		rezultat += String.format("%-20s%-20s%-30s%9.2f W\n", 
				"Naziv proizvo�a�a",
				this.proizvo�a�,
				"Potro�nja energije:",
				this.potro�nja);
		
		rezultat += String.format("%-20s%-20s%-30s%6d sati\n", 
				"Naziv modela",
				this.model,
				"Maks. broj sati rada:",
				this.maxBrojSati);
		
		rezultat += String.format("%-20s%19d %-30s%6d ssk\n", 
				"Godina proizvodnje:",
				this.godinaProizvodnje,
				"Broj stepeni slobode kretanja: ",
				this.stepeniSlobodeKretanja);
		
		String pogon = "";
		
		if (this.vrstaPogona == VrstaPogona.MAGNETNI_LINEARNI_AKTUATOR) {
			pogon = "Magnetni linearni aktuator";
		}
		   else	if (this.vrstaPogona == VrstaPogona.ELEKTROMAGNETNI_POGON) {
				pogon = "Elektromagnetni pogon";
		}
			else
				pogon = "Hidrauli�ni pogon";
		
		rezultat += String.format("%-7s%-33s%-30s%9.2f #", 
				"Pogon:",
				pogon,
				"Efikasnost:",
				this.getEfikasnost());
		
		
		return rezultat;
	}
	
	
	public static List<IndustrijskiRobot> load (String imeDatoteke) {
		
		List<IndustrijskiRobot> lista = new ArrayList<>();
		
		try {
			
			FileInputStream fis = new FileInputStream(imeDatoteke);
			Scanner s = new Scanner(fis);
			
			while(s.hasNext()) {
				
				double potro�nja = s.nextDouble();
				long sati = s.nextLong();
				long godina = s.nextLong();
				String proizvo�a� = s.nextLine().trim();
				long ssk = s.nextLong();
				String pogonAkronim = s.next().trim();
				String model = s.nextLine().trim();
				
				VrstaPogona vp = null;
				
				if (pogonAkronim.equals("MLA")) {
					vp = VrstaPogona.MAGNETNI_LINEARNI_AKTUATOR;
				}
				else if (pogonAkronim.equals("EMP")) {
					vp = VrstaPogona.ELEKTROMAGNETNI_POGON;
				}
				else {
					vp = VrstaPogona.HIDRAULI�NI_POGON;	
			}
				IndustrijskiRobot ir = new IndustrijskiRobot(proizvo�a�, model, 
						godina, ssk,sati, potro�nja, vp);
				
				lista.add(ir);
		}
			
		s.close();	
			
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			System.out.println("Gre�ka!");
			e.printStackTrace();
		}
		
		
		
		return lista;
		
	}
	
	
	
	
}
