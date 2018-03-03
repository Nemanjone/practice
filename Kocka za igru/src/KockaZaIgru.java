
 public class KockaZaIgru {
	

    public static void main(String args []) {
    
	 System.out.println("Zbir dve kocke      Proseèan broj bacanja");
	 System.out.println();
	 for (int i = 2;i <13; i++)
		 System.out.printf("%7d %24.2f\n", i, prosekZaZbir(i));
	 
    }
	 
	public static int baciZaZbir(int zbir) {
		
		Kocka kocka1= new Kocka();		
		Kocka kocka2 = new Kocka();		
	    int brojBacanja = 0;

		do {
			kocka1.baci();
			kocka2.baci();
            brojBacanja++;	
		}while (kocka1.broj + kocka2.broj != zbir);
		return brojBacanja; 
	}

	public  static double prosekZaZbir(int zbir) {
		int ukupanBrojBacanja = 0;
		for (int i= 0; i <=1000; i ++ )
			ukupanBrojBacanja = ukupanBrojBacanja + baciZaZbir(zbir);
		    return (double)ukupanBrojBacanja/1000;
	} 

}
    
     class Kocka {
    	
    	public int broj;
    	
    	public Kocka () {
    		baci();
    	}
    	public Kocka (int n) {
    		broj =  n;
    	}
    	public  void baci() {
    		broj = (int)(Math.random()*6 + 1);	 
    	}
    }
  