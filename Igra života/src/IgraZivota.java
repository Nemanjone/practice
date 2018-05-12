import java.util.*;

public class IgraZivota {

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
			kol.novaGeneracija();
			g++;
		}
		
		
	}

}
 class Kolonija {
	 private int n;
	 private boolean[][]m;// true- zauzeta æelija
	 
	 public Kolonija (int n) {
		 this.n=n;
		 m = new boolean[n+2][n+2];
	 }
	 public void zauzmiÆeliju(int i, int j) {
		 m[i][j] = true;
	 }
	 public void novaGeneracija() {
		 boolean[][]m1 = new boolean[n+2][n+2];
		 int bs; //broj suseda
		 
		 for ( int i = 1; i <= n; i++)
			 for (int j = 1; j <=n; j++) {
				 bs = 0;
				 
			for (int k = i-1; k <=i + 1;k++)
				for (int l = j-1; l<=j+1; l++)
				 if ( m[k][l] = true)
					 bs++;
			bs = (m[i][j] == true)? bs -1: bs;
			if (m[i][j] == false)
				if (bs ==3)
					m1[i][j] = true;
				else 
					m1[i][j]= false;
			else if
			(bs<2 || bs >3)
				m1[i][j] = false;
			else
				m1[i][j] = true;
			
			 }
		 m = m1;
	 }
	 
	 public void prikaži(){
		 for (int i = 1;i<=n;i++) {
			 for (int j=1; j<=n;j++)
				 System.out.print(m[i][j]? "*": " ");
			 System.out.println();
			 		 
		 }
	 }
	 
 }