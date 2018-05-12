import java.util.Random;

public class Ra�un {

	private String imeRadnje, ulicaIBroj, grad;
	private String vreme, datum;
	private String kasir;
	
	private int transakcija;
	
	private Stavka [] stavke = new Stavka[50];
	private int slede�aStavka = 0;
	
	public Ra�un(String imeRadnje, String ulicaIBroj, String grad, String vreme, String datum, String kasir) {
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
		stavke[slede�aStavka] = s;
		slede�aStavka++;
			
	}
	
	public void �tampajSeparator(int �irinaRa�una) {
		for (int i=0; i < �irinaRa�una/2; i++) {
			System.out.print("= ");
		}
		System.out.println();
	}
	
		public void �tampajRa�un(int �irinaRa�una) {
			//100 �irina ra�una
			
			System.out.println(imeRadnje);
			System.out.println(ulicaIBroj + " " + grad);
			�tampajSeparator(�irinaRa�una);
			System.out.println("Datum " + datum);
			System.out.println("Vreme " + vreme);
			�tampajSeparator(�irinaRa�una);
			
			double suma = 0;
			
			for ( int i = 0; i < slede�aStavka; i++) {
				
				stavke[i].�tampajStavku(�irinaRa�una);
				suma+=stavke[i].getCena();
			}
			
			�tampajSeparator(�irinaRa�una);
			
			double porez = suma*0.2;
			double iznos = suma - porez;
			
			int �irinaZaNaziv = �irinaRa�una - 13; 
			
			
			String format1 = "%%-%ds%%12.2f\n";
			String format2 = String.format(format1, �irinaZaNaziv);
			
			
			System.out.printf(format2, "Ukupan iznos: ",iznos );
			System.out.printf(format2, "Ukupan porez: ", porez);
			System.out.printf(format2, "Ukupno za uplatu: ", suma);
			�tampajSeparator(�irinaRa�una);
			
			System.out.println("Kasir: " + kasir);
			System.out.println("Broj transakcije: " + transakcija);
			
			
		}
	
	}
	

