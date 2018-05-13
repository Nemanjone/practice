import java.awt.BasicStroke;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics2D;
import java.awt.Toolkit;
import java.awt.image.BufferedImage;
import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;

public class Dugme extends JPanel {

	public static void main(String[] args) {
		
		JFrame okvir = new JFrame("Dugme");
		Dugme sadržaj = new Dugme();
		okvir.setContentPane(sadržaj);
		okvir.pack();
		Dimension velièinaOkvira = Toolkit.getDefaultToolkit().getScreenSize();
		okvir.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		okvir.setLocationRelativeTo(null);
		okvir.setResizable(false);
		okvir.setVisible(true);
		
	}
	
	public Dugme() {
		
		setPreferredSize(new Dimension(400, 250));
		setBackground(Color.GRAY);
		
		JPanel panel = new JPanel();
		
		BufferedImage slika = new BufferedImage(24, 24, BufferedImage.TYPE_INT_RGB);
		Graphics2D g2 = (Graphics2D)slika.getGraphics();
		g2.setColor(Color.LIGHT_GRAY);
		g2.fillRect(0, 0, 24, 24);
		g2.setStroke(new BasicStroke(3));
		g2.setColor(Color.BLACK);
		g2.drawLine(4, 4, 20, 20);
		g2.drawLine(4, 20, 20, 4);
		g2.dispose();
		
		Icon clearIcon = new ImageIcon(slika);
		JButton clearButton = new JButton("Clear the display", clearIcon);
		
		panel.add(clearButton);
		add(panel);
			
	}
	
}
