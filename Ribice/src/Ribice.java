import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.geom.Ellipse2D;
import java.awt.geom.GeneralPath;
import java.awt.geom.Point2D;
import java.awt.geom.Rectangle2D;

import javax.swing.JFrame;
import javax.swing.JPanel;

public class Ribice {

	public static void main(String [] args) {
		
		Akvarijum a = new Akvarijum(400,350);
		slikaAkvarijuma slika = new slikaAkvarijuma(a);
		
		JFrame okvir = new JFrame("Akvarijum");
		okvir.setSize(400, 350);
		okvir.setLocation(100, 100);
		okvir.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		 
		okvir.add(slika);
		okvir.setVisible(true);
	
	}
}

class Riba {
	
	private Color boja;
	private Point2D refTaèka;
	private int dužina;
	private int visina;
	private boolean desniSmer;
	public Riba(Color boja, Point2D refTaèka, int dužina, int visina, boolean desniSmer) {
		super();
		this.boja = boja;
		this.refTaèka = refTaèka;
		this.dužina = dužina;
		this.visina = visina;
		this.desniSmer = desniSmer;
	}
	
	public void nacrtaj (Graphics2D g2d) {
		
		g2d.setPaint(boja);
		
		double refTaèkaX = refTaèka.getX();
		double refTaèkaY = refTaèka.getY();
		double desnaIvicaRibe = refTaèkaX + dužina;
		double donjaIvicaRibe = refTaèkaY + visina;
		double centarRibeY = refTaèkaY + visina/2;
		
		double dužinaTela = 0.8*dužina;
		double levaIvicaTela;
		
		double dužinaOka = 0.1 * dužina;
		double gornjaIvicaOka = centarRibeY - (0.1*dužina) - dužinaOka/2;
		double levaIvicaOka;
		
		double dužinaRepa = 0.25*dužina;
		double visinaRepa = 0.125*dužina;
		double vrhRepa =  centarRibeY - visinaRepa;
		double dnoRepa = centarRibeY + visinaRepa;
		double krajRepa;
		double dodirTelaRepa;
		
		if (desniSmer) { 
			levaIvicaTela = desnaIvicaRibe - dužinaTela;
			levaIvicaOka = desnaIvicaRibe - 0.26*dužina;
			krajRepa = refTaèkaX;
			dodirTelaRepa = krajRepa + dužinaRepa;
		}else {
			levaIvicaTela = refTaèkaX;
		levaIvicaOka = refTaèkaX * (0.26*dužina) - dužinaOka;
		krajRepa = desnaIvicaRibe;
		dodirTelaRepa = krajRepa - dužinaRepa;
		}
		
		Ellipse2D.Double telo = new Ellipse2D.Double(levaIvicaTela, refTaèkaY, dužinaTela, visina);
		g2d.fill(telo);
		
		GeneralPath konturaRepa = new GeneralPath();
		konturaRepa.moveTo(krajRepa, vrhRepa);
		konturaRepa.lineTo(krajRepa, dnoRepa);
		konturaRepa.lineTo(dodirTelaRepa, centarRibeY);
		konturaRepa.closePath();
		g2d.fill(konturaRepa);
		
		g2d.setPaint(Color.DARK_GRAY);
		Ellipse2D.Double oko = new Ellipse2D.Double(levaIvicaOka, gornjaIvicaOka, dužinaOka, dužinaOka);
		g2d.fill(oko);
		
	}
}

class Akvarijum {
	
	private int dužina, visina;
	private Riba[] ribice = new Riba[4];
	
	public Akvarijum(int dužina, int visina) {
		super();
		this.dužina = dužina;
		this.visina = visina;
		
		for (int i = 0; i < ribice.length; i++) {
			
			int d = 40 + i * 15;
			int v = (int)(Math.round(d*0.5));
			
			Color b = Color.WHITE;
			
			switch((int)(4*Math.random())+1) {
			
			case 1:
				b = Color.YELLOW;
				break;
			case 2:
				b = Color.MAGENTA;
				break;
			case 3:
				b = Color.BLUE;
				break;
			case 4: 
				b = Color.RED;
				break;
			}
			
			ribice[i] = new Riba(b, new Point2D.Double(dužina*i/5 + 5, visina*i/4 + 5),
					d, v, Math.random()<0.5 ? true : false);	
		}	
	}
	
	public void nacrtaj (Graphics2D g2d) {
		for (Riba r: ribice)
		r.nacrtaj(g2d);	
	}
	
}

class slikaAkvarijuma extends JPanel {
	
	private Akvarijum a;

	public slikaAkvarijuma(Akvarijum a) {
		super();
		this.a = a;
	}
	
	public void paintComponent(Graphics g) {
		Graphics2D g2d = (Graphics2D) g;
		
		g2d.setPaint(Color.CYAN);
		g2d.fill(new Rectangle2D.Double(0, 0, getWidth(), getHeight()));
		a.nacrtaj(g2d);
	
	}
	
}



