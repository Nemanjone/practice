import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Polygon;
import java.awt.geom.Ellipse2D;
import java.awt.geom.Rectangle2D;
import javax.swing.JApplet;
import javax.swing.JComponent;
import javax.swing.JLabel;
import javax.swing.SwingConstants;

public class KamionAplet extends JApplet {
	
	public void init() {
	
		setLayout(new BorderLayout());
		
		JLabel naslov = new JLabel("Bokijev kamion", SwingConstants.CENTER);
		naslov.setFont(new Font("Serif", Font.BOLD,20));
		add(naslov,BorderLayout.NORTH);
		
		JComponent fap = new Kamion();
		add(fap,BorderLayout.CENTER);
	}
}
 
class Kamion extends JComponent {
	
	public void paintComponent(Graphics g) {
	
	Graphics2D g2 = (Graphics2D) g;
	
	Color bledoPlava = new Color(0.75f, 0.750f, 1.0f);
	g2.setColor(bledoPlava);
	
	g2.fill(new Rectangle2D.Double(0, 0, 300, 300));
	g2.setColor(Color.RED);
	g2.fill(new Rectangle2D.Double(50, 100, 120, 80));
	g2.fill(new Rectangle2D.Double(170, 130, 80, 50));
	
	Polygon trougao = new Polygon();
	trougao.addPoint(170, 100);
	trougao.addPoint(170, 130);
	trougao.addPoint(200, 130);
	g2.setColor(Color.YELLOW);
	g2.fillPolygon(trougao);
	
	g2.setColor(Color.DARK_GRAY);
	g2.fill(new Ellipse2D.Double(70, 160, 40, 40));
	g2.setColor(Color.WHITE);
	g2.fill(new Ellipse2D.Double(80, 170, 20, 20));
	
	g2.setColor(Color.DARK_GRAY);
	g2.fill(new Ellipse2D.Double(190, 160, 40, 40));
	g2.setColor(Color.WHITE);
	g2.fill(new Ellipse2D.Double(200, 170, 20, 20));
	
	g2.setFont(new Font("Serif", Font.ITALIC, 20));
	g2.setColor(Color.WHITE);
	g2.drawString("Boki",70 , 125);
	g2.drawString("Sladoled - Navalite!", 70, 150);
	
}
}
