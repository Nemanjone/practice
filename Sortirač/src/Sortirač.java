

public class Tester {

	public static void main(String [] args) {
		
		KompleksanBroj [] a = new KompleksanBroj[10]; 
		
		for (int i = 0; i < a.length; i++) 
			a[i] = new KompleksanBroj(Math.random()*5,Math.random()*5 );
			for (KompleksanBroj z : a) System.out.println(z);
		System.out.println();
		
		Sortiraè.Uporeðivaè.sortiraj(a, new Sortiraè.Uporeðivaè() {
			
			@Override
			public int uporedi(Object x, Object y) {
				// TODO Auto-generated method stub
				KompleksanBroj z1 = (KompleksanBroj)x;
				KompleksanBroj z2 = (KompleksanBroj)y;
				double rezultat = z1.moduo() - z2.moduo();
				return (int)Math.signum(rezultat);
			}	
	}
);

	for (KompleksanBroj z : a)System.out.println(z);
	System.out.println();
	
	Sortiraè.Uporeðivaè.sortiraj(a, new Sortiraè.Uporeðivaè() {
	public int uporedi(Object x, Object y) {
	     KompleksanBroj z1 = (KompleksanBroj) x;
	     KompleksanBroj z2 = (KompleksanBroj) y;
	     double rezultat = z1.Re() - z2.Re();
	     if (rezultat ==0)
	    	 rezultat = z1.Im() - z2.Im();
	     return (int) Math.signum(rezultat);
	}	
	}
	);
	for (KompleksanBroj z : a)System.out.println(z);
	}
	}
	
	

 class Sortiraè  {
	
	

	 public interface Uporeðivaè  {
		
		public int uporedi(Object x, Object y); 

		public static void sortiraj(
				Object[] a, int leviKraj, int desniKraj, Uporeðivaè u) {
			
			int k = (int)(Math.random()*(desniKraj - leviKraj +1)) + leviKraj;
			Object pivot = a[k];
			
			int i = leviKraj, j = desniKraj;
			do {
				while ((i < desniKraj) && u.uporedi(pivot, a[i]) > 0)i++;
				while ((j > leviKraj) && u.uporedi(pivot, a[j]) < 0) j--;
				if (i < j) {
					Object tmp = a[i]; a[i] = a[j]; a[j] = tmp; 
				}
				if (i <=j) {i++;j--;}
			}while (i<=j);
			
			if (leviKraj < j) sortiraj(a,leviKraj, j, u);
			if (i < desniKraj)sortiraj(a, i, desniKraj, u);
		}
		
		public static void sortiraj(Object[] a, Uporeðivaè u) {
		
		sortiraj (a, 0, a.length -1, u);
		}		
}
 }

public class KompleksanBroj{
	
	public double r,i; //realni, imaginarni deo
	
	
	
	public  KompleksanBroj (double r, double i) { //konstruktor
		this.r = r;
		this.i = i;
	}
	public double Re() {return r;}
	
	public double Im() {return i;}
	
	public double moduo() {return Math.sqrt(r*r+i*i);} //moduo
	
	public  KompleksanBroj konjugovanBroj(KompleksanBroj a) {
		return new KompleksanBroj(a.r, -a.i);
	}
    public KompleksanBroj konjugovanBroj() {
    	return new KompleksanBroj(this.r, - this.i);
    }
    public  KompleksanBroj zbir (KompleksanBroj a, KompleksanBroj b) {
	 
    	return new KompleksanBroj(a.r + b.r, a.i + b.i);
    }
    public KompleksanBroj dodaj (KompleksanBroj a) {
    	return new KompleksanBroj(this.r +a.r, this.i + i );
    	}
    public  KompleksanBroj proizvod (KompleksanBroj a, KompleksanBroj b) {
    	return new KompleksanBroj(a.r*b.r - a.i*b.i, a.r*b.i + a.i*b.r);
    }
    public KompleksanBroj pomnoži(KompleksanBroj a) {
    	return new KompleksanBroj(this.r*a.r - this.i*a.i,this.r*a.i + this.i*a.r );
    }
    public String toString() {return "(" + r +"," + i + ")";}
	
	}
