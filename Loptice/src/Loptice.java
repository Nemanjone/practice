import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.geom.Ellipse2D;
import java.awt.geom.RectangularShape;
import javax.swing.JComponent;
import javax.swing.JFrame;
import org.w3c.dom.events.MouseEvent;

public class Loptice {
	
	public static void main (String [] args) {
		
		JFrame okvir =  new JFrame("Loptice skoèice");
		okvir.add(new LopticeSkoèice (10, 30));
		okvir.pack();
		okvir.setLocationRelativeTo(null);;
		okvir.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		okvir.setResizable(false);
		okvir.setVisible(true);
		
	}

}

class LopticeSkoèice extends JComponent {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	Loptica [] loptice;
	
	 LopticeSkoèice(int n, int ms) {
		
		setPreferredSize(new Dimension(400, 400));
		
		loptice = new Loptica[n];
		
		for (int i = 0; i < loptice.length; i++) 
			loptice[i] = new Loptica(0,400,0,400);
		
	    addMouseListener(new MouseAdapter() {
	
		public  void mousePressed ( MouseEvent dogaðaj) {
			for (Loptica l: loptice)
				l.kreniPrema( dogaðaj.getScreenX(), dogaðaj.getClientY());
		}
	});
		
		javax.swing.Timer t = new javax.swing.Timer(ms, new ActionListener() {
			
			public void actionPerformed(ActionEvent dogaðaj) {
				repaint();
				
			}
		});
		t.start();	
	}
	
	public void paintComponent(Graphics g) {
		
		Graphics2D g2d = (Graphics2D) g;
		
		g2d.setPaint(Color.DARK_GRAY);
		g2d.fillRect(0, 0, getWidth(), getHeight());
		
		for (Loptica l: loptice) {
			l.pomeri();
			l.nacrtaj(g2d);
		}
		
	}
	
} 

class Loptica {
	
	private double x, y;
	private double xmin, xmax;
	
	private double ymin, ymax;
	
	private double dx, dy;
	
	private Color boja;
	private double preènik;
	public Loptica(double xmin, double xmax, double ymin, double ymax) {
		super();
		this.xmin = xmin;
		this.xmax = xmax;
		this.ymin = ymin;
		this.ymax = ymax;
		this.x = (xmin + xmax)/2;
		this.y = (ymin + ymax)/2;
		this.preènik = 6;
		this.boja = Color.YELLOW;
		double ugao = 2*Math.PI*Math.random();
		double brzina = 4 + 8*Math.random();
		dx = Math.cos(ugao)*brzina;
		dy = Math.sin(ugao)*brzina;
		
	}
	
	public void nacrtaj (Graphics2D g2d) {
		
		g2d.setPaint(boja);
		Ellipse2D loptica = new Ellipse2D.Double(x - preènik, y - preènik,
				2*preènik, 2*preènik);
		g2d.fill(loptica);
	}
	
	public void pomeri() {
		
		if (xmax - xmin < 2*preènik || ymax - ymin < 2*preènik)
			return;
		
		double novoX = x + dx;
		double novoY = y + dy;
		
		if (novoY < ymin + preènik) {
			novoY = 2 * (ymin + preènik) - novoY;
			dy =Math.abs(dy);
		}
		else if (novoY > ymax - preènik) {
			novoY = 2 * (ymax - preènik) - novoY;
			dy = -Math.abs(dy);	
		}
	    if (novoX < xmin + preènik) {
			novoX = 2*(xmin + preènik) - novoX;
			dx = Math.abs(dx);
		}
	    else if (novoX > xmax - preènik) {
	    	novoX = 2*(xmax - preènik) - novoX;
	    	dx = - Math.abs(dx);	
	    }
	    x = novoX;
	    y = novoY;
		
	}
	
	public void kreniPrema (int e, int f) {
		double vx = e-x;
		double vy = f-x;
		double d = Math.sqrt(vx*vx + vy*vy);
		
		if (d != 0) {
			double s = Math.sqrt(dx*dx + dy*dy);
			dx = vx/d*s;
			dy = vy/d*s;
			
		}
		
	}
	
}








