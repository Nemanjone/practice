import java.awt.BorderLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

public class ProricanjeSudbine {
	
	public static void main (String [] args) {
		
		JFrame okvir = new JFrame("Proricanje sudbine");
		okvir.add(new Prorica�Sudbine1());
		okvir.pack();
		okvir.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		okvir.setVisible(true);
	}
		
		
 public static class Prorica�Sudbine1 extends JPanel implements ActionListener {
	
	private String [] sudbine = {
			
			"Uplatite Loto i sedmica je Va�a!",
			"Uskoro �ete upoznati zgodnu osobu.",
			"Problemi na poslu ili u �koli.",
			"Dobi�ete desetku na slede�em ispitu.",
			"Uskoro �ete otputovati u sre�nije krajeve.",
			"Auto �e Vam se pokvariti.",
			"Za ro�endan �ete dobiti poklon od voljene osobe.",
			"Neko Vam radi iza le�a.",
			"�uvajte se neiskrenih prijatelja.",
			"Poklonite pa�nju voljenoj osobi.",
			"Uskoro Vas o�ekuje povi�ica.",
			"Posetite zubara da ne biste za�alili.",
			"Ostavite alkohol i pu�enje.",
			"Manje jedite masnu hranu.",
			"Kupite sebi ne�to da popravite raspolo�enje."
			
	};
	
	private JButton dugmeSlede�a;
	private JLabel oznakaSudbine;
	private JTextField poljeSudbine;
	
	public Prorica�Sudbine1 () {
		
	
		
		setLayout(new BorderLayout());
		
		dugmeSlede�a = new JButton("Slede�a");
		oznakaSudbine = new JLabel("Va�a sudbina: ");
		poljeSudbine = new JTextField(slu�ajnaSudbina(),25);
		poljeSudbine.setEditable(false);
		
		
		JPanel panelSudbine = new JPanel();
		panelSudbine.add(oznakaSudbine);
		panelSudbine.add(poljeSudbine);
		
		JPanel panelDugmeta = new JPanel();
		dugmeSlede�a.addActionListener(this);
		panelDugmeta.add(dugmeSlede�a);
		
		add(panelSudbine, BorderLayout.NORTH);
		add(panelDugmeta, BorderLayout.SOUTH);
	
	}
	
	public String slu�ajnaSudbina() {
		int i = (int)(Math.random()*sudbine.length);
		return sudbine[i];
	}
	
	public void actionPerformed(ActionEvent d) {
		
		poljeSudbine.setText(slu�ajnaSudbina());
		
	}

}
}
