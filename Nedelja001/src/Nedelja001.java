
public class Nedelja001 {
	
	public static void main (String [] args ) {
		
		Veverica v1 = new Veverica("Chip", "braon");
		
		System.out.println(v1);
		
		v1.savijLevuRuku();
		System.out.println(v1);
		System.out.println();
		
		v1.savijDesnuRuku();
		System.out.println(v1);
		System.out.println();
		
		v1.pridr�i("LE�NIK");
		System.out.println(v1);
		System.out.println();
		
		v1.ispru�iLevuRuku();
		System.out.println(v1);
		System.out.println();
		
		v1.ispru�iDesnuRuku();
		System.out.println(v1);
	}

}
