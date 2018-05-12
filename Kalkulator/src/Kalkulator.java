import java.awt.Color;
import java.awt.GridLayout;
import java.awt.TextField;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.BorderFactory;
import javax.swing.JApplet;
import javax.swing.JButton;
import javax.swing.JFileChooser;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

public class Kalkulator extends JApplet {
	
	public static void main(String[] args) {
		
		JFrame okvir = new JFrame("Kalkulator");
		okvir.add(new PanelKalkulatora());
		okvir.pack();
		okvir.setLocation(100, 100);
		okvir.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		okvir.setVisible(true);	
	}

	public void init() {
		add(new PanelKalkulatora());	
	}
		
	public static class PanelKalkulatora extends JPanel implements ActionListener {
		
		private JTextField xPolje, yPolje;
		private JLabel rezultat;
		
		public PanelKalkulatora() {
			
			setBackground(Color.GRAY);
			setBorder(BorderFactory.createEmptyBorder(5, 5, 5, 5));
			
			xPolje = new JTextField("0", 10);
			xPolje.setBackground(Color.WHITE);
			yPolje = new JTextField("0", 10);
			yPolje.setBackground(Color.WHITE);
			
			JPanel xPanel = new JPanel();
			xPanel.add(new JLabel(" x = "));
			xPanel.add(xPolje);
			
			JPanel yPanel = new JPanel();
			yPanel.add(new JLabel(" y = "));
			yPanel.add(yPolje);
			
			
			
			JPanel dPanel = new JPanel();
			dPanel.setLayout(new GridLayout(1, 4));
			
			JButton sabDugme = new JButton("+");
			sabDugme.addActionListener(this);
			dPanel.add(sabDugme);
			
			JButton oduDugme = new JButton("-");
			oduDugme.addActionListener(this);
			dPanel.add(oduDugme);
			
			JButton mnoDugme = new JButton("*");
			mnoDugme.addActionListener(this);
			dPanel.add(mnoDugme);
			
			JButton deljDugme = new JButton("/");
			deljDugme.addActionListener(this);
			dPanel.add(deljDugme);
			
			
			
			rezultat = new JLabel("x + y = 0", JLabel.CENTER);
			rezultat.setForeground(Color.RED);
			rezultat.setBackground(Color.WHITE);
			rezultat.setOpaque(true);
			
			
			setLayout(new GridLayout(4, 1, 3, 3));
			add(xPanel);
			add(yPanel);
			add(dPanel);
			add(rezultat);
			
			xPolje.requestFocus();
		
		}
		
		public void actionPerformed (ActionEvent dogaðaj) {
			double xBroj, yBroj;
			
			try { 
				String xString = xPolje.getText();
				xBroj = Double.parseDouble(xString);	
			}
			catch(NumberFormatException ex) {
				rezultat.setText("Greška: x nije broj");
				xPolje.requestFocus();
				return;	
			}
			
			try {
				
				String yString = yPolje.getText();
				yBroj = Double.parseDouble(yString);
			}
			catch(NumberFormatException ex) {
				rezultat.setText("Greška: y nije broj");
				yPolje.requestFocus();
				return;
			} 
			
			String op = dogaðaj.getActionCommand();
			if (op.equals("+"))
				rezultat.setText("x + y = " + (xBroj + yBroj));
			else if (op.equals("-"))
				rezultat.setText("x - y = " + (xBroj - yBroj));
			else if (op.equals("*"))
				rezultat.setText("x * y = " + (xBroj*yBroj));
			else if (op.equals("/")){
				if (yBroj == 0)
					rezultat.setText("Greška: deljenje nulom!");
				else
			rezultat.setText("x / y = " + xBroj/yBroj);
			}
		}
	}
}
