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
		
		JFrame okvir =  new JFrame("Loptice sko�ice");
		okvir.add(new LopticeSko�ice (10, 30));
		okvir.pack();
		okvir.setLocationRelativeTo(null);;
		okvir.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		okvir.setResizable(false);
		okvir.setVisible(true);
		
	}

}

class LopticeSko�ice extends JComponent {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	Loptica [] loptice;
	
	 LopticeSko�ice(int n, int ms) {
		
		setPreferredSize(new Dimension(400, 400));
		
		loptice = new Loptica[n];
		
		for (int i = 0; i < loptice.length; i++) 
			loptice[i] = new Loptica(0,400,0,400);
		
	    addMouseListener(new MouseAdapter() {
	
		public  void mousePressed ( MouseEvent doga�aj) {
			for (Loptica l: loptice)
				l.kreniPrema( doga�aj.getScreenX(), doga�aj.getClientY());
		}
	});
		
		javax.swing.Timer t = new javax.swing.Timer(ms, new ActionListener() {
			
			public void actionPerformed(ActionEvent doga�aj) {
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
	private double pre�nik;
	public Loptica(double xmin, double xmax, double ymin, double ymax) {
		super();
		this.xmin = xmin;
		this.xmax = xmax;
		this.ymin = ymin;
		this.ymax = ymax;
		this.x = (xmin + xmax)/2;
		this.y = (ymin + ymax)/2;
		this.pre�nik = 6;
		this.boja = Color.YELLOW;
		double ugao = 2*Math.PI*Math.random();
		double brzina = 4 + 8*Math.random();
		dx = Math.cos(ugao)*brzina;
		dy = Math.sin(ugao)*brzina;
		
	}
	
	public void nacrtaj (Graphics2D g2d) {
		
		g2d.setPaint(boja);
		Ellipse2D loptica = new Ellipse2D.Double(x - pre�nik, y - pre�nik,
				2*pre�nik, 2*pre�nik);
		g2d.fill(loptica);
	}
	
	public void pomeri() {
		
		if (xmax - xmin < 2*pre�nik || ymax - ymin < 2*pre�nik)
			return;
		
		double novoX = x + dx;
		double novoY = y + dy;
		
		if (novoY < ymin + pre�nik) {
			novoY = 2 * (ymin + pre�nik) - novoY;
			dy =Math.abs(dy);
		}
		else if (novoY > ymax - pre�nik) {
			novoY = 2 * (ymax - pre�nik) - novoY;
			dy = -Math.abs(dy);	
		}
	    if (novoX < xmin + pre�nik) {
			novoX = 2*(xmin + pre�nik) - novoX;
			dx = Math.abs(dx);
		}
	    else if (novoX > xmax - pre�nik) {
	    	novoX = 2*(xmax - pre�nik) - novoX;
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








