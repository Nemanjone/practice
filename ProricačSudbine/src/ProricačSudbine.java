import java.awt.Color;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.BorderFactory;
import javax.swing.JApplet;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class ProricaèSudbine extends JApplet {

	public static void main(String [] args) {
		
		JFrame okvir = new JFrame("ProricaèSudbine");
		okvir.setLocation(100, 100);
		okvir.setSize(350, 150);
		okvir.add(new PanelProricaèSudbine());
		okvir.pack();
		okvir.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		okvir.setVisible(true);
		
	}
	
	public void init() {
		add( new PanelProricaèSudbine());
	}
	


 public static class PanelProricaèSudbine extends JPanel implements ActionListener {
	
	private JLabel poruka;
	private JLabel rezultat;
	
	public PanelProricaèSudbine () {
		
		setBackground(Color.DARK_GRAY);
		setBorder(BorderFactory.createEmptyBorder(5, 5, 5, 5));
		
		JPanel osnovniPanel = new JPanel();
		osnovniPanel.setLayout(new GridLayout(1, 10));
		
		JButton qpanel = new JButton("1");
	    qpanel.addActionListener(this);
	    qpanel.setFont(new Font("Monospaced", Font.BOLD,20));
	    osnovniPanel.add(qpanel);
		
	    JButton wpanel = new JButton("2");
	    wpanel.addActionListener(this);
	    wpanel.setFont(new Font("Monospaced", Font.BOLD,20));
	    osnovniPanel.add(wpanel);
	    
	    JButton epanel = new JButton("3");
	    epanel.addActionListener(this);
	    epanel.setFont(new Font("Monospaced", Font.BOLD,20));
	    osnovniPanel.add(epanel);
	    
	    JButton rpanel = new JButton("4");
	    rpanel.addActionListener(this);
	    rpanel.setFont(new Font("Monospaced", Font.BOLD,20));
	    osnovniPanel.add(rpanel);
	    
	    JButton tpanel = new JButton("5");
	    tpanel.addActionListener(this);
	    tpanel.setFont(new Font("Monospaced", Font.BOLD,20));
	    osnovniPanel.add(tpanel);
	    
	    JButton zpanel = new JButton("6");
	    zpanel.addActionListener(this);
	    zpanel.setFont(new Font("Monospaced", Font.BOLD,20));
	    osnovniPanel.add(zpanel);
	    
	    JButton upanel = new JButton("7");
	    upanel.addActionListener(this);
	    upanel.setFont(new Font("Monospaced", Font.BOLD,20));
	    osnovniPanel.add(upanel);
	    
	    JButton ipanel = new JButton("8");
	    ipanel.addActionListener(this);
	    ipanel.setFont(new Font("Monospaced", Font.BOLD,20));
	    osnovniPanel.add(ipanel);
	    
	    JButton opanel = new JButton("9");
	    opanel.addActionListener(this);
	    opanel.setFont(new Font("Monospaced", Font.BOLD,20));
	    osnovniPanel.add(opanel);
	    
	    JButton ppanel = new JButton("10");
	    ppanel.addActionListener(this);
	    ppanel.setFont(new Font("Monospaced", Font.BOLD,20));
	    osnovniPanel.add(ppanel);
	    
	    
	    rezultat = new JLabel("", JLabel.CENTER);
	    rezultat.setForeground(Color.BLACK);
	    rezultat.setBackground(Color.PINK);
	    rezultat.setOpaque(true);
	    rezultat.setFont(new Font("Serif", Font.BOLD + Font.ITALIC,20));
	    
	    poruka = new JLabel("Izaberite omiljeni broj od 1 do 10, kako biste saznali svoju sudbinu.", JLabel.CENTER);
	    poruka.setForeground(Color.BLACK);
	    poruka.setBackground(Color.YELLOW);
	    poruka.setOpaque(true);
	    poruka.setFont(new Font ("SansSerif", Font.PLAIN, 16));
	    
	    
	    setLayout(new GridLayout(3, 1, 3, 3));
	    add(poruka);
	    add(osnovniPanel);
	    add(rezultat);
	    
	    
	}
	
	public void actionPerformed (ActionEvent dogaðaj) {
		
		String izbor = dogaðaj.getActionCommand();
		
		if (izbor.equals("1"))
			rezultat.setText("Vi ste miljenik sudbine, uvek æete biti broj jedan.");
		else if (izbor.equals("2"))
			rezultat.setText("Nemojte da brinete, najteže je iza Vas. Buduænost je svetla:");
		else if (izbor.equals("3"))
			rezultat.setText("U pravu ste i kada svi sumnjaju u Vas. Nemojte da odustajete.");
		else if (izbor.equals("4"))
			rezultat.setText("Nije sve tako crno. Uz pomoæ porodice, daleko æete dogurati.");
		else if (izbor.equals("5"))
			rezultat.setText("Vaš brod plovi nemirnim vodama. Ne brinite, mirna luka nije daleko.");
		else if (izbor.equals("6"))
			rezultat.setText("Crni oblaci pokrivaju Vaš horizont. Dozvolite Suncu novog dana da Vas ogreje.");
		else if (izbor.equals("7"))
			rezultat.setText("Sudbina Vas nije mazila. Naravno, ni nagrada neæe izostati.");
		else if (izbor.equals("8"))
			rezultat.setText("Nije zlato sve što sija. Izaberite prave vrednosti i put æe Vam biti lak.");
		else if (izbor.equals("9"))
			rezultat.setText("Više brinete nego što treba. Fortuna Vam je naklonjena.");
		else
			rezultat.setText("Ako se za nekog može reæi da je roðen pod sreænom zvezdom, onda ste to Vi.");
		
		}
	
	 }
  }
