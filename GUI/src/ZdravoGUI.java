import javax.swing.JOptionPane;

public class ZdravoGUI {

	public static void main(String [] args) {
		
		String ime = JOptionPane.showInputDialog(null,"Kako se zovete?",
				"Grafi�ki ulaz", JOptionPane.QUESTION_MESSAGE);
		
		String godine = JOptionPane.showInputDialog(null, "Koliko imate godina",
			   "Grafi�ki ulaz", JOptionPane.QUESTION_MESSAGE);
		
		int god = Integer.parseInt(godine);
		
		String poruka = "Zdravo " + ime + "!\n";
		poruka += god + " su najlep�e godine.";
		
		JOptionPane.showMessageDialog(null, poruka,
				"Grafi�ki izlaz", JOptionPane.INFORMATION_MESSAGE);
		System.exit(0);
		
	}
	
}
