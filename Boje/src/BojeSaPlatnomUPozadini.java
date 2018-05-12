import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.MouseMotionListener;
import java.awt.image.BufferedImage;
import java.util.EnumSet;
import javax.swing.JColorChooser;
import javax.swing.JFrame;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JPanel;


public class BojeSaPlatnomUPozadini extends JPanel{


	public static void main(String[] args) {

		JFrame okvir = new JFrame("Boje sa platnom u pozadini");
		BojeSaPlatnomUPozadini sadrzaj = new BojeSaPlatnomUPozadini();
		okvir.setContentPane(sadrzaj);
		okvir.setJMenuBar(sadrzaj.getMenuBar());
		okvir.pack();
		okvir.setResizable(false);
		Dimension velicinaOkvira = Toolkit.getDefaultToolkit().getScreenSize();
		okvir.setLocationRelativeTo(null);
		okvir.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		okvir.setVisible(true);
	}

	private enum Alat  { KRIVA, LINIJA, PRAVOUGAONIK, KRUZNI_OBLIK, OBOJENI_PRAVOUGAONIK,
		OBOJENI_KRUZNI_OBLIK, POPRSKAJ, IZBRISI	}

	private final static EnumSet<Alat> 	ALAT_ZA_OBLIKOVANJE = EnumSet.range(Alat.LINIJA, Alat.OBOJENI_KRUZNI_OBLIK);

	private Alat trenutniAlat = Alat.KRIVA;

	private Color trenutnaBoja = Color.BLACK;

	private Color bojaZaBojenje = Color.white;

	private BufferedImage PUP;                                 //platno u pozadini

	private boolean pomeranjeMisa;

	private int startX, startY;

	private int trenutniX, trenutniY;

	public BojeSaPlatnomUPozadini() {
		
		setPreferredSize(new Dimension(600, 400));
		RukovalacMišem rukovalacMišem = new RukovalacMišem();
		addMouseListener(rukovalacMišem);
		addMouseMotionListener(rukovalacMišem);
	}

	public void paintComponent(Graphics g) {
		if (PUP == null)                           
			napraviPUP();
		g.drawImage(PUP, 0, 0, null);

		if (pomeranjeMisa && ALAT_ZA_OBLIKOVANJE.contains(trenutniAlat)) {
			g.setColor(trenutnaBoja);
			postaviTrenutniOblik(g);
		}
	}

	private void napraviPUP() {
		PUP = new BufferedImage(getWidth(), getHeight(), BufferedImage.TYPE_INT_RGB);
		Graphics pup = PUP.createGraphics();
		pup.setColor(bojaZaBojenje);
		pup.fillRect(0, 0, getWidth(), getHeight());
		pup.dispose();
	} 

	private void postaviTrenutniOblik(Graphics g) {
		switch(trenutniAlat) {
		case LINIJA: g.drawLine(startX, startY, trenutniX, trenutniY);break;
		case KRUZNI_OBLIK: nacrtajKruzniOblik(g, false, startX, startY, trenutniX, trenutniY);break;
		case PRAVOUGAONIK: nacrtajPravougaonik(g, false, startX, startY, trenutniX, trenutniY);break;
		case OBOJENI_KRUZNI_OBLIK: nacrtajKruzniOblik(g, true, startX, startY, trenutniX, trenutniY);break;
		case OBOJENI_PRAVOUGAONIK: nacrtajPravougaonik(g, true, startX, startY, trenutniX, trenutniY);break;
		}
	}

	private void nacrtajPravougaonik(Graphics g, boolean obojeni, int x1, int y1, int x2, int y2) {
		if (x1 == x2 || y1 == y2)
			return;
		if (x2 < x1) {
			int privremeni = x1;
			x1 = x2;
			x2 = privremeni;
		}
		if (y2 < y1) {
			int privremeni = y1;
			y1 = y2;
			y2 = privremeni;
		}
		if (obojeni)
			g.fillRect(x1, y1, x2 - x1, y2- y1);
		else
			g.drawRect(x1, y1, x2 - x1, y2 - y1);
	}

