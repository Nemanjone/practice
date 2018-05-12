import java.util.Scanner;

public class HashTable {

	private static class CvoristeListe{

		String kljuc;
		String vrednost;
		CvoristeListe sledeci;

	}

	private CvoristeListe[] tabela;
	private int brojac;

	public HashTable() {
		tabela = new CvoristeListe[64];
	}

	public HashTable (int pocetnaVelicina) {
		if (pocetnaVelicina <= 0)
			throw new IllegalArgumentException("Neprihvatljiva velicina tabele.");
		tabela = new CvoristeListe[pocetnaVelicina];

	}

	void prikazi() {

		System.out.println();
		for (int i = 0; i < tabela.length; i++) {
			System.out.print(i + ":");
			CvoristeListe lista = tabela[i];
			while (lista != null) {
				System.out.print(lista.kljuc +  "," + lista.vrednost);
				lista = lista.sledeci;
			}
			System.out.println();
		}	
	}

	public void put (String kljuc, String vrednost) {

		assert kljuc != null;

		int korpa = hash(kljuc);

		CvoristeListe lista = tabela[korpa];

		while (lista != null) {
			if(lista.kljuc.equals(kljuc))
				break;
			lista = lista.sledeci;
		}

		if (lista != null) {
			lista.vrednost = vrednost;
		}
		else {
			if(brojac >= 0.75 * tabela.length){
				promeniVelicinu();
				korpa = kljuc.hashCode();

			}

			CvoristeListe novoCvoriste = new CvoristeListe();
			novoCvoriste.kljuc = kljuc;
			novoCvoriste.vrednost = vrednost;
			novoCvoriste.sledeci = tabela[korpa];
			tabela[korpa] = novoCvoriste;
			brojac++;
		}

	}

	public String get(String kljuc) {
		int korpa = hash(kljuc);

		CvoristeListe lista = tabela[korpa];
		while (lista != null) {

			if (lista.kljuc.equals(kljuc))
				return lista.vrednost;
			lista = lista.sledeci;
		}
		return null;

	}

	public void remove(String kljuc) {

		int korpa =hash(kljuc);

		if(tabela[korpa] == null) {
			return;
		}
		if (tabela[korpa].kljuc.equals(kljuc)){
			tabela[korpa] = tabela[korpa].sledeci;
			brojac--;
			return;
		}
		CvoristeListe prethodni = tabela[korpa];
		CvoristeListe trenutni = prethodni.sledeci;

		while (trenutni != null && trenutni.kljuc.equals(kljuc)) {
			trenutni = trenutni.sledeci;
			prethodni = trenutni;
		}
		if(trenutni != null) {
			prethodni.sledeci = trenutni.sledeci;
			brojac--;
		}

	}

	public boolean containsKey(String kljuc) {

		int korpa = hash(kljuc);
		CvoristeListe lista = tabela[korpa];

		while (lista != null) {
			if(lista.kljuc.equals(kljuc))
				return true;;
				lista = lista.sledeci;
		}
		return false;
	}

	public int velicina() {
		return brojac;
	}

	private int hash(Object kljuc) {
		return(Math.abs(kljuc.hashCode())) % tabela.length;
	}

	private void promeniVelicinu() {
		CvoristeListe[] novaTabela = new CvoristeListe[tabela.length * 2];
		for (int i = 0; i < tabela.length; i++) {
			CvoristeListe lista = tabela[i];
			while (lista != null) {
				CvoristeListe sledeci = lista.sledeci;
				int hash = (Math.abs(lista.kljuc.hashCode())) % novaTabela.length;
				lista.sledeci = novaTabela[hash];
				novaTabela[hash] = lista;
				lista = sledeci;
			}

		}
		tabela = novaTabela;
	}

	public static void main(String[] args) {

		HashTable tabela = new HashTable(2);
		String kljuc, vrednost;
		Scanner tastatura = new Scanner(System.in);
		while (true) {
			System.out.println("\nMeni:");
			System.out.println("     1. test put(kljuc, vrednost)");
			System.out.println("     2. test get(kljuc)");
			System.out.println("     3. test containsKey(kljuc)");
			System.out.println("     4. test remove(kljuc)");
			System.out.println("     5. test prikazi sadrzaj hash tabele.");
			System.out.println("     6. EXIT");
			System.out.print("Izaberite opciju: ");

			int unos = tastatura.nextInt();


			switch (unos) {
			case 1:
				System.out.print("\n Kljuc = " );
				kljuc = tastatura.next();
				System.out.print(" Vrednost = ");
				vrednost = tastatura.next();
				tabela.put(kljuc, vrednost);
				break;
			case 2:
				System.out.print("\n Kljuc = " );
				kljuc = tastatura.next();
				System.out.println(" Vrednost je " + tabela.get(kljuc));
				break;
			case 3:
				System.out.print("\n Kljuc = " );
				kljuc = tastatura.next();
				System.out.println(" containsKey(" + kljuc + ") je " +
						tabela.containsKey(kljuc));
				break;
			case 4:
				System.out.print("\n Kljuc = " );
				kljuc = tastatura.next();
				tabela.remove(kljuc);
				break;
			case 5:
				tabela.prikazi();
				break;
			case 6:
				return;
			default:
				System.out.println(" Neprihvatljiva komanda!");
				break;
			}
			System.out.println("\n Velicina tabele je " + tabela.velicina());


		
		}

	}

}
