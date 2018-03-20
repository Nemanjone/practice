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
		
		JButton IstoènoDugme = new JButton("Istoèno");
		JButton ZapadnoDugme = new JButton("Zapadno");
		JButton SevernoDugme = new JButton("Severno");
		JButton JužnoDugme = new JButton("Južno");
		JButton CentralnoDugme = new JButton("Centralno");
		
		JPanel panel = new JPanel();
		
		panel.setLayout(new java.awt.BorderLayout(5, 10));
		
		panel.add(IstoènoDugme, java.awt.BorderLayout.EAST);
		panel.add(ZapadnoDugme, java.awt.BorderLayout.WEST);
		panel.add(SevernoDugme, java.awt.BorderLayout.NORTH);
		panel.add(JužnoDugme, java.awt.BorderLayout.SOUTH);
		panel.add(CentralnoDugme, java.awt.BorderLayout.CENTER);
		
		
		okvir.add(panel);
		
		okvir.setVisible(true);
		
		
		
	}
	
}
