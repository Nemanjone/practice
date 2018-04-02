import java.util.Map;
import java.util.TreeMap;
import java.util.TreeSet;

public class IndeksKnjige {
	
	TreeMap<String, TreeSet<Integer>> indeks;               //izraz i strana na kojoj swe nalazi
	indeks = new TreeMap<String, TreeSet<Integer>>();
	
	public void dodajIndeks(String izraz, int ref) {
		
		TreeSet<Integer> skupRef;
		
		skupRef = indeks.get(izraz);
		
		if (skupRef == null) {                                 // prva referenca za izraz
			TreeSet<Integer> prvaRef = new TreeSet<Integer>();
			prvaRef.add(ref);
			indeks.put(izraz, prvaRef);
		
		}
		else 
			skupRef.add(ref);

}
	
	public void prikažiIndeks() {
		
		for(Map.Entry<String, TreeSet<Integer>> par :
			                                           indeks.entrySet()) {
		
			String izraz = par.getKey();
			TreeSet<Integer> skupRef = par.getValue();
			System.out.print(izraz);
			for (int ref : skupRef) {
				System.out.print( " " + ref);
			}
			System.out.println();
		  }
		
	   }
	}
	
	
	
