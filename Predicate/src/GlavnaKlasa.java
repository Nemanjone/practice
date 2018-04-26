import java.util.List;
import java.util.ArrayList;
import java.util.Collection;
import java.util.TreeSet;

public class GlavnaKlasa  {

	static class ParanBroj implements Predicate<Integer> {

		public boolean test(Integer i) {
			if(i % 2 == 0)
				return true;
			else
				return false;
		}
	}

	static class Big implements Predicate<Integer> {

		public boolean test(Integer i) {
			if(i > 100)
				return true;
			else
				return false;
		}
	}

	static Collection<Integer> makeSet() {
		Collection<Integer> set = new TreeSet<Integer>();
		set.add(32);
		set.add(17);
		set.add(142);
		set.add(56);
		set.add(1899);
		set.add(57);
		set.add(999);
		set.add(86);
		set.add(83);
		set.add(101);
		set.add(67);

		return set;
	}


	public static void main(String[] args) {

		Collection<Integer> kolekcija;

		List<Integer> rezultat;

		Predicate<Integer> pred = new ParanBroj();

		kolekcija = makeSet();
		System.out.println("Originalna kolekcija " + kolekcija);

		Predicates.remove(kolekcija, pred);
		System.out.println("Ukloni neparne: " + kolekcija);

		kolekcija = makeSet();
		Predicates.retain(kolekcija, pred);
		System.out.println("Zadrzi parne: " + kolekcija);

		kolekcija = makeSet();
		rezultat = Predicates.collect(kolekcija, pred);
		System.out.println("Skupi parne: " + rezultat);

		ArrayList<Integer> lista = new ArrayList<Integer>(kolekcija);
		int i = Predicates.find(lista, pred);
		System.out.println("Prvi parni broj ima indeks: " + i);

		pred = new Big();

		kolekcija = makeSet();
		System.out.println("Originalna kolekcija: " + kolekcija);
		Predicates.remove(kolekcija, pred);
		System.out.println("Ukloni brojeve manje od 100: " + kolekcija);

		kolekcija = makeSet();
		Predicates.retain(kolekcija, pred);
		System.out.println("Zadrzi brojeve vece od 100: " + kolekcija);

		kolekcija = makeSet();
		rezultat = Predicates.collect(kolekcija, pred);
		System.out.println("Lista brojeva veæih od sto: " + rezultat);

		lista = new ArrayList<Integer>(kolekcija);
		i = Predicates.find(lista, pred);
		System.out.println("Prvi veliki broj je na indeksu: " + i);

	}

}
