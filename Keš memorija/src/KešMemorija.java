import java.util.Scanner;

public class Ke�Memorija {
	private ElementKe�a[] ke�;
	private int n;
	
	public Ke�Memorija(int veli�ina) {
		
		ke� = new ElementKe�a[veli�ina];	
	}
	public void add(ElementKe�a noviElem) {
		ElementKe�a elem;
		int i;
		
		for ( i = 0; i <n; i++) {
			elem = ke�[i];
			if(noviElem.equals(elem)) {
			noviElem = elem;
			break;
		}
	}
         if (i == n)
        	 if(n == ke�.length)
        		 i--;
        	 else n++;
         
         for (int j = i; j>0; j--)
        	 ke�[j] = ke�[j-1];
         ke�[0] = noviElem;
         
	}
	
	public ElementKe�a NKE() {
		return ke�[0];
	}
	public void prika�i() {
		for ( int i = 0; i<n;i++)
			System.out.println(ke�[i]);
	}
	public void prika�iSve() {
	for (ElementKe�a elem:ke�)
		System.out.println(elem);
	}
	public static void main(String[] args) {
		
		Ke�Memorija ke�Re�i = new Ke�Memorija(5) ;
		
		ke�Re�i.add(new ElementKe�a("Pera"));
		ke�Re�i.add(new ElementKe�a("Zika"));
		ke�Re�i.add(new ElementKe�a("Laza"));
		ke�Re�i.add(new ElementKe�a("Zika"));
		ke�Re�i.add(new ElementKe�a("Mika"));
		ke�Re�i.add(new ElementKe�a("Mika"));
		ke�Re�i.add(new ElementKe�a("Pera"));
		ke�Re�i.add(new ElementKe�a("Sava"));
		ke�Re�i.add(new ElementKe�a("Deki"));
		ke�Re�i.add(new ElementKe�a("Zika"));
		ke�Re�i.add(new ElementKe�a("Zika"));
		System.out.println("Sadr�aj ke�a: ");
		ke�Re�i.prika�iSve();
		
		
		
	}
}

	class ElementKe�a {
		
		private String sadr�aj;
		
		public ElementKe�a(String s) {
			sadr�aj = s;
		}
		public String getSadr�aj() {
			return sadr�aj;	
		}
		
		public boolean equals (Object o) {
			ElementKe�a drugiElement = (ElementKe�a) o;
			return sadr�aj.equals(drugiElement.sadr�aj);
		}
		
		public String toString () {
			return "element ke�a: " + sadr�aj;
		}
		
	}



