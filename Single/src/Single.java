
public class Single {
	
	public static void main (String [] args) {
		
		m1();
		m2();
		m3();
		
	}
	
	public static void m1() {
		DataBase db = DataBase.getInstance();
		db.query("SELECT * FROM user;");
	}
	public static void m2() {
		DataBase db = DataBase.getInstance();
		db.query("SELECT * FROM post;");
		
	}
	public static void m3() {
		DataBase db = DataBase.getInstance();
		db.query("SELECT * FROM page;");
	}
	
}
