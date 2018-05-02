import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import javax.swing.JButton;
import javax.swing.JFileChooser;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import java.util.ArrayList;
import java.util.Scanner;

public class DameDatoteka extends JPanel {

	/**
	 * 
	 */
	private static final long serialVersionUID = -7422266333636042996L;

	public static void main(String[] args) {

		JFrame okvir = new JFrame("Dame");
		DameDatoteka sadrzaj = new DameDatoteka();
		okvir.setContentPane(sadrzaj);
		okvir.pack();
		Dimension velicinaOkvira = Toolkit.getDefaultToolkit().getScreenSize();
		okvir.setLocation((int)(velicinaOkvira.width - velicinaOkvira.getWidth() / 2), 
				(int)(velicinaOkvira.height - velicinaOkvira.getHeight() / 2));
		okvir.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		okvir.setResizable(false);
		okvir.setVisible(true);

	}

	private JButton novaIgraDugme;
	private JButton predajPartijuDugme;
	private JButton snimiDugme;
	private JButton ucitajDugme;

	private JLabel poruka;

	public DameDatoteka() {

		setLayout(null);
		setPreferredSize(new Dimension(350, 250));
		setBackground(new Color(0, 150, 0));

		Tabla tabla = new Tabla();

		add(tabla);
		add(novaIgraDugme);
		add(predajPartijuDugme);
		add(snimiDugme);
		add(ucitajDugme);
		add(poruka);

		tabla.setBounds(20, 20, 164, 164);
		novaIgraDugme.setBounds(210, 20, 120, 30);
		ucitajDugme.setBounds(210, 65, 120, 30);
		snimiDugme.setBounds(210, 110, 120, 30);
		predajPartijuDugme.setBounds(210, 155, 120, 30);
		poruka.setBounds(0, 200, 350, 30);

	}

	private static class DamePotez {

		int izReda, izKolone;
		int uRed, uKolonu;

		public DamePotez(int r1, int k1, int r2, int k2) {
			izReda = r1;
			izKolone = k1;
			uRed = r2;
			uKolonu = k2;
		}

		boolean jeSkocila() {
			return (izReda - uRed == 2 || izKolone - uKolonu == 2);
		}

	}

	private class Tabla extends JPanel implements ActionListener, MouseListener {

		/**
		 * 
		 */
		private static final long serialVersionUID = 8015396831673511098L;

		DamaPodaci tabla;

		boolean igraUToku;

		int trenutniIgrac;
		int izabraniRed, izabranaKolona;

		DamePotez[] dozvoljeniPotezi;

		JFileChooser prozorIzbora;

		Tabla() {
			setBackground(Color.BLACK);
			addMouseListener(this);

			predajPartijuDugme = new JButton("Predaj se!");
			predajPartijuDugme.addActionListener(this);

			novaIgraDugme = new JButton("Nova igra");
			novaIgraDugme.addActionListener(this);

			snimiDugme = new JButton("Snimi igru");
			snimiDugme.addActionListener(this);

			ucitajDugme = new JButton("Uèitaj igru");
			ucitajDugme.addActionListener(this);

			poruka = new JLabel("", JLabel.CENTER);
			poruka.setFont(new Font("Serif", Font.BOLD, 14));
			poruka.setForeground(Color.GREEN);
			tabla = new DamaPodaci();
			napraviNovuIgru();

		}

		public void actionPerformed(ActionEvent dogadjaj) {

			Object izvor = dogadjaj.getSource();
			if (izvor == novaIgraDugme)
				napraviNovuIgru();
			else if (izvor == predajPartijuDugme)
				predajPartiju();
			else if (izvor == snimiDugme)
				sacuvajPartiju();
			else if (izvor == ucitajDugme)
				ucitajPartiju();
		}

