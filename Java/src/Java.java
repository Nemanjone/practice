import java.awt.Component;
import java.awt.Dimension;
import java.awt.Image;
import java.awt.Toolkit;
import java.net.URL;
import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;

import org.omg.CosNaming.NamingContextExtPackage.AddressHelper;

public class Java extends JPanel {
	
	public static void main(String[] args) {
		
		JFrame okvir = new JFrame("Java");
		Java sadržaj = new Java("java1.png");
		okvir.setContentPane(sadržaj);
		okvir.pack();
		Dimension velièinaOkvira =Toolkit.getDefaultToolkit().getScreenSize();
		okvir.setLocationRelativeTo(null);
		okvir.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		okvir.setVisible(true);
		
	}
		
	public Java(String imeSlike) {
		
		ClassLoader cl = getClass().getClassLoader();
		URL izvorURL = cl.getResource(imeSlike);
		if (izvorURL != null) { 
			Toolkit alat = Toolkit.getDefaultToolkit();
			Image slika = alat.createImage(izvorURL);
		
			Icon ikona = new ImageIcon(slika);
			
			JButton javaDugme = new JButton("<html> <font size= 24> <u> <font color=blue> Sada</u> je vreme <br> za " +
											"šolju <font color=red>kafe</font>.", ikona);
			
			JPanel panel = new JPanel();
			panel.add(javaDugme);
			
			add(panel);
	}
  }
}
