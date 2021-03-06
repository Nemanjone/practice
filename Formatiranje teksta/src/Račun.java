import java.util.Random;

public class Račun {

	private String imeRadnje, ulicaIBroj, grad;
	private String vreme, datum;
	private String kasir;
	
	private int transakcija;
	
	private Stavka [] stavke = new Stavka[50];
	private int sledećaStavka = 0;
	
	public Račun(String imeRadnje, String ulicaIBroj, String grad, String vreme, String datum, String kasir) {
		super();
		this.imeRadnje = imeRadnje;
		this.ulicaIBroj = ulicaIBroj;
		this.grad = grad;
		this.vreme = vreme;
		this.datum = datum;
		this.kasir = kasir;
		
		Random r = new Random();
		
		this.transakcija = r.nextInt(100000);
		
	}

	public void dodajStavku(Stavka s) {
		stavke[sledećaStavka] = s;
		sledećaStavka++;
			
	}
	
	public void štampajSeparator(int širinaRačuna) {
		for (int i=0; i < širinaRačuna/2; i++) {
			System.out.print("= ");
		}
		System.out.println();
	}
	
		public void štampajRačun(int širinaRačuna) {
			//100 širina računa
			
			System.out.println(imeRadnje);
			System.out.println(ulicaIBroj + " " + grad);
			štampajSeparator(širinaRačuna);
			System.out.println("Datum " + datum);
			System.out.println("Vreme " + vreme);
			štampajSeparator(širinaRačuna);
			
			double suma = 0;
			
			for ( int i = 0; i < sledećaStavka; i++) {
				
				stavke[i].štampajStavku(širinaRačuna);
				suma+=stavke[i].getCena();
			}
			
			štampajSeparator(širinaRačuna);
			
			double porez = suma*0.2;
			double iznos = suma - porez;
			
			int širinaZaNaziv = širinaRačuna - 13; 
			
			
			String format1 = "%%-%ds%%12.2f\n";
			String format2 = String.format(format1, širinaZaNaziv);
			
			
			System.out.printf(format2, "Ukupan iznos: ",iznos );
			System.out.printf(format2, "Ukupan porez: ", porez);
			System.out.printf(format2, "Ukupno za uplatu: ", suma);
			štampajSeparator(širinaRačuna);
			
			System.out.println("Kasir: " + kasir);
			System.out.println("Broj transakcije: " + transakcija);
			
			
		}
	
	}
	