		void sacuvajPartiju() {
			if (prozorIzbora == null)
				prozorIzbora = new JFileChooser();
			File izabranaDatoteka;
			izabranaDatoteka = new File("Dame.text");
			prozorIzbora.setSelectedFile(izabranaDatoteka);;
			prozorIzbora.setDialogTitle("Izaberite datoteku za snimanje igre: ");
			int opcija = prozorIzbora.showSaveDialog(this);
			if (opcija != JFileChooser.APPROVE_OPTION)
				return;
			izabranaDatoteka = prozorIzbora.getSelectedFile();
			if (izabranaDatoteka.exists()) {
				int odgovor = JOptionPane.showConfirmDialog(this,
						"Datoteka \"" + izabranaDatoteka.getName() +
						"\" vec postoji.\nDa li zelite da je zamenite? ", 
						"Potvrdi zamenu",
						JOptionPane.YES_NO_OPTION,
						JOptionPane.WARNING_MESSAGE);
				if (odgovor != JOptionPane.YES_NO_OPTION)
					return;
			}

			PrintWriter izlaz;

			try {
				FileWriter tok = new FileWriter(izabranaDatoteka);
				izlaz = new PrintWriter(tok);
			}
			catch (Exception e) {
				JOptionPane.showMessageDialog(this, "Greska prilikom otvaranja datoteke:\n" + e);
				return;
			}
			try {
				izlaz.println("DameDatoteka");
				for (int red = 0; red < 8; red++) {
					for (int kolona = 0; kolona < 8; kolona++) {
						int deo = tabla.deoNa(red, kolona);
						switch (deo) {
						case DamaPodaci.PRAZNO: izlaz.print("prazno "); break;
						case DamaPodaci.CRVENI: izlaz.print("crveni "); break;
						case DamaPodaci.CRNI: izlaz.print("crni "); break;
						case DamaPodaci.CRVENI_KRALJ: izlaz.print("CRVENI "); break;
						case DamaPodaci.CRNI_KRALJ: izlaz.print("CRNI "); break;
						}
					}
					izlaz.println();	

				}
				izlaz.println(trenutniIgrac == DamaPodaci.CRVENI ? "crveni" : "crni");
				izlaz.flush();
				izlaz.close();
				if (izlaz.checkError())
					throw new IOException("Greska prilikom snimanja datoteke.");

			} 
			catch (Exception e) {
				JOptionPane.showMessageDialog(this, "Greska prilikom zapisivanja teksta:\n" + e);
			}
		}

		void ucitajPartiju() {
			if (prozorIzbora == null)
				prozorIzbora = new JFileChooser();
			prozorIzbora.setDialogTitle("Izaberite datoteku igre Dame: ");
			prozorIzbora.setSelectedFile(null);
			int opcija = prozorIzbora.showOpenDialog(this);
			if (opcija != JFileChooser.APPROVE_OPTION)
				return;
			File izabranaDatoteka = prozorIzbora.getSelectedFile();
			Scanner tastatura;
			try {
				BufferedReader ulaz = new BufferedReader(new FileReader(izabranaDatoteka));
				tastatura = new Scanner(ulaz);
			}
			catch (Exception e) {
				JOptionPane.showMessageDialog(this, "Greska prilikom ucitavanja datoteke.\n" + e);
				return;
			}
			try {
				DamaPodaci novaTabla = new DamaPodaci();
				int noviTrenutniIgrac;
				String imeProgramaIzDatoteke = tastatura.nextLine();
				if (!imeProgramaIzDatoteke.equals("DameDatoteka"))
					throw new Exception("Izabrana datoteka ne sadrzi igru dame.");
				for (int red = 0; red < 8; red++) {
					for (int kolona = 0; kolona < 8; kolona++) {
						String kodDela = tastatura.next();
						switch (kodDela) {
						case "prazno": novaTabla.postaviDeoNa(red, kolona, DamaPodaci.PRAZNO); break;
						case "crveni": novaTabla.postaviDeoNa(red, kolona, DamaPodaci.CRVENI); break;
						case "crni":   novaTabla.postaviDeoNa(red, kolona, DamaPodaci.CRNI); break;
						case "CRVENI": novaTabla.postaviDeoNa(red, kolona, DamaPodaci.CRVENI_KRALJ); break;
						case "CRNI":   novaTabla.postaviDeoNa(red, kolona, DamaPodaci.CRNI_KRALJ); break;
						default: throw new Exception("Nedozvoljeni podaci nadjeni u datoteci.");
						}
						if (red % 2 != kolona % 2 && novaTabla.deoNa(red, kolona) != DamaPodaci.PRAZNO)
							throw new Exception("Nedozvoljeni podaci2 nadjeni u datoteci.");
					}
				}
				String trenutniIgracString = tastatura.next();
				if (trenutniIgracString.equals("crveni"))
					noviTrenutniIgrac = DamaPodaci.CRVENI;
				else if (trenutniIgracString.equals("crni"))
					noviTrenutniIgrac = DamaPodaci.CRNI;
				else
					throw new Exception("Nedozvoljeni trenutni igrac nadjen u datoteci.");
				tabla = novaTabla;
				trenutniIgrac = noviTrenutniIgrac;
				dozvoljeniPotezi = tabla.getDozvoljeniPotezi(trenutniIgrac);
				izabraniRed = -1;
				igraUToku = true;
				novaIgraDugme.setEnabled(false);
				ucitajDugme.setEnabled(false);
				snimiDugme.setEnabled(true);
				predajPartijuDugme.setEnabled(true);
				if (trenutniIgrac == DamaPodaci.CRVENI)
					poruka.setText("Igra ucitana -- CRVENI ja na potezu.");
				else
					poruka.setText("Igra ucitana -- CRNI je na potezu.");
				repaint();
			}
			catch (Exception e) {
				JOptionPane.showMessageDialog(this, "Greska prilikom ucitavanja podataka:\n" + e);
			} 
		}

