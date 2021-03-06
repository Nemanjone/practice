
public class Krug {

	private double prečnik;
	
	public Krug (double p ) 
		throws PogrešanPrečnikIzuzetak  {
			
			promeniPrečnik(p);
		}
	
	public void promeniPrečnik(double p)
		throws PogrešanPrečnikIzuzetak {
		
		if (p >=0)
			prečnik = p;
		
		else
			throw new PogrešanPrečnikIzuzetak (
			"Negativan prečnik kruga");
		
	}
	
	public double getPrečnik() {
		return prečnik;
	}
	
	public double površina () {
		
		return Math.PI*prečnik*prečnik;
		
	}
	
}
	
public class TestKrug {
	
	public static void main(String [] args) {
		
		try {
			System.out.println("Konstruisanje prvog kruga...");
			Krug k1= new Krug(5);
			k1.promeniPrečnik(-1);
			System.out.println("Konstruisanje drugog kruga...");
			Krug k2 = new Krug(-5);
		}
		catch{PogrešanPrečnikIzuzetak e) {
			System.out.println(e.getMessage());
		
		}
	}
		
}