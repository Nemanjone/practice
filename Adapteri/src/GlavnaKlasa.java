
public class GlavnaKlasa {

	public static void main(String[] args) {
		
		RernaNaGas r = new RernaNaGas();
		
		RernaNaGasAdapter ra = new RernaNaGasAdapter(r);
		
		ra.crisp();
		
		System.out.println(ra);
	}
	
}
