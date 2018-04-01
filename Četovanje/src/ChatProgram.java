import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;
import javax.swing.BorderFactory;
import javax.swing.Box;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;

public class ChatProgram extends JFrame {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	private enum TipPrograma {SERVER,KLIJENT};
	private enum StanjeKonekcije {POVEZANO, PREKINUTO};

	private TipPrograma program = null;
	private static String brojPorta = "2345";
	private static String udaljeniRaèunar = "localhost";
	
	private RukovalacKonekcije konekcija;
	
	private JButton serverDugme, klijentDugme;
	private JButton prekiniDugme, pošaljiDugme;
	private JTextField serverPortPolje;
	private JTextField udaljeniRaèunarPolje, udaljeniPortPolje;
	private JTextField porukaPolje;
	private JTextArea log;
	
	public ChatProgram(String naslov) {
		super (naslov);
		
		ActionListener rukovalac = new RukovalacDugmadima();
		
		serverDugme = new JButton("Èekaj vezu");
		serverDugme.addActionListener(rukovalac);
		
		klijentDugme = new JButton("Uspostavi vezu");
		klijentDugme.addActionListener(rukovalac);
		
		prekiniDugme = new JButton("Prekini vezu");
		prekiniDugme.addActionListener(rukovalac);
		prekiniDugme.setEnabled(false);
		
		pošaljiDugme = new JButton("Pošalji poruku");
		pošaljiDugme.addActionListener(rukovalac);
		pošaljiDugme.setEnabled(false);
		
		porukaPolje = new JTextField();
		porukaPolje.addActionListener(rukovalac);
		porukaPolje.setEditable(false);
		
		log = new JTextArea(20, 60);
		log.setLineWrap(true);
		log.setWrapStyleWord(true);
		log.setEditable(false);
		
		serverPortPolje = new JTextField(brojPorta, 5);
		udaljeniPortPolje = new JTextField(brojPorta, 5);
		udaljeniRaèunarPolje = new JTextField(udaljeniRaèunar, 18);
		
		JPanel sadržaj = new JPanel();
		sadržaj.setLayout(new BorderLayout(3, 3));
		sadržaj.setBackground(Color.GRAY);
		sadržaj.setBorder(BorderFactory.createLineBorder(Color.GRAY,3));
		
		JPanel trakaVeza = new JPanel();
		trakaVeza.setLayout(new FlowLayout(FlowLayout.CENTER,3,3));
		trakaVeza.add(serverDugme);
		trakaVeza.add(new JLabel("port"));
		trakaVeza.add(serverPortPolje);
		trakaVeza.add(Box.createHorizontalStrut(12));
		trakaVeza.add(klijentDugme);
		trakaVeza.add(udaljeniRaèunarPolje);
		trakaVeza.add(new JLabel("port"));
		trakaVeza.add(udaljeniPortPolje);
		trakaVeza.add(Box.createHorizontalStrut(12));
		trakaVeza.add(prekiniDugme);
		
		JPanel trakaPoruka = new JPanel();
		trakaPoruka.setLayout(new BorderLayout(3, 3));
		trakaPoruka.setBackground(Color.GRAY);
		trakaPoruka.add(new JLabel("Unesi poruku: "), BorderLayout.WEST);
		trakaPoruka.add(porukaPolje, BorderLayout.CENTER);
		trakaPoruka.add(pošaljiDugme, BorderLayout.EAST);
		
		sadržaj.add(trakaVeza, BorderLayout.NORTH);
		sadržaj.add(new JScrollPane(log), BorderLayout.CENTER);
		sadržaj.add(trakaPoruka, BorderLayout.SOUTH);
		
		setContentPane(sadržaj);
		pack();
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		
		addWindowListener(new WindowAdapter() {
			
			public void windowClosed(WindowEvent we) {
				
			if (konekcija != null &&
					konekcija.stanje() == StanjeKonekcije.POVEZANO) {
				konekcija.zatvori();
			}
			System.exit(0);
			} 
     	});	
	}
	
	public static void main (String [] args ) {
		
		ChatProgram okvir = new ChatProgram("Program za èetovanje");
		okvir.setVisible(true);
	
	}
	
