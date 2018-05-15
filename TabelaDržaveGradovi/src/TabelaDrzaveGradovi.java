import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.Toolkit;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

public class TabelaDrzaveGradovi extends JPanel {
	
	public static void main(String[] args) {
		
		JFrame okvir = new JFrame("Tabela Demo");
		TabelaDrzaveGradovi sadr�aj = new TabelaDrzaveGradovi();
		okvir.setContentPane(sadr�aj);
		okvir.setSize(new Dimension(350, 300));
		Dimension velicinaOkvira = Toolkit.getDefaultToolkit().getScreenSize();
		okvir.setLocationRelativeTo(null);
		okvir.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		okvir.setVisible(true);
		
	}
	
	public TabelaDrzaveGradovi() {
		
		String [] imenaKolona = new String [] {"Dr�ava", "Glavni grad"};
		DefaultTableModel model = new DefaultTableModel(drzaveIGradovi, imenaKolona) {
			
			public boolean isCellEditable(int red, int kolona) {
				return false;
			}
		};
		
		JTable tabela = new JTable(model);
		
		setLayout(new BorderLayout());
		add(new JScrollPane(tabela), BorderLayout.CENTER);
	}
	
	private static String [][] drzaveIGradovi = new String[][] {
		
		{"Srbija", "Beograd"},
		{"Makedonija", "Skoplje"},
		{"Bugarska", "Sofija"},
		{"Ma�arska", "Budimpe�ta"},
		{"Nema�ka", "Berlin"},
		{"Austrija", "Be�"}, 
		{"Francuska", "Pariz"},
		{"�panija", "Madrid"},
		{"Hrvatska", "Zagreb"},
		{"Slovenija", "LJubljana"},
		{"Albanija", "Tirana"}
		
	};
}
