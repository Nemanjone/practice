import java.awt.BorderLayout;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.InetAddress;
import java.net.ServerSocket;
import java.net.Socket;
import javax.swing.JFrame;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;

public class VišenitniServer {
	
	public static void main (String[] args) {
		
		VišenitniServerOkvir okvir = new VišenitniServerOkvir();
		okvir.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		okvir.setVisible(true);
		okvir.startServer();
	}

}

class VišenitniServerOkvir extends JFrame {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	private JTextArea log;
	
	public VišenitniServerOkvir() {
	
	setTitle("Višenitni server");
	setSize(500, 300);
	
	log = new JTextArea();
	log.setEditable(false);
	
	setLayout(new BorderLayout());
	add(new JScrollPane(log), BorderLayout.CENTER);
	
	}
	
	
	public void startServer() {
		
		log.append("Server je startovan..." + "\n");
		
		int k = 0;
		
		try {
			ServerSocket srvSoket = new ServerSocket(2345);
			
			while (true) {
				Socket kliSoket = srvSoket.accept();
				k++;
				
				InetAddress inetAdresa = kliSoket.getInetAddress();
				log.append("Domensko ime klijenta " + k + " :"
				+ inetAdresa.getHostName() + "\n");
				log.append("IP adresa klijenta " + k + " :"
						+ inetAdresa.getHostAddress() + "\n");
				
				Thread nitKlijenta = new Thread(
						new RukovalacKlijenta(kliSoket,k));
				
				nitKlijenta.start();
				log.append("Pokrenuta nit za klijenta " + k + "\n");
					
			}
		}
		
		catch (IOException e) {
		log.append("Prekid rada servera: " + e + "\n");	
		}
		
	}
	
	
	private class RukovalacKlijenta implements Runnable {
		
		private Socket kliSoket;
		private int klijent;
		
		public RukovalacKlijenta(Socket kliSoket, int klijent) {
			super();
			this.kliSoket = kliSoket;
			this.klijent = klijent;
		}
		
		public void run () {
			
			try {
				DataInputStream odKlijnta = new DataInputStream(
						kliSoket.getInputStream());
				DataOutputStream kaKlijentu = new DataOutputStream(
						kliSoket.getOutputStream());
				
				while(true) {
					
					double r = odKlijnta.readDouble();
					log.append("Preènik kruga primljen od klijenta ");
					log.append(klijent + ": " + r + "\n");
					
					double p = r*r*Math.PI;
					
					kaKlijentu.writeDouble(p);
					kaKlijentu.flush();
					log.append("Površina kruga poslata klijentu ");
					log.append(klijent + ": " + p + "\n");	
				}
				
			}
			catch (IOException e) {
				log.append("Prekid konekcije sa klijentom ");
				log.append(klijent + ": " + "\n");
			}
		}
		
	}
}
