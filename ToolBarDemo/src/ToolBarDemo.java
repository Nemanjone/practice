import java.awt.BasicStroke;
import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.RenderingHints;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.MouseMotionListener;
import java.awt.image.BufferedImage;
import javax.swing.AbstractAction;
import javax.swing.Action;
import javax.swing.BorderFactory;
import javax.swing.ButtonGroup;
import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.JToolBar;

public class ToolBarDemo extends JPanel {

	public static void main(String[] args) {

		JFrame okvir = new JFrame("TooBar Demo");
		ToolBarDemo sadržaj = new ToolBarDemo();
		okvir.setContentPane(sadržaj);
		okvir.pack();
		okvir.setResizable(false);
		Dimension velièinaOkvira = Toolkit.getDefaultToolkit().getScreenSize();
		okvir.setLocationRelativeTo(null);
		okvir.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		okvir.setVisible(true);
	}

	private class Display extends JPanel implements MouseListener, MouseMotionListener {

		private BufferedImage OSC;
		private Color trenutnaBoja = Color.RED;
		private int prethodnoX, prethodnoY;
		private BasicStroke stroke;

		public Display() {

			addMouseListener(this);
			addMouseMotionListener(this);
			setPreferredSize(new Dimension(300, 300));
			stroke = new BasicStroke(3, BasicStroke.CAP_ROUND, BasicStroke.JOIN_ROUND);	
		}
		void postaviTrenutnuBoju(Color c) {
			trenutnaBoja = c;
		}

		void oèisti() {
			if (OSC != null) {
				Graphics g = OSC.getGraphics();
				g.setColor(Color.WHITE);
				g.fillRect(0, 0, getWidth(), getHeight());
				g.dispose();
				repaint();
			}
		}

		public void paintComponent(Graphics g) {
			proveriSliku();
			g.drawImage(OSC, 0, 0, null);
		}

		void proveriSliku() {
			if (OSC == null) {
				OSC = new BufferedImage(getWidth(), getHeight(), BufferedImage.TYPE_INT_RGB);
				oèisti();
			}
			else if (OSC.getWidth() != getWidth() || OSC.getHeight() != getHeight()) {
				BufferedImage noviOSC;
				noviOSC = new BufferedImage(getWidth(), getHeight(), BufferedImage.TYPE_INT_RGB);
				Graphics g = OSC.getGraphics();
				g.drawImage(OSC, 0, 0, getWidth(), getHeight(), null);
				g.dispose();
				OSC = noviOSC;
			}
		}

		public void mousePressed(MouseEvent dogaðaj) {
			prethodnoX = dogaðaj.getX();
			prethodnoY = dogaðaj.getY();
		}

		public void mouseDragged(MouseEvent dogaðaj) {
			Graphics2D g2 = (Graphics2D)OSC.getGraphics();
			g2.setColor(trenutnaBoja);
			g2.setStroke(stroke);
			g2.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
			g2.drawLine(prethodnoX, prethodnoY, dogaðaj.getX(), dogaðaj.getY());
			g2.dispose();
			repaint();
			prethodnoX = dogaðaj.getX();
			prethodnoY = dogaðaj.getY();	
		}
		@Override
		public void mouseMoved(MouseEvent arg0) {}
		@Override
		public void mouseClicked(MouseEvent arg0) {}
		@Override
		public void mouseEntered(MouseEvent arg0) {}
		@Override
		public void mouseExited(MouseEvent arg0) {}
		@Override
		public void mouseReleased(MouseEvent arg0) {}
	}

	private Display display;

	public ToolBarDemo () {

		setLayout(new BorderLayout(2, 2));
		setBackground(Color.GRAY);
		setBorder(BorderFactory.createLineBorder(Color.LIGHT_GRAY, 2));

		display = new Display();
		add(display, BorderLayout.CENTER);

		JToolBar toolBar = new JToolBar();
		add(toolBar, BorderLayout.NORTH);

		ButtonGroup grupa = new ButtonGroup();
		toolBar.add(napraviRadioDugme(Color.RED, grupa, true));
		toolBar.add(napraviRadioDugme(Color.GREEN, grupa, false));
		toolBar.add(napraviRadioDugme(Color.BLUE, grupa, false));
		toolBar.addSeparator(new Dimension(20, 20));

		toolBar.add(napraviOèistiDugme());
	}

	private JRadioButton napraviRadioDugme (final Color c, ButtonGroup grupa, boolean izabrana) {

		BufferedImage slika = new BufferedImage(30, 30, BufferedImage.TYPE_INT_RGB);
		Graphics g = slika.getGraphics();
		g.setColor(Color.LIGHT_GRAY);
		g.fillRect(0, 0, 30, 30);
		g.setColor(c);
		g.fill3DRect(1, 1, 24, 24, true);
		g.dispose();
		Icon neizabranaIkona = new ImageIcon(slika);

		slika = new BufferedImage(30, 30, BufferedImage.TYPE_INT_RGB);
		g = slika.getGraphics();
		g.setColor(Color.DARK_GRAY);
		g.fillRect(0, 0, 30, 30);
		g.setColor(c);
		g.fill3DRect(3, 3, 24, 24, false);
		g.dispose();
		Icon izabranaIkona = new ImageIcon(slika);

		JRadioButton dugme = new JRadioButton(neizabranaIkona);
		dugme.setSelectedIcon(izabranaIkona);
		dugme.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				display.postaviTrenutnuBoju(c);
			}
		});

		grupa.add(dugme);
		if (izabrana) 
			dugme.setSelected(true);

		return dugme;
	}

	private JButton napraviOèistiDugme() {

		BufferedImage slika = new BufferedImage(24, 24, BufferedImage.TYPE_INT_RGB);
		Graphics2D g2 = (Graphics2D)slika.getGraphics();
		g2.setColor(Color.GRAY);
		g2.fillRect(0, 0, 24, 24);
		g2.setStroke(new BasicStroke(3));
		g2.setColor(Color.BLACK);
		g2.drawLine(4, 4, 20, 20);
		g2.drawLine(4, 20, 20, 4);
		g2.dispose();
		Icon oèistiIkona = new ImageIcon(slika);

		Action oèistiAkcija = new AbstractAction(null, oèistiIkona) {

			@Override
			public void actionPerformed(ActionEvent e) {

				display.oèisti();

			}
		};

		oèistiAkcija.putValue(Action.SHORT_DESCRIPTION, "Oèisti ekran");
		JButton dugme = new JButton(oèistiAkcija);

		return dugme;
	}

}
