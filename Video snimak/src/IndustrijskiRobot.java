import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class IndustrijskiRobot {

	public enum VrstaPogona {
	MAGNETNI_LINEARNI_AKTUATOR,
	ELEKTROMAGNETNI_POGON,
	HIDRAULIÈNI_POGON 
	}
	
	private String proizvoðaè;
	private String model;
	private long godinaProizvodnje, stepeniSlobodeKretanja, maxBrojSati;
	private double potrošnja;
	private VrstaPogona vrstaPogona;
	
	
	public String getProizvoðaè() {
		return proizvoðaè;
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
	public double getPotrošnja() {
		return potrošnja;
	}
	public VrstaPogona getVrstaPogona() {
		return vrstaPogona;
	}
	
	
	public IndustrijskiRobot(String proizvoðaè, String model, long godinaProizvodnje, long stepeniSlobodeKretanja,
			long maxBrojSati, double potrošnja, VrstaPogona vrstaPogona) {
		super();
		this.proizvoðaè = proizvoðaè;
		this.model = model;
		this.godinaProizvodnje = godinaProizvodnje;
		this.stepeniSlobodeKretanja = stepeniSlobodeKretanja;
		this.maxBrojSati = maxBrojSati;
		this.potrošnja = potrošnja;
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
		
		return this.potrošnja * Math.sqrt(maxBrojSati)/
				(this.stepeniSlobodeKretanja -2)*L;	
	}
	@Override
	public String toString() {
		String rezultat = "";
		
		rezultat += String.format("%-20s%-20s%-30s%9.2f W\n", 
				"Naziv proizvoðaèa",
				this.proizvoðaè,
				"Potrošnja energije:",
				this.potrošnja);
		
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
				pogon = "Hidraulièni pogon";
		
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
				
				double potrošnja = s.nextDouble();
				long sati = s.nextLong();
				long godina = s.nextLong();
				String proizvoðaè = s.nextLine().trim();
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
					vp = VrstaPogona.HIDRAULIÈNI_POGON;	
			}
				IndustrijskiRobot ir = new IndustrijskiRobot(proizvoðaè, model, 
						godina, ssk,sati, potrošnja, vp);
				
				lista.add(ir);
		}
			
		s.close();	
			
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			System.out.println("Greška!");
			e.printStackTrace();
		}
		
		
		
		return lista;
		
	}
	
	
	
	
}
