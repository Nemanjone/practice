import java.util.*;
import java.io.*;

public class PonovljeneReèi {

	
	public static void main(String[] args) throws IOException {
	
	int brojReèi = 0;
	int brojÈestihReèi= 0;
	KešMemorija kešReèi = new KešMemorija(30);
	
	System.out.println("Lista èesto ponavljanih reèi: ");
	System.out.println("----------------------------");
	
	Scanner dokument = new Scanner(new File("tekst.txt"));
	
	while (dokument.hasNext()) {
		String reè = dokument.next();
		brojReèi++;
		kešReèi.add(new ElementKeša(reè.toLowerCase()));
		int r = kešReèi.NKE().getRef();
		if (r>1) {
			brojÈestihReèi++;
			System.out.println(reè + " (" + r + ")");
		}
	}
			System.out.println("------------------------");
			System.out.println("Ukupan broj reèi u tekstu: " + brojReèi);
			System.out.println("Broj ponavljanih reèi: " + brojÈestihReèi);
	} 
}
	 class KešMemorija {
		
	
	private ElementKeša[] keš;
	private int n;
	
	public KešMemorija(int velièina) {
		
		keš = new ElementKeša[velièina];	
	}
	public void add(ElementKeša noviElem) {
		ElementKeša elem;
		int i;
		
		for ( i = 0; i <n; i++) {
			elem = keš[i];
			if(noviElem.equals(elem)) {
			noviElem = elem;
			break;
		}
	}
         if (i == n)
        	 if(n == keš.length)
        		 i--;
        	 else n++;
         
         for (int j = i; j>0; j--)
        	 keš[j] = keš[j-1];
         noviElem.uvecajRef();
         keš[0] = noviElem;
         
	}
	
	public ElementKeša NKE() {
		return keš[0];
	}
	public void prikaži() {
		for ( int i = 0; i<n;i++) {
			System.out.println(keš[i].getSadržaj());
		    System.out.println("  ("+ keš[i].getRef() + ")");
	}
}
}
	
class ElementKeša {
		
		private String sadržaj;
		private int ref;
		
		public ElementKeša(String reè) {
			sadržaj = reè;
		}
		public String getSadržaj() {
			return sadržaj;	
		}
		
		public int getRef() {
			return ref;
		}
		
		public void uvecajRef() {
			ref++;
		}
			public boolean equals (Object o) {
				ElementKeša drugiElement = (ElementKeša) o;
				return sadržaj.equals(drugiElement.sadržaj);
			}
			
			public String toString () {
				return "element keša: " + sadržaj;
			}
   
}

