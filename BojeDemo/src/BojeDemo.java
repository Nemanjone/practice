import java.awt.BasicStroke;
import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.GradientPaint;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.GridLayout;
import java.awt.Paint;
import java.awt.RenderingHints;
import java.awt.TexturePaint;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.MouseMotionListener;
import java.awt.geom.Rectangle2D;
import java.awt.image.BufferedImage;
import java.net.URL;
import javax.imageio.ImageIO;
import javax.swing.BorderFactory;
import javax.swing.ButtonGroup;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.JSlider;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;

public class BojeDemo extends JPanel {

	public static void main(String[] args) {

		JFrame okvir = new JFrame("Vuci od vrha");
		BojeDemo sadr�aj = new BojeDemo();
		okvir.setContentPane(sadr�aj);
		okvir.pack();
		Dimension veli�inaOkvira = Toolkit.getDefaultToolkit().getScreenSize();
		okvir.setLocationRelativeTo(null);
		okvir.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		okvir.setVisible(true);
	}	

	private class Prika�i extends JPanel implements MouseListener, MouseMotionListener {

		int [] xKoordinata, yKoordinata;
		int ta�kaZaPovala�enje = -1;

		public Prika�i() {
			setBackground(Color.WHITE);
			setPreferredSize(new Dimension(400, 300));
			addMouseListener(this);
			addMouseListener(this);
		}

		public void paintComponent(Graphics g) {
			super.paintComponent(g);
			Graphics2D g2 = (Graphics2D) g;
			if (xKoordinata == null) {
				xKoordinata = new int [] { scaleX(0.2), scaleX(0.8), scaleX(0.5),
						scaleX(0.95), scaleX(0.35), scaleX(0.1)};
				yKoordinata = new int [] { scaleY(0.15), scaleY(0.1), scaleY(0.5),
						scaleY(0.45), scaleY(0.9), scaleY(0.7)};	
			}

			g2.setPaint(boja);
			g2.fillPolygon(xKoordinata, yKoordinata, 6);
			g2.setColor(Color.BLACK);
			g2.setStroke(new BasicStroke(2));
			g2.setRenderingHint(RenderingHints.KEY_ANTIALIASING,
					RenderingHints.VALUE_ANTIALIAS_ON);
			g2.drawPolygon(xKoordinata, yKoordinata, 6);
			for(int i = 0; i < 6; i++)
				g2.fillRect(xKoordinata[i] - 3, yKoordinata[i] - 3, 7, 7);
		}

		private int scaleX(double x) {
			return (int) (x * getWidth());
		}

		private int scaleY(double y) {
			return (int) (y * getHeight());
		}

		public void mousePressed(MouseEvent doga�aj) {
			ta�kaZaPovala�enje = -1;
			for (int i = 0; i < 6; i++) {
				if (Math.abs(xKoordinata[i] - doga�aj.getX()) < 4 && 
						Math.abs(yKoordinata[i]) - doga�aj.getY() < 4) {
					ta�kaZaPovala�enje = -1;
					break;
				}
			}
		}

		public void mouseDragged(MouseEvent doga�aj) {
			if (ta�kaZaPovala�enje < 0)
				return;
			int x = Math.max(0, Math.min(doga�aj.getX(), getWidth()));
			int y = Math.max(0, Math.min(doga�aj.getY(), getHeight()));
			xKoordinata[ta�kaZaPovala�enje] = x;
			yKoordinata[ta�kaZaPovala�enje] = y;
			repaint();
		}

		@Override
		public void mouseMoved(MouseEvent e) {}

		@Override
		public void mouseClicked(MouseEvent e) {}

		@Override
		public void mouseEntered(MouseEvent e) {}

		@Override
		public void mouseExited(MouseEvent e) {	}

		@Override
		public void mouseReleased(MouseEvent e) {}

	}

	private ActionListener rukovalacDugmetom = new ActionListener() {

		@Override
		public void actionPerformed(ActionEvent doga�aj) {
			
			trenutnoDugme = (JRadioButton)doga�aj.getSource();
			slider1.removeChangeListener(rukovalacSliderom);
			slider2.removeChangeListener(rukovalacSliderom);
			if (trenutnoDugme == gradientDugme1 || trenutnoDugme == gradientDugme2) {
				oznaka1.setText(" Ugao: ");
				oznaka2.setText(" �irina: ");
				slider1.setMinimum(0);
				slider1.setMaximum(360);
				slider1.setValue(gradientUgao);
				slider2.setMinimum(10);
				slider2.setMaximum(300);
				slider2.setValue(gradient�irina);
			}
			else {
				oznaka1.setText(" Pomeranje teksture: ");
				oznaka2.setText(" Skala teksture: ");
				slider1.setMinimum(0);
				slider1.setMaximum(100);
				slider1.setValue(teksturaOffset);
				slider2.setMinimum(25);
				slider2.setMaximum(200);
				slider2.setValue(skalaTeksture);
			}
			slider1.addChangeListener(rukovalacSliderom);
			slider2.addChangeListener(rukovalacSliderom);
			podesiBoju();
		}
	};

