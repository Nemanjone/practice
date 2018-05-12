import java.util.*;

public class IgraZivota {

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
			kol.novaGeneracija();
			g++;
		}
		
		
	}

}
 class Kolonija {
	 private int n;
	 private boolean[][]m;// true- zauzeta �elija
	 
	 public Kolonija (int n) {
		 this.n=n;
		 m = new boolean[n+2][n+2];
	 }
	 public void zauzmi�eliju(int i, int j) {
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
	 
	 public void prika�i(){
		 for (int i = 1;i<=n;i++) {
			 for (int j=1; j<=n;j++)
				 System.out.print(m[i][j]? "*": " ");
			 System.out.println();
			 		 
		 }
	 }
	 
 }