	private void nacrtajKruzniOblik(Graphics g, boolean obojeni, int x1, int y1, int x2, int y2) {
		if (x1 == x2 || y1 == y2)
			return;
		if (x2 < x1) {
			int privremeni = x1;
			x1 = x2;
			x2 = privremeni;
		}
		if (y2 < y1) {
			int privremeni = y1;
			y1 = y2;
			y2 = privremeni;
		}
		if (obojeni)
			g.fillOval(x1, y1, x2 - x1, y2 - y1);
		else
			g.drawOval(x1, y1, x2 - x1, y2 - y1);
	}

	private void repaintPravougaonik(int x1, int y1, int x2, int y2) {
		if (x2 < x1) {
			int privremeni = x1;
			x1 = x2;
			x2 = privremeni;
		}
		if (y2 < y1) {
			int privremeni = y1;
			y1 = y2;
			y2 = privremeni;
		}
		x1--;
		x2++;
		y1--;
		y2++;
		repaint(x1, y1, x2 - x1, y2 - y1);	
	}

	public JMenuBar getMenuBar() {

		JMenuBar menuBar = new JMenuBar();

		JMenu bojeMeni = new JMenu("Boje");
		JMenu alatMeni = new JMenu("Alat");

		menuBar.add(bojeMeni);
		menuBar.add(alatMeni);

		ActionListener listener = new RukovalacMenija();

		JMenuItem item = new JMenuItem("Crtaj crnom bojom");
		item.addActionListener(listener);
		bojeMeni.add(item);

		item = new JMenuItem("Crtaj belom bojom");
		item.addActionListener(listener);
		bojeMeni.add(item);

		item = new JMenuItem("Crtaj crvenom bojom");
		item.addActionListener(listener);
		bojeMeni.add(item);

		item = new JMenuItem("Crtaj zelenom bojom");
		item.addActionListener(listener);
		bojeMeni.add(item);

		item = new JMenuItem("Crtaj plavom bojom");
		item.addActionListener(listener);
		bojeMeni.add(item);

		item =  new JMenuItem("Crtaj žutom bojom");
		item.addActionListener(listener);
		bojeMeni.add(item);

		item = new JMenuItem("Izaberi boju za crtanje...");
		item.addActionListener(listener);
		bojeMeni.add(item);

		bojeMeni.addSeparator();

		item = new JMenuItem("Oboji...");
		item.addActionListener(listener);
		bojeMeni.add(item);

		item = new JMenuItem("Kriva linija");
		item.addActionListener(listener);
		alatMeni.add(item);

		alatMeni.addSeparator();

		item = new JMenuItem("Linija");
		item.addActionListener(listener);
		alatMeni.add(item);

		item = new JMenuItem("Pravougaonik");
		item.addActionListener(listener);
		alatMeni.add(item);

		item = new JMenuItem("Kruzni oblik");
		item.addActionListener(listener);
		alatMeni.add(item);

		item = new JMenuItem("Obojeni pravougaonik");
		item.addActionListener(listener);
		alatMeni.add(item);

		item = new JMenuItem("Obojeni kruzni oblik");
		item.addActionListener(listener);
		alatMeni.add(item);

		alatMeni.addSeparator();

		item = new JMenuItem("Prospi boju");
		item.addActionListener(listener);
		alatMeni.add(item);

		item = new JMenuItem("Izbriši");
		item.addActionListener(listener);
		alatMeni.add(item);

		return menuBar;	
	}

