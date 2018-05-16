import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.InputStream;
import java.net.URL;
import java.net.URLConnection;
import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JEditorPane;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextField;
import javax.swing.JToolBar;
import javax.swing.event.HyperlinkEvent;
import javax.swing.event.HyperlinkListener;

public class WebCitacNit extends JPanel {

	public static void main(String[] args) {


		JFrame okvir = new JFrame("Nemanja pretra�iva�");
		WebCitacNit sadr�aj = new WebCitacNit();
		okvir.setContentPane(sadr�aj);
		okvir.setLocationRelativeTo(null);
		okvir.setSize(600, 500);
		Dimension veli�inaOkvira = Toolkit.getDefaultToolkit().getScreenSize();
		okvir.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		okvir.setVisible(true);

	}

	private JEditorPane editor;
	private JTextField unosAdrese;
	private JButton goDugme;

	private class LinkListener implements HyperlinkListener {

		@Override
		public void hyperlinkUpdate(HyperlinkEvent doga�aj) {
			if (doga�aj.getEventType() == HyperlinkEvent.EventType.ACTIVATED) {
				new NitKojaU�itava(doga�aj.getURL());
			}	
		}
	}

	private class GoListener implements ActionListener {

		@Override
		public void actionPerformed(ActionEvent e) {
			URL url;
			try {
				String lokacija = unosAdrese.getText().trim();
				if (lokacija.length() == 0)
					throw new Exception();
				if (! lokacija.contains("://"))
					lokacija = "http://" + lokacija;
				url = new URL(lokacija);	
			}
			catch (Exception e1) {
				JOptionPane.showMessageDialog(WebCitacNit.this, "Niste uneli ispravan URL");
				return;
			}
			new NitKojaU�itava(url);	
		}
	}

	private class NitKojaU�itava extends Thread {

		private URL urlKojaSeU�itava;

		public NitKojaU�itava(URL url) {
			urlKojaSeU�itava = url;
			unosAdrese.setEnabled(false);
			goDugme.setEnabled(false);
			start();
		}
		public void run() {
			InputStream unos = null;
			try {
				editor.setContentType("text/plain");
				editor.setText("U�itavam URL" + urlKojaSeU�itava + "...");
				URLConnection konekcija = urlKojaSeU�itava.openConnection();
				unos = konekcija.getInputStream();
				String tipSadr�ine = konekcija.getContentType();
				if (tipSadr�ine == null)
					throw new Exception();
				if (! (tipSadr�ine.startsWith("text/plain") ||
						tipSadr�ine.startsWith("text/html")||
						tipSadr�ine.startsWith("text/rtf")))
					throw new Exception();
				editor.setText("U�itavam sadr�inu dokumenta...");
				unosAdrese.setText(urlKojaSeU�itava.toString());
				unos.close();
				unos = null;
				editor.setPage(urlKojaSeU�itava);

			}
			catch (Exception e) {
				editor.setContentType("text/plain");
				editor.setText("Izvinite, tra�eni dokument nije na�en " +
						" ili ne mo�e da se u�ita.\n\nGre�ka: " + e);
			}
			finally {
				goDugme.setEnabled(true);
				unosAdrese.setEnabled(true);
				unosAdrese.selectAll();
				unosAdrese.requestFocus();
				if (unos != null) {
					try {
						unos.close();
					}
					catch (Exception e) {

					}	
				}
			}
		}
	}

	public WebCitacNit () {

		setBackground(Color.BLACK);
		setLayout(new BorderLayout(1,1));
		setBorder(BorderFactory.createLineBorder(Color.BLACK, 1));

		editor = new JEditorPane();
		editor.setEditable(false);
		editor.addHyperlinkListener(new LinkListener());
		add(new JScrollPane(editor), BorderLayout.CENTER);

		JToolBar toolbar = new JToolBar();
		toolbar.setFloatable(false);
		add(toolbar, BorderLayout.NORTH);

		ActionListener goListener = new GoListener();

		unosAdrese = new JTextField("B92.net", 40);
		unosAdrese.addActionListener(goListener);

		goDugme = new JButton(" Go ");
		goDugme.addActionListener(goListener);

		toolbar.add(new JLabel("Adresa: "));
		toolbar.add(unosAdrese);
		toolbar.addSeparator(new Dimension(5, 0));
		toolbar.add(goDugme);

	}
}
