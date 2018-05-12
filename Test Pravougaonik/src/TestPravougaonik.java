import java.awt.Component;
import java.awt.Graphics;

import javax.swing.JComponent;
import javax.swing.JFrame;

public class TestPravougaonik {
	
	public static void main(String [] args) {
		
		JFrame okvir = new JFrame("Za Taru!!!!");
		okvir.setSize(300, 200);
		okvir.setLocation(500,450);
		okvir.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		GrafièkaKomponenta komp = new GrafièkaKomponenta();
		
		okvir.add(komp);
		okvir.setVisible(true);
	}

}

class GrafièkaKomponenta extends JComponent{


       public void paintComponent  (Graphics g) {
	
	g.drawString("Sreæan roðendan, Tara!", 60, 50);
	g.drawRect(50, 80, 150, 50);
	
}
}