	private class RukovalacMenija implements ActionListener {
		public void actionPerformed(ActionEvent dogadjaj) {
			String izvor = dogadjaj.getActionCommand();
			if (izvor.equals("Izaberi boju za crtanje...")) {
				Color novaBoja = JColorChooser.showDialog(BojeSaPlatnomUPozadini.this,
						"Izaberi booju za crtanje", trenutnaBoja);
				if (novaBoja != null)
					trenutnaBoja = novaBoja;
			}
			else if (izvor.equals("Oboji...")) {
				Color novaBoja = JColorChooser.showDialog(BojeSaPlatnomUPozadini.this,
						"Izaberi boju", bojaZaBojenje);
				if (novaBoja != null) {
					bojaZaBojenje = novaBoja;
					Graphics pup = PUP.createGraphics();
					pup.setColor(bojaZaBojenje);
					pup.fillRect(0, 0, PUP.getWidth(), PUP.getHeight());
					pup.dispose();
					BojeSaPlatnomUPozadini.this.repaint();	
				}
			}

			else if (izvor.equals("Crtaj crnom bojom"))
				trenutnaBoja = Color.BLACK;
			else if (izvor.equals("Crtaj belom bojom"))
				trenutnaBoja = Color.WHITE;
			else if (izvor.equals("Crtaj crvenom bojom"))
				trenutnaBoja = Color.RED;
			else if (izvor.equals("Crtaj zelenom bojom"))
				trenutnaBoja = Color.GREEN;
			else if (izvor.equals("Crtaj plavom bojom"))
				trenutnaBoja = Color.BLUE;
			else if (izvor.equals("Crtaj žutom bojom"))
				trenutnaBoja = Color.YELLOW;
			else if (izvor.equals("Kriva linija"))
				trenutniAlat = Alat.KRIVA;
			else if (izvor.equals("Linija"))
				trenutniAlat = Alat.LINIJA;
			else if (izvor.equals("Pravougaonik"))
				trenutniAlat = Alat.PRAVOUGAONIK;
			else if (izvor.equals("Kruzni oblik"))
				trenutniAlat = Alat.KRUZNI_OBLIK;
			else if (izvor.equals("Obojeni pravougaonik"))
				trenutniAlat = Alat.OBOJENI_PRAVOUGAONIK;
			else if (izvor.equals("Obojeni kruzni oblik"))
				trenutniAlat = Alat.OBOJENI_KRUZNI_OBLIK;
			else if (izvor.equals("Prospi boju"))
				trenutniAlat = Alat.POPRSKAJ;
			else if (izvor.equals("Izbriši"))
				trenutniAlat = Alat.IZBRISI;
		}
	}

	private class RukovalacMišem implements MouseListener, MouseMotionListener {

		int prethodnoX, prethodnoY;
		double [][] poprskajCrveno, poprskajZeleno, poprskajPlavo;

		void primeniAlatPoLiniji(int x1, int y1, int x2, int y2) {
			Graphics g = PUP.getGraphics();
			g.setColor(bojaZaBojenje);
			int širina = PUP.getWidth();
			int visina = PUP.getHeight();
			int razdaljina = Math.max(Math.abs(x2 - x1), Math.abs(y2 - y1));
			double dx = (x2 - x1)/razdaljina;
			double dy = (y2 - y1)/razdaljina;
			for (int d = 0; d < razdaljina; d++) {
				int x = (int) Math.round(x1 + dx * d);
				int y = (int) Math.round(y1 + dy * d);
				if (trenutniAlat == Alat.IZBRISI) {
					g.fillRect(x -5, y - 5, 10, 10);
					repaint( -5, y - 5, 10, 10);		
				}
				else {
					for (int i = 0; i < 7; i++) 
						for (int j = 0; j < 7; j++) {
							int r = y + j -3;
							int c = x + i -3;
							if (!(r < 0 || r >= visina || c < 0 || c >= širina || poprskajCrveno[i][j] == -1 )) {
								int trenutnaBoja = PUP.getRGB(c, r);
								int trenutnaCrvena = (trenutnaBoja >> 16) & 0xFF;
								int trenutnaZelena  = (trenutnaBoja >> 8) & 0xFF;
								int trenutnaPlava = trenutnaBoja & 0xFF;
								int novaCrvena = (int) (trenutnaCrvena * 0.7 + poprskajCrveno[i][j] * 0.3);
								int novaZelena = (int) (trenutnaZelena * 0.7 + poprskajZeleno[i][j] * 0.3);
								int novaPlava = (int) (trenutnaPlava * 0.7 + poprskajPlavo[i][j] * 0.3);
								int novaBoja = novaCrvena << 16 | novaZelena << 8 | novaPlava;
								PUP.setRGB(c, r, novaBoja);
								poprskajCrveno[i][j] = trenutnaCrvena + 0.3 + poprskajCrveno[i][j] * 0.7;
								poprskajZeleno[i][j] = trenutnaZelena + 0.3 + poprskajZeleno[i][j] * 0.7;
								poprskajPlavo[i][j] = trenutnaPlava + 0.3 + poprskajPlavo[i][j] * 0.7;
							}
						}
					repaint(x -3, y - 3, 7, 7);
				}
			}
			g.dispose();
		}

