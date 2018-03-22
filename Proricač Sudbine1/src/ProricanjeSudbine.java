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
		okvir.add(new ProricaèSudbine1());
		okvir.pack();
		okvir.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		okvir.setVisible(true);
	}
		
		
 public static class ProricaèSudbine1 extends JPanel implements ActionListener {
	
	private String [] sudbine = {
			
			"Uplatite Loto i sedmica je Vaša!",
			"Uskoro æete upoznati zgodnu osobu.",
			"Problemi na poslu ili u školi.",
			"Dobiæete desetku na sledeæem ispitu.",
			"Uskoro æete otputovati u sreænije krajeve.",
			"Auto æe Vam se pokvariti.",
			"Za roðendan æete dobiti poklon od voljene osobe.",
			"Neko Vam radi iza leða.",
			"Èuvajte se neiskrenih prijatelja.",
			"Poklonite pažnju voljenoj osobi.",
			"Uskoro Vas oèekuje povišica.",
			"Posetite zubara da ne biste zažalili.",
			"Ostavite alkohol i pušenje.",
			"Manje jedite masnu hranu.",
			"Kupite sebi nešto da popravite raspoloženje."
			
	};
	
	private JButton dugmeSledeæa;
	private JLabel oznakaSudbine;
	private JTextField poljeSudbine;
	
	public ProricaèSudbine1 () {
		
	
		
		setLayout(new BorderLayout());
		
		dugmeSledeæa = new JButton("Sledeæa");
		oznakaSudbine = new JLabel("Vaša sudbina: ");
		poljeSudbine = new JTextField(sluèajnaSudbina(),25);
		poljeSudbine.setEditable(false);
		
		
		JPanel panelSudbine = new JPanel();
		panelSudbine.add(oznakaSudbine);
		panelSudbine.add(poljeSudbine);
		
		JPanel panelDugmeta = new JPanel();
		dugmeSledeæa.addActionListener(this);
		panelDugmeta.add(dugmeSledeæa);
		
		add(panelSudbine, BorderLayout.NORTH);
		add(panelDugmeta, BorderLayout.SOUTH);
	
	}
	
	public String sluèajnaSudbina() {
		int i = (int)(Math.random()*sudbine.length);
		return sudbine[i];
	}
	
	public void actionPerformed(ActionEvent d) {
		
		poljeSudbine.setText(sluèajnaSudbina());
		
	}

}
}
