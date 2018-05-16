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


		JFrame okvir = new JFrame("Nemanja pretraživaè");
		WebCitacNit sadržaj = new WebCitacNit();
		okvir.setContentPane(sadržaj);
		okvir.setLocationRelativeTo(null);
		okvir.setSize(600, 500);
		Dimension velièinaOkvira = Toolkit.getDefaultToolkit().getScreenSize();
		okvir.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		okvir.setVisible(true);

	}

	private JEditorPane editor;
	private JTextField unosAdrese;
	private JButton goDugme;

	private class LinkListener implements HyperlinkListener {

		@Override
		public void hyperlinkUpdate(HyperlinkEvent dogaðaj) {
			if (dogaðaj.getEventType() == HyperlinkEvent.EventType.ACTIVATED) {
				new NitKojaUèitava(dogaðaj.getURL());
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
			new NitKojaUèitava(url);	
		}
	}

	private class NitKojaUèitava extends Thread {

		private URL urlKojaSeUèitava;

		public NitKojaUèitava(URL url) {
			urlKojaSeUèitava = url;
			unosAdrese.setEnabled(false);
			goDugme.setEnabled(false);
			start();
		}
		public void run() {
			InputStream unos = null;
			try {
				editor.setContentType("text/plain");
				editor.setText("Uèitavam URL" + urlKojaSeUèitava + "...");
				URLConnection konekcija = urlKojaSeUèitava.openConnection();
				unos = konekcija.getInputStream();
				String tipSadržine = konekcija.getContentType();
				if (tipSadržine == null)
					throw new Exception();
				if (! (tipSadržine.startsWith("text/plain") ||
						tipSadržine.startsWith("text/html")||
						tipSadržine.startsWith("text/rtf")))
					throw new Exception();
				editor.setText("Uèitavam sadržinu dokumenta...");
				unosAdrese.setText(urlKojaSeUèitava.toString());
				unos.close();
				unos = null;
				editor.setPage(urlKojaSeUèitava);

			}
			catch (Exception e) {
				editor.setContentType("text/plain");
				editor.setText("Izvinite, traženi dokument nije naðen " +
						" ili ne može da se uèita.\n\nGreška: " + e);
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
