import java.util.ArrayList;
import java.util.List;

 public class DataBase {
	
	private static DataBase instance = null;
	
	private Object connection = null;
	
	private DataBase () {}
	
	public final static DataBase getInstance() {
		if(instance == null) {
			instance = new DataBase();
		}
		return instance;
	}
	
	private void connect() {
		if (connection == null) {
			System.out.println("Uspostavljam konekciju... ");
		}
		connection = "konekcija";
	}
	
	public List<Object> query (String sqlQuery) {
		
		connect();
		System.out.println("Izvršavam upit... ");
		
		ArrayList<Object> rezultati = new ArrayList<>();
		rezultati.add(new String( "Rezultat 1")); //simulacija
		rezultati.add(new String ("Rezultat 2"));
		rezultati.add(new String ("Rezultat 3"));
		return rezultati;
	}
	
	

}
