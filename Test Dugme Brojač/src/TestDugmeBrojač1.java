
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;

public class TestDugmeBrojaè1 {
	
	public static void main (String[] args) {
		
		DugmeBrojaèOkvir1  okvir = new DugmeBrojaèOkvir1();
		okvir.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		okvir.setVisible(true);
	}
}

class DugmeBrojaèOkvir1 extends JFrame {
	
	private JLabel oznaka;
	
	public DugmeBrojaèOkvir1 () {
		setTitle("Brojanje pritisaka na dugme: ");
		setSize(300, 150);
		setLocation(600, 450);
		setLayout(new FlowLayout(FlowLayout.CENTER,30,20));
	
		oznaka = new JLabel("Broj pritisaka = 0");
		add(oznaka);
		JButton dugme = new JButton("Pritisni me");
		add(dugme);
		
		dugme.addActionListener(new ActionListener() {  //instanca anonimne klase koja implementira ActionListener
			
			private int brojaè;
			
		
			public void actionPerformed(ActionEvent e) {
				
				brojaè++;
				oznaka.setText("Broj pritisaka = " + brojaè);
				
			}
		});
		
	}
	}
	
