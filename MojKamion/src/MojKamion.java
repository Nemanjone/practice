import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Polygon;
import java.awt.Rectangle;
import java.awt.geom.Ellipse2D;
import javax.swing.JApplet;
import javax.swing.JComponent;
import javax.swing.JLabel;
import javax.swing.SwingConstants;

public class MojKamion extends JApplet {

	
	public void init() {
		
		setLayout(new BorderLayout());
		
		JLabel naslov = new JLabel("Tarina magija", SwingConstants.CENTER);
		Font serif = new Font("Serif", Font.ITALIC, 20);
		add(naslov, BorderLayout.NORTH);
		
		Kamion1 fap = new Kamion1();
		add(fap, BorderLayout.CENTER);
		
	}
}

class Kamion1 extends JComponent {
	
	public void paintComponent(Graphics g) {
		
		Graphics2D g2 = (Graphics2D)g;
		
		g2.setColor(Color.ORANGE);                        //pozadina
		g2.fill(new Rectangle(0, 0, 300, 300));
		
		g2.setColor(Color.PINK);                       //šasija
		g2.fill(new Rectangle(50, 100, 120, 80));
		g2.fill(new Rectangle(170, 130, 80, 50));
		
		Polygon trougao = new Polygon();             //kabina
		trougao.addPoint(170, 100);
		trougao.addPoint(170, 130);
		trougao.addPoint(200, 130);
		g2.setColor(Color.GREEN);
		g2.fillPolygon(trougao);;
		
		g2.setColor(Color.BLACK);                              //zadnji toèak
		g2.fill(new Ellipse2D.Double(60, 150, 50, 50));
		g2.setColor(Color.WHITE);
		g2.fill(new Ellipse2D.Double(72, 163, 25, 25));
		
		g2.setColor(Color.BLACK);                             //prednji toèak
		g2.fill(new Ellipse2D.Double(190, 160, 40, 40));
		g2.setColor(Color.WHITE);
		g2.fill(new Ellipse2D.Double(200, 170, 20, 20));
		
		g2.setFont(new Font("Monospaced", Font.BOLD + Font.ITALIC, 18));
		g2.setColor(Color.BLUE);
		g2.drawString("TAKICA", 70, 125);
		g2.drawString("Samo u Nedoðiji", 70, 145);
		
		
		
		
		
		
		
	}
	
}
