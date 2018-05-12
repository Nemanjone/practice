import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;

public class BorderLayout {

	public BorderLayout(int i, int j) {
		// TODO Auto-generated constructor stub
	}

	public static void main(String [] args) {
		
		JFrame okvir = new JFrame("Test BorderLayout");
		okvir.setSize(200,300);
		okvir.setLocation(100, 150);
		okvir.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		JButton Isto�noDugme = new JButton("Isto�no");
		JButton ZapadnoDugme = new JButton("Zapadno");
		JButton SevernoDugme = new JButton("Severno");
		JButton Ju�noDugme = new JButton("Ju�no");
		JButton CentralnoDugme = new JButton("Centralno");
		
		JPanel panel = new JPanel();
		
		panel.setLayout(new java.awt.BorderLayout(5, 10));
		
		panel.add(Isto�noDugme, java.awt.BorderLayout.EAST);
		panel.add(ZapadnoDugme, java.awt.BorderLayout.WEST);
		panel.add(SevernoDugme, java.awt.BorderLayout.NORTH);
		panel.add(Ju�noDugme, java.awt.BorderLayout.SOUTH);
		panel.add(CentralnoDugme, java.awt.BorderLayout.CENTER);
		
		
		okvir.add(panel);
		
		okvir.setVisible(true);
		
		
		
	}
	
}
