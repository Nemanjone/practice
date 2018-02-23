import java.util.*;

public class bacanjeNovcica {
	
	public static void main(String args[]) {
		
		
		
		Scanner tastatura = new Scanner(System.in);
		
	
		int ishodBacanja;
		int brojPisma;
		int brojGlava;
		
		final int PISMO = 0;
		
		while (true)  {
			System.out.println("Unesite željeni broj bacanja novèiæa: ");
		    int brojBacanja = tastatura.nextInt();
		    
		    if (brojBacanja == 0 ) {break;}
		    
		    brojGlava = 0;
		    brojPisma = 0;
		    
		    for (int i= 0;  i < brojBacanja; i++) {
		    	ishodBacanja =(int)(Math.random() + 0.5);
		    	if (ishodBacanja == PISMO) {
		    		brojPisma++;
		    	}else {
		    		brojGlava++;
		    	}
		    	
		    }System.out.println("Broj pisma: " + brojPisma);
		    System.out.println("Broj glava: " + brojGlava);
		    System.out.println("broj pisama/broj bacanja: " + (double)brojPisma/brojBacanja);
		    System.out.println("Broj glava/broj bacanja: " + (double)brojGlava/brojBacanja);
		    
		}  
		
		
		
	}
	

}
