import java.io.File;
import java.io.FileReader;
import java.util.Scanner;
import javax.swing.JFileChooser;
import javax.swing.JOptionPane;

public class IzborDatoteke {
	
	public static void main (String [] args) {
		
		JFileChooser prozorIzbora = new JFileChooser();
		prozorIzbora.setDialogTitle("Izaberite datoteku za èitanje: ");
		prozorIzbora.setSelectedFile(null);
		
		int izbor = prozorIzbora.showOpenDialog(null);
		if (izbor !=JFileChooser.APPROVE_OPTION)
			return;
		
		File datoteka = prozorIzbora.getSelectedFile();
		
		Scanner ulaz = null;
		
		try {
			ulaz = new Scanner(new FileReader(datoteka));
		
		} 
		catch (Exception e) {
			JOptionPane.showMessageDialog(null, 
					"Greška prilikom otvaranja datoteke:\n" + e);
			return;	
		}
		
		finally {ulaz.close();}
	}

}
