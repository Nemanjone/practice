
public class RimskiBroj {

	 private int n;
	
	public RimskiBroj (int n) {
	this.n = n;
	}
	public RimskiBroj(String r) {
		for (int i = 0; i < r.length(); i++)
		switch ( r.charAt(i)) {
		case 'm': case 'M':  n = n + 1000; break;
		case 'd': case 'D':  n= n+500; break;
		case 'c': case 'C':  n= n+100; break;
		case 'l': case 'L':  n= n+50; break;
		case 'x': case 'X':  n= n+10; break;
		case 'v': case 'V':  n= n+5; break;
		case 'i': case 'I':  n= n+1; break;
		default: 
			System.out.println("Niste pravilno uneli rimski broj");
			System.exit(-1);
		}
		
	}
	
	public int toInt() {return n;}
	
	public String toString() {return d2r(n);}
	
	private String d2r(int n) {
		String r = "";
		while (n>=1000) {r = r + 'M'; n = n-1000; }
		while (n>=500)  {r = r + 'D'; n = n-500; }
		while (n>=100) {r = r + 'C'; n = n-100; }
		while (n>=50) {r = r + 'L'; n = n-50; }
		while (n>=10) {r = r + 'X'; n = n-10; }
		while (n>=5) {r = r + 'V'; n = n-5; }
		while (n>=1) {r = r + 'I'; n = n-1; }
		return r;
	}
	public static RimskiBroj zbir (RimskiBroj a, RimskiBroj b) {
		return new RimskiBroj(a.n + b.n);}
	
	public RimskiBroj dodaj(RimskiBroj a) {
		return new RimskiBroj(this.n + a.n);	
		}
	public static RimskiBroj proizvod (RimskiBroj a, RimskiBroj b) {
		return new RimskiBroj(a.n * b.n);
	}
	public RimskiBroj pomnoži(RimskiBroj a) {
		return new RimskiBroj(this.n*a.n);
	}
	public static void main(String args[]) {
		
        RimskiBroj x = new RimskiBroj("xxxiiii");
		System.out.println("x = " + x.toInt());
		System.out.println("x = " + x.toString());
		
	    RimskiBroj y = new RimskiBroj("mdclxvi");
		System.out.println("y = " + y.toInt());
		System.out.println("y = " + y.toString());
		
		System.out.println();
		
		System.out.println("x + y = " + RimskiBroj.zbir(x,y));
		
		System.out.println("x + y = " + RimskiBroj.zbir(x,y).toInt());
	
        System.out.println("x+y = " + x.dodaj(y) );
        System.out.println("x+y = " + x.dodaj(y).toInt());
        
        System.out.println();
        
        System.out.println("x*y = " + RimskiBroj.proizvod(x, y));
        System.out.println("x*y = " + RimskiBroj.proizvod(x, y).toInt());
		
        System.out.println("x*y = " + x.pomnoži(y));
        System.out.println("x*y = " + x.pomnoži(y).toInt());
	}
	
	}
	

