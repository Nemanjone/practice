import java.awt.BorderLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;
import java.net.URL;
import javax.swing.JEditorPane;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextField;
import javax.swing.event.HyperlinkEvent;
import javax.swing.event.HyperlinkListener;

public class Veb�ita� extends JFrame {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	private JLabel urlOznaka;
	private JTextField urlPolje;
	private JEditorPane urlStrana;
	
	public Veb�ita�(String naslov) {
	super (naslov);
	urlOznaka = new JLabel("URL: ");
	urlPolje = new JTextField();
	
	urlPolje.addActionListener(new ActionListener() {
		
		@Override
		public void actionPerformed(ActionEvent e) {
			// TODO Auto-generated method stub
			try {
				URL url = new URL(urlPolje.getText().trim());
				urlStrana.setPage(url);
				
			}
			catch (IOException ex) {
				System.out.println(ex);
				
			}
		}
	});
	
	urlStrana = new JEditorPane();
	urlStrana.setEditable(false);
	
	urlStrana.addHyperlinkListener(new HyperlinkListener() {
		
		@Override
		public void hyperlinkUpdate(HyperlinkEvent e) {
			// TODO Auto-generated method stub
			if (e.getEventType() ==
					HyperlinkEvent.EventType.ACTIVATED)
				try {
					urlStrana.setPage(e.getURL());
				}
			catch (IOException ex) {
				System.out.println(ex);
			}
		}
	});
	
	JPanel trakaURL = new JPanel();
	trakaURL.setLayout(new BorderLayout(3,3));
	trakaURL.add(urlOznaka, BorderLayout.WEST);
	trakaURL.add(urlPolje, BorderLayout.CENTER);
	
	JPanel sadr�aj = new JPanel();
	sadr�aj.setLayout(new BorderLayout(3,3));
	sadr�aj.add(trakaURL, BorderLayout.NORTH);
	sadr�aj.add(new JScrollPane(urlStrana), BorderLayout.CENTER);
	
	setContentPane(sadr�aj);
	setBounds(50, 100, 800, 600);
	setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	
	}
	
	public static void main (String[] args) {
		
		Veb�ita� jv� = new Veb�ita�("Jednostavni veb �ita�");
		jv�.setVisible(true);
	}
}
