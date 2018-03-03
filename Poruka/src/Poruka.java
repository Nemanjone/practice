
public class Poruka {
	
	public static void main(String[]args) {
		
		if (args.length == 0)
			return;
		
		if (args[0].equals("-d"))
			System.out.println("Dobar dan!");
		else if(args[0].equals("-z"))
			System.out.println("Zbogom!");
		else
			return;
		
		for( int i = 1; i < args.length; i++)
			System.out.print(" " + args[i]);
		System.out.println("!");
		
	}

}
