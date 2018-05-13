import java.awt.BasicStroke;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.GridLayout;
import java.awt.RenderingHints;
import java.awt.Stroke;
import java.awt.Toolkit;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.MouseMotionListener;
import javax.swing.BorderFactory;
import javax.swing.JFrame;
import javax.swing.JPanel;

public class StrokeDemo extends JPanel {

	public static void main(String[] args) {

		JFrame okvir = new JFrame("Pritisni i vuci; desni klik za prvougaonike");
		StrokeDemo sadrzaj = new StrokeDemo();
		okvir.setContentPane(sadrzaj);
		okvir.pack();
		Dimension velicinaOkvira = Toolkit.getDefaultToolkit().getScreenSize();
		okvir.setLocationRelativeTo(null);
		okvir.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		okvir.setVisible(true);
	}

	public class Prikazi extends JPanel {
		Stroke stroke;
		boolean antialiased;
		boolean nacrtajLiniju = true;
		int x1, y1, x2, y2;
		public Prikazi(Stroke s, boolean a) {
			stroke = s;
			antialiased = a;
			x1 = y1 = 15;
			x2 = 80;
			y2 = 85;
			setPreferredSize(new Dimension(100, 100));
			setBackground(Color.white);
		}

		public void paintComponent(Graphics g) {
			super.paintComponent(g);
			Graphics2D g2 = (Graphics2D) g;
			g2.setStroke(stroke);
			if (antialiased) {
				g2.setRenderingHint(RenderingHints.KEY_ANTIALIASING,
						RenderingHints.VALUE_ANTIALIAS_ON);
			}
			if (nacrtajLiniju)
				g2.drawLine(x1, y1, x2, y2);
			else {
				int a = Math.min(x1, x2);
				int b = Math.min(y1, y2);
				int w = Math.abs(x1 - x2);
				int h = Math.abs(y1 - y2);
				g2.drawRect(a, b, w, h);
			}
		}
	}

	private class RukovalacMisem implements MouseListener, MouseMotionListener {

		@Override
		public void mouseMoved(MouseEvent e) {}

		@Override
		public void mouseClicked(MouseEvent e) {}

		@Override
		public void mouseEntered(MouseEvent e) {}

		@Override
		public void mouseExited(MouseEvent e) {}

		@Override
		public void mousePressed(MouseEvent e) {}

		@Override
		public void mouseReleased(MouseEvent dogadjaj) {
			for (int i = 0; i < 5; i++) 
				for (int j = 0; j < 3; j++) {
					emiteri[i][j].x1 = dogadjaj.getX();
					emiteri[i][j].x2 = dogadjaj.getX();
					emiteri[i][j].y1 = dogadjaj.getY();
					emiteri[i][j].y1 = dogadjaj.getY();
					emiteri[i][j].nacrtajLiniju = !dogadjaj.isMetaDown();
					emiteri[i][j].repaint();
				}	
		}

		public void mouseDragged(MouseEvent dogadjaj) {
			for (int i = 0; i < 5; i++) 
				for (int j = 0; j < 3; j++) {
					emiteri[i][j].x2 = dogadjaj.getX();
					emiteri[i][j].y2 = dogadjaj.getY();
					emiteri[i][j].repaint();
			} 
		}
	}

		private Prikazi[][] emiteri = new Prikazi[5][3];

		public StrokeDemo() {
			
			setLayout(new GridLayout(3, 5, 3, 3));
			setBorder(BorderFactory.createLineBorder(Color.GRAY));
			setBackground(Color.GRAY);
			
			emiteri[0][0] = new Prikazi(new BasicStroke(1), false);
			emiteri[1][0] = new Prikazi(new BasicStroke(2), false);
			emiteri[2][0] = new Prikazi(new BasicStroke(5), false);
			emiteri[3][0] = new Prikazi(new BasicStroke(10), false);
			emiteri[4][0] = new Prikazi(new BasicStroke(20), false);
			emiteri[0][1] = new Prikazi(new BasicStroke(1, 
					BasicStroke.CAP_ROUND,BasicStroke.JOIN_ROUND), true);
			emiteri[1][1] = new Prikazi(new BasicStroke(2, 
					BasicStroke.CAP_ROUND,BasicStroke.JOIN_ROUND), true);
			emiteri[2][1] = new Prikazi(new BasicStroke(5, 
					BasicStroke.CAP_ROUND,BasicStroke.JOIN_ROUND), true);
			emiteri[3][1] = new Prikazi(new BasicStroke(10, 
					BasicStroke.CAP_ROUND,BasicStroke.JOIN_ROUND), true);
			emiteri[4][1] = new Prikazi(new BasicStroke(20, 
					BasicStroke.CAP_ROUND,BasicStroke.JOIN_ROUND), true);
			emiteri[0][2] = new Prikazi(new BasicStroke(1, BasicStroke.CAP_BUTT,
					BasicStroke.JOIN_BEVEL, 10, new float[] {5, 5}, 0), true);
			emiteri[1][2] = new Prikazi(new BasicStroke(2, BasicStroke.CAP_BUTT,
					BasicStroke.JOIN_BEVEL, 10, new float[] {5, 5}, 0), true);
			emiteri[2][2] = new Prikazi(new BasicStroke(5, BasicStroke.CAP_BUTT,
					BasicStroke.JOIN_BEVEL, 10, new float[] {5, 5}, 0), true);
			emiteri[3][2] = new Prikazi(new BasicStroke(10, BasicStroke.CAP_BUTT,
					BasicStroke.JOIN_BEVEL, 10, new float[] {5, 5}, 0), true);
			emiteri[4][2] = new Prikazi(new BasicStroke(20, BasicStroke.CAP_BUTT,
					BasicStroke.JOIN_BEVEL, 10, new float[] {5, 5}, 0), true);
			
			RukovalacMisem rukovalac = new RukovalacMisem();
			
			
			for (int red = 0; red < 3; red++) 
				for (int kolona = 0; kolona < 5; kolona++) {
					add(emiteri[kolona][red]);
					emiteri[kolona][red].addMouseListener(rukovalac);
					emiteri[kolona][red].addMouseMotionListener(rukovalac);
			}
		}
	}



