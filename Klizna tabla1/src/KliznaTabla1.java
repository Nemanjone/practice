import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.util.Scanner;
import javax.swing.JFrame;
import javax.swing.JPanel;

public class KliznaTabla1 {
	
	public static void main (String [] args) {
	
	KliznaTabla tabla = new KliznaTabla(4);
	IzgledTable panel = new IzgledTable(tabla);
	
	JFrame okvir = new JFrame("Klizna tabla");
	int strana = panel.getStranaPanela();
	okvir.setSize(strana + 8, strana + 25);
	okvir.setResizable(false);
	okvir.add(panel);
	okvir.setLocationRelativeTo(null);
	okvir.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	okvir.setVisible(true);
	
	Scanner tastatura = new Scanner(System.in);
	
	System.out.print("Vaš sledeæi potez (0 za kraj): ");
	int p = tastatura.nextInt();
	
	while (p > 0) {
		if (tabla.pomeri(p)) {
			System.out.println("Dozvoljen potez.");
		}
		else 
			System.out.println("Nedozvoljen potez");
		panel.nacrtajTablu();
		System.out.print("Vaš sledeæi potez (0 za kraj): ");
		p =tastatura.nextInt();
		
	}
	    System.exit(0);
	}
}

class KliznaTabla {
	
	private int n;
	private int[][] t;
	private int iPM;
	private int jPM;
	
	public KliznaTabla (int n) {
		
		this.n = n;
		t = new int [n][n];
		
		int p = n*n -1;
		for(int i = 0; i < n; i++)
			for (int j = 0; j < n; j++) {
				t[i][j] = p;
				p--;
				
			}
		iPM = n - 1;
		jPM = n - 1;
	}
	public int getN() {return n;}
	
	public int [][] getT() {return t;}
	
	public boolean pomeri (int p) {
		
		int i = -1;
		int j = -1;
		
		boolean dozvoljenPotez = false;
		
		if (iPM > 0 && t[iPM - 1][jPM] == p) {
			i = iPM - 1;
			j = jPM;
		dozvoljenPotez = true;	
		}
		if (iPM < n-1 && t[iPM +1][jPM] == p) {
			i = iPM + 1;
			j = jPM;
			 dozvoljenPotez = true;
		}
		if (jPM > 0 && t[iPM][jPM -1] == p) {
			i = iPM;
			j = jPM - 1;
			dozvoljenPotez = true;
			
		}
		if (jPM < n-1 && t[iPM][jPM + 1] == p) {
			i = iPM;
			j = jPM + 1;
			dozvoljenPotez = true;
			
		}
		if (dozvoljenPotez) {
			t[iPM][jPM] = t[i][j];
			t[i][j] = 0;
			iPM = i;
			jPM = j;
 			
		}
		return dozvoljenPotez;
	}

}

class IzgledTable extends JPanel {
	
	private KliznaTabla tabla;
	private int stranaPloèice = 40;
	private int stranaTable;
	private int stranaPanela;
	
	public IzgledTable (KliznaTabla tabla) {
		
		this.tabla = tabla;
		stranaTable = stranaPloèice*tabla.getN();
		stranaPanela = stranaTable + 2*stranaPloèice;
	}

	public int getStranaPanela() {
		return stranaPanela;
	}

	public void nacrtajPloèicu (Graphics2D g2d, int p, int i, int j) {
		
		int x = stranaPloèice + (stranaPloèice*j);
		int y = stranaPloèice * (stranaPloèice*i);
		
		if (p ==0) {
			g2d.setPaint(Color.BLACK);
			g2d.drawRect(x, y, stranaPloèice, stranaPloèice);
			g2d.fillRect(x, y, stranaPloèice, stranaPloèice);

		}
		else {
			
			g2d.setPaint(Color.WHITE);
			g2d.fillRect(x, y, stranaPloèice, stranaPloèice);
			g2d.setPaint(Color.BLACK);
			g2d.drawRect(x, y, stranaPloèice, stranaPloèice);
			g2d.drawString(p + "", x +15, y + 25);
		}
	}
	
	public void paintComponent ( Graphics g) {
		
		Graphics2D g2d = (Graphics2D) g;
		
		g2d.setPaint(Color.YELLOW);
		g2d.fillRect(0, 0, stranaPanela, stranaPanela);
		
		int [][] t = tabla.getT();
		for (int i = 0; i < t.length; i++)
			for ( int j = 0; j < t[i].length; j++)
				nacrtajPloèicu(g2d, t[i][j], i, j);
		
	}
	public void nacrtajTablu () {
		this.repaint();
		
	}
	
}

