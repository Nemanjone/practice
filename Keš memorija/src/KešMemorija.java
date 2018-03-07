import java.util.Scanner;

public class KešMemorija {
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
         keš[0] = noviElem;
         
	}
	
	public ElementKeša NKE() {
		return keš[0];
	}
	public void prikaži() {
		for ( int i = 0; i<n;i++)
			System.out.println(keš[i]);
	}
	public void prikažiSve() {
	for (ElementKeša elem:keš)
		System.out.println(elem);
	}
	public static void main(String[] args) {
		
		KešMemorija kešReèi = new KešMemorija(5) ;
		
		kešReèi.add(new ElementKeša("Pera"));
		kešReèi.add(new ElementKeša("Zika"));
		kešReèi.add(new ElementKeša("Laza"));
		kešReèi.add(new ElementKeša("Zika"));
		kešReèi.add(new ElementKeša("Mika"));
		kešReèi.add(new ElementKeša("Mika"));
		kešReèi.add(new ElementKeša("Pera"));
		kešReèi.add(new ElementKeša("Sava"));
		kešReèi.add(new ElementKeša("Deki"));
		kešReèi.add(new ElementKeša("Zika"));
		kešReèi.add(new ElementKeša("Zika"));
		System.out.println("Sadržaj keša: ");
		kešReèi.prikažiSve();
		
		
		
	}
}

	class ElementKeša {
		
		private String sadržaj;
		
		public ElementKeša(String s) {
			sadržaj = s;
		}
		public String getSadržaj() {
			return sadržaj;	
		}
		
		public boolean equals (Object o) {
			ElementKeša drugiElement = (ElementKeša) o;
			return sadržaj.equals(drugiElement.sadržaj);
		}
		
		public String toString () {
			return "element keša: " + sadržaj;
		}
		
	}



