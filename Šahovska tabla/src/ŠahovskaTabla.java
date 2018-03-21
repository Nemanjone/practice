import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.geom.Rectangle2D;
import javax.swing.JApplet;
import javax.swing.JComponent;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.SwingConstants;

public class ŠahovskaTabla extends JApplet {
	
	public void init () {
		
		setLayout(new BorderLayout());
		
		JLabel naslov = new JLabel ("Šahovska tabla", SwingConstants.CENTER);
		Font mono = new Font("Monospaced", Font.BOLD, 18);
		add(naslov, BorderLayout.NORTH);
		
		NapraviTablu šah = new NapraviTablu();
		add(šah, BorderLayout.CENTER);

	}
}

	class NapraviTablu extends JComponent {
		
		public void paintComponent(Graphics g) {
			
			Graphics2D g2 = (Graphics2D)g;
			
			
			
			g2.setColor(Color.WHITE);
			g2.fill(new Rectangle2D.Double(0, 0, 320, 320));
			
			
			
			g2.setColor(Color.BLACK);                               //crna polja...
			g2.fill(new Rectangle2D.Double(40, 0, 40, 40));
			
			g2.setColor(Color.BLACK);
			g2.fill(new Rectangle2D.Double(120, 0, 40, 40));
			
			g2.setColor(Color.BLACK);
			g2.fill(new Rectangle2D.Double(200, 0, 40, 40));
			
			g2.setColor(Color.BLACK);
			g2.fill(new Rectangle2D.Double(280, 0, 40, 40));
			
			
			g2.setColor(Color.BLACK);                               //crna polja...
			g2.fill(new Rectangle2D.Double(0, 40, 40, 40));
			
			g2.setColor(Color.BLACK);
			g2.fill(new Rectangle2D.Double(80, 40, 40, 40));
			
			g2.setColor(Color.BLACK);
			g2.fill(new Rectangle2D.Double(160, 40, 40, 40));
			
			g2.setColor(Color.BLACK);
			g2.fill(new Rectangle2D.Double(240, 40, 40, 40));
			
			
			g2.setColor(Color.BLACK);                               //crna polja...
			g2.fill(new Rectangle2D.Double(40, 80, 40, 40));
			
			g2.setColor(Color.BLACK);
			g2.fill(new Rectangle2D.Double(120, 80, 40, 40));
			
			g2.setColor(Color.BLACK);
			g2.fill(new Rectangle2D.Double(200, 80, 40, 40));
			
			g2.setColor(Color.BLACK);
			g2.fill(new Rectangle2D.Double(280, 80, 40, 40));
			
			
			g2.setColor(Color.BLACK);                               //crna polja...
			g2.fill(new Rectangle2D.Double(0, 120, 40, 40));
			
			g2.setColor(Color.BLACK);
			g2.fill(new Rectangle2D.Double(80, 120, 40, 40));
			
			g2.setColor(Color.BLACK);
			g2.fill(new Rectangle2D.Double(160, 120, 40, 40));
			
			g2.setColor(Color.BLACK);
			g2.fill(new Rectangle2D.Double(240, 120, 40, 40));
			
			
			g2.setColor(Color.BLACK);                               //crna polja...
			g2.fill(new Rectangle2D.Double(40, 160, 40, 40));
			
			g2.setColor(Color.BLACK);
			g2.fill(new Rectangle2D.Double(120, 160, 40, 40));
			
			g2.setColor(Color.BLACK);
			g2.fill(new Rectangle2D.Double(200, 160, 40, 40));
			
			g2.setColor(Color.BLACK);
			g2.fill(new Rectangle2D.Double(280, 160, 40, 40));
			
			
			
			
			g2.setColor(Color.BLACK);                               //crna polja...
			g2.fill(new Rectangle2D.Double(0, 200, 40, 40));
			
			g2.setColor(Color.BLACK);
			g2.fill(new Rectangle2D.Double(80, 200, 40, 40));
			
			g2.setColor(Color.BLACK);
			g2.fill(new Rectangle2D.Double(160, 200, 40, 40));
			
			g2.setColor(Color.BLACK);
			g2.fill(new Rectangle2D.Double(240, 200, 40, 40));
			
			
			
			g2.setColor(Color.BLACK);                               //crna polja...
			g2.fill(new Rectangle2D.Double(40, 240, 40, 40));
			
			g2.setColor(Color.BLACK);
			g2.fill(new Rectangle2D.Double(120, 240, 40, 40));
			
			g2.setColor(Color.BLACK);
			g2.fill(new Rectangle2D.Double(200, 240, 40, 40));
			
			g2.setColor(Color.BLACK);
			g2.fill(new Rectangle2D.Double(280, 240, 40, 40));
			
			
			
			g2.setColor(Color.BLACK);                               //crna polja...
			g2.fill(new Rectangle2D.Double(0, 280, 40, 40));
			
			g2.setColor(Color.BLACK);
			g2.fill(new Rectangle2D.Double(80, 280, 40, 40));
			
			g2.setColor(Color.BLACK);
			g2.fill(new Rectangle2D.Double(160, 280, 40, 40));
			
			g2.setColor(Color.BLACK);
			g2.fill(new Rectangle2D.Double(240, 280, 40, 40));
		}
		
		
	}
