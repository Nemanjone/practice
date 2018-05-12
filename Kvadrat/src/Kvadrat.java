import java.awt.Color;
import java.awt.Graphics2D;
import java.awt.event.FocusEvent;
import java.awt.event.FocusListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.event.MouseListener;
import javax.swing.JApplet;
import javax.swing.JFrame;
import javax.swing.JPanel;

public class Kvadrat extends JApplet {

	

	public static void main (String[] args) {
		
		JFrame okvir = new JFrame("Magièni kvadrat");
		okvir.add(new PanelKvadrata());
		okvir.setLocation(100, 100);
		okvir.setSize(300, 300);
		okvir.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		okvir.setVisible(true);	
	}
	
	public void init() {
		add(new PanelKvadrata());	
	}

public static class  PanelKvadrata extends JPanel 
	   implements KeyListener, FocusListener, MouseListener {
		   
		

		private static final int STRANA_KVADRATA = 40;
		   
		   private Color bojaKvadrata;
		   
		   private int xKvadrata, yKvadrata;

		public PanelKvadrata() {
		
			bojaKvadrata = Color.BLUE;
			xKvadrata = 100;
			yKvadrata = 100;
			
			setBackground(Color.WHITE);
			
			addKeyListener(this);
			addFocusListener(this);
			addMouseListener(this);	
		}
		   
		   public void paintComponent(Graphics2D g) {
			   
			   Graphics2D g2 = (Graphics2D) g;
			   
			   super.paintComponent(g2);
			   
			   if (hasFocus())
				   g2.setPaint(Color.CYAN);
			   else 
				   g2.setPaint(Color.LIGHT_GRAY);
			   
			   int širina = getSize().width;
			   int visina = getSize().height;
			   
			   g2.drawRect(0, 0, širina - 1, visina - 1);
			   g2.drawRect(1, 1, širina - 3, visina - 3);
			   g2.drawRect(2, 2, širina - 5, visina - 5);
			   
			   g2.setPaint(bojaKvadrata);
			   g2.fillRect(xKvadrata, yKvadrata, STRANA_KVADRATA, STRANA_KVADRATA);
			   
			   g2.setPaint(Color.RED);
			   if (hasFocus()) {
				   
				   g2.drawString("Tasteri sa strelicama pomeraju kvadrat", 10, 20);
				   g2.drawString("Tasteri S, C, Z, P menjaju boju kvadrata", 10, 40);
				   
			   } else
				   g2.drawString("Kliknite mišem radi aktiviranja prozora", 10, 20);   
		  
		   }
			
			public void focusGained(FocusEvent dogaðaj) {
				repaint();
			}
			
			public void focusLost(FocusEvent dogaðaj) {
				repaint();	
			}
			
			public void keyTyped (KeyEvent dogaðaj) {
			
			char taster = dogaðaj.getKeyChar();
			
			if (taster == 'S' || taster == 's') {
				bojaKvadrata = Color.GRAY;
				repaint();
			}
			
			if (taster == 'C' || taster == 'c') {
				bojaKvadrata = Color.RED;
				repaint();
			}
			if (taster == 'Z' || taster == 'z') {
				bojaKvadrata = Color.GREEN;
				repaint();
			}
			if (taster == 'P' || taster == 'p') {
				bojaKvadrata = Color.BLUE;
				repaint();
			}
			
		}
			
		public void keyPressed(KeyEvent dogaðaj) {
			
			int taster = dogaðaj.getKeyCode();
			
			if (taster == KeyEvent.VK_LEFT) {
				xKvadrata -= 8;
				if (xKvadrata < 3)
					xKvadrata = 3;
				repaint();	
			}
			else if (taster == KeyEvent.VK_RIGHT) {
				xKvadrata += 8;
				if (xKvadrata > getWidth() - 3 - STRANA_KVADRATA)
					xKvadrata = getWidth() -3 - STRANA_KVADRATA;
				repaint();
				
			}
			
			else if (taster == KeyEvent.VK_UP) {
				yKvadrata -=8;
				if (yKvadrata < 3)
					yKvadrata = 3;
				repaint();
			}
			else if (taster == KeyEvent.VK_DOWN) {
				yKvadrata+=8;
				if (yKvadrata> getHeight() - 3- STRANA_KVADRATA)
					yKvadrata = getHeight() -3- STRANA_KVADRATA;
				repaint();
				
			}
		}	
		
		
		   public void mousePressed(java.awt.event.MouseEvent evt) {
			
			requestFocus();
		  }
		   
			
			public void keyReleased(KeyEvent evt) {}
			
			
			public void mouseClicked(java.awt.event.MouseEvent evt) {}

		
			public void mouseEntered(java.awt.event.MouseEvent evt) {}

			
			public void mouseExited(java.awt.event.MouseEvent evt) {}

			
			public void mouseReleased(java.awt.event.MouseEvent evt) {}
		}
	
}
 

