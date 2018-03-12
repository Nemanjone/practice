import java.util.Random;

public class Raèun {

	private String imeRadnje, ulicaIBroj, grad;
	private String vreme, datum;
	private String kasir;
	
	private int transakcija;
	
	private Stavka [] stavke = new Stavka[50];
	private int sledeæaStavka = 0;
	
	public Raèun(String imeRadnje, String ulicaIBroj, String grad, String vreme, String datum, String kasir) {
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
		stavke[sledeæaStavka] = s;
		sledeæaStavka++;
			
	}
	
	public void štampajSeparator(int širinaRaèuna) {
		for (int i=0; i < širinaRaèuna/2; i++) {
			System.out.print("= ");
		}
		System.out.println();
	}
	
		public void štampajRaèun(int širinaRaèuna) {
			//100 širina raèuna
			
			System.out.println(imeRadnje);
			System.out.println(ulicaIBroj + " " + grad);
			štampajSeparator(širinaRaèuna);
			System.out.println("Datum " + datum);
			System.out.println("Vreme " + vreme);
			štampajSeparator(širinaRaèuna);
			
			double suma = 0;
			
			for ( int i = 0; i < sledeæaStavka; i++) {
				
				stavke[i].štampajStavku(širinaRaèuna);
				suma+=stavke[i].getCena();
			}
			
			štampajSeparator(širinaRaèuna);
			
			double porez = suma*0.2;
			double iznos = suma - porez;
			
			int širinaZaNaziv = širinaRaèuna - 13; 
			
			
			String format1 = "%%-%ds%%12.2f\n";
			String format2 = String.format(format1, širinaZaNaziv);
			
			
			System.out.printf(format2, "Ukupan iznos: ",iznos );
			System.out.printf(format2, "Ukupan porez: ", porez);
			System.out.printf(format2, "Ukupno za uplatu: ", suma);
			štampajSeparator(širinaRaèuna);
			
			System.out.println("Kasir: " + kasir);
			System.out.println("Broj transakcije: " + transakcija);
			
			
		}
	
	}
	

