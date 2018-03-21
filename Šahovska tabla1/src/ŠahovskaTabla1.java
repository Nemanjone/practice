import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import javax.swing.JComponent;
import javax.swing.JFrame;

public class ŠahovskaTabla1 {
	
	public static void main( String [] args) {
		
		JFrame okvir = new JFrame("Šahovska tabla");
		okvir.setLocation(100, 200);
		okvir.setSize(300, 320);
		okvir.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		okvir.add(new Tabla (240));
		okvir.setVisible(true);
	}
}

class Tabla extends JComponent {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private int širinaPolja;
	private int XO = 20; // x koordinata unutar table
	private int YO = 20; //y koordinata
	
	public Tabla(int širinaTable) {
	širinaPolja = širinaTable/8;
	}
	
	public void paintComponent(Graphics g) {
		
		Graphics2D g2 = (Graphics2D) g;
		
		for (int i = 0; i < 8; i++) {
			int yi = YO + (i * širinaPolja);
			for (int j = 0; j < 8; j++) {
				int xj = XO +(j * širinaPolja);
				if ((i+j)%2 == 0)                                //belo polje
					g2.setPaint(new Color(0.7f, 0.3f, 0.0f));
				else
					g2.setPaint(Color.YELLOW);
				g2.fillRect(xj, yi, širinaPolja, širinaPolja);
			}
			
		}
		
	}
		
}