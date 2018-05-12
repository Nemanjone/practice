import java.awt.Insets;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.PrintWriter;
import java.nio.file.FileAlreadyExistsException;
import javax.swing.ImageIcon;
import javax.swing.JFileChooser;
import javax.swing.JFrame;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.KeyStroke;
import javax.swing.UIManager;
import javax.swing.plaf.FileChooserUI;

public class Editor {
	
	public static void main ( String [] args) {
		
		JFrame okvir = new OkvirEditora();
		okvir.setSize(700, 500);
		okvir.setLocationRelativeTo(null);
		okvir.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		okvir.setVisible(true);
		
	}
}
 class OkvirEditora extends JFrame {
	 
	 private static final String opisPrograma =
			 "Vrlo jednostavan editor koji prikazuje osnovne moguænosti\n" +
	         "za rad sa menijima u Javi. U programskoj traci za menije\n " +
			 "se nalaze dva menija \"Datoteka\" i \"Pomoæ\" koji sadrže\n" 
			 + "dodatne opcije za rad sa tekstualnim datotekama.\n" +
			 "                                     Verzija: 0.1alfa";
	 
	 private JTextArea poljeTeksta;
	 private File datoteka;
	 
	 public OkvirEditora () {
		 super ( "Jednostavan editor: nesaèuvan tekst");
		 
		 try {
			 UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
			 
		 } 
		 catch (Exception ex) {}
		 
		 setJMenuBar(napraviMeni());
		 poljeTeksta = new JTextArea(25,50);
		 poljeTeksta.setMargin(new Insets(3,5, 0, 0));
		 JScrollPane pomeraèTeksta = new JScrollPane(poljeTeksta);
		 setContentPane(pomeraèTeksta);
	 }
	 private JMenuBar napraviMeni () {
		 
		 ActionListener rukovalac = new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent dogaðaj) {
				// TODO Auto-generated method stub
				
				String opcija = dogaðaj.getActionCommand();
				
				if (opcija.equals("Nova"))
					poèni();
				else if (opcija.equals("Otvori..."))
					otvori();
				else if (opcija.equals("Saèuvaj..."))
					saèuvaj();
				else if (opcija.equals("Kraj"))
					završi();
				else if (opcija.equals("Opis"))
					opiši();
			  }	
			};
	
	JMenu meniDatoteka = new JMenu("Datoteka");
	meniDatoteka.setMnemonic('D');
	
	JMenuItem opcijaNova = new JMenuItem("Nova");
	opcijaNova.setMnemonic('N');
	opcijaNova.setAccelerator(KeyStroke.getKeyStroke(
			KeyEvent.VK_N, ActionEvent.CTRL_MASK));
	opcijaNova.addActionListener(rukovalac);
	meniDatoteka.add(opcijaNova);
	
	
	JMenuItem opcijaOtvori = new JMenuItem("Otvori...");
	opcijaOtvori.setMnemonic('O');
	opcijaOtvori.setAccelerator(KeyStroke.getKeyStroke(
			KeyEvent.VK_0, ActionEvent.CTRL_MASK));
	opcijaOtvori.addActionListener(rukovalac);
	meniDatoteka.add(opcijaOtvori);
	
	
	JMenuItem opcijaSaèuvaj = new JMenuItem("Saèuvaj...");
	opcijaSaèuvaj.setMnemonic('S');
	opcijaSaèuvaj.setAccelerator(KeyStroke.getKeyStroke(
			KeyEvent.VK_S, ActionEvent.CTRL_MASK));
	opcijaSaèuvaj.addActionListener(rukovalac);
	meniDatoteka.add(opcijaSaèuvaj);
	
	meniDatoteka.addSeparator();
	
	JMenuItem opcijaZavrši = new JMenuItem("Kraj");
	opcijaZavrši.setMnemonic('Z');
	opcijaZavrši.setAccelerator(KeyStroke.getKeyStroke(
			KeyEvent.VK_K, ActionEvent.CTRL_MASK));
	opcijaZavrši.addActionListener(rukovalac);
	meniDatoteka.add(opcijaZavrši);
	
	JMenu meniPomoæ = new JMenu("Pomoæ");
	meniPomoæ.setMnemonic('P');
	
	JMenuItem opcijaOpis = new JMenuItem("Opis");
	opcijaOpis.setMnemonic('O');
	opcijaOpis.setAccelerator(KeyStroke.getKeyStroke(
			KeyEvent.VK_P, ActionEvent.CTRL_MASK));
	opcijaOpis.addActionListener(rukovalac);
	meniPomoæ.add(opcijaOpis);
	
	JMenuBar trakaZaMeni = new JMenuBar();
	trakaZaMeni.add(meniDatoteka);
	trakaZaMeni.add(meniPomoæ);
	return trakaZaMeni;
			
	 }
			 		 
	private void poèni() {
		
		poljeTeksta.setText("");
		datoteka = null;
		setTitle("Jednostavan editor: nesaèuvan tekst");
		
	}				 
			 
	 private void saèuvaj () {
		 JFileChooser izbor = new JFileChooser();
		 File izabranaDatoteka;
		 if (datoteka == null)
			 izabranaDatoteka = new File (" ImeDatoteke.txt");
		 else
			 izabranaDatoteka = new File(datoteka.getName());
		 izbor.setSelectedFile(izabranaDatoteka);
		 izbor.setDialogTitle("Izaberite datoteku radi èuvanja teksta");
		 int opcijaIzbora = izbor.showSaveDialog(this);
		 if ( opcijaIzbora != JFileChooser.APPROVE_OPTION)
			 return;
		 izabranaDatoteka = izbor.getSelectedFile();
		 if ( izabranaDatoteka.exists()) {
			 int odgovor = JOptionPane.showConfirmDialog(this,
					 "Datoteka \"" + izabranaDatoteka.getName()
					  + "\"veæ postoji.\nDa li želite da je zamenite?",
					  "Potvrdite zamenu datoteke", 
					  JOptionPane.YES_NO_OPTION, 
					  JOptionPane.WARNING_MESSAGE);
			 if (odgovor != JOptionPane.YES_OPTION)
				 return;	 
		 }
		 
		 PrintWriter pisaè;
		 
		 try {
			 pisaè = new PrintWriter(new FileWriter(izabranaDatoteka));
			 pisaè.print(poljeTeksta.getText());
			 
			 pisaè.close();
			 
		 }
		 catch (Exception ex) {
			 JOptionPane.showConfirmDialog(this, 
					 "Greška prilikom otvaranja ili pisanja datoteke: \n" + ex);
			 return;	 
		 }
		 datoteka = izabranaDatoteka;
		 setTitle("Jednostavan editor: " + datoteka.getName());
	 }
	 
	 public void otvori () {
		 JFileChooser izbor = new JFileChooser();
		 izbor.setDialogTitle("Izaberite datoteku radi otvaranja");
		 izbor.setSelectedFile(null);
		 int opijaIzbora = izbor.showOpenDialog(this);
		 if (opijaIzbora != JFileChooser.APPROVE_OPTION)
			 return;
		 File izabranaDatoteka = izbor.getSelectedFile();
		 BufferedReader èitaè;
		 String tekst = "";
		 try {
			 èitaè = new BufferedReader(new FileReader(izabranaDatoteka));
			 while (èitaè.ready())
				 tekst += èitaè.readLine() + "\n";
			 èitaè.close();
			 
		 }
		 catch (Exception ex) {
			 JOptionPane.showMessageDialog(this, 
					 "Greška prilikom otvaranja ili èitanja datoteke:\n" + ex);
			 return;
		 }
		 
		 poljeTeksta.setText(tekst);
		 poljeTeksta.setCaretPosition(0);
		 datoteka = izabranaDatoteka;
		 setTitle("Jednostavan editor: " + datoteka.getName());
		  
	 }
	 
	 private void završi() {
		 System.exit(0);
	 }
	 
	 public void opiši () {
		 JOptionPane.showMessageDialog(this, opisPrograma,
				 "Opis programa", 
				 JOptionPane.INFORMATION_MESSAGE);
	 }
	  
 }