
public class KompleksanBroj {
	
	public double r,i;
	
	public KompleksanBroj (double r, double i) { //konstruktor
		this.r = r;
		this.i = i;
	}
	public double Re() {return r;}
	
	public double Im() {return i;}
	
	public double moduo() {return Math.sqrt(r*r+i*i);}
	
	public static KompleksanBroj konjugovanBroj(KompleksanBroj a) {
		return new KompleksanBroj(a.r, -a.i);
	}
    public KompleksanBroj konjugovanBroj() {
    	return new KompleksanBroj(this.r, - this.i);
    }
    public static  KompleksanBroj zbir (KompleksanBroj a, KompleksanBroj b) {
	 
    	return new KompleksanBroj(a.r + b.r, a.i + b.i);
    }
    public KompleksanBroj dodaj (KompleksanBroj a) {
    	return new KompleksanBroj(this.r +a.r, this.i + i );
    }
    public static KompleksanBroj proizvod (KompleksanBroj a, KompleksanBroj b) {
    	return new KompleksanBroj(a.r*b.r - a.i*b.i, a.r*b.i + a.i*b.r);
    }
    public KompleksanBroj pomnoži(KompleksanBroj a) {
    	return new KompleksanBroj(this.r*a.r - this.i*a.i,this.r*a.i + this.i*a.r );
    }
    public String toString() {return "(" + r +"," + i + ")";}
    
    public static void main (String[]args) {
    	
    	KompleksanBroj x = new KompleksanBroj(1, 1);
    	
    	System.out.println("x = " + x);
    	System.out.println("Re x " + x.Re());
    	System.out.println("Im x " + x.Im());
    	System.out.println("moduo x " + x.moduo());
    	System.out.println("konjugovano x " + x.konjugovanBroj());
    	System.out.println("x + konjugovano x = " + 
    	KompleksanBroj.zbir(x, x.konjugovanBroj()));
    	
    	System.out.println();
    	
    	KompleksanBroj y = new KompleksanBroj(0, 1);
    	
    	System.out.println("y = " + y);
    	System.out.println("Re y " + y.Re());
    	System.out.println("Im y " + y.Im());
    	System.out.println("moduo y " + y.moduo());
    	System.out.println("konjugovano y " + y.konjugovanBroj());
    	System.out.println("x + y = " + x.dodaj(y)); 
    	System.out.println("x*y = " + x.pomnoži(y));
    	
    }
}
