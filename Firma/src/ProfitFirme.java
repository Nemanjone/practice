import java.util.*;

public class ProfitFirme {

	public static void main(String [] args) {
		
		System.out.print("Program za rad sa tabelom profita");
		System.out.println(" firme sa vise prodavnica.");
		System.out.println();
		
		Firma abc = new Firma(3);
		Scanner tastatura = new Scanner(System.in);
		int brojOpcije;
		
		do {
			prikaziMeni();
			brojOpcije = tastatura.nextInt();
			
			switch (brojOpcije) {
			case 1:
				abc.unesiProfit();
				break;
			case 2: 
				abc.prikaziProfit();
				break;
			case 3: 
				if (abc.getProfit() == null)
					System.out.println("Greska: podaci ne postoje.");
				else {
					System.out.print("Ukupni godisnji profit firme: ");
					System.out.printf("%8.2f", abc.godisnjiProfit());
					System.out.println();		
				}
					break;
			case 4: 
				abc.prikaziProfitPoMesecima();
				break;
			case 5: 
				abc.prikaziProfitPoProdavnicama();
				break;
			case 0:
				System.out.println("Kraj programa.");
			default:
				System.out.println("Greska! Pogresna opcija.");
		
			}
			
		}   while (brojOpcije != 0);	
		
	}
	
	private static void prikaziMeni() {
		
		System.out.println();
		System.out.println("Izaberite jednu od ovih opcija: ");
		System.out.println("   1. Unos tabele profita");
		System.out.println("   2. Prikaz tabele profita");
		System.out.println("   3. Prikaz ukupnog godisnjeg profita");
		System.out.println("   4. Prikaz profita po mesecima");
		System.out.println("   5. Prikaz profita po prodavnicama");
		System.out.println("   0. Kraj rada");
	}
}


	class Firma{
		
		private int n; //broj prodavnica
		private double [][] profit;
		
		public Firma(int n) {
			this.n= n;
		}
		
		public double[][] getProfit(){
			return profit;
		}
		
		public void unesiProfit() {
			
			profit = new double[n][12]; 
		
		
		Scanner tastatura = new Scanner(System.in);
		
		for (int i = 0; i < n; i++)
			for (int j = 0; j < 12; j++) {
				
				System.out.print("Unesite profit Vase prodavnice " + i);
				System.out.println(" za mesec " + j + ": ");
				profit[i][j] = tastatura.nextDouble();
			}
				
	}
		
		public void prikaziProfit() {
		
			if (profit == null) {
			System.out.println("Greska! Podaci ne postoje. ");
			return;
			}
			System.out.println("Tabela profita po prodavnicama i mesecima: ");
			
			for (int i = 0; i < n; i++) {
				for (int j = 0; j < 12; j++)
					
					System.out.printf("%6.2f\n", profit[i][j] );
			}
			
			}
		
		
		
		public double godisnjiProfit() {
			
			double godProfit = 0;
			
			for (int i = 0; i < n; i++)
				for (int j = 0; j < 12; j++)
					godProfit += profit[i][j];
			
			System.out.println( godProfit);
			return godProfit;
	
		}
				
        private double mesecniProfit(int m) {
        	double mesProfit = 0;
        	for (int i =0; i < n; i++)
        		mesProfit +=profit[i][m];
        	return mesProfit;	
        }				
		
        public void prikaziProfitPoMesecima() {
        	
        	if (profit == null) {
        		System.out.println("Greska! Podaci ne postoje.");
        		return;
        	}
        	System.out.println("Profit prodavnica po mesecima: ");
        	for (int m = 0; m < 12; m++)
        		System.out.printf("%6.2f\n1" , mesecniProfit(m));
        	System.out.println();	
        	
        }
			
        public void prikaziProfitPoProdavnicama() {
        	
        	if (profit == null) {
        		System.out.println("Greska! Podaci ne postoje. ");
        		return;
        	}
        	
        	double[] profitProdavnice = new double[n];
        	
        	for (int i = 0; i < n; i++)
        		for (int j = 0; j < 12; j++ )
        			profitProdavnice[i] += profit[i][j];
        	System.out.println("Ukupni profit po prodavnicama: ");
        	for (int i = 0; i < n; i++) {
        		System.out.print("Prodavnica " + i + ": ");
        		System.out.printf("%7.2f", profitProdavnice[i]);
        		System.out.println();
        	}
        }
        
		}
		
		
		
		
		
		
		
		