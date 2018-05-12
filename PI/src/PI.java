import java.awt.Color;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class PI extends JPanel implements ActionListener {

	/**
	 * 
	 */
	private static final long serialVersionUID = 7258397793733034286L;

	public static void main(String[] args) {

		JFrame okvir = new JFrame("Izracunavanje konstante PI");
		okvir.setLocationRelativeTo(null);
		okvir.setSize(500, 300);
		PI sadrzaj = new PI();
		okvir.setContentPane(sadrzaj);
		okvir.pack();
		okvir.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		okvir.setResizable(false);
		okvir.setVisible(true);

	}

	private JLabel trenutnaProcenaLabel;
	private JLabel brojPokusajaLabel;
	private JButton dugme;
	private NitZaIzracunavanje runner;
	private volatile boolean running;

	public PI () {

		setLayout(new GridLayout(4, 1, 2, 2));
		setBackground(Color.BLUE);
		setBorder(BorderFactory.createLineBorder(Color.BLUE, 2));

		JLabel stvarnaVrednostPI = new JLabel("Stvarna vrednost PI: " + Math.PI);
		stvarnaVrednostPI.setOpaque(true);
		stvarnaVrednostPI.setFont(new Font ("Monospaced", Font.BOLD, 20));

		trenutnaProcenaLabel = new JLabel("Trenutna procena:  (none)");
		trenutnaProcenaLabel.setOpaque(true);
		trenutnaProcenaLabel.setFont(new Font ("Monospaced", Font.BOLD, 20));

		brojPokusajaLabel = new JLabel("Broj pokušaja: ");
		brojPokusajaLabel.setOpaque(true);
		brojPokusajaLabel.setFont(new Font("Monospaced", Font.BOLD, 20));
		
		add(stvarnaVrednostPI);
		add(trenutnaProcenaLabel);
		add(brojPokusajaLabel);

		JPanel dno = new JPanel();
		add(dno);

		dugme = new JButton("Run");
		dno.add(dugme);
		dugme.addActionListener(this);

		runner = new NitZaIzracunavanje();
		runner.start();
	}

	public void actionPerformed(ActionEvent dogadjaj) {

		if(running) {
			dugme.setText("Run");
			running = false;
		}
		else {
			dugme.setText("Pause");
			synchronized (runner) {
				running = true;
				runner.notify();

			}
		}
	}

	private class NitZaIzracunavanje extends Thread {

		final int VELICINA_SERIJE = 1000000;
		long brojPokusaja;
		long brojPokusajaUKrugu;

		public NitZaIzracunavanje() {
			setDaemon(true);
			setPriority(Thread.currentThread().getPriority() - 1);
		}

		public void run() {
			while(true) {
				synchronized(this) {
					while(!running) {
						try {
							wait();
						}
						catch (InterruptedException e) {
						}
					}
				}

				for (int i = 0; i < VELICINA_SERIJE; i++) {
					double x = Math.random();
					double y = Math.random();
					brojPokusaja++;
					if (x * x + y * y < 1)
						brojPokusajaUKrugu++;
				}

				double trenutnaProcena = 4 * ((double)brojPokusajaUKrugu / brojPokusaja);
				brojPokusajaLabel.setText("Broj pokusaja: " + brojPokusaja );
				trenutnaProcenaLabel.setText("Trenutna procena: " + trenutnaProcena);
			}

		}

	}

}










