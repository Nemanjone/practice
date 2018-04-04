
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
		
		v1.pridrži("LEŠNIK");
		System.out.println(v1);
		System.out.println();
		
		v1.ispružiLevuRuku();
		System.out.println(v1);
		System.out.println();
		
		v1.ispružiDesnuRuku();
		System.out.println(v1);
	}

}
