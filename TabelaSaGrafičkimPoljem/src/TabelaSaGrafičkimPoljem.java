import java.awt.BasicStroke;
import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Toolkit;
import java.awt.geom.Line2D;
import javax.swing.BorderFactory;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.event.TableModelEvent;
import javax.swing.event.TableModelListener;
import javax.swing.table.AbstractTableModel;

public class TabelaSaGrafièkimPoljem extends JPanel {

	public static void main(String[] args) {

		JFrame okvir = new JFrame("Tabela sa grafièkim poljem");
		TabelaSaGrafièkimPoljem sadržaj = new TabelaSaGrafièkimPoljem();
		okvir.setContentPane(sadržaj);
		okvir.pack();
		Dimension velièinaOkvira = Toolkit.getDefaultToolkit().getScreenSize();
		okvir.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		okvir.setLocationRelativeTo(null);
		okvir.setVisible(true);

	}

	private class ModelTabeleSaKoordinatama extends AbstractTableModel {

		private Double[] xKoordinate = new Double [25];
		private Double[] yKoordinate = new Double [25];

		public int getColumnCount() {
			return 3;
		}

		public int getRowCount() {
			return xKoordinate.length;
		}

		public Object getValueAt(int red, int kolona) {
			if (kolona == 0)
				return (red + 1);
			else if (kolona == 1)
				return xKoordinate[red];
			else
				return yKoordinate[red];
		}

		public Class<?> getColumnClass(int kolona) {
			if (kolona == 0)
				return Integer.class;
			else 
				return Double.class;
		}

		public String getColumnName(int kolona) {
			if (kolona == 0)
				return "Redni broj";
			else if (kolona == 1)
				return "X";
			else
				return "Y";
		}

		public boolean isCellEditable(int red, int kolona) {
			return kolona > 0;
		}

		public void setValueAt(Object object, int red, int kolona) {
			
			if (kolona == 1)
				xKoordinate[red] = (Double)object;
			if (kolona == 2)
				yKoordinate[red] = (Double)object;
			fireTableCellUpdated(red, kolona);
		}
	}

	private class Display extends JPanel {

		public void paintComponent(Graphics g) {
			super.paintComponent(g);
			Graphics2D g2 = (Graphics2D)g;

			double minimum = -0.5;
			double maksimum = 5;

			int brojaè = model.getRowCount();
			for (int i = 0; i < brojaè; i++) {
				Double x = (Double)model.getValueAt(i, 1);
				Double y = (Double)model.getValueAt(i, 2);

				if (x != null && y != null) {
					if (x < minimum)
						minimum = x - 0.5;
					if (x > maksimum)
						maksimum = x + 0.5;
					if (y < minimum)
						minimum = y - 0.5;
					if (y > maksimum)
						maksimum = y + 0.5;
				}
			}

			g2.translate(getWidth()/2, getHeight()/2);
			g2.scale(getWidth() / (maksimum - minimum), - getHeight() / (maksimum - minimum));
			g2.translate(-(maksimum + minimum)/2, - (maksimum + minimum)/2);

			double širinaPiksela = (maksimum - minimum) / getWidth();
			double visinaPiksela = (maksimum - minimum ) / getHeight();

			g2.setStroke(new BasicStroke(0));

			g2.setColor(Color.BLUE);
			g2.draw(new Line2D.Double(minimum, 0, maksimum, 0));
			g2.draw(new Line2D.Double(0, minimum, 0, maksimum));

			if (maksimum - minimum < 100) {
				int debljina = (int)minimum;
				while (debljina <= maksimum) {
					g2.draw(new Line2D.Double(debljina, 0, debljina, 3*visinaPiksela));
					g2.draw(new Line2D.Double(0, debljina, 3*širinaPiksela, debljina));
					debljina++;
				}
			}

			g2.setColor(Color.RED);
			for (int i = 0; i < brojaè; i++) {
				Double x = (Double)model.getValueAt(i, 1);
				Double y = (Double)model.getValueAt(i, 2);
				if (x != null && y != null) {
					g2.draw(new Line2D.Double(x - 3*širinaPiksela, y, x + 3*visinaPiksela, y));
					g2.draw(new Line2D.Double(x, y - 3*visinaPiksela, x, y + 3*visinaPiksela));
				}
			}
		}
	}

	private JTable tabela;
	private ModelTabeleSaKoordinatama model;
	private Display display;

	public TabelaSaGrafièkimPoljem() {

		setLayout(new BorderLayout());
		setBorder(BorderFactory.createLineBorder(Color.BLACK, 1));

		model = new ModelTabeleSaKoordinatama();
		tabela = new JTable(model);
		tabela.setRowHeight(25);
		tabela.setShowGrid(true);
		tabela.setGridColor(Color.BLACK);
		tabela.setPreferredScrollableViewportSize(new Dimension(250, 300));
		tabela.getColumnModel().getColumn(0).setPreferredWidth(50);
		tabela.getColumnModel().getColumn(1).setPreferredWidth(100);
		tabela.getColumnModel().getColumn(2).setPreferredWidth(100);
		tabela.getTableHeader().setReorderingAllowed(false);

		add(new JScrollPane(tabela), BorderLayout.WEST);

		for (int i = 0; i < 6; i++) {
			model.setValueAt((int) (450*Math.random())/100.0, i, 1);
			model.setValueAt((int) (450*Math.random())/100.0, i,2);	
		}
		

		display = new Display();
		display.setPreferredSize(new Dimension(300, 300));
		display.setBackground(Color.WHITE);
		add(display, BorderLayout.CENTER);

		model.addTableModelListener(new TableModelListener() {

			@Override
			public void tableChanged(TableModelEvent e) {
				display.repaint();	
			}
		});
	}
}
