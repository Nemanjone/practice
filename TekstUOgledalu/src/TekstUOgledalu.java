import java.awt.Color;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.FontMetrics;
import java.awt.Graphics;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.image.BufferedImage;
import java.lang.reflect.GenericArrayType;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;

public class TekstUOgledalu extends JPanel {

	private String tekst;

	private BufferedImage OSC;

	public TekstUOgledalu(String tekst) {
		if (tekst == null)
			tekst = "";
		this.tekst= tekst;
	}

	public void setTekst(String tekst) {
		if (tekst == null) 
			tekst = "";
		if (! tekst.equals(this.tekst)) {
			this.tekst = tekst;
			revalidate();
			repaint();
		}
	}

	public String getTekst() {
		return tekst;
	}

	public void paintComponent(Graphics g) {

		int širina = getWidth();
		int visina = getHeight();
		if (OSC == null || širina != OSC.getWidth() || visina != OSC.getHeight()) {
			OSC = new BufferedImage(širina, visina, BufferedImage.TYPE_INT_RGB);
		}
		Graphics OSG = OSC.getGraphics();
		OSG.setColor(getBackground());
		OSG.fillRect(0, 0, širina, visina);
		OSG.setColor(getForeground());
		OSG.setFont(getFont());
		FontMetrics fm = OSG.getFontMetrics(getFont());
		int x = (širina - fm.stringWidth(tekst))/2;
		int y = (visina + fm.getAscent() - fm.getDescent())/2;
		OSG.drawString(tekst, x, y);
		OSG.dispose();
		g.drawImage(OSC, širina, 0, 0, visina, 0, 0, širina, visina, null);
	}

	public Dimension getPreferredSize() {
		FontMetrics fm = getFontMetrics(getFont());
		return new Dimension(fm.stringWidth(tekst) + 10, fm.getAscent() + fm.getDescent() + 10);
	}	
}

class CustomComponent extends JPanel {

	public static void main(String[] args) {

		JFrame okvir = new JFrame("Custom Component");
		CustomComponent sadržaj = new CustomComponent();
		okvir.setContentPane(sadržaj);
		okvir.setSize(400,150);
		Dimension velicinaOkvira = Toolkit.getDefaultToolkit().getScreenSize();
		okvir.setLocationRelativeTo(null);
		okvir.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		okvir.setVisible(true);
	}

	private TekstUOgledalu pozdrav;
	private JButton promeniTekst;

	public CustomComponent() {

		setLayout(new FlowLayout());

		pozdrav = new TekstUOgledalu("PUSTI ME NAPOLJE!");
		pozdrav.setBackground(Color.BLACK);
		pozdrav.setForeground(Color.RED);
		pozdrav.setFont(new Font("SansSerif", Font.BOLD, 30));
		add(pozdrav);

		promeniTekst = new JButton("Promeni tekst");
		add(promeniTekst);

		promeniTekst.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				if (pozdrav.getTekst().equals("PUSTI ME NAPOLJE!"))
					pozdrav.setTekst("Upomoæ!");
				else 
					pozdrav.setTekst("PUSTI ME NAPOLJE!");
				if (promeniTekst.getText().equals("Vrati se nazad"))
					promeniTekst.setText("Promeni tekst");
				else
					promeniTekst.setText("Vrati se nazad");

			}
		});	
	}
}