	private void prikaži(String poruka) {
		log.append(poruka);
		log.setCaretPosition(log.getDocument().getLength());
		
	}
	
private class RukovalacDugmadima implements ActionListener {
	public void actionPerformed(ActionEvent ae) {
		
		Object izvorDogaðaja = ae.getSource();
		
		if (izvorDogaðaja == serverDugme) {
			if (konekcija == null ||
					konekcija.stanje() == StanjeKonekcije.PREKINUTO) {
				String portString = serverPortPolje.getText();
				int port;
				try {
					port = Integer.parseInt(portString);
					if (port < 1025 || port > 65535)
						throw new NumberFormatException();	
				}
			
			catch (NumberFormatException e) {
				JOptionPane.showMessageDialog(ChatProgram.this, 
						portString + " nije ispravan broj porta.");
				return;
			}
			klijentDugme.setEnabled(false);
			serverDugme.setEnabled(false);
			program = TipPrograma.SERVER;
			konekcija = new RukovalacKonekcije(port);
				
		}	
	}
		
	else if (izvorDogaðaja == klijentDugme) {
		if (konekcija == null ||
				konekcija.stanje() == StanjeKonekcije.PREKINUTO) {
			String portString =
					udaljeniPortPolje.getText().trim();
			int port;
			try {
				port = Integer.parseInt(portString);
				if (port < 1025 || port > 65535)
					throw new NumberFormatException();	
			}
			catch (NumberFormatException e) {
				JOptionPane.showMessageDialog(ChatProgram.this,
						portString + " nije ispravan broj porta.");
				return;
			}
			klijentDugme.setEnabled(false);
			serverDugme.setEnabled(false);
			program = TipPrograma.KLIJENT;
			konekcija = new RukovalacKonekcije(
					udaljeniRaèunarPolje.getText().trim(),port);	
		}
	}
	else if (izvorDogaðaja == prekiniDugme) {
		if (konekcija != null)
			konekcija.zatvori();
		
	}
	else if (izvorDogaðaja == pošaljiDugme ||
			izvorDogaðaja == porukaPolje) {
		if (konekcija != null &&
				konekcija.stanje() == StanjeKonekcije.POVEZANO) {
			konekcija.pošalji(porukaPolje.getText());
			porukaPolje.selectAll();
			porukaPolje.requestFocus();
		  }
	   }
	}
}
private class RukovalacKonekcije extends Thread {
	
	private volatile StanjeKonekcije s;
	private String udaljeniRaèunar;
	private int port;
	private ServerSocket srvSoket;
	private Socket kliSocket;
	private PrintWriter izlaz;
	private BufferedReader ulaz;
	
	RukovalacKonekcije(int port) {
		this.port = port;
		prikaži("\nÈEKANJE VEZE NA PORTU" + port + "\n");
		start();
	}
	
	RukovalacKonekcije (String udaljeniRaèunar, int port) {
		this.udaljeniRaèunar = udaljeniRaèunar;
		this.port = port;
		prikaži("\nUSPOSTAVLJANJE VEZE SA " + udaljeniRaèunar);
		prikaži(" NA PORTU " + port + "\n");
		start();
	}
	synchronized StanjeKonekcije stanje() {
		return s;
	}
	synchronized void pošalji(String poruka) {
		if (s == StanjeKonekcije.POVEZANO) {
			prikaži("POŠALJI: " + poruka + "\n");
			izlaz.println(poruka);
			izlaz.flush();
			if (izlaz.checkError()) {
				prikaži("\n\nGREŠKA PRILIKOM SLANJA PODATAKA!");
				zatvori();
			}
			
		}
	}
	
	synchronized void zatvori() {
		
		s = StanjeKonekcije.PREKINUTO;
		serverDugme.setEnabled(true);
		klijentDugme.setEnabled(true);
		prekiniDugme.setEnabled(false);
		pošaljiDugme.setEnabled(false);
		porukaPolje.setEditable(false);
		
		try {
			if (kliSocket != null)
				kliSocket.close();
			else if (srvSoket != null)
				srvSoket.close();
		}
		catch (IOException e) {
			
		}
	}
	
	public void run() {
		
		try {
			if (program == TipPrograma.SERVER) {
				srvSoket = new ServerSocket(port);
				kliSocket = srvSoket.accept();
				srvSoket.close();
			}
		
		else if (program == TipPrograma.KLIJENT) {
			kliSocket = new Socket(udaljeniRaèunar,port);
			
		}
			
			srvSoket = null;
			ulaz = new BufferedReader(
					new InputStreamReader(kliSocket.getInputStream()));
			izlaz = new PrintWriter(kliSocket.getOutputStream());
			s = StanjeKonekcije.POVEZANO;
			prikaži("\nUSPOSTAVLJENA VEZA\n");
			porukaPolje.setEditable(true);
			porukaPolje.setText("");
			porukaPolje.requestFocus();
			pošaljiDugme.setEnabled(true);
			prekiniDugme.setEnabled(true);
			
			while (s == StanjeKonekcije.POVEZANO) {
				String red = ulaz.readLine();
				if (red == null) {
					prikaži("\nVEZA PREKINUTA SA DRUGE STRANE\n");
					s = StanjeKonekcije.PREKINUTO;	
				}
				else
					prikaži("\nPRIMLJENO: "  + red + "\n");
			}	
	  }
		catch (Exception e) {
			if (s == StanjeKonekcije.POVEZANO)
				prikaži("\n\n GREŠKA: " + e + "\n");	
		}
		finally {
			zatvori();
			prikaži("\n*** VEZA PREKINUTA ***\n");
			kliSocket = null;
			srvSoket = null;
			ulaz = null;
			izlaz = null;
			
			
			
	      	}
	     }
	 }	
  }
