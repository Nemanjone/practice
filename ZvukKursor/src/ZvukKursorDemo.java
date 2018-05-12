import java.applet.AudioClip;
import java.awt.Color;
import java.awt.Cursor;
import java.awt.Dimension;
import java.awt.GridLayout;
import java.awt.Image;
import java.awt.Point;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.net.URL;
import javax.swing.BorderFactory;
import javax.swing.JApplet;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;

public class ZvukKursorDemo extends JPanel {

	public static void main(String[] args) {

		JFrame okvir = new JFrame("Zvuk || Kursor. Demo");
		ZvukKursorDemo sadrzaj = new ZvukKursorDemo();
		okvir.setContentPane(sadrzaj);
		okvir.pack();
		okvir.setResizable(false);
		Dimension velicainaOkvira = Toolkit.getDefaultToolkit().getScreenSize();
		okvir.setLocationRelativeTo(null);
		okvir.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		okvir.setVisible(true);
	}

	public ZvukKursorDemo () {

		setLayout(new GridLayout(4, 4, 3, 3));
		setBackground(Color.GRAY);
		setBorder(BorderFactory.createLineBorder(Color.GRAY));

		JButton dugme;

		RukovalacDugmeta rukovalac = new RukovalacDugmeta();

		dugme = new JButton("Pusti zvuk1");
		dugme.addActionListener(rukovalac);
		add(dugme);

		dugme = new JButton("Koristi unkrsni kursor");
		dugme.addActionListener(rukovalac);
		add(dugme);

		dugme = new JButton("Pusti zvuk2");
		dugme.addActionListener(rukovalac);
		add(dugme);

		dugme = new JButton("Koristi èekajuæi kursor");
		dugme.addActionListener(rukovalac);
		add(dugme);

		dugme = new JButton("Pusti zvuk3");
		dugme.addActionListener(rukovalac);
		add(dugme);

		dugme = new JButton("Koristi pomerajuæi kursor");
		dugme.addActionListener(rukovalac);
		add(dugme);

		dugme = new JButton("Koristi moj kursor");
		dugme.addActionListener(rukovalac);
		add(dugme);
		
		dugme = new JButton("Koristi Sunðer Boba");
		dugme.addActionListener(rukovalac);
		add(dugme);
		
	}

	private class RukovalacDugmeta implements ActionListener {

		@Override
		public void actionPerformed(ActionEvent dogadjaj) {

			String izvor = dogadjaj.getActionCommand();
			if (izvor.equals("Pusti zvuk1"))
				playAudioResource("click2.wav");
			else if (izvor.equals("Pusti zvuk2"))
				playAudioResource("click3.wav");
			else if (izvor.equals("Pusti zvuk3"))
				playAudioResource("clikSound.wav");
			else if (izvor.equals("Koristi èekajuæi kursor"))
				setCursor(Cursor.getPredefinedCursor(Cursor.WAIT_CURSOR));
			else if (izvor.equals("Koristi unkrsni kursor"))
				setCursor(Cursor.getPredefinedCursor(Cursor.CROSSHAIR_CURSOR));
			else if (izvor.equals("Koristi pomerajuæi kursor"))
				setCursor(Cursor.getPredefinedCursor(Cursor.MOVE_CURSOR));
			else if (izvor.equals("Koristi moj kursor"))
				koristiMojKursor("slikaKursor1.png");
			else if (izvor.equals("Koristi Sunðer Boba"))
				koristiMojKursor("slikaKursor3.png");
			if (izvor.startsWith("Pusti"))
				setCursor(Cursor.getDefaultCursor());
		}
	}

	private void playAudioResource(String imeZvuka) {
		ClassLoader cl = getClass().getClassLoader();
		URL izvorURL = cl.getResource(imeZvuka);
		if (izvorURL != null) {
			AudioClip zvuk = JApplet.newAudioClip(izvorURL);
			zvuk.play();
		}
	}

	private void koristiMojKursor(String imeSlike) {
		ClassLoader cl = getClass().getClassLoader();
		URL izvorURL = cl.getResource(imeSlike);
		if (izvorURL != null) {
			Toolkit alat = Toolkit.getDefaultToolkit();
			Image slika = alat.createImage(izvorURL);
			Point hotSpot = new Point(7, 7);
			Cursor kursor = alat.createCustomCursor(slika, hotSpot,"Smeško");
			setCursor(kursor);
		}
	}
}
