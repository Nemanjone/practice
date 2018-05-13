import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import javax.swing.AbstractAction;
import javax.swing.Action;
import javax.swing.BorderFactory;
import javax.swing.ButtonGroup;
import javax.swing.JCheckBox;
import javax.swing.JCheckBoxMenuItem;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.JRadioButtonMenuItem;
import javax.swing.KeyStroke;

public class IzborDemo extends JPanel {

	public static void main(String[] args) {

		JFrame okvir = new JFrame("Izaberi");
		IzborDemo sadržaj = new IzborDemo();
		okvir.setContentPane(sadržaj);
		okvir.setJMenuBar(sadržaj.menuBar);
		okvir.pack();
		okvir.setResizable(false);
		okvir.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		okvir.setLocationRelativeTo(null);
		okvir.setVisible(true);

	}

	private JLabel poruka;
	private Action akcionaPoruka;
	private JRadioButton crveniRadio, plaviRadio, zeleniRadio, žutiRadio;
	private JComboBox<String> izborPrednjeStrane;
	private Action[] pozadinskeAkcije;
	private String[] imePozadinskihBoja = {"Crna", "Siva", "Svetlosiva", "Bela"};
	private Color[] pozadinskeBoje = {Color.BLACK, Color.GRAY, Color.LIGHT_GRAY, Color.WHITE};

	private JMenuBar menuBar;

