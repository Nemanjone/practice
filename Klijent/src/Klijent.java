import java.awt.BorderLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.Socket;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;

public class Klijent {

	public static void main(String[] args) {
		
		KlijentOkvir okvir = new KlijentOkvir();
		okvir.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		okvir.setVisible(true);
	} 
}
class KlijentOkvir extends JFrame {
	
	private JTextField pre�nikPolje;
	private JTextArea log;
	
	private DataInputStream odServera;
	private DataOutputStream kaServeru;
	
	public KlijentOkvir() {
		
		setTitle("Klijent");
		setSize(500, 300);
		
		pre�nikPolje = new JTextField();
		pre�nikPolje.setHorizontalAlignment(JTextField.LEFT);
		
		pre�nikPolje.addActionListener(new RukovalacEntera());
		
		log = new JTextArea();
		log.setEditable(false);
		
		JPanel panel = new JPanel();
		panel.setLayout(new BorderLayout());
		panel.add(new JLabel("Pre�nik kruga: " ), BorderLayout.WEST);
		panel.add(pre�nikPolje, BorderLayout.CENTER);
		
		
		setLayout(new BorderLayout());
		add(panel,BorderLayout.NORTH);
		add(new JScrollPane(log), BorderLayout.CENTER);
		
		try {
			Socket kliSoket = new Socket("localhost", 2345);
			log.append("Uspostavljanje konekcije sa serverom..." + "\n");
			
			odServera = new DataInputStream(kliSoket.getInputStream());
			kaServeru = new DataOutputStream(kliSoket.getOutputStream());	
		}
		catch (IOException e) {
			log.append("Neuspe�no uspostavljanje konekcije sa serverom: " + e);
		}	
	}
	
private class RukovalacEntera implements ActionListener {
	
	public void actionPerformed(ActionEvent ae) {
		
		try {
			double r = Double.parseDouble(pre�nikPolje.getText().trim());
			
			kaServeru.writeDouble(r);
			kaServeru.flush();
			log.append("Pre�nik kruga poslat serveru: ");
			log.append(r + "\n");
			
			double p = odServera.readDouble();
			log.append("Povr�ina kruga primljena od servera: ");
			log.append(p + "\n");
			
		}
		catch (IOException e1) {
			log.append("Gre�ka u komunikaciji sa serverom: " + e1);
			
			}
		}
	}
}