		void napraviNovuIgru(){
			if (igraUToku == true) {
				poruka.setText("Prvo zavrsite trenutnu igru!");
				return;
			}
			tabla.postaviIgru();
			trenutniIgrac = DamaPodaci.CRVENI;
			dozvoljeniPotezi = tabla.getDozvoljeniPotezi(DamaPodaci.CRVENI);
			izabraniRed = -1;
			poruka.setText("Crveni: igraj!");
			igraUToku = true;
			novaIgraDugme.setEnabled(false);
			snimiDugme.setEnabled(true);
			predajPartijuDugme.setEnabled(true);
			repaint();
		}
		void predajPartiju() {
			if (igraUToku == false) {
				poruka.setText("Igra nije u toku!");
				return;
			}
			if (trenutniIgrac == DamaPodaci.CRVENI)
				krajIgre("CRVENI se predao. CRNI je pobednik.");
			else
				krajIgre("CRNI se predao. CRVENI je pobednik");
		}

		void krajIgre(String str) {
			poruka.setText(str);
			novaIgraDugme.setEnabled(true);
			ucitajDugme.setEnabled(true);
			snimiDugme.setEnabled(false);
			predajPartijuDugme.setEnabled(false);
			igraUToku = false;
		}

		void klikniNaKvadrat(int red, int kolona) {
			for (int i = 0; i < dozvoljeniPotezi.length; i++) {
				if (dozvoljeniPotezi[i].izReda == red && dozvoljeniPotezi[i].izKolone == kolona) {
					izabraniRed = red;
					izabranaKolona = kolona;
					if (trenutniIgrac == DamaPodaci.CRVENI)
						poruka.setText("Crveni: igraj!");
					else
						poruka.setText("Crni: igraj");
					repaint();
					return;
				}
				if (izabraniRed < 0) {
					poruka.setText("Kliknite na deo koji zelite da pomerite.");
					return;
				}
			}

			for (int i = 0; i < dozvoljeniPotezi.length; i++) 
				if (dozvoljeniPotezi[i].izReda == izabraniRed && dozvoljeniPotezi[i].izKolone == izabranaKolona &&
				dozvoljeniPotezi[i].uRed == red && dozvoljeniPotezi[i].uKolonu == kolona) {
					igraj(dozvoljeniPotezi[i]);
					return;	
				}
			poruka.setText("Kliknite na kvadrat na koji zelite da stanete.");

		}

