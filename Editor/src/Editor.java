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
			 "Vrlo jednostavan editor koji prikazuje osnovne mogu�nosti\n" +
	         "za rad sa menijima u Javi. U programskoj traci za menije\n " +
			 "se nalaze dva menija \"Datoteka\" i \"Pomo�\" koji sadr�e\n" 
			 + "dodatne opcije za rad sa tekstualnim datotekama.\n" +
			 "                                     Verzija: 0.1alfa";
	 
	 private JTextArea poljeTeksta;
	 private File datoteka;
	 
	 public OkvirEditora () {
		 super ( "Jednostavan editor: nesa�uvan tekst");
		 
		 try {
			 UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
			 
		 } 
		 catch (Exception ex) {}
		 
		 setJMenuBar(napraviMeni());
		 poljeTeksta = new JTextArea(25,50);
		 poljeTeksta.setMargin(new Insets(3,5, 0, 0));
		 JScrollPane pomera�Teksta = new JScrollPane(poljeTeksta);
		 setContentPane(pomera�Teksta);
	 }
	 private JMenuBar napraviMeni () {
		 
		 ActionListener rukovalac = new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent doga�aj) {
				// TODO Auto-generated method stub
				
				String opcija = doga�aj.getActionCommand();
				
				if (opcija.equals("Nova"))
					po�ni();
				else if (opcija.equals("Otvori..."))
					otvori();
				else if (opcija.equals("Sa�uvaj..."))
					sa�uvaj();
				else if (opcija.equals("Kraj"))
					zavr�i();
				else if (opcija.equals("Opis"))
					opi�i();
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
	
	
	JMenuItem opcijaSa�uvaj = new JMenuItem("Sa�uvaj...");
	opcijaSa�uvaj.setMnemonic('S');
	opcijaSa�uvaj.setAccelerator(KeyStroke.getKeyStroke(
			KeyEvent.VK_S, ActionEvent.CTRL_MASK));
	opcijaSa�uvaj.addActionListener(rukovalac);
	meniDatoteka.add(opcijaSa�uvaj);
	
	meniDatoteka.addSeparator();
	
	JMenuItem opcijaZavr�i = new JMenuItem("Kraj");
	opcijaZavr�i.setMnemonic('Z');
	opcijaZavr�i.setAccelerator(KeyStroke.getKeyStroke(
			KeyEvent.VK_K, ActionEvent.CTRL_MASK));
	opcijaZavr�i.addActionListener(rukovalac);
	meniDatoteka.add(opcijaZavr�i);
	
	JMenu meniPomo� = new JMenu("Pomo�");
	meniPomo�.setMnemonic('P');
	
	JMenuItem opcijaOpis = new JMenuItem("Opis");
	opcijaOpis.setMnemonic('O');
	opcijaOpis.setAccelerator(KeyStroke.getKeyStroke(
			KeyEvent.VK_P, ActionEvent.CTRL_MASK));
	opcijaOpis.addActionListener(rukovalac);
	meniPomo�.add(opcijaOpis);
	
	JMenuBar trakaZaMeni = new JMenuBar();
	trakaZaMeni.add(meniDatoteka);
	trakaZaMeni.add(meniPomo�);
	return trakaZaMeni;
			
	 }
			 		 
	private void po�ni() {
		
		poljeTeksta.setText("");
		datoteka = null;
		setTitle("Jednostavan editor: nesa�uvan tekst");
		
	}				 
			 
	 private void sa�uvaj () {
		 JFileChooser izbor = new JFileChooser();
		 File izabranaDatoteka;
		 if (datoteka == null)
			 izabranaDatoteka = new File (" ImeDatoteke.txt");
		 else
			 izabranaDatoteka = new File(datoteka.getName());
		 izbor.setSelectedFile(izabranaDatoteka);
		 izbor.setDialogTitle("Izaberite datoteku radi �uvanja teksta");
		 int opcijaIzbora = izbor.showSaveDialog(this);
		 if ( opcijaIzbora != JFileChooser.APPROVE_OPTION)
			 return;
		 izabranaDatoteka = izbor.getSelectedFile();
		 if ( izabranaDatoteka.exists()) {
			 int odgovor = JOptionPane.showConfirmDialog(this,
					 "Datoteka \"" + izabranaDatoteka.getName()
					  + "\"ve� postoji.\nDa li �elite da je zamenite?",
					  "Potvrdite zamenu datoteke", 
					  JOptionPane.YES_NO_OPTION, 
					  JOptionPane.WARNING_MESSAGE);
			 if (odgovor != JOptionPane.YES_OPTION)
				 return;	 
		 }
		 
		 PrintWriter pisa�;
		 
		 try {
			 pisa� = new PrintWriter(new FileWriter(izabranaDatoteka));
			 pisa�.print(poljeTeksta.getText());
			 
			 pisa�.close();
			 
		 }
		 catch (Exception ex) {
			 JOptionPane.showConfirmDialog(this, 
					 "Gre�ka prilikom otvaranja ili pisanja datoteke: \n" + ex);
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
		 BufferedReader �ita�;
		 String tekst = "";
		 try {
			 �ita� = new BufferedReader(new FileReader(izabranaDatoteka));
			 while (�ita�.ready())
				 tekst += �ita�.readLine() + "\n";
			 �ita�.close();
			 
		 }
		 catch (Exception ex) {
			 JOptionPane.showMessageDialog(this, 
					 "Gre�ka prilikom otvaranja ili �itanja datoteke:\n" + ex);
			 return;
		 }
		 
		 poljeTeksta.setText(tekst);
		 poljeTeksta.setCaretPosition(0);
		 datoteka = izabranaDatoteka;
		 setTitle("Jednostavan editor: " + datoteka.getName());
		  
	 }
	 
	 private void zavr�i() {
		 System.exit(0);
	 }
	 
	 public void opi�i () {
		 JOptionPane.showMessageDialog(this, opisPrograma,
				 "Opis programa", 
				 JOptionPane.INFORMATION_MESSAGE);
	 }
	  
 }