import java.awt.Color;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;

public class KliznaTabla2 {

	public static void main (String [] args) {
		
		KliznaTabla  tabla = new KliznaTabla(4);
		IzgledTable panelTable = new IzgledTable(tabla);
		
		JFrame okvir = new JFrame("Klizna tabla");
		okvir.setSize(300, 300);
		okvir.add(panelTable);
		okvir.setLocationRelativeTo(null);
		okvir.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		okvir.setVisible(true);
		
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

class DugmePloèice extends JButton implements ActionListener {
	
	private KliznaTabla tabla;
	private IzgledTable panel;
	
	public DugmePloèice(KliznaTabla tabla, IzgledTable panel) {
		this.tabla = tabla;
		this.panel = panel;
		addActionListener(this);
		
	}
	
    public void actionPerformed (ActionEvent d) {
    	
    	String oznaka = getText();
    	if (!oznaka.equals("")) {
    		int p = Integer.parseInt(oznaka);
    		tabla.pomeri(p);
    		panel.nacrtaj();
    	}
       }
    }

class IzgledTable extends JPanel  {
	
	private KliznaTabla tabla;
	private DugmePloèice[][] tablaDugmadi;
	
	public IzgledTable(KliznaTabla tabla) {
		
		this.tabla = tabla;
		int n = tabla.getN();
		tablaDugmadi = new DugmePloèice[n][n];
		
		setLayout(new GridLayout(n, n));
		
		for ( int i = 0; i < n; i++)
			for (int j = 0; j < n; j++) {
				tablaDugmadi[i][j] = new DugmePloèice(tabla, this);
				add(tablaDugmadi[i][j]);
			}
		nacrtaj();
	}
	
	public void nacrtaj () {
		int n = tabla.getN();
		int [][] t = tabla.getT();
		
		for ( int i = 0; i < n; i++)
			for ( int j = 0; j < n; j++) {
				
				if ( t[i][j] == 0) {
				tablaDugmadi[i][j].setBackground(Color.BLACK);
				tablaDugmadi[i][j].setText("" + t[i][j]);
			}
		else {
			tablaDugmadi[i][j].setBackground(Color.YELLOW);
			tablaDugmadi[i][j].setText("" + t[i][j]);
			}
		
		  }
       }
	 }
