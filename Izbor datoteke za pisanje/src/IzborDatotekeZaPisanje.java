import java.io.File;
import java.io.FileWriter;
import java.io.PrintWriter;
import javax.swing.JFileChooser;
import javax.swing.JOptionPane;

public class IzborDatotekeZaPisanje {
	
	public static void main( String [] args) {
		
		JFileChooser prozorIzbora = new JFileChooser();
		prozorIzbora.setDialogTitle("Izaberite datoteku za pisanje: ");
		prozorIzbora.setSelectedFile(null);
		int izbor = prozorIzbora.showOpenDialog(null);
		if (izbor != JFileChooser.APPROVE_OPTION)
			return;
		
		File datoteka = prozorIzbora.getSelectedFile();
		
		if (datoteka.exists()) {
			int odgovor = JOptionPane.showConfirmDialog(null,
					"Datoteka \"" + datoteka.getName()
					+ "\" postoji. \nZameniti njen sadržaj?", 
					"Potvrdite zamenu datoteke",
					JOptionPane.YES_NO_OPTION, 
					JOptionPane.WARNING_MESSAGE);
			return;
		}
			
			PrintWriter izlaz = null;
			
			try {
				izlaz = new PrintWriter(new FileWriter(datoteka));
			}
			catch (Exception e) {
				JOptionPane.showMessageDialog(null, 
						"Greška prilikom otvaranja datoteke:\n" + e);
				return;
			}
			finally {
				izlaz.close();
			}
		}
			
	}

