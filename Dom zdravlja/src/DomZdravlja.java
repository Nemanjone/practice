import java.util.*;

public class DomZdravlja {

	private static final int NOVI_PACIJENT = 1;
	private static final int ZAVR�EN_PREGLED = 2;
	private static final int LISTA_PACIJENATA = 3;
	private static final int LISTA_DOKTORA = 4;
	private static final int LISTA_PREGLEDA = 5;
	private static final int KRAJ_RADA = 6;
	
	private String  imeDZ;
	private ArrayList<Doktor> listaDoktora;
	private ArrayList<Pacijent> listaPacijenata;
	private ArrayList<Pregled> listaPregleda;
	
	public DomZdravlja (String imeDZ) {
		this.imeDZ = imeDZ;
		listaDoktora = new ArrayList<Doktor>();
		listaPacijenata = new ArrayList<Pacijent>();
		listaPregleda = new ArrayList<Pregled>();
		
	}
	
	public void otvoriRecepciju (Scanner t) {
		
		String ime,id,spec;
		String jo�;
		
		System.out.println("   Dom zdravlja\"" + imeDZ + "\"");
		System.out.println("\nUnesite listu doktora u smeni: ");
		System.out.println();
		
		do {
			System.out.print("     Ime doktora: "); ime = t.nextLine();
			System.out.print("     Id doktora: ");id = t.nextLine();
			System.out.print("Specijalnost doktora: "); spec = t.nextLine();
			 
			Doktor dok = new Doktor (ime, id,spec);
			listaDoktora.add(dok);
			System.out.print("\nSlede�i doktor (d/n)? ");
			jo� = t.nextLine();
		} while (jo�.toUpperCase().equals("D"));
	}
	
	public void otvori�ekaonicu(Scanner t) {
		
		int opcija;
		do {
			prika�iOpcije();
			
			opcija = t.nextInt();
			t.nextLine();
			
			switch (opcija) {
			case NOVI_PACIJENT:
				dodajPacijenta(t);
				break;
			case ZAVR�EN_PREGLED:
				zavr�iPregled(t);
				break;
			case LISTA_PACIJENATA:
				prika�iPacijente();
				break;
			case LISTA_DOKTORA:
				prika�iDoktore();
				break;
			case LISTA_PREGLEDA:
				prika�iPreglede();
				break;
			case KRAJ_RADA:
				break;
				default:
				System.out.println("\nIzabrali ste pogre�nu opciju! ");
			}
		}while(opcija !=KRAJ_RADA);
	}
	
	 private void prika�iOpcije() {
		 
		 System.out.println();
		 System.out.println("Opcije menija su: ");
		 System.out.println("  1. Novi pavijent u �ekaonici");
		 System.out.println("  2. Zavr�en pregled pacijenta");
		 System.out.println("  3. Lista pacijenata u �ekaonici");
		 System.out.println("  4. Lista slobodnih doktora");
		 System.out.println("  5. Lista trenutnih pregleda");
		 System.out.println("  6. Kraj rada");
		 System.out.print(" Unesite broj opcije: ");
		 
	 }
	
	private void prika�iDoktore() {
		
		int n = listaDoktora.size();
		if (n == 0) {
			System.out.println();
			System.out.println("\nNema slobodnih doktora...");
		}
		else {
			System.out.println("\nSlobodni doktori: ");
			for (int i = 0; i<n; i++)
				listaDoktora.get(i).prika�i();
			
		}
		
	}
	 
	 private void prika�iPacijente() {
		 
		 int n = listaPacijenata.size();
		 if (n == 0) {
			 System.out.println();
			 System.out.println("\nNema pacijenata koji �ekaju...");
		 }
			 else {
				 for(int i=0; i < n; i++)
					 listaPacijenata.get(i).prika�i();
			 } 
	 }
		 
		 private void prika�iPreglede() {
			 
			 int n = listaPregleda.size();
			 
			 if ( n == 0) {
				 System.out.println();
				 System.out.println("\nNema Pregleda koji su u toku...");
			 }
			 else {
				 for (int i = 0; i < n; i++)
					 listaPregleda.get(i).prika�i();	 
			 } 
		 }
		 
