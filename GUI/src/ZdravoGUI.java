import javax.swing.JOptionPane;

public class ZdravoGUI {

	public static void main(String [] args) {
		
		String ime = JOptionPane.showInputDialog(null,"Kako se zovete?",
				"Grafièki ulaz", JOptionPane.QUESTION_MESSAGE);
		
		String godine = JOptionPane.showInputDialog(null, "Koliko imate godina",
			   "Grafièki ulaz", JOptionPane.QUESTION_MESSAGE);
		
		int god = Integer.parseInt(godine);
		
		String poruka = "Zdravo " + ime + "!\n";
		poruka += god + " su najlepše godine.";
		
		JOptionPane.showMessageDialog(null, poruka,
				"Grafièki izlaz", JOptionPane.INFORMATION_MESSAGE);
		System.exit(0);
		
	}
	
}
