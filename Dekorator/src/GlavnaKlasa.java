
public class GlavnaKlasa {

	public static void main(String[] args) {
		
		Mail ml = new MailDekorator("@singidunum.ac.rs", "Neki dopunski potpis koji ima firma...");
		
		ml.setTo("mtair@singimail.ac.rs");
		ml.setContent("Dobar dan!");
		ml.send();
		
		
		
		
		
	}
}
