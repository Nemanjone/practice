import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;

public class FlowLayout {

		public static void main(String [] args) {
			
			JFrame okvir = new JFrame("Test Flowlayout");
			okvir.setSize(300, 200);
			okvir.setLocation(100, 150);
			
			JButton crevenoDugme = new JButton("Crveno");
			JButton zelenoDugme = new JButton("Zeleno");
			JButton plavoDugme = new JButton("Plavo");
			JButton narand�astoDugme = new JButton("Narand�asto");
			JButton beloDugme = new JButton("Belo");
			JButton crnoDugme = new JButton("Crno");
			
			JPanel panel = new JPanel();
			
			panel.add(crevenoDugme);
			panel.add(zelenoDugme);
			panel.add(plavoDugme);
			panel.add(narand�astoDugme);
			panel.add(beloDugme);
			panel.add(crnoDugme);
			
			okvir.add(panel);
			okvir.setVisible(true);
			
}}
