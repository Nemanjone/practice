
import java.util.ArrayList;

public class OsnovnaKlasa {

	public static void main(String[]args) {
		
		ArrayList<Student> lista = new ArrayList<Student>();
		
		lista.add(new Student("Pera", "Periæ", "165484618", "66411561"));
		lista.add(new Student("Mika", "Tika", "5454565", "5616516"));
		
		System.out.printf("Lista ima: ", lista.size() + "elemenata");
		
		for (int i = 0; i < lista.size(); i++) {
			lista.get(i).getJmbg();
			System.out.println(lista.get(i).getJmbg());
			
			
		}
		
		for (Student s:lista) {
			System.out.println(s.getJmbg());
		}
		
		lista.remove(1);
		
		lista.add(1, new Student ("Ana", "Balaban", "654165165", "65465"));
		
		for (Student s:lista)
			System.out.println(s.getIme());
	}
}
