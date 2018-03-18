import java.util.*;

public class IgraŽivota2 {

	public static void main(String[]args) {
		
		System.out.println("Ovo je igra života!\n");
		
		System.out.println("Unesite velièinu (broj vrsta i kolona) kolonije: ");
		
		Scanner tastatura = new Scanner (System.in);
		int n = tastatura.nextInt();
		
		Kolonija kol = new Kolonija(n);
		
		System.out.print("Unesite broj organizama na poèetku: ");
		int brojOrganizama = tastatura.nextInt();
		System.out.print("Unesite vrste i kolone ");
		System.out.println(" organizama na poèetku - ");
		
		for ( int i = 0; i < brojOrganizama; i++) {
			System.out.print(" Organizam " + (i+1) + ": ");
			int v = tastatura.nextInt();
			int k = tastatura.nextInt();
			kol.zauzmiÆeliju(v, k);
		}
		
		System.out.println();
		int g = 0;
		
		while (true) {
			System.out.println("Generacija " + g + ": ");
			kol.prikaži();
			System.out.print("Sledeæa generacija (d/n)? ");
			String novaGen = tastatura.next();
			if (novaGen.equals("n"))break;
			kol.novaGen();
			g++;
					}	
	}

}

class Kolonija  {
	 

	 
	 private int n;
	 private Æelija[][]m;// true- zauzeta æelija
	 
	 private enum Stanje {PRAZNO, ZAUZETO;
	 
	 public String toString () {
		 return (ordinal() == 0) ? " " :"*";	 
	 }
	 }

	 private class Æelija {
		 
	 
		private int vrsta, kolona;
		 private Stanje sadržaj;
		 private int susedi;
	 
	 private  Æelija (int vrsta, int kolona) {
		 this.vrsta = vrsta;
		 this.kolona = kolona;
		 this.sadržaj = sadržaj;
	 }
	 
	 private void brojSuseda() {
		 int bs = 0; 
		 
		 for ( int i =vrsta - 1; i <= vrsta + 1; i++)
			 for (int j = kolona - 1; j <=kolona + 1; j++) {
				 if ( m[i][j].sadržaj == Stanje.ZAUZETO)
					 bs++;
				 susedi = (sadržaj == Stanje.ZAUZETO)? bs - 1:bs;
	 }
	 }
	 
	 private  void novoStanje() {
		 
	 switch (sadržaj) {
	 case PRAZNO: 
		 if (susedi == 3)
			 sadržaj = Stanje.ZAUZETO;
		 break;
	 case ZAUZETO:
		 if (susedi <2 || susedi  > 3)
			 sadržaj = Stanje.PRAZNO;
		 break;
	 }
	 }
	 
	 private void prikaži(){
			 System.out.println(sadržaj);
			 		 
		 }
	 }
	 
	 public Kolonija (int n) {
		 this.n=n;
		 m = new Æelija[n+2][n+2];
		 for ( int i = 0; i <= n +2; i++)
			 for (int j = 0; j <=n +2; j++)
				 m[i][j] = new Æelija(i,j);
	 }
		 
	 public void zauzmiÆeliju(int i, int j) {
		 m[i][j].sadržaj = Stanje.ZAUZETO;
		
	 }
	 
	 public void novaGen() {
		 
		 for ( int i = 1; i <= n; i++)
			 for (int j = 1; j <=n; j++)
				 m[i][j]. brojSuseda();
		 for ( int i = 1; i <= n; i++)
			 for (int j = 1; j <=n; j++)
				 m[i][j].novoStanje();
		 }
	 
	 public void prikaži() {
		 for ( int i = 1; i <= n; i++) {
			 for (int j = 1; j <=n; j++)
				 m[i][j].prikaži();
		 System.out.println();
	 }
	 }
	 }

	 

	
