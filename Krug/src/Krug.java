
public class Krug {

	private double preènik;
	
	public Krug (double p ) 
		throws PogrešanPreènikIzuzetak  {
			
			promeniPreènik(p);
		}
	
	public void promeniPreènik(double p)
		throws PogrešanPreènikIzuzetak {
		
		if (p >=0)
			preènik = p;
		
		else
			throw new PogrešanPreènikIzuzetak (
			"Negativan preènik kruga");
		
	}
	
	public double getPreènik() {
		return preènik;
	}
	
	public double površina () {
		
		return Math.PI*preènik*preènik;
		
	}
	
}
	
public class TestKrug {
	
	public static void main(String [] args) {
		
		try {
			System.out.println("Konstruisanje prvog kruga...");
			Krug k1= new Krug(5);
			k1.promeniPreènik(-1);
			System.out.println("Konstruisanje drugog kruga...");
			Krug k2 = new Krug(-5);
		}
		catch{PogrešanPreènikIzuzetak e) {
			System.out.println(e.getMessage());
		
		}
	}
		
}