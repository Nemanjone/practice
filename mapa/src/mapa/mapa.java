package mapa;

import java.util.Iterator;
import java.util.Map;
import java.util.Set;

public class mapa {
	
	Map<String, Double> mapa;
	
	Set<Map.Entry<String,Double>> parovi = mapa.entrySet();
	Iterator<Map.Entry<String, Double>> parIter = parovi.iterator();
	
	System.out.println("Mapa sadrži sledeæe parove kljuè/vrednost: ");
	
	while (parIter.hasNext()) {
		Map.Entry<String, Double>par = parIter.next();
		String kljuè = par.getKey();
		Double vrednost = par.getValue();
		System.out.println(kljuè + "," + vrednost);
		
	}
}