		 private void dodajPacijenta(Scanner t) {
			 
			 String ime, jmb, simptom, mob;
			 
			 System.out.println();
			 System.out.print("   Ime pacijenta: "); ime = t.nextLine();
			 System.out.print("   JMB pacijenta: "); jmb = t.nextLine();
		     System.out.print("   Simptomi bolesti: ");simptom = t.nextLine();
		     System.out.print("Med. oblast bolesti: ");mob = t.nextLine();
		     
		     Pacijent pac = new Pacijent(ime, jmb, simptom, mob);
		     listaPacijenata.add(pac);
		     proveri�ekaonicu();    
		 }
		 
		 private void zavr�iPregled(Scanner t) {
			 
			 String id;
			 System.out.println();
			 System.out.print("\nID doktora kod koga je zavr�en pregled; ");
			 id = t.nextLine();
			 
			 for (int i = 0; i < listaPregleda.size(); i++) {
				 Pregled preg = listaPregleda.get(i);
				 Doktor dok = preg.getDok();
				 if (id.equals(dok.getID())) {
					 Pacijent pac = preg.getPac();
					 listaPacijenata.remove(pac);
					 listaDoktora.add(dok);
					 System.out.println("\nDoktor " + id + " je slobodan.");
					 listaPregleda.remove(preg);
					 proveri�ekaonicu();
					 return;	 
				 } 
			 }
			 System.out.println("Gre�ka. Doktor " + id + " nije na�en u lisit pregleda.");	 
		 }
		 
		 private void proveri�ekaonicu() {
			 
			 for (int i = 0; i < listaPacijenata.size();i ++ ) {
				 Pacijent pac = listaPacijenata.get(i);
				 for ( int j = 0; j < listaDoktora.size(); j++) {
					 Doktor dok = listaDoktora.get(j);
					 if ( pac.getMob().equals(dok.getSpec())) {
						 Pregled preg = new Pregled (dok,pac);
						 listaPregleda.add(preg);
						 listaPacijenata.remove(pac);
						 i--;
						 listaDoktora.remove(dok);
						 System.out.println("\nNovi pregled: ");
						 preg.prika�i();
						 break;
					 }
					 
				 }
				 
			 }
		 }
		 
		 public static void main (String[]args) {
			 
			 Scanner tastatura = new Scanner(System.in);
			 
			 DomZdravlja dz = new DomZdravlja("Beograd");
			 dz.otvoriRecepciju(tastatura);
			 dz.otvori�ekaonicu(tastatura);
	 
		 }
		 
	 }
	
	class Pacijent {
		
		private String ime;
		private String jmb;
		private String simptom;
		private String mob;
		
		public Pacijent (String ime, String jmb, String simptom, String mob) {
	   
			 this.ime = ime;
			 this.jmb = jmb;
			 this.simptom = simptom;
			 this.mob = mob;	 
		}
		public String getIme() {
			return ime;
		}
		
		public String getMob() {
			return mob;
		}
		
		public void prika�i() {
			
			System.out.printf("\n-----------------------------------\n");
			System.out.printf("     Ime pacijenta: %s\n", ime);
			System.out.printf("     JMB pacijenta: %s\n", jmb);
			System.out.printf("     Simptomi bolesti: %s\n", simptom);
			System.out.printf("Med. oblast bolesti: %s\n", mob);
		}
		
	}
		
		class Doktor {
			
			private String ime;
			private String spec;
			private String id;
			
			public Doktor ( String ime, String id, String spec) {
				
				this.ime = ime;
				this.id = id;
				this.spec = spec;
			}
			
			public String getIme() {
				return ime;
			}
			public String getID() {
				return id;
			}
			public String getSpec() {
				return spec;
			}
			
			public void prika�i() {
				System.out.printf("\n------------------------------\n");
				System.out.printf("         Ime doktora: %s\n", ime);
				System.out.printf("         ID doktora: %s\n", id);
				System.out.printf("Specijalnost doktora: %s\n", spec);
			
			}
		
	}
		
		class Pregled {
			
			private Doktor dok;
			private Pacijent pac;
			
			public Pregled(Doktor dok, Pacijent pac) {
				
				this.dok = dok;
				this.pac = pac;	
			}
			public Doktor getDok() {
				return dok;
			}
			
			public Pacijent getPac() {
				return pac;
			}
			public void prika�i() {
				dok.prika�i();
				pac.prika�i();
			}
		}
	
	
	
	

