import java.util.*;

public class EratostenovoSito {  //Niz prostih brojeva ciji je proizvod manji od korena broja m - granice niza 
	
	public static void main (String [] args) {
		
		if (args.length == 0){
			System.out.print("Granica niza prostih brojeva ");
			System.out.println(" nije navedena u komndnom redu!");
			
		}
		
	int m = Integer.parseInt(args[0]); 
	
	boolean [] prostBroj = new boolean[m];
	
	for (int i = 0 ; i < m; i++)
		prostBroj[i] = true;
	
	int n = (int) Math.ceil(Math.sqrt(m));

	for (int i = 2; i < n; i++)	{
		if (prostBroj[i])
			for (int j = 2*i;j <m; j = j+i)
				prostBroj[j] = false;
	}
		
	int j = 0;
	
	for (int i = 2; i < m; i++)
		if (prostBroj[i]) {
			System.out.print(i + " ");
			j++;
		
	     if (j == 10) {
	    	 System.out.println();
	    	 j = 0;
	    	 
	     }

		}

	}
	
}

	

