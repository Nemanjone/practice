import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.FontMetrics;
import java.awt.Graphics;
import java.awt.GridLayout;
import java.awt.Toolkit;
import javax.swing.BorderFactory;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JSlider;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;

public class Transparentnost extends JPanel {

	public static void main(String[] args) {

		JFrame okvir= new JFrame("Transparentnost boja");
		Transparentnost sadrzaj = new Transparentnost();
		okvir.setContentPane(sadrzaj);
		okvir.pack();
		Dimension velicinaOkvira = Toolkit.getDefaultToolkit().getScreenSize();
		okvir.setLocationRelativeTo(null);
		okvir.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		okvir.setVisible(true);
	}

	private JSlider trougaoTransparentnost;
	private JSlider krugTransparentnost;
	private JSlider pravougaonikTransparentnost;
	private JSlider tekstTransparentnost;

	private Font tekstFont = new Font("Serif", Font.BOLD, 42);

	private JPanel emitujPanel = new JPanel() {

		public void paintComponent(Graphics g) {

			super.paintComponent(g);
			Color bojaTrougla = new Color(255, 0, 0, trougaoTransparentnost.getValue());
			Color bojaKruga = new Color(0, 255, 0, krugTransparentnost.getValue());
			Color bojaPravougaonika = new Color(0, 0, 255, pravougaonikTransparentnost.getValue());
			Color bojaTeksta = new Color(0, 0, 0, tekstTransparentnost.getValue());
			
			g.setColor(bojaTrougla);
			g.fillPolygon(new int[] { scaleX(0.25), scaleX(0.7), scaleX(0.1)},
					new int [] {scaleY(0.1), scaleY(0.7), scaleY(0.7)}, 3);
			
			g.setColor(bojaKruga);
			g.fillOval(scaleX(0.3), scaleY(0.45), getWidth()/2, getHeight()/2);
			
			g.setColor(bojaPravougaonika);
			g.fillRect(scaleX(0.4), scaleY(0.15), getWidth()/2, getHeight()/2);
			
			FontMetrics metrika = g.getFontMetrics(tekstFont);
			int širinaLinije1 = metrika.stringWidth("Transparentnost");
			int širinaLinije2 = metrika.stringWidth("boja");
			int visinaTeksta = metrika.getHeight() + metrika.getAscent();
			int vrhSkip = (getHeight() - visinaTeksta)/2;
			int leviSkip1 = (getWidth() - širinaLinije1)/2;
			int leviSkip2 = (getWidth() - širinaLinije2)/2;
			g.setColor(bojaTeksta);
			g.setFont(tekstFont);
			g.drawString("Transparentnost", leviSkip1, vrhSkip + metrika.getAscent());
			g.drawString("boja", leviSkip2, vrhSkip + metrika.getAscent() + metrika.getHeight());

		}
		private int scaleX (double x) {
			return (int) (x * getWidth());
		}
		private int scaleY (double y) {
			return (int) (y * getHeight());
		}

	};

	private ChangeListener rukovalac = new ChangeListener() {

		@Override
		public void stateChanged(ChangeEvent e) {
			emitujPanel.repaint();	
		}
	};

	public Transparentnost() {
		
		setLayout(new BorderLayout(3,3));
		setBorder(BorderFactory.createLineBorder(Color.GRAY, 2));
		setBackground(Color.GRAY);

		emitujPanel.setBackground(Color.WHITE);
		emitujPanel.setPreferredSize(new Dimension(400, 300));
		add(emitujPanel,BorderLayout.CENTER);

		JPanel dole = new JPanel();
		dole.setLayout(new GridLayout(4, 2, 3, 3));
		add(dole, BorderLayout.SOUTH);

		dole.add(new JLabel("Transparentnost trougla"));
		trougaoTransparentnost = new JSlider(0, 255);
		trougaoTransparentnost.addChangeListener(rukovalac);
		dole.add(trougaoTransparentnost);

		dole.add(new JLabel("Transparentnost kruga"));
		krugTransparentnost = new JSlider(0, 255);
		krugTransparentnost.addChangeListener(rukovalac);
		dole.add(krugTransparentnost);

		dole.add(new JLabel("Transparentnost pravougaonika"));
		pravougaonikTransparentnost = new JSlider(0, 255);
		pravougaonikTransparentnost.addChangeListener(rukovalac);
		dole.add(pravougaonikTransparentnost);

		dole.add(new JLabel("Transparentnost teksta"));
		tekstTransparentnost = new JSlider(0, 255);
		tekstTransparentnost.addChangeListener(rukovalac);
		dole.add(tekstTransparentnost);
	}

}
