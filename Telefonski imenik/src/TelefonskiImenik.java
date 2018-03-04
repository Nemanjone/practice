
public class TelefonskiImenik {
	
	private String[][]  imenik;
	private int n = 0;
	private final int N = 100;
	
	private TelefonskiImenik () {
		imenik = new String[N][2];
	}
		
		private int naðiKontakt(String imeOsobe) {
			for (int i = 0; i < n; i++) {
				if(imenik[i][0].equals(imeOsobe))
					return i;
			
			}	return -1;
		
		}
	public String naðiBroj(String imeOsobe)	{
		
		int i = naðiKontakt(imeOsobe);
		if ( i>=0)
			return imenik[i][1];
	else 
		return null;
	}
	
	public void dodajKontakt(String imeOsobe, String brojOsobe) {
		
		if (imeOsobe == null || brojOsobe == null) {
			System.out.println("Greška. Prazno ime ili broj kontakta. ");
			return;
		}
		int i = naðiKontakt(imeOsobe);
		if (i>=0)
			imenik[i][1] = brojOsobe;
		else if(n ==N)
			System.out.println("Imenik je pun!");
		else {
			imenik[n][0] = imeOsobe;
			imenik[n][1] = brojOsobe;
			n++;
		}
		
	}
	
	public void ukloniKontakt (String imeOsobe) {
		int i = naðiKontakt(imeOsobe);
		if (i>=0) {
			imenik[i][0] = imenik[n-1][0];
			imenik[i][1] = imenik[n-1][1];
			n--;
		}
	}
	 public static void main(String[] args) {
		 TelefonskiImenik mojImenik = new TelefonskiImenik();
		 mojImenik.dodajKontakt("Tara", null);
		 mojImenik.dodajKontakt("Tara", "063254816");
		 mojImenik.dodajKontakt("Mama", "0631088449");
		 mojImenik.dodajKontakt("Nemanja", "0637207413");
		 mojImenik.dodajKontakt("Mama", "0641756370");
		 System.out.println("Nemanja: " + mojImenik.naðiKontakt("Nemanja"));
		 mojImenik.dodajKontakt("Nemanja", "06987456");
		 System.out.println("Nemanja: " + mojImenik.naðiBroj("Nemanja"));
		 System.out.println("Mama: " + mojImenik.naðiBroj("Mama"));
		 mojImenik.ukloniKontakt("Tara");
		 System.out.println("Tara: " + mojImenik.naðiBroj("Tara"));
		 
		 
	 }
	
	
}