import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.net.URL;
import java.util.ArrayList;
import javax.swing.AbstractAction;
import javax.swing.Action;
import javax.swing.BorderFactory;
import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JList;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.ListSelectionModel;

public class SmesneIkone extends JPanel {

	public static void main(String[] args) {

		JFrame okvir = new JFrame("Smešne ikone");
		SmesneIkone sadrzaj = new SmesneIkone();
		okvir.setContentPane(sadrzaj);
		okvir.pack();
		okvir.setResizable(false);
		okvir.setSize(1300, 700);
		okvir.setLocationRelativeTo(null);
		okvir.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		okvir.setVisible(true);

	}

	private static class IconInfo {
		int brojIkone;
		int x, y;
	}

	private ArrayList<IconInfo> ikone = new ArrayList<IconInfo>();

	private int brojPrikazanihIkona;
	private int brojPostavljenihIkona;

	private JList<Icon> listaIkona;

	private JButton undoButton;
	private JButton redoButton;

	private DisplejPanelIkona displejPanel;

	private Image[] slikeIkona;

	private class DisplejPanelIkona extends JPanel implements MouseListener {

		public void paintComponent(Graphics g) {
			super.paintComponent(g);
			if (slikeIkona == null) {
				g.drawString("Ne mogu da uèitam ikone", 10, 30);
				return;
			}
			for (int i = 0; i < brojPrikazanihIkona; i++) {
				IconInfo info = ikone.get(i);
				g.drawImage(slikeIkona[info.brojIkone], info.x, info.y, this);		
			}
		}

		public void mousePressed(MouseEvent dogaðaj) {
			IconInfo info = new IconInfo();
			info.brojIkone = listaIkona.getSelectedIndex();
			info.x = dogaðaj.getX() - 105;
			info.y = dogaðaj.getY() - 105;
			if (brojPrikazanihIkona == ikone.size())
				ikone.add(info);
			else
				ikone.set(brojPrikazanihIkona, info);
			brojPrikazanihIkona++;
			brojPostavljenihIkona = brojPrikazanihIkona;
			redoButton.setEnabled(false);
			undoButton.setEnabled(true);
			repaint();
		}

		@Override
		public void mouseClicked(MouseEvent arg0) {}

		@Override
		public void mouseEntered(MouseEvent arg0) {}

		@Override
		public void mouseExited(MouseEvent arg0) {}

		@Override
		public void mouseReleased(MouseEvent arg0) {}

	}

	public SmesneIkone() {

		setLayout(new BorderLayout(2, 2));
		setBackground(Color.GRAY);
		setBorder(BorderFactory.createLineBorder(Color.GRAY, 2));

		displejPanel = new DisplejPanelIkona();
		displejPanel.setPreferredSize(new Dimension(400, 300));
		displejPanel.setBackground(new Color(220, 220, 255));
		displejPanel.addMouseListener(displejPanel);
		add(displejPanel, BorderLayout.CENTER);


		listaIkona = napraviListuIkona();
		if (listaIkona == null)
			return;
		add(new JScrollPane(listaIkona), BorderLayout.EAST);

		Action undoAkcija = new AbstractAction("Undo") {

			@Override
			public void actionPerformed(ActionEvent arg0) {
				if (brojPrikazanihIkona > 0) {
					brojPrikazanihIkona--;
					redoButton.setEnabled(true);
					displejPanel.repaint();
				}	
			}
		};

		Action redoAkcija = new AbstractAction("Redo") {

			@Override
			public void actionPerformed(ActionEvent e) {
				if (brojPrikazanihIkona < brojPostavljenihIkona) {
					brojPrikazanihIkona++;
					if (brojPrikazanihIkona == brojPostavljenihIkona)
						redoButton.setEnabled(false);
					undoButton.setEnabled(true);
					displejPanel.repaint();
				}	
			}
		};

		undoButton = new JButton(undoAkcija);
		redoButton = new JButton(redoAkcija);
		undoButton.setEnabled(false);
		redoButton.setEnabled(false);

		JPanel dugmePanela = new JPanel();
		dugmePanela.add(undoButton);
		dugmePanela.add(redoButton);
		add(dugmePanela, BorderLayout.SOUTH);
	

	}

	private JList<Icon> napraviListuIkona() {
		
		String[] imenaIkona = new String [] {
				"slika1.png", "slika2.png", "slika3.png", "slika4.png", "slika5.png",
				"slika6.png", "slika7.png", "slika8.png", "slika9.png", "slika10.png",
				"slika11.png", "slika12.png", "slika13.png", "slika14.png", "slika15.png",		
		};

		slikeIkona = new Image[imenaIkona.length];

		ClassLoader cl = getClass().getClassLoader();
		Toolkit alat = Toolkit.getDefaultToolkit();
		try {
			for (int i = 0; i < imenaIkona.length; i++) {
				URL slikeURL = cl.getResource(imenaIkona[i]);
				if (slikeURL == null)
					throw new Exception();
				slikeIkona[i] = alat.createImage(slikeURL);
			}
		}
		catch (Exception e) {
			slikeIkona = null;
			return null;
		}

		ImageIcon[] ikone = new ImageIcon[slikeIkona.length];
		for (int i = 0; i < slikeIkona.length; i++) 
			ikone[i] = new ImageIcon(slikeIkona[i]);

		JList<Icon> lista = new JList<Icon>(ikone);

		lista.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
		lista.setSelectedIndex(0);

		return lista;	
	}
}
