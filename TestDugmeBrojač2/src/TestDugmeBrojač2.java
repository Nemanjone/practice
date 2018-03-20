
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

public class TestDugmeBrojaè2 {
	
	public static void main (String[] args) {
		
		DugmeBrojaèOkvir2  okvir = new DugmeBrojaèOkvir2();
		okvir.setDefaultCloseOperation(JFrame.DO_NOTHING_ON_CLOSE);
		
		okvir.addWindowListener(new WindowAdapter()  {
			
			public void windowClosing(WindowEvent e) {
				
				Object [] opcija = {"Da", "Ne"};
				int izabranaOpcija = JOptionPane.showOptionDialog(null, 
						"Zaista želite da završite program?", 
						"Kraj rada programa", 
						JOptionPane.DEFAULT_OPTION, 
						JOptionPane.WARNING_MESSAGE, 
						null, opcija, opcija[0]);
				
				if (izabranaOpcija == 0)
					System.exit(0);
			}
		});
		okvir.setVisible(true);
	}
}
class DugmeBrojaèOkvir2 extends JFrame {
	
	private JLabel oznaka;
	
private class RukovalacDugmeta implements ActionListener {
	
	
	private int brojaè;
	
	public void actionPerformed (ActionEvent e) {
		brojaè++;
		oznaka.setText("Broj pritisaka = " + brojaè);
		
	}
	}
		
		public DugmeBrojaèOkvir2 () {
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