		void igraj(DamePotez potez) {

			tabla.igrajPotez(potez);

			if(potez.jeSkocila()) {
				dozvoljeniPotezi = tabla.getDozvoljeneSkokoveOd(trenutniIgrac,potez.uRed, potez.uKolonu);
				if (dozvoljeniPotezi != null) {
					if (trenutniIgrac == DamaPodaci.CRVENI)
						poruka.setText("Crveni: moras da nastavis da skaèeš");
					else
						poruka.setText("Crni: moraš da nastaviš da skaèeš");
					izabraniRed = potez.uRed;
					izabranaKolona = potez.uKolonu;
					repaint();
					return;
				}
			}

			if (trenutniIgrac == DamaPodaci.CRVENI) {
				trenutniIgrac = DamaPodaci.CRNI;
				dozvoljeniPotezi = tabla.getDozvoljeniPotezi(trenutniIgrac);
				if (dozvoljeniPotezi == null)
					krajIgre("Crni nema gde. Crveni pobedjuje.");
				else if (dozvoljeniPotezi[0].jeSkocila())
					poruka.setText("Crni: igraj. Moraš da skoèiš.");
				else
					poruka.setText("Crni: igraj.");
			}
			else { 
				trenutniIgrac = DamaPodaci.CRVENI;
				dozvoljeniPotezi = tabla.getDozvoljeniPotezi(trenutniIgrac);
				if (dozvoljeniPotezi == null)
					krajIgre("Crveni nema gde. Crni pobedjuje.");
				else if (dozvoljeniPotezi[0].jeSkocila())
					poruka.setText("Crveni: igraj. Moraš da skoèiš.");
				else
					poruka.setText("Crveni: igraj!");
			}
			izabraniRed = -1;

			if (dozvoljeniPotezi != null) {
				boolean istiPocetniKvadrat = true;
				for (int i = 0; i < dozvoljeniPotezi.length; i++) 
					if (dozvoljeniPotezi[i].izReda != dozvoljeniPotezi[0].izKolone) {
						istiPocetniKvadrat = false;
						break;
					}
				if (istiPocetniKvadrat) {
					izabraniRed = dozvoljeniPotezi[0].izReda;
					izabranaKolona = dozvoljeniPotezi[0].izKolone;
				}

			}
			repaint();
		}

		public void paintComponent(Graphics g) {

			g.setColor(Color.BLACK);
			g.drawRect(0, 0, getSize().width - 1, getSize().height -1);
			g.drawRect(1, 1, getSize().width - 3, getSize().width - 3);

			for (int red = 0; red < 8; red++) {
				for (int kolona = 0; kolona < 8; kolona++) {
					if (red % 2 == kolona % 2)
						g.setColor(Color.LIGHT_GRAY);
					else
						g.setColor(Color.GRAY);
					g.fillRect(2 + kolona*20 , 2 + red*20, 20, 20);

					switch(tabla.deoNa(red, kolona)) {

					case DamaPodaci.CRVENI:
						g.setColor(Color.RED);
						g.fillOval(4 + kolona*20, 4 + red*20, 15, 15);
						break;
					case DamaPodaci.CRNI:
						g.setColor(Color.BLACK);
						g.fillOval(4 + kolona*20, 4 + red*20, 15, 15);
						break;
					case DamaPodaci.CRNI_KRALJ:
						g.setColor(Color.BLACK);
						g.fillOval(4 + kolona*20, 4 + red*20, 15, 15);
						g.setColor(Color.WHITE);
						g.drawString("K", 7 + kolona*20,  16 + red*20);
						break;
					case DamaPodaci.CRVENI_KRALJ:
						g.setColor(Color.RED);
						g.fillOval(4 + kolona*20, 4 + red*20, 15, 15);
						g.setColor(Color.WHITE);
						g.drawString("K", 7 + kolona*20,  16 + red*20);
						break;
					}
				}

			}

			if (igraUToku) {
				g.setColor(Color.CYAN);
				for (int i = 0; i < dozvoljeniPotezi.length; i++) {
					g.drawRect(2 + dozvoljeniPotezi[i].izKolone*20, 2 + dozvoljeniPotezi[i].izReda*20, 19, 19);
					g.drawRect(3 + dozvoljeniPotezi[i].izKolone*20, 3 + dozvoljeniPotezi[i].izReda*20, 19, 19);
				}
				if (izabraniRed >= 0) {
					g.setColor(Color.WHITE);
					g.drawRect(2 + izabranaKolona*20, 2 + izabraniRed*20, 19, 19);
					g.drawRect(3 + izabranaKolona*20, 3 + izabraniRed*20, 17, 17);
					g.setColor(Color.GREEN);

					for (int i = 0; i < dozvoljeniPotezi.length; i++) {
						if (dozvoljeniPotezi[i].izKolone == izabranaKolona && dozvoljeniPotezi[i].izReda == izabraniRed) {
							g.drawRect(2 + dozvoljeniPotezi[i].uKolonu*20, 2 + dozvoljeniPotezi[i].uRed*20, 19, 19);
							g.drawRect(3 + dozvoljeniPotezi[i].uKolonu*20, 3 + dozvoljeniPotezi[i].uRed*20, 17, 17);	
						}
					}
				}
			}
		}

