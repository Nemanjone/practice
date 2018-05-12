import java.awt.BorderLayout;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import javax.swing.JFrame;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;

public class JednostavniServer {
	
	public static void main (String [] args) {
		
		ServerOkvir okvir = new ServerOkvir();
		okvir.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		okvir.setVisible(true);
		okvir.startServer();
	}
}

class ServerOkvir extends JFrame {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	private JTextArea log;
	
	public ServerOkvir() {
		
		setTitle("Server");
		setSize(500, 300);
		
		log = new JTextArea();
		log.setEditable(false);
		
		setLayout(new BorderLayout());
		add(new JScrollPane(log), BorderLayout.CENTER);	
	}
	
	public void startServer() {
		
		log.append("Server je startovan..."+ '\n');
		
		try {
			ServerSocket srvSoket = new ServerSocket(2345);
			
			Socket kliSoket = srvSoket.accept();
			srvSoket.close();
			
			DataInputStream odKlijenta = new DataInputStream(
					kliSoket.getInputStream());
			DataOutputStream kaKlijentu = new DataOutputStream(
					kliSoket.getOutputStream());
			
			while (true) {
				double r = odKlijenta.readDouble();
				log.append("Preènik kruga primljen od klijenta: ");
				log.append(r + "\n");
				
				double p = r * r *Math.PI;
				
				kaKlijentu.writeDouble(p);
				kaKlijentu.flush();
				log.append("Površina kruga poslata klijentu: ");
				log.append(p + "\n");
				
			}
					
		}
		catch(IOException e) {
			log.append("Prekid konekcije sa klijentom: " + e + "\n");
		}
	}
}