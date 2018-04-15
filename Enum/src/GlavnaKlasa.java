
public class GlavnaKlasa {
	
	public static void main(String[] args) {
		
		String gorivo = " e ";
		
		Automobil a1 = new Automobil(VrstaGoriva.fromSkracenica(gorivo), "Tesla");

		System.out.println(a1.getModel() + " " + a1.getVrstaGoriva());

	}

}
