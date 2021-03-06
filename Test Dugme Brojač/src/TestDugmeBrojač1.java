
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;

public class TestDugmeBrojač1 {
	
	public static void main (String[] args) {
		
		DugmeBrojačOkvir1  okvir = new DugmeBrojačOkvir1();
		okvir.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		okvir.setVisible(true);
	}
}

class DugmeBrojačOkvir1 extends JFrame {
	
	private JLabel oznaka;
	
	public DugmeBrojačOkvir1 () {
		setTitle("Brojanje pritisaka na dugme: ");
		setSize(300, 150);
		setLocation(600, 450);
		setLayout(new FlowLayout(FlowLayout.CENTER,30,20));
	
		oznaka = new JLabel("Broj pritisaka = 0");
		add(oznaka);
		JButton dugme = new JButton("Pritisni me");
		add(dugme);
		
		dugme.addActionListener(new ActionListener() {  //instanca anonimne klase koja implementira ActionListener
			
			private int brojač;
			
		
			public void actionPerformed(ActionEvent e) {
				
				brojač++;
				oznaka.setText("Broj pritisaka = " + brojač);
				
			}
		});
		
	}
	}
	
