import java.awt.BorderLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.BufferedInputStream;
import java.io.BufferedReader;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileWriter;
import java.io.InputStreamReader;
import java.net.Socket;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.SwingUtilities;

public class FileKlijent {
	
	public static void main(String[] args) {
		
	//	SwingUtilities.invokeLater(new Runnable() {

		//	public void run() {
				
				KlijentOkvir okvir = new KlijentOkvir();
				okvir.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
				okvir.setLocationRelativeTo(null);
				okvir.setVisible(true);
				
		//	}	
			
		//});
	}

}

class KlijentOkvir extends JFrame {
	
	private JTextField poljeDatoteke;
	private JTextArea log;
	
	private BufferedReader ucitajOdKorisnika;
	private DataOutputStream kaServeru;
	private BufferedReader odServera;
	
	public KlijentOkvir() {
		setTitle("Klijent");
		setSize(500, 300);
		
		poljeDatoteke = new JTextField();
		poljeDatoteke.setHorizontalAlignment(JTextField.LEFT);
		poljeDatoteke.addActionListener(new RukovalacEntera());
		
		log = new JTextArea();
		log.setEditable(false);
		
		JPanel panel = new JPanel();
		panel.setLayout(new BorderLayout());
		panel.add(new JLabel("Ime datoteke: "), BorderLayout.WEST);
		panel.add(poljeDatoteke, BorderLayout.CENTER);
		
		setLayout(new BorderLayout());
		add(panel, new BorderLayout().NORTH);
		add(new JScrollPane(log), BorderLayout.CENTER);
		
		try {
			Socket klijentSoket = new Socket("localhost", 2345);
			log.append("Uspostavljenje konekcije sa serverom..." + "\n");
			
			//ucitajOdKorisnika = new BufferedReader(new InputStreamReader(System.in));
			kaServeru = new DataOutputStream(klijentSoket.getOutputStream());
			odServera = new BufferedReader(new InputStreamReader(klijentSoket.getInputStream()));
		}
		catch (Exception e) {
		log.append("Neuspesno uspostavljanje konekcije sa serverom: " + e);
		}
		
	}
	
	private class RukovalacEntera implements ActionListener {

		@Override
		public void actionPerformed(ActionEvent e) {
			try {
				String imeDatoteke = poljeDatoteke.getText().trim();
				//String datoteka = ucitajOdKorisnika.readLine();
				//kaServeru.writeBytes(datoteka + "\n");
				kaServeru.writeBytes(imeDatoteke);
				kaServeru.flush();
				//FileWriter fw = new FileWriter("C:\\Users\\Marko\\Desktop\\Tekstovi");
				String datotekaOdServera = "";
				while(!datotekaOdServera.equals(null)) {
					log.append("Od servera: " + datotekaOdServera);
				} 
				datotekaOdServera = odServera.readLine();
				//fw.write(datotekaOdServera);
				//fw.close(); 
				
				
			}catch(Exception ae) {
				log.append("Greska u komunikaciji sa serverom: " + ae);
			}
			
		}
		
	}
	
}