		public void mousePressed(MouseEvent dogadjaj) {
			if (igraUToku == false)
				poruka.setText("Klikni \"Nova igra\" da zapoèneš igru.");
			else {
				int kolona = (dogadjaj.getX() - 2) / 20;
				int red = (dogadjaj.getY() - 2) / 20;
				if (kolona >= 0 && kolona < 8 && red >= 0 && red < 8)
					klikniNaKvadrat(red, kolona);
			}
		}

		public void mouseReleased(MouseEvent dogadjaj) {}
		public void mouseClicked(MouseEvent dogadjaj) {}
		public void mouseEntered(MouseEvent dogadjaj) {}
		public void mouseExited(MouseEvent dogadjaj) {}

	}

	private static class DamaPodaci {

		static final int

		PRAZNO = 0,
		CRVENI = 1,
		CRVENI_KRALJ = 2,
		CRNI = 3,
		CRNI_KRALJ = 4	;

		int [][] tabla;

		public DamaPodaci() {
			tabla = new int [8][8];
			postaviIgru();
		}

		void postaviIgru() {

			for (int red = 0; red < 8; red++) {
				for (int kolona = 0; kolona < 8; kolona++) {
					if (red % 2 == kolona % 2) {
						if (red < 3)
							tabla[red][kolona] = CRNI;
						else if (red > 4)
							tabla[red][kolona] = CRVENI;
						else
							tabla[red][kolona] = PRAZNO;
					}
					else {
						tabla[red][kolona] = PRAZNO;
					}
				}
			}
		}

		int deoNa(int red, int kolona) {
			return tabla[red][kolona];
		}

		int postaviDeoNa(int red, int kolona, int deo) {
			return tabla[red][kolona] = deo;
		}

		void igrajPotez(DamePotez potez) {
			igrajPotez(potez.izReda, potez.izKolone, potez.uRed, potez.uKolonu);
		}

		void igrajPotez(int izReda, int izKolone, int uRed, int uKolonu) {
			tabla[uRed][uKolonu] = tabla[izReda][izKolone];
			tabla[izReda][izKolone] = PRAZNO;
			if (izReda - uRed == 2 || izReda - uRed == -2) {
				int skokRed = (izReda + uRed) / 2;
				int skokKolona = (izKolone + uKolonu) / 2;
				tabla[skokRed][skokKolona] = PRAZNO;
			}
			if (uRed == 0 && tabla[uRed][uKolonu] == CRVENI)
				tabla[uRed][uKolonu] = CRVENI_KRALJ;
			if (uRed == 7 && tabla[uRed][uKolonu] == CRNI)
				tabla[uRed][uKolonu] = CRNI_KRALJ;
		}

		DamePotez[] getDozvoljeniPotezi(int igrac) {


			if (igrac != CRVENI && igrac != CRNI)
				return null;

			int igracKralj;
			if (igrac == CRVENI)
				igracKralj = CRVENI_KRALJ;
			else
				igracKralj = CRNI_KRALJ;

			ArrayList<DamePotez> potezi = new ArrayList<DamePotez>();

			for (int red = 0; red < 8; red++) {
				for (int kolona = 0; kolona < 8; kolona++) {
					if (tabla[red][kolona] == igrac || tabla[red][kolona] == igracKralj ) {
						if (mozeDaSkoci(igrac,red, kolona, red + 1, kolona + 1, red + 2, kolona + 2))
							potezi.add(new DamePotez(red, kolona, red + 2, kolona + 2));
						if (mozeDaSkoci(igrac,red, kolona, red - 1, kolona + 1, red - 2, kolona + 2))
							potezi.add(new DamePotez(red, kolona, red - 2, kolona + 2));
						if (mozeDaSkoci(igrac,red, kolona, red + 1, kolona - 1, red + 2, kolona - 2))
							potezi.add(new DamePotez(red, kolona, red + 2, kolona - 2));
						if (mozeDaSkoci(igrac,red, kolona, red - 1, kolona - 1, red - 2, kolona - 2))
							potezi.add(new DamePotez(red, kolona, red - 2, kolona - 2));
					}
				}
			}

			if (potezi.size() == 0) {
				for (int red = 0; red < 8; red++) {
					for (int kolona = 0; kolona < 8; kolona++) {
						if (tabla[red][kolona] == igrac || tabla[red][kolona] == igracKralj ) {
							if (mozeDaIgra(igrac,red, kolona, red + 1, kolona + 1))
								potezi.add(new DamePotez(red, kolona, red + 1, kolona + 1));
							if (mozeDaIgra(igrac,red, kolona, red - 1, kolona + 1))
								potezi.add(new DamePotez(red, kolona, red - 1, kolona + 1));
							if (mozeDaIgra(igrac,red, kolona, red + 1, kolona - 1))
								potezi.add(new DamePotez(red, kolona, red + 1, kolona - 1));
							if (mozeDaIgra(igrac,red, kolona, red - 1, kolona - 1))
								potezi.add(new DamePotez(red, kolona, red - 1, kolona - 1));	
						}	
					}
				}
			}

			if (potezi.size() == 0)
				return null;
			else {
				DamePotez[] pomeriArray = new DamePotez[potezi.size()];
				for (int i = 0; i < potezi.size(); i++)
					pomeriArray[i] = potezi.get(i);
				return pomeriArray;

			}	
		}

