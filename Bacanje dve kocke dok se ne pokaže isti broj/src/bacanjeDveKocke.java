
public class bacanjeDveKocke {

	public static void main(String [] args) {
		
		int brojBacanja = 0;
		KockaZaIgru kocka1 = new KockaZaIgru();
		KockaZaIgru kocka2 = new KockaZaIgru();
		
		do {
			kocka1.baci();
			System.out.print("Na prvoj kocki je pao broj: ");
			System.out.println(kocka1.broj);
			 
			kocka2.baci();
			System.out.print("Na drugoj kocki je pao broj: ");
			System.out.println(kocka2.broj);
			
			brojBacanja ++;
			
			} while(kocka1.broj != kocka2.broj);
		
		System.out.println();
		System.out.print("Dve kocke su baèene " + brojBacanja);
		System.out.println(" puta pre nego što je pao isti broj.");
		}
		
	}
	
	class KockaZaIgru {
		
		public int broj; //broj na gornjoj strani kocke
		
		public KockaZaIgru() { //konstruktor bez parametra
			baci();             // poziv metoda baci()
		}
		public KockaZaIgru (int n) {  //konstruktor sa parametrom
			broj = n;
		}
        public void baci() {                    //bacanje kocke
        	broj = (int)(6*Math.random()) + 1;
        }
	}
	
	
	
	
	
	
	