		public void mousePressed(MouseEvent dogadjaj) {
			startX = prethodnoX = trenutniX = dogadjaj.getX();
			startY = prethodnoY = trenutniY = dogadjaj.getY();
			pomeranjeMisa = true;
			if(trenutniAlat == Alat.IZBRISI) {
				Graphics g = PUP.createGraphics();
				g.setColor(bojaZaBojenje);
				g.fillRect(startX - 5, startY - 5, 10 , 10);
				g.dispose();
				repaint(startX - 5, startY - 5, 10 , 10);
			}
			else if (trenutniAlat == Alat.POPRSKAJ) {
				if (poprskajCrveno == null) {
					poprskajCrveno = new double[7][7];
					poprskajZeleno = new double[7][7];
					poprskajPlavo = new double[7][7];
				}
				int širina = PUP.getWidth();
				int visina = PUP.getHeight();
				int x = dogadjaj.getX();
				int y = dogadjaj.getY();
				for (int i = 0; i < 7; i++) 
					for (int j = 0; j < 7; j++) {
						int r = y + j -3;
						int c = x + i -3;
						if (r < 0 || r >= visina || c < 0 || c >= širina) {
							poprskajCrveno[i][j] = -1;	
						}
						else {
							int boja = PUP.getRGB(c, r);
							poprskajCrveno[i][j] = (boja >> 16) & 0xFF;
							poprskajZeleno[i][j] = (boja >> 8) & 0xFF;
							poprskajPlavo[i][j] = boja & 0xFF;
					}
				}
			}
		}

		public void mouseDragged(MouseEvent dogadjaj) {
			trenutniX = dogadjaj.getX();
			trenutniY = dogadjaj.getY();
			if (trenutniAlat == Alat.KRIVA) {
				Graphics g = PUP.getGraphics();
				g.setColor(trenutnaBoja);
				g.drawLine(prethodnoX, prethodnoY, trenutniX, trenutniY);
				g.dispose();
				repaintPravougaonik(prethodnoX, prethodnoY, trenutniX, trenutniY);
			}
			else if (ALAT_ZA_OBLIKOVANJE.contains(trenutniAlat)) {
				repaintPravougaonik(startX, startY, prethodnoX, prethodnoY);
				repaintPravougaonik(startX, startY, trenutniX, trenutniY);		
			}
			else {
				primeniAlatPoLiniji(prethodnoX, prethodnoY, trenutniX, trenutniY);
			}
			prethodnoX = trenutniX;
			prethodnoY = trenutniY;
		}

		public void mouseReleased(MouseEvent dogadjaj) {
			pomeranjeMisa = false;
			if (ALAT_ZA_OBLIKOVANJE.contains(trenutniAlat)) {
				Graphics g = PUP.createGraphics();
				g.setColor(trenutnaBoja);
				postaviTrenutniOblik(g);
				g.dispose();
				repaint();
			}
		}

		public void mouseMoved(MouseEvent dogadjaj) {}
		public void mouseClicked(MouseEvent dogadjaj) {}
		public void mouseEntered(MouseEvent dogadjaj) {}
		public void mouseExited(MouseEvent dogadjaj) {}

	}
}
