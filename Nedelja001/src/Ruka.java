
public class Ruka {
	
	public enum Stanje {SAVIJENA, ISPRU�ENA };
	private Stanje stanje = Stanje.ISPRU�ENA;
	
	public void savij() {
		stanje = Stanje.SAVIJENA;
		
	}
	 public void ispru�i() {
		 stanje = Stanje.ISPRU�ENA;
	 }
	 
	 public Stanje getStanje() {
		 return stanje;
	 }
	 public boolean jeSavijena() {
		 return stanje == Stanje.SAVIJENA;
	 }
	 
	 public boolean jeIspru�ena() {
		 return stanje == Stanje.ISPRU�ENA;
	 }
	 
	 
	 
	 
	 
	 
	 
	 
	 
	 
	 
	 
	 
	 
	 
	 
	 

}
