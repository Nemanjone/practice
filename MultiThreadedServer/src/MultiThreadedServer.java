import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.Scanner;
import java.util.concurrent.ArrayBlockingQueue;

public class MultiThreadedServer {


	public static final int PORT = 2345;

	private static final int THREAD_POOL_SIZE = 10;

	private static final int CONNECTION_QUEUE_SIZE = 5;

	private static ArrayBlockingQueue<Socket> konekcijaRed;

	public static void main(String[] args) {

		File direktorijum;

		ServerSocket serverSoket;

		Socket konekcija;


		if (args.length == 0) {
			System.out.println(" Java FileServer <direktorijum>");
			return;
		}
		direktorijum = new File(args[0]);
		if (!direktorijum.exists()) {
			System.out.println("Takav direktorijum ne postoji!");
			return;
		}
		if (!direktorijum.isDirectory()) {
			System.out.println("Traženi pojam nije direktorijum!");
			return;
		}

		konekcijaRed = new ArrayBlockingQueue<Socket>(CONNECTION_QUEUE_SIZE);

		for (int i = 0; i < THREAD_POOL_SIZE; i++) {
			ConnectionHandler radnici = new ConnectionHandler(direktorijum);
			radnici.start();
		}

		try {
			serverSoket = new ServerSocket(PORT);
			System.out.println("Èekam na portu " + PORT);
			while (true) {
				konekcija = serverSoket.accept();
				konekcijaRed.add(konekcija);
			}
		}
		catch (Exception e) {
			System.out.println("Server se ugasio!");
			System.out.println("Greska: " + e);
			return;
		}

	}
	private static class ConnectionHandler extends Thread {
		File direktorijum;
		public ConnectionHandler(File direktorijum) {
			this.direktorijum = direktorijum;
			setDaemon(true);
		}
		public void run () {
			while(true) {
				try {
					Socket konekcija = konekcijaRed.take();
					handleConnection(direktorijum, konekcija);
				}
				catch (Exception e) {

				}
			}
		}
	}

	private static void handleConnection(File direktorijum, Socket konekcija) {
		Scanner ulaz;
		PrintWriter izlaz;
		String komanda = "Komanda nije uèitana";

		try {
			ulaz = new Scanner(konekcija.getInputStream());
			izlaz = new PrintWriter(konekcija.getOutputStream());
			komanda = ulaz.nextLine();
			if (komanda.equals("index")) {
				sendIndex(direktorijum, izlaz);
			}
			else if (komanda.startsWith("get")) {
				String imeDatoteke = komanda.substring(3).trim();
				sendFile(imeDatoteke, direktorijum, izlaz);
			}
			else {
				izlaz.println("Pogrešna komanda.");
				izlaz.flush();
			}
			System.out.println("OK    " + konekcija.getInetAddress() + " " + komanda);
		}
		catch(Exception e) {
			System.out.println("Greska: " + konekcija.getInetAddress() + " " + komanda + " " + e);
		}
		finally {
			try {
				konekcija.close();
			}
			catch (IOException e) {

			}
		}
	}

	private static void sendIndex (File direktorijum, PrintWriter izlaz) throws Exception {

		String [] listaDatoteka = direktorijum.list();
		for (int i = 0; i < listaDatoteka.length; i++) {
			izlaz.println(listaDatoteka[i]);
			izlaz.flush();
			izlaz.close();
			if (izlaz.checkError())
				throw new Exception("Greska prilikom slanja podataka!");
		}	
	}

	private static void sendFile (String imeDatoteke, File direktorijum, PrintWriter izlaz) throws Exception {
		File datoteka = new File(direktorijum, imeDatoteke);
		if (!datoteka.exists() || !datoteka.isDirectory()) {
			izlaz.println("Greska!");
		}
		else {
			izlaz.println("ok");
			BufferedReader fileIn = new BufferedReader(new FileReader(datoteka));

			while(true) {
				String red = fileIn.readLine();
				if (red == null)
					break;
				izlaz.println(red);
			}
			fileIn.close();
		}

		izlaz.flush();
		izlaz.close();
		if(izlaz.checkError())
			throw new Exception("Greska prilikom slanja podataka.");
	}
}
