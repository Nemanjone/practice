
public class radnik {
  
	private String ime;
	private long jmbg;
    private int staž;
    private double plata;
    
    public void Radnik (String i, long id, int s, double p) {
    	ime = i;
    	jmbg = id;
    	staž = s;
    	plata = p;
    }
	
	public String getIme() {
		return ime;
	}
    public int getStaž() {
    	return staž;
    }
    public void setStaž() {
    	int s = 0;
		staž = s ;
    }
    public long getJmbg() {
    	return jmbg;
    }
    public double getPlata() {
    	return plata;
    }
    public void PoveæajPlatu(double procenat) {
    	plata += plata*procenat/100;
    }
 
	}
    
