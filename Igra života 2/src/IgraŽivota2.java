import java.util.*;

public class Igra�ivota2 {

	public static void main(String[]args) {
		
		System.out.println("Ovo je igra �ivota!\n");
		
		System.out.println("Unesite veli�inu (broj vrsta i kolona) kolonije: ");
		
		Scanner tastatura = new Scanner (System.in);
		int n = tastatura.nextInt();
		
		Kolonija kol = new Kolonija(n);
		
		System.out.print("Unesite broj organizama na po�etku: ");
		int brojOrganizama = tastatura.nextInt();
		System.out.print("Unesite vrste i kolone ");
		System.out.println(" organizama na po�etku - ");
		
		for ( int i = 0; i < brojOrganizama; i++) {
			System.out.print(" Organizam " + (i+1) + ": ");
			int v = tastatura.nextInt();
			int k = tastatura.nextInt();
			kol.zauzmi�eliju(v, k);
		}
		
		System.out.println();
		int g = 0;
		
		while (true) {
			System.out.println("Generacija " + g + ": ");
			kol.prika�i();
			System.out.print("Slede�a generacija (d/n)? ");
			String novaGen = tastatura.next();
			if (novaGen.equals("n"))break;
			kol.novaGen();
			g++;
					}	
	}

}

class Kolonija  {
	 

	 
	 private int n;
	 private �elija[][]m;// true- zauzeta �elija
	 
	 private enum Stanje {PRAZNO, ZAUZETO;
	 
	 public String toString () {
		 return (ordinal() == 0) ? " " :"*";	 
	 }
	 }

	 private class �elija {
		 
	 
		private int vrsta, kolona;
		 private Stanje sadr�aj;
		 private int susedi;
	 
	 private  �elija (int vrsta, int kolona) {
		 this.vrsta = vrsta;
		 this.kolona = kolona;
		 this.sadr�aj = sadr�aj;
	 }
	 
	 private void brojSuseda() {
		 int bs = 0; 
		 
		 for ( int i =vrsta - 1; i <= vrsta + 1; i++)
			 for (int j = kolona - 1; j <=kolona + 1; j++) {
				 if ( m[i][j].sadr�aj == Stanje.ZAUZETO)
					 bs++;
				 susedi = (sadr�aj == Stanje.ZAUZETO)? bs - 1:bs;
	 }
	 }
	 
	 private  void novoStanje() {
		 
	 switch (sadr�aj) {
	 case PRAZNO: 
		 if (susedi == 3)
			 sadr�aj = Stanje.ZAUZETO;
		 break;
	 case ZAUZETO:
		 if (susedi <2 || susedi  > 3)
			 sadr�aj = Stanje.PRAZNO;
		 break;
	 }
	 }
	 
	 private void prika�i(){
			 System.out.println(sadr�aj);
			 		 
		 }
	 }
	 
	 public Kolonija (int n) {
		 this.n=n;
		 m = new �elija[n+2][n+2];
		 for ( int i = 0; i <= n +2; i++)
			 for (int j = 0; j <=n +2; j++)
				 m[i][j] = new �elija(i,j);
	 }
		 
	 public void zauzmi�eliju(int i, int j) {
		 m[i][j].sadr�aj = Stanje.ZAUZETO;
		
	 }
	 
	 public void novaGen() {
		 
		 for ( int i = 1; i <= n; i++)
			 for (int j = 1; j <=n; j++)
				 m[i][j]. brojSuseda();
		 for ( int i = 1; i <= n; i++)
			 for (int j = 1; j <=n; j++)
				 m[i][j].novoStanje();
		 }
	 
	 public void prika�i() {
		 for ( int i = 1; i <= n; i++) {
			 for (int j = 1; j <=n; j++)
				 m[i][j].prika�i();
		 System.out.println();
	 }
	 }
	 }

	 

	
