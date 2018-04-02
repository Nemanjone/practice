import java.util.HashMap;
import java.util.Map;

public class TeleImenik {
	
	
	private Map<String,String> imenik;
	
	public TeleImenik() {
		imenik = new HashMap<String,String>();
		
	}
	
	public String naðiBroj(String imeOsobe) {
		
		return imenik.get(imeOsobe);
	}
	public void dodajKontakt(String imeOsobe, String brojOsobe) {
	
		imenik.put(imeOsobe, brojOsobe);
		
	}
	public void ukloniKontakt(String imeosobe) {
		imenik.remove(imeosobe);
	}

}
