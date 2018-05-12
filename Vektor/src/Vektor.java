
public class Vektor {
	
	private double x, y;

	public double getX() {
		return x;
	}

	public void setX(double x) {
		this.x = x;
	}

	public double getY() {
		return y;
	}

	public void setY(double y) {
		this.y = y;
	}
		
	public Vektor() {
		this.x = 0.0;
		this.y = 0.0;
		
	}

	public Vektor(double x, double y) {
		super();
		this.x = x;
		this.y = y;
	}
	
	public void Saberi(Vektor v) {
		this.x+=v.getX();
		this.y+=v.getY();
	}
	public Vektor (Vektor v) {
		this.x = v.getX();
		this.y= v.getY();
	}
	
	@Override
	public String toString() {
		return "Vektor [x=" + x + ", y=" + y + "]";
	}
	
	public void Oduzmi(Vektor v) {
		this.x-=v.getX();
		this.y-=v.getY();
	}
	
	public void Skaliraj(double skalar) {
		this.x *=skalar;
		this.y*=skalar;
	}
	
	public double Intenzitet() {
		
		return Math.sqrt(Math.pow(this.x, 2.0) + Math.pow(this.y, 2.0));
	}
	

	public static void main(String[] args) {
		
		Vektor v1 = new Vektor(4, 4);
		Vektor v2 = new Vektor(3, 3);
		
		Vektor v3= new Vektor(v1);
		
		v3.Saberi(v2);
		v3.Skaliraj(2.0);
		v3.Oduzmi(v1);
		
		
		
    System.out.println("v1 je " + v1);
    System.out.println("v2 je " + v2);
    System.out.println("v3 je " + v3);
    System.out.println("v3 intenzitet je: " + v3.Intenzitet());
	}
}
