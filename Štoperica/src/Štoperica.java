import java.awt.Color;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.Toolkit;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class �toperica extends JLabel implements MouseListener {

	public static void main(String[] args) {

		JFrame okvir = new JFrame("�toperica");
		�toperica sadr�aj = new �toperica();
		okvir.setContentPane(sadr�aj);
		okvir.pack();
		okvir.setSize(200, 100);
		Dimension veli�inaEkrana = Toolkit.getDefaultToolkit().getScreenSize();
		okvir.setLocationRelativeTo(null);
		okvir.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		okvir.setVisible(true);
	}

	private long po�etnoVreme;
	boolean merimVreme;

	public �toperica () {
		super(" Klikni da startuje� tajmer. ", JLabel.CENTER);
		addMouseListener(this);
	}

	public boolean daLiMerimVreme() {
		return merimVreme;
	}

	@Override
	public void mousePressed(MouseEvent doga�aj) {

		if (merimVreme == false) {
			merimVreme = true;
			po�etnoVreme = doga�aj.getWhen();
			setText("Merim vreme...");
		}
		else {
			merimVreme = false;
			long zavr�noVreme = doga�aj.getWhen();
			double sekunde = (zavr�noVreme - po�etnoVreme) / 1000.0;
			setText("Vreme: " + sekunde + "sekundi");
		}	
	}

	@Override
	public void mouseReleased(MouseEvent e) {}

	@Override
	public void mouseClicked(MouseEvent e) {}

	@Override
	public void mouseExited(MouseEvent e) {}

	@Override
	public void mouseEntered(MouseEvent e) {}
 }

class Component extends JPanel {

	private �toperica tajmer;

	public Component() {

		setLayout(new FlowLayout());
	
		tajmer = new �toperica();
		tajmer.setBackground(Color.WHITE);
		tajmer.setForeground(Color.BLUE);
		tajmer.setOpaque(true);
		tajmer.setFont(new Font("Serif", Font.PLAIN, 20));
		
		add(tajmer);
	}
}


