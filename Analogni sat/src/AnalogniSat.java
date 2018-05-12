import java.awt.BasicStroke;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.RenderingHints;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.geom.AffineTransform;
import java.awt.geom.Ellipse2D;
import java.awt.geom.Line2D;
import java.awt.geom.Point2D;
import java.util.Calendar;
import java.util.GregorianCalendar;
import javax.swing.JComponent;
import javax.swing.JFrame;


public class AnalogniSat {
	
	public static void main(String [] args) {
		
		JFrame okvir = new JFrame("Analogni sat");
		okvir.setLocationRelativeTo(null);
		okvir.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		okvir.add(new Sat());
		okvir.pack();
		okvir.setVisible(true);
		
	}
}
class Sat extends JComponent {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	private Dimension dimSata;
	private int Ëas;
	private int min;
	private int sek;
	private Line2D kazaljka»as;
	private Line2D kazaljkaMin;
	private Line2D kazaljkaSek;
	private Line2D oznaka»as;
	private Ellipse2D krugSata;
	
	public Sat  (int r) {
		dimSata = new Dimension(r, r);
		
		Point2D p1 = new Point2D.Double(0, 0);
		Point2D p2 = new Point2D.Double(0, -r/2.0 + 0.05*r);
		Point2D p3 = new Point2D.Double(0, -r/2.0 + 0.12*r);
		Point2D p4 = new Point2D.Double(0, -r/2.0 + 0.03*r);
		Point2D p5 = new Point2D.Double(0, -r/2.0 + 0.05*r);
		Point2D p6 = new Point2D.Double(0, -r/2.0);
		
		kazaljkaMin = new Line2D.Double(p1, p2);
		kazaljka»as = new Line2D.Double(p1, p3);
		kazaljkaSek = new Line2D.Double(p1, p4);
		
		krugSata = new Ellipse2D.Double(
				0, 0, dimSata.getWidth(), dimSata.getHeight());
		
		oznaka»as = new Line2D.Double(p5, p6);
		
		GregorianCalendar sada = new GregorianCalendar();
		Ëas = sada.get(Calendar.HOUR);
		min = sada.get(Calendar.MINUTE);
		sek = sada.get(Calendar.SECOND);
		
		javax.swing.Timer t = new javax.swing.Timer(1000, new ActionListener() {
			
		public void actionPerformed(ActionEvent dogaaj) {
			
			sek = sek + 1;
			int m = sek/60;
			sek = sek % 60;
			min = min + m;
			int Ë = min/60;
			min = min % 60;
			Ëas = (Ëas + Ë)%12;
			repaint();
		}
		});
		t.start();		
	}	
	
	public Sat() {
		this(200);
	}
	
	public void setPreferredSize  (Dimension dim)  {           //Java Bean
		dimSata = dim;
	}
	
	public Dimension getPreferredSize () {
	
		return ( new Dimension (dimSata.width + 2, dimSata.height + 2));
		
	}
	
	public Dimension getMaximumSize() {
		return(new Dimension(dimSata.width + 5, dimSata.height + 5));
	}
	
	public Dimension getMinimumSize() {
		return dimSata;
	}
	
	public void paintComponent(Graphics g) {
		
		Graphics2D g2d = (Graphics2D) g;
		super.paintComponent(g2d);
		
		AffineTransform staraAT = g2d.getTransform();
		
		g2d.setRenderingHint(RenderingHints.KEY_ANTIALIASING, 
				RenderingHints.VALUE_ANTIALIAS_ON);
		
		int ugaoSek = sek*6;
		int ugaoMin = min*6 + sek/10;
		int ugao»as = Ëas*30 + min/2;
		
		g2d.setColor(Color.BLACK);
		g2d.setStroke(new BasicStroke(3));
		g2d.draw(krugSata);
		
		g2d.setColor(Color.YELLOW);
		g2d.fill(krugSata);
		
		g2d.setTransform(staraAT);
		g2d.setColor(Color.BLACK);
		g2d.translate(dimSata.width/2, dimSata.width/2);
		for (int i = 0; i < 12; i++) {
			g2d.rotate(30 * Math.PI/180);      //90 stepeni je PI/2 Radijana; 360 /12 = 30 stepeni
			g2d.setStroke(new BasicStroke(1));;// Math.PI / 180 = 1 stepen
			g2d.draw(oznaka»as);	
		}
		
		g2d.setTransform(staraAT);
		g2d.translate(dimSata.width/2, dimSata.width/2);
		g2d.rotate(ugao»as*Math.PI/180);
		g2d.setColor(Color.BLUE);
		g2d.setStroke(new BasicStroke(3));
		g2d.draw(kazaljka»as);
		
		g2d.setTransform(staraAT);
		g2d.translate(dimSata.width/2, dimSata.width/2);
		g2d.rotate(ugaoMin*Math.PI/180);
		g2d.setColor(Color.RED);
		g2d.setStroke(new BasicStroke(2));
		g2d.draw(kazaljkaMin);
		
		g2d.setTransform(staraAT);
		g2d.translate(dimSata.width/2, dimSata.width/2);
		g2d.rotate(ugaoSek*Math.PI/180);
		g2d.setColor(Color.BLACK);
		g2d.setStroke(new BasicStroke(1));
		g2d.draw(kazaljkaSek);

		
		}
	
	
	}
	
	
	
	
