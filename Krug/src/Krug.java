
public class Krug {

	private double pre�nik;
	
	public Krug (double p ) 
		throws Pogre�anPre�nikIzuzetak  {
			
			promeniPre�nik(p);
		}
	
	public void promeniPre�nik(double p)
		throws Pogre�anPre�nikIzuzetak {
		
		if (p >=0)
			pre�nik = p;
		
		else
			throw new Pogre�anPre�nikIzuzetak (
			"Negativan pre�nik kruga");
		
	}
	
	public double getPre�nik() {
		return pre�nik;
	}
	
	public double povr�ina () {
		
		return Math.PI*pre�nik*pre�nik;
		
	}
	
}
	
public class TestKrug {
	
	public static void main(String [] args) {
		
		try {
			System.out.println("Konstruisanje prvog kruga...");
			Krug k1= new Krug(5);
			k1.promeniPre�nik(-1);
			System.out.println("Konstruisanje drugog kruga...");
			Krug k2 = new Krug(-5);
		}
		catch{Pogre�anPre�nikIzuzetak e) {
			System.out.println(e.getMessage());
		
		}
	}
		
}