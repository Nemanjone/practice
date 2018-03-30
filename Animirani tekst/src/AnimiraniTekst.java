import java.awt.Font;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class AnimiraniTekst {
	
	public static void main (String [] args) {
		
		JFrame okvir = new JFrame("Animirani tekst");
		okvir.setSize(300, 200);
		okvir.setLocationRelativeTo(null);
		okvir.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		okvir.add(new TestAnimiraniTekst());
		okvir.setVisible(true);
	}
}
 class TestAnimiraniTekst extends JPanel implements Runnable {
	 
	 /**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	private JLabel oznaka = new JLabel("Dobrodošli!",JLabel.CENTER);

	 
	 public TestAnimiraniTekst () {
		 add(oznaka);
		 oznaka.setFont(new Font("Serif", Font.BOLD, 22));
		 new Thread(this).start();
	 }
	 
	 public void run() {
		 try {
			 while (true) {
				 if (oznaka.getText() == null)
					 oznaka.setText("Dobrodošli!");
				 else
					 oznaka.setText(null);
				 
				 Thread.sleep(500);
			 } 
		 }
		 catch (InterruptedException ex) {
			 
		 }
	 } 
 }