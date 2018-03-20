import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;

public class TestDugmeBroja� {
	
	public static void main (String[] args) {
		
		DugmeBroja�Okvir  okvir = new DugmeBroja�Okvir();
		okvir.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		okvir.setVisible(true);
	}

}
class DugmeBroja�Okvir extends JFrame {
	
	private JLabel oznaka;
	
private class RukovalacDugmeta implements ActionListener {
	
	
	private int broja�;
	
	public void actionPerformed (ActionEvent e) {
		broja�++;
		oznaka.setText("Broj pritisaka = " + broja�);
		
	}
	}
		
		public DugmeBroja�Okvir () {
			setTitle("Brojanje pritisaka na dugme: ");
			setSize(300, 150);
			setLocation(600, 450);
			setLayout(new FlowLayout(FlowLayout.CENTER,30,20));
			
			oznaka = new JLabel("Broj pritisaka = 0");
			add(oznaka);
			
			JButton dugme = new JButton("Pritisni me");
			add(dugme);
			dugme.addActionListener(new RukovalacDugmeta());
				
	}
}