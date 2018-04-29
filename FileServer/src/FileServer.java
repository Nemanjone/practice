import java.awt.BorderLayout;
import java.io.BufferedInputStream;
import java.io.BufferedReader;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileReader;
import java.io.InputStreamReader;
import java.net.ServerSocket;
import java.net.Socket;
import javax.swing.JFrame;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.SwingUtilities;

public class FileServer {

	public static void main(String[] args) {



		/*SwingUtilities.invokeLater (new Runnable() {
			public void run() {*/

				ServerOkvir okvir = new ServerOkvir();
				okvir.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
				okvir.setVisible(true);
				okvir.startServer();

			//}

		//});

	}
}

class ServerOkvir extends JFrame{

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

		log.append("Server je startovan..." + '\n');

		try {
			ServerSocket serverSoket = new ServerSocket(2345);

			Socket klijentSoket = serverSoket.accept();
			serverSoket.close();

			BufferedReader odKlijenta = new BufferedReader(new InputStreamReader
					(klijentSoket.getInputStream()));
			DataOutputStream kaKlijentu = new DataOutputStream(
					klijentSoket.getOutputStream());

			while(true) {

				String imeDatoteke = odKlijenta.readLine().trim();
				log.append("Tražena datoteka " + imeDatoteke);
				File direktorijum;
				String [] datoteke;
				direktorijum = new File(imeDatoteke);
				System.out.println("Trazite datoteku u: " + direktorijum);

				if(!direktorijum.exists() && !direktorijum.isDirectory()) {
					System.out.println("Greska: Direktorijum ne postoji!");
				}
				else {
					try {
						datoteke = direktorijum.list();
						log.append("Datoteke u direktorijumu " + direktorijum + ": ");
						for (int i = 0; i < datoteke.length; i++) {
							log.append( " " + datoteke[i]);
							File proveriDatoteku = new File(imeDatoteke);
							boolean provera = proveriDatoteku.exists();
							if(provera == true) {
								log.append("Datoteka postoji.");
								FileReader fr = new FileReader(proveriDatoteku);
								BufferedReader br = new BufferedReader(fr);
								String red = "";
								while(red != null) {
									log.append(red);
									red = br.readLine();
									kaKlijentu.writeBytes(red + "\n"); 
									kaKlijentu.flush();
									log.append("Datoteka poslata klijentu.");
								}

								br.close();
							}
							else
								log.append("Datoteka ne postoji!");

						}

					}
					catch(Exception e) {
						log.append("Greska prilikom slanja datoteke!");
					}
				}

			}

		}
		catch (Exception e) {
			System.out.println("Greska prilikom uspostavljanja konekcije!" + e);

		}
	
	}

 }






