
public class Planeta {
	
	String ime;
	Double x, y, masa;
	
	public Planeta(String imePlanete, Double x, Double y, Double masa) {
		super();
		this.ime = imePlanete;
		this.x = x;
		this.y = y;
		this.masa = masa;
	}
	public String getImePlanete() {
		return ime;
	}
	public Double getX() {
		return x;
	}
	public Double getY() {
		return y;
	}
	public Double getMasa() {
		return masa;
	}
	
	public double getUdaljenost(Planeta p) {
		return Math.sqrt(Math.pow(p.getX() - this.x, 2) + Math.pow(p.getY() - this.y,2 ));
		
	}
	
	public double getSilaPrivlaèenja (Planeta p) {
		return 6.67408e-11* this.getMasa() * p.getMasa()/Math.pow(this.getUdaljenost(p), 2);
		
	}
	@Override
	public String toString() {
		return "Planeta [ime=" + ime + ", x=" + x + ", y=" + y + ", masa=" + masa + "]";
	}
	
	
}
