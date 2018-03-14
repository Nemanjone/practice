import java.util.ArrayList;
import java.util.Scanner;

public class PovezanaLista {
	
	public static void main(String[] args) {
		
		Scanner tastatura = new Scanner(System.in);
		
		ArrayList<ElementListe> povezanaLista = new ArrayList<ElementListe>();
		
		povezanaLista.add(new ElementListe("Ðokica", 17, "Predugaèak"));
		povezanaLista.add(new ElementListe("Mikica", 37, "Pametna"));
		povezanaLista.add(new ElementListe("Perica", 36, "Genije"));
		
		
		System.out.println(povezanaLista);
		
		System.out.println("Da li želite da dodate novi element? (d/n) ");
		
		
		String ponovo = tastatura.next(); 
		
		if (ponovo.equals("d")) {
			System.out.println("Unesite novi element: ");
			povezanaLista.add(new ElementListe(tastatura.nextLine(),tastatura.nextInt(), tastatura.nextLine()));
			System.out.println(povezanaLista);
		}}
		
	
		
	}
	
	
	
	

