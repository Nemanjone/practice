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

public class Štoperica extends JLabel implements MouseListener {

	public static void main(String[] args) {

		JFrame okvir = new JFrame("Štoperica");
		Štoperica sadržaj = new Štoperica();
		okvir.setContentPane(sadržaj);
		okvir.pack();
		okvir.setSize(200, 100);
		Dimension velièinaEkrana = Toolkit.getDefaultToolkit().getScreenSize();
		okvir.setLocationRelativeTo(null);
		okvir.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		okvir.setVisible(true);
	}

	private long poèetnoVreme;
	boolean merimVreme;

	public Štoperica () {
		super(" Klikni da startuješ tajmer. ", JLabel.CENTER);
		addMouseListener(this);
	}

	public boolean daLiMerimVreme() {
		return merimVreme;
	}

	@Override
	public void mousePressed(MouseEvent dogaðaj) {

		if (merimVreme == false) {
			merimVreme = true;
			poèetnoVreme = dogaðaj.getWhen();
			setText("Merim vreme...");
		}
		else {
			merimVreme = false;
			long završnoVreme = dogaðaj.getWhen();
			double sekunde = (završnoVreme - poèetnoVreme) / 1000.0;
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

	private Štoperica tajmer;

	public Component() {

		setLayout(new FlowLayout());
	
		tajmer = new Štoperica();
		tajmer.setBackground(Color.WHITE);
		tajmer.setForeground(Color.BLUE);
		tajmer.setOpaque(true);
		tajmer.setFont(new Font("Serif", Font.PLAIN, 20));
		
		add(tajmer);
	}
}


