
public class radnik {
  
	private String ime;
	private long jmbg;
    private int sta�;
    private double plata;
    
    public void Radnik (String i, long id, int s, double p) {
    	ime = i;
    	jmbg = id;
    	sta� = s;
    	plata = p;
    }
	
	public String getIme() {
		return ime;
	}
    public int getSta�() {
    	return sta�;
    }
    public void setSta�() {
    	int s = 0;
		sta� = s ;
    }
    public long getJmbg() {
    	return jmbg;
    }
    public double getPlata() {
    	return plata;
    }
    public void Pove�ajPlatu(double procenat) {
    	plata += plata*procenat/100;
    }
 
	}
    