	private ChangeListener rukovalacSliderom = new ChangeListener() {

		@Override
		public void stateChanged(ChangeEvent e) {
			podesiBoju();
		}
	};

	private void podesiBoju() {
		
		if (trenutnoDugme == gradientDugme1 || trenutnoDugme == gradientDugme2) {
			gradientUgao = slider1.getValue();
			gradient�irina = slider2.getValue();
			int x = getWidth()/2;
			int y = getHeight()/2;
			int dx = (int)(gradient�irina * Math.cos(gradientUgao/180.0 * Math.PI));
			int dy = (int)(gradient�irina * Math.sin(gradientUgao/180.0 * Math.PI));

			if (trenutnoDugme == gradientDugme1)
				boja = new GradientPaint(x, y,Color.LIGHT_GRAY, x + dx, y + dy, Color.BLACK, true);
			else
				boja = new GradientPaint(x, y, Color.RED, x+ dx, y + dy, Color.YELLOW, true);
		}
		else {
			teksturaOffset = slider1.getValue();
			skalaTeksture = slider2.getValue();
			BufferedImage tekstura;
			if (trenutnoDugme == teksturaDugme1)
				tekstura = smiley;
			else 
				tekstura = kraljica;
			int �irina = tekstura.getWidth() * skalaTeksture / 100;
			int visina = tekstura.getHeight() * skalaTeksture / 100;
			int offsetX = �irina * teksturaOffset / 100;
			int offsetY = visina * teksturaOffset / 100;
			Rectangle2D sidro = new Rectangle2D.Double(offsetX, offsetY, �irina, visina);
			boja = new TexturePaint(tekstura, sidro);
		}
		prika�i.repaint();	
	}

	private Prika�i prika�i = new Prika�i();
	private Paint boja;
	private BufferedImage kraljica, smiley;
	private JRadioButton gradientDugme1, gradientDugme2;
	private JRadioButton teksturaDugme1, teksturaDugme2;
	private JRadioButton trenutnoDugme;
	private int gradientUgao = 45, gradient�irina = 50;
	private int teksturaOffset = 0, skalaTeksture = 100;
	private JSlider slider1, slider2;
	private JLabel oznaka1 = new JLabel(" Ugao: ");
	private JLabel oznaka2 = new JLabel(" �irina: ");

	public BojeDemo() {
		
		setLayout(new BorderLayout(3, 3));
		setBorder(BorderFactory.createLineBorder(Color.GRAY, 3));
		setBackground(Color.GRAY);
		add(prika�i, BorderLayout.CENTER);

		JPanel donji = new JPanel();
		donji.setLayout(new GridLayout(0, 2, 5, 5));
		add(donji, BorderLayout.SOUTH);

		slider1 = new JSlider(0, 360, gradientUgao);
		slider1.addChangeListener(rukovalacSliderom);

		slider2 = new JSlider(10, 300, gradientUgao);
		slider2.addChangeListener(rukovalacSliderom);

		donji.add(oznaka1);
		donji.add(slider1);
		donji.add(oznaka2);
		donji.add(slider2);

		ButtonGroup grupa = new ButtonGroup();

		gradientDugme1 = new JRadioButton("Crna/Siva Gradient");
		gradientDugme1.addActionListener(rukovalacDugmetom);
		donji.add(gradientDugme1);
		grupa.add(gradientDugme1);
		gradientDugme1.setSelected(true);

		trenutnoDugme = gradientDugme1;

		gradientDugme2 = new JRadioButton("Crvena/�uta Gradient");
		gradientDugme2.addActionListener(rukovalacDugmetom);
		donji.add(gradientDugme2);
		grupa.add(gradientDugme2);

		podesiBoju();

		try {
			ClassLoader cl = BojeDemo.class.getClassLoader();
			URL slikaUrl = cl.getResource("slikaKursor1.png");
			if (slikaUrl != null)
				smiley = ImageIO.read(slikaUrl);
			slikaUrl = cl.getResource("kraljicaSrce.jpg");
			kraljica = ImageIO.read(slikaUrl);
		}
		catch (Exception e) {
			return;
		}

		teksturaDugme1 = new JRadioButton("Smajli");
		teksturaDugme1.addActionListener(rukovalacDugmetom);
		donji.add(teksturaDugme1);
		grupa.add(teksturaDugme1);

		teksturaDugme2 = new JRadioButton("Kraljica");
		teksturaDugme2.addActionListener(rukovalacDugmetom);
		donji.add(teksturaDugme2);
		grupa.add(teksturaDugme2);

	}
}
