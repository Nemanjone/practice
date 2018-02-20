import java.util.*;

public class Palindrom {

	public static void main (String args[]) {
		
		
		Scanner tastatuta = new Scanner(System.in);
		String red;
		
		novi_red: do {
          System.out.println("Unesite reèenicu(<enter> za kraj): ");
          red = tastatuta.nextLine();
          red = red.toLowerCase();
          
          String reèenica = "";
          for (int i = 0; i < red.length(); i++) {
        	 char znak = red.charAt(i);
        	 if (Character.isLetter(znak))
        		 reèenica+=znak;
        	  
          }
			int l = 0;
			int d = reèenica.length() -1;
			
			while (l < d) {
				if (reèenica.charAt(l) != reèenica.charAt(d)) {
					System.out.println("To nije palindrom");
					continue novi_red;
				}
				l++;
				d--;
			}
		
		System.out.println("To jeste palindrom");
	 
	
}   while (red.length() != 0);
}
}
