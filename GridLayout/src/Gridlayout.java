import java.awt.GridLayout;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
	
	
public class Gridlayout {

	

	

			public static void main(String [] args) {
				
				JFrame okvir = new JFrame("Test GridLayout");
				okvir.setSize(300, 200);
				okvir.setLocation(100, 150);
				okvir.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
				
				JButton crevenoDugme = new JButton("Crveno");
				JButton zelenoDugme = new JButton("Zeleno");
				JButton plavoDugme = new JButton("Plavo");
				JButton narandžastoDugme = new JButton("Narandžasto");
				JButton beloDugme = new JButton("Belo");
				JButton crnoDugme = new JButton("Crno");
				
				JPanel panel = new JPanel();
				
				panel.setLayout(new GridLayout(3, 2, 5, 10));
				
				panel.add(crevenoDugme);
				panel.add(zelenoDugme);
				panel.add(plavoDugme);
				panel.add(narandžastoDugme);
				panel.add(beloDugme);
				panel.add(crnoDugme);
				
				okvir.add(panel);
				okvir.setVisible(true);
				
	}}
	

