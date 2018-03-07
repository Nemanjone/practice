import java.util.*;
import java.io.*;

public class PonovljeneRe�i {

	
	public static void main(String[] args) throws IOException {
	
	int brojRe�i = 0;
	int broj�estihRe�i= 0;
	Ke�Memorija ke�Re�i = new Ke�Memorija(30);
	
	System.out.println("Lista �esto ponavljanih re�i: ");
	System.out.println("----------------------------");
	
	Scanner dokument = new Scanner(new File("tekst.txt"));
	
	while (dokument.hasNext()) {
		String re� = dokument.next();
		brojRe�i++;
		ke�Re�i.add(new ElementKe�a(re�.toLowerCase()));
		int r = ke�Re�i.NKE().getRef();
		if (r>1) {
			broj�estihRe�i++;
			System.out.println(re� + " (" + r + ")");
		}
	}
			System.out.println("------------------------");
			System.out.println("Ukupan broj re�i u tekstu: " + brojRe�i);
			System.out.println("Broj ponavljanih re�i: " + broj�estihRe�i);
	} 
}
	 class Ke�Memorija {
		
	
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
         noviElem.uvecajRef();
         ke�[0] = noviElem;
         
	}
	
	public ElementKe�a NKE() {
		return ke�[0];
	}
	public void prika�i() {
		for ( int i = 0; i<n;i++) {
			System.out.println(ke�[i].getSadr�aj());
		    System.out.println("  ("+ ke�[i].getRef() + ")");
	}
}
}
	
class ElementKe�a {
		
		private String sadr�aj;
		private int ref;
		
		public ElementKe�a(String re�) {
			sadr�aj = re�;
		}
		public String getSadr�aj() {
			return sadr�aj;	
		}
		
		public int getRef() {
			return ref;
		}
		
		public void uvecajRef() {
			ref++;
		}
			public boolean equals (Object o) {
				ElementKe�a drugiElement = (ElementKe�a) o;
				return sadr�aj.equals(drugiElement.sadr�aj);
			}
			
			public String toString () {
				return "element ke�a: " + sadr�aj;
			}
   
}

