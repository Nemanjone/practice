import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.ServerSocket;
import java.net.Socket;

public class Server {
	
	//Serverska strana
	
	int port = 2345;
	try {
		ServerSocket server = new ServerSocket(port);
		while (true) {
			Socket konekcija = server.accept();
			InputStream in = konekcija.getInputStream();
			OutputStream out = konekcija.getOutputStream();
			
			//komunikacija sa klijentom...
			
			konekcija.close();
		}
		
	}
	catch (IOException e) {
		System.out.println("Kraj rada servera usled greške: " + e);
	}

}

 	//klijentska strana

	String komp = "192.168.1.8";
	int port;
	try {
		Socket konekcija = new Socket(komp, port);
		InputStream in = konekcija.getInputStream();
		OutputStream out = konekcija.getOutputStream();
		
		// komunikacija sa klijentom
		
		konekcija.close();
		
		
	}
	catch (IOException e) {
		System.out.println("Neuspešno uspostavljanje konekcije: " + e);
	}

	}


