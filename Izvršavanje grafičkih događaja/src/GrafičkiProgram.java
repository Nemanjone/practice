import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.SwingUtilities;

public class GrafičkiProgram {
	
	public static void main (String [] args) {
		
		SwingUtilities.invokeLater(new Runnable() {
			
			@Override
			public void run() {
				// TODO Auto-generated method stub
				JFrame frame = new JFrame("Grafički program");
				JLabel oznaka = new JLabel("Test niti za izvršavanje događaja");
				oznaka.setHorizontalAlignment(0);
				frame.add(oznaka);
				frame.setLocationRelativeTo(null);
				frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
				frame.setSize(250, 200);
				frame.setVisible(true);
				
			}
		});	
	}
	
}
