import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Graphics2D;

import javax.swing.JComponent;
import javax.swing.JFrame;

public class TestFont extends JComponent {
	
	public static void main(String[] args) {
		
		JFrame okvir = new JFrame("Dodrodošli!");
		okvir.setSize(350, 200);
		okvir.setLocation(150, 200);
		okvir.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		GrafièkaKomponenta komp = new GrafièkaKomponenta();
		
		okvir.add(komp);
		okvir.setVisible(true);
		
	}
}

class GrafièkaKomponenta extends JComponent{
	
	public void paintComponent (Graphics g) {
		
		Graphics2D g2 =(Graphics2D) g;
		
		Font sansBold36 = new Font("SansSerif", Font.BOLD,36);
		g2.setFont(sansBold36);
		g2.drawString("Æao, Takice!", 50, 50);
		Font serifPlain18 = new Font("Serif", Font.PLAIN,18);
		g2.setFont(serifPlain18);
		g2.setPaint(Color.RED);
		g2.drawString("Danas je divan dan!", 80, 100);
		
		
		
	}
}
