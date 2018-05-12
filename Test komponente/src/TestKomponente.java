import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.JTextField;
import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JComboBox;

public class TestKomponente {

	public static void main(String[] args) {
	
	JFrame okvir = new JFrame("Test komponente");
	okvir.setSize(600,150);
	okvir.setLocation(400, 350);
	
	JButton dugmeOK = new JButton("OK");
	JLabel oznakaIme = new JLabel("Unesite svoje ime: ");
	JTextField tekstPoljeIme = new JTextField("Ovde upišite svoje ime");
	JCheckBox potvrdaStudent = new JCheckBox("Student");
	JRadioButton radioDugmeZaposlen = new JRadioButton("Zaposlen");
	JComboBox kombPoljeGodina = new JComboBox(new String [] {"I godina", "II godina", "III godina", "IV godina"} );
	
	JPanel panel = new JPanel();
	
	panel.add(dugmeOK);
	panel.add(oznakaIme);
	panel.add(tekstPoljeIme);
	panel.add(potvrdaStudent);
	panel.add(radioDugmeZaposlen);
	panel.add(kombPoljeGodina);
	
	okvir.add(panel);
	
	okvir.setVisible(true);
	
	
	
}
}