
public class Ruka {
	
	public enum Stanje {SAVIJENA, ISPRUŽENA };
	private Stanje stanje = Stanje.ISPRUŽENA;
	
	public void savij() {
		stanje = Stanje.SAVIJENA;
		
	}
	 public void ispruži() {
		 stanje = Stanje.ISPRUŽENA;
	 }
	 
	 public Stanje getStanje() {
		 return stanje;
	 }
	 public boolean jeSavijena() {
		 return stanje == Stanje.SAVIJENA;
	 }
	 
	 public boolean jeIspružena() {
		 return stanje == Stanje.ISPRUŽENA;
	 }
	 
	 
	 
	 
	 
	 
	 
	 
	 
	 
	 
	 
	 
	 
	 
	 
	 

}
