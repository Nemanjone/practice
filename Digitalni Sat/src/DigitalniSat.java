import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Calendar;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JTextField;


public class DigitalniSat {
	
	public static void main (String [] args) {
		
		JFrame okvir = new JFrame("Digitalni sat");
		okvir.add(new PanelDigitalnogSata());
		okvir.setLocation(100, 100);
		okvir.pack();
		okvir.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		okvir.setVisible(true);
		
	}
}

class PanelDigitalnogSata extends JPanel  {
	
	private JTextField vreme;
	
	public PanelDigitalnogSata() {
		vreme = new JTextField(5);
		vreme.setFont(new Font(Font.SANS_SERIF, Font.PLAIN, 48));
		vreme.setEditable(false);
		vreme.getCaret().setVisible(false);
		
		add(vreme);
		
		javax.swing.Timer t = new javax.swing.Timer(1000, new ActionListener() {
			
			public void actionPerformed(ActionEvent e) {
				Calendar sada = Calendar.getInstance();
				int è = sada.get(Calendar.HOUR_OF_DAY);
				int m = sada.get(Calendar.MINUTE);
				int s = sada.get(Calendar.SECOND);
				vreme.setText("" + è + ":" + m + ":" + s);
			
	}});
		
		t.start();
	
}
}