	public IzborDemo() {

		poruka = new JLabel("DO VIÐENJA", JLabel.CENTER);
		poruka.setOpaque(true);
		poruka.setBorder(BorderFactory.createEmptyBorder(10, 10, 10, 10));
		poruka.setFont(new Font("Serif", Font.BOLD, 72));
		poruka.setForeground(Color.RED);
		poruka.setBackground(Color.BLACK);

		ActionListener rukovalacPrednjestrane = new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent dogaðaj) {

				switch (dogaðaj.getActionCommand()) {
				case "Crvena":
					poruka.setForeground(Color.RED);
					izborPrednjeStrane.setSelectedIndex(0);
					break;
				case "Plava":
					poruka.setForeground(Color.BLUE);
					izborPrednjeStrane.setSelectedIndex(1);
					break;
				case "Zelena":
					poruka.setForeground(Color.GREEN);
					izborPrednjeStrane.setSelectedIndex(2);
					break;
				case "Žuta":
					poruka.setForeground(Color.YELLOW);
					izborPrednjeStrane.setSelectedIndex(3);
					break;
				}
			}
		};

		ButtonGroup grupaBoja = new ButtonGroup();

		crveniRadio = new JRadioButton("Crvena");
		grupaBoja.add(crveniRadio);
		crveniRadio.addActionListener(rukovalacPrednjestrane);

		plaviRadio = new JRadioButton("Plava");
		grupaBoja.add(plaviRadio);
		plaviRadio.addActionListener(rukovalacPrednjestrane);

		zeleniRadio = new JRadioButton("Zelena");
		grupaBoja.add(zeleniRadio);
		zeleniRadio.addActionListener(rukovalacPrednjestrane);

		žutiRadio = new JRadioButton("Žuta");
		grupaBoja.add(žutiRadio);
		žutiRadio.addActionListener(rukovalacPrednjestrane);

		crveniRadio.setSelected(true);

		izborPrednjeStrane = new JComboBox<String>();
		izborPrednjeStrane.addItem("Crvena");
		izborPrednjeStrane.addItem("Plava");
		izborPrednjeStrane.addItem("Zelena");
		izborPrednjeStrane.addItem("Žuta");

		izborPrednjeStrane.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				switch (izborPrednjeStrane.getSelectedIndex()) {
				case 0:
					poruka.setForeground(Color.RED);
					crveniRadio.setSelected(true);
					break;
				case 1:
					poruka.setForeground(Color.BLUE);
					plaviRadio.setSelected(true);
					break;
				case 2:
					poruka.setForeground(Color.GREEN);
					zeleniRadio.setSelected(true);
					break;
				case 3:
					poruka.setForeground(Color.YELLOW);
					žutiRadio.setSelected(true);
					break;
				}
			}
		});


		akcionaPoruka = new AbstractAction("Koristi\"ZDRAVO\"") {

			@Override
			public void actionPerformed(ActionEvent dogaðaj) {

				boolean koristiZdravo = (boolean) akcionaPoruka.getValue(Action.SELECTED_KEY);
				if (koristiZdravo)
					poruka.setText("ZDRAVO");
				else
					poruka.setText("DO VIÐENJA");
			}
		};
		
		akcionaPoruka.putValue(Action.SELECTED_KEY, false);
		JCheckBox porukaCheckBox = new JCheckBox(akcionaPoruka);

		JRadioButton[] pozadinskiRadioButton = new JRadioButton[pozadinskeBoje.length];
		pozadinskeAkcije = new Action[imePozadinskihBoja.length];
		ButtonGroup pozadinskaGrupa = new ButtonGroup();

		for (int i = 0; i < imePozadinskihBoja.length; i++) {
			final Color boja = pozadinskeBoje[i];
			pozadinskeAkcije[i] = new AbstractAction(imePozadinskihBoja[i]) {

				@Override
				public void actionPerformed(ActionEvent dogaðaj) {
					poruka.setBackground(boja);
				}
			};

			pozadinskeAkcije[i].putValue(Action.SELECTED_KEY, false);

			KeyStroke preèica = KeyStroke.getKeyStroke("ctrl " + imePozadinskihBoja[i].charAt(0));
			pozadinskeAkcije[i].putValue(Action.ACCELERATOR_KEY, preèica);

			pozadinskiRadioButton[i] = new JRadioButton(pozadinskeAkcije[i]);
			pozadinskaGrupa.add(pozadinskiRadioButton[i]);

		}
		
		pozadinskeAkcije[0].putValue(Action.SELECTED_KEY, true);

		JMenu upravljaèkiMeni = new JMenu("Upravljaj");
		upravljaèkiMeni.add(new JCheckBoxMenuItem(akcionaPoruka));

		int preèicaMaska = Toolkit.getDefaultToolkit().getMenuShortcutKeyMask();
		KeyStroke odustaniKeyStroke = KeyStroke.getKeyStroke(KeyEvent.VK_O, preèicaMaska);
		JMenuItem odustani = new JMenuItem("Odustani");
		odustani.addActionListener(new ActionListener() {

			@Override
			
			public void actionPerformed(ActionEvent dogaðaj) {
				System.exit(0);	
			}
		});
		
		upravljaèkiMeni.add(odustani);

		JMenu bojeMeni = new JMenu("Pozadinske boje");
		for (Action akcija : pozadinskeAkcije) 
			bojeMeni.add(new JRadioButtonMenuItem(akcija));
		menuBar = new JMenuBar();
		menuBar.add(upravljaèkiMeni);
		menuBar.add(bojeMeni);

		setBackground(Color.LIGHT_GRAY);
		setBorder(BorderFactory.createEmptyBorder(5, 5, 5, 5));
		JPanel levo = new JPanel();
		JPanel desno = new JPanel();
		JPanel centar = new JPanel();
		JPanel dole = new JPanel();

		setLayout(new BorderLayout());
		add(levo, BorderLayout.WEST);
		add(desno, BorderLayout.EAST);
		add(centar, BorderLayout.CENTER);
		levo.setLayout(new GridLayout(4, 1));
		desno.setLayout(new GridLayout(4, 1));
		centar.setBackground(Color.LIGHT_GRAY);
		centar.setLayout(new BorderLayout(5, 5));
		centar.add(poruka, BorderLayout.CENTER);
		centar.add(dole, BorderLayout.SOUTH);
		dole.setBackground(Color.LIGHT_GRAY);
		dole.setLayout(new GridLayout(1, 2, 5, 5));

		levo.add(crveniRadio);
		levo.add(plaviRadio);
		levo.add(zeleniRadio);
		levo.add(žutiRadio);

		for (JRadioButton dugme : pozadinskiRadioButton) 
			desno.add(dugme);
		dole.add(izborPrednjeStrane);
		dole.add(porukaCheckBox);			
	}
}