		DamePotez[] getDozvoljeneSkokoveOd(int igrac, int red, int kolona) {
			if (igrac != CRVENI && igrac != CRNI)
				return null;
			int igracKralj;
			if (igrac == CRVENI)
				igracKralj = CRVENI_KRALJ;
			else
				igracKralj = CRNI_KRALJ;
			ArrayList<DamePotez> potezi = new ArrayList<DamePotez>();
			if (tabla[red][kolona] == igrac || tabla[red][kolona] == igracKralj ) {
				if (mozeDaSkoci(igrac,red, kolona, red + 1, kolona + 1, red + 2, kolona + 2))
					potezi.add(new DamePotez(red, kolona, red + 2, kolona + 2));
				if (mozeDaSkoci(igrac,red, kolona, red - 1, kolona + 1, red - 2, kolona + 2))
					potezi.add(new DamePotez(red, kolona, red - 2, kolona + 2));
				if (mozeDaSkoci(igrac,red, kolona, red + 1, kolona - 1, red + 2, kolona - 2))
					potezi.add(new DamePotez(red, kolona, red + 2, kolona - 2));
				if (mozeDaSkoci(igrac,red, kolona, red - 1, kolona - 1, red - 2, kolona - 2))
					potezi.add(new DamePotez(red, kolona, red - 2, kolona - 2));
			}
			if (potezi.size() == 0)
				return null;
			else {
				DamePotez[] pomeriArray = new DamePotez[potezi.size()];
				for (int i = 0; i < potezi.size(); i++) 
					pomeriArray[i] = potezi.get(i);
				return pomeriArray;

			}
		}

		private boolean mozeDaSkoci(int igrac, int r1, int k1, int r2, int k2, int r3, int k3) {

			if(r3 < 0 || r3 >= 8 || k3 < 0 || k3 >= 8)
				return false;
			if (tabla[r3][k3] != PRAZNO)
				return false;
			if (igrac == CRVENI) {
				if (tabla[r1][k1] == CRVENI && r3 > r1)
					return false;
				if (tabla[r2][k2] != CRNI && tabla[r2][k2] != CRNI_KRALJ)
					return false;
				return true;
			}
			else {
				if(tabla [r1][k1] == CRNI && r3 < r1)
					return false;
				if (tabla[r2][k2] != CRVENI && tabla[r2][k2] != CRVENI_KRALJ)
					return false;
				return true;

			}	
		}

		private boolean mozeDaIgra(int igrac, int r1, int k1, int r2, int k2) {

			if (r2 < 0 || r2 >= 8 || k2 < 0 || k2 >= 8)
				return false;
			if (tabla[r2][k2] != PRAZNO)
				return false;
			if (igrac == CRVENI) {
				if (tabla [r1][k1] == CRVENI && r2 > r1)
					return false;
				return true;
			}
			else {
				if (tabla[r1][k1] == CRNI && r2 < r1)
					return false;
				return true;
			}
		}
	}
}

























