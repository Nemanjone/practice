import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.net.URL;
import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;


public class KarteVecaManja extends JPanel {

	/**
	 * 
	 */
	private static final long serialVersionUID = -7170679124758657545L;

	public static void main(String[] args) {
		
		JFrame okvir = new JFrame(" Veæa || Manja ");
		KarteVecaManja sadrzaj = new KarteVecaManja();
		okvir.setContentPane(sadrzaj);
		okvir.pack();
		okvir.setResizable(false);
		okvir.setLocationRelativeTo(null);
		okvir.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		okvir.setVisible(true);
	}

	public KarteVecaManja() {

		setBackground(new Color(130, 50, 40));
		setLayout(new BorderLayout(3, 3));

		PanelKarte tabla = new PanelKarte();
		add(tabla, BorderLayout.CENTER);

		JPanel dugmePanela = new JPanel();
		dugmePanela.setBackground(new Color(220, 200, 50));
		add(dugmePanela, BorderLayout.SOUTH);
		
		JButton manja = new JButton("MANJA");
		manja.addActionListener(tabla);
		dugmePanela.add(manja);

		JButton veca = new JButton("VEÆA");
		veca.addActionListener(tabla);
		dugmePanela.add(veca);


		JButton novaIgra = new JButton("Nova igra");
		novaIgra.addActionListener(tabla);
		dugmePanela.add(novaIgra);

		setBorder(BorderFactory.createLineBorder(new Color(255, 50, 100)));

	}

	private class PanelKarte extends JPanel implements ActionListener {

		/**
		 * 
		 */
		private static final long serialVersionUID = -4197219202267455711L;
		
		Spil spil;
		Ruka ruka;
		String poruka;

		boolean igraUToku;
		Font velikiFont;

		Image slikeKarata;

		public PanelKarte() {

			ucitajSliku();
			setBackground(new Color(0, 120, 0));
			setForeground(Color.YELLOW);
			velikiFont = new Font("Serif", Font.PLAIN, 18);
			setPreferredSize(new Dimension(15 + 4*(15 + 79), 185));
			postaviNovuIgru();
		}

		public void actionPerformed(ActionEvent dogadjaj) {
			String izvor = dogadjaj.getActionCommand();
			if (izvor.equals("VEÆA"))
				postaviVecu();
			else if (izvor.equals("MANJA"))
				postaviManju();
			else if (izvor.equals("Nova igra"))
				postaviNovuIgru();
		}

		void postaviVecu() {
			if (igraUToku == false) {
				poruka = "Pritisni \"Nova igra\" da bi ponovo zapoèeo igru!";
				repaint();
				return;			
			}
			ruka.dodajKartu(spil.deliKarte());
			int brojKreiranihKarata = ruka.getBrojKarte();
			Karta ovaKarta = ruka.getKarta(brojKreiranihKarata - 1);
			Karta prethodnaKarta = ruka.getKarta (brojKreiranihKarata - 2);
			if (ovaKarta.getVrednost() < prethodnaKarta.getVrednost()) {
				igraUToku = false;
				poruka = "Šteta! Izgubili ste.";
			}
			else if (ovaKarta.getVrednost() == prethodnaKarta.getVrednost()) {
				igraUToku = false;
				poruka = "Šteta. Izgubili ste za dlaku.";
			}
			else if (brojKreiranihKarata == 4) {
				igraUToku = false;
				poruka = "Pobedili ste! Tri puta ste taèno pogodili.";
			}
			else {
				poruka = "Dobro Vam ide! Probajte " + brojKreiranihKarata + " kartu.";
			}
			repaint();	
		}

		void postaviManju() {
			if (igraUToku == false) {
				poruka = "Pritisni \"Nova igra\" da bi ponovo zapoèeo igru!";
				repaint();
				return;
			}
			ruka.dodajKartu(spil.deliKarte());
			int brojKreiranihKarata = ruka.getBrojKarte();
			Karta ovaKarta = ruka.getKarta(brojKreiranihKarata - 1);
			Karta prethodnaKarta = ruka.getKarta(brojKreiranihKarata - 2);
			if (ovaKarta.getVrednost() > prethodnaKarta.getVrednost()) {
				igraUToku = false;
				poruka = "Šteta! Izgubili ste.";
			}
			else if (ovaKarta.getVrednost() == prethodnaKarta.getVrednost()) {
				igraUToku = false;
				poruka = "Šteta. Izgubili ste za dlaku.";
			}
			else if (brojKreiranihKarata == 4) {
				igraUToku = false;
				poruka = "Pobedili ste! Tri puta ste taèno pogodili. ";
			}
			else {
				poruka = "Dobro Vam ide! Probajte " + brojKreiranihKarata + ".";
			}
			repaint();
		}

		void postaviNovuIgru() {
			if (igraUToku) {
				poruka = "Morate da završite ovu partiju!";
				repaint();
				return;
			}
			spil = new Spil(true);
			ruka = new Ruka();
			spil.promesaj();
			ruka.dodajKartu(spil.deliKarte());
			poruka = "Da li je sledeæa karta manja ili veæa?";
			igraUToku = true;
			repaint();
		}

		public void paintComponent(Graphics g) {
			super.paintComponent(g);
			if (slikeKarata == null) {
				g.drawString("Greška: ne mogu da naðem slike karata!", 10, 30);
				return;
			}
			g.setFont(velikiFont);
			g.drawString(poruka, 15, 168);
			int brojKreiranihKarata = ruka.getBrojKarte();
			for (int i = 0; i < brojKreiranihKarata; i++) 
				nacrtajKartu(g, ruka.getKarta(i), 15 + i * (15 + 79), 15);
			if (igraUToku)
				nacrtajKartu(g, null, 15 + brojKreiranihKarata * (15 + 79), 15);
		}

		public void nacrtajKartu(Graphics g, Karta karta, int x, int y) {
			int cx;                                     //pozicija levog gornjeg ugla karte na slici
			int cy;
			if (karta == null) {
				cy = 4 * 123;                           // koordinate karte okrenute nadole
				cx = 2 * 79;
			}
			else {
				cx = (karta.getVrednost() - 1) * 79;
				switch (karta.getBoja()) {
				case Karta.TREF:  cy = 0; break;
				case Karta.KOCKA: cy = 123; break;
				case Karta.SRCE:  cy = 2 * 123; break;
				//case Karta.JOKER: cy = 4 * 123; break;
				default:          cy = 3 * 123; break; // pik
				}
			}
			g.drawImage(slikeKarata, x, y, x + 79, y + 123, cx, cy, cx + 79, cy + 123, this);
		}

		private void ucitajSliku() {
			ClassLoader cl = getClass().getClassLoader();
			URL slikaURL = cl.getResource("Cards.png");
			if (slikaURL != null)
				slikeKarata = Toolkit.getDefaultToolkit().createImage(slikaURL);
		}
	}
}
