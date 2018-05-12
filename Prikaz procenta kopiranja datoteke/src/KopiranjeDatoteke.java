import java.awt.BorderLayout;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JProgressBar;
import javax.swing.JTextField;
import javax.swing.SwingUtilities;
import javax.swing.border.TitledBorder;

public class KopiranjeDatoteke extends JFrame {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	private JProgressBar traka = new JProgressBar();
	private JButton dugme = new JButton("Kopiraj");
	private JTextField original = new JTextField();
	private JTextField kopija = new JTextField();
	
	public KopiranjeDatoteke() {
		
		JPanel panel1 = new JPanel();
		panel1.setLayout(new BorderLayout());
		panel1.setBorder(new TitledBorder("Originalna datoteka"));
		panel1.add(original, BorderLayout.CENTER);
		
		JPanel panel2 = new JPanel();
		panel2.setLayout(new BorderLayout());
		panel2.setBorder(new TitledBorder("Kopija datoteke"));
		panel2.add(kopija,BorderLayout.CENTER);
		
		JPanel panel3 = new JPanel();
		panel3.setLayout(new GridLayout(2, 1));
		panel3.add(panel1);
		panel3.add(panel2);
		
		JPanel panel4 = new JPanel();
		panel4.add(dugme);
		
		this.add(traka, BorderLayout.NORTH);
		this.add(panel3, BorderLayout.CENTER);
		this.add(panel4, BorderLayout.SOUTH);
		
		traka.setStringPainted(true);
		
		dugme.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) { 
				// TODO Auto-generated method stub
				
				new Thread(new ZadatakKopiranja()).start();
				
			}
		});
	}
	
	 public static void main(String [] args) {
		 
		 SwingUtilities.invokeLater(new Runnable() {
			
			@Override
			public void run() {
				// TODO Auto-generated method stub
				
				JFrame okvir = new KopiranjeDatoteke();
				okvir.setLocationRelativeTo(null);
				okvir.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
				okvir.setTitle("Kopiranje datoteke");
				okvir.setSize(300, 200);
				okvir.setVisible(true);
				
			}
		  });
		 
	 }
	
class ZadatakKopiranja implements Runnable {
	
	private int p;
	
	public void run() {
		BufferedInputStream ulaz = null;
		BufferedOutputStream izlaz = null;
		
		try {
			File imeUlaza = new File (original.getText().trim());
			ulaz = new BufferedInputStream(
					new FileInputStream(imeUlaza));
			
			File imeIzlaza = new File(kopija.getText());
			izlaz = new BufferedOutputStream(
					new FileOutputStream(imeIzlaza));
			
			long n = 0;
			try {
				n = ulaz.available();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
			traka.setValue(0);
			
			long k = 0;
			byte [] bafer = new byte[256];
			
			int b;
			
			try {
				while ((b = ulaz.read(bafer, 0, bafer.length)) != -1) {
					izlaz.write(bafer, 0, b);
					k = k + b;
					p = (int)(k * 100 / n);
					traka.setValue(p);
				}
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
		}
		catch (FileNotFoundException e) {
			e.printStackTrace();
			
		}
		finally {
			try {
				if (ulaz != null)
					ulaz.close();
				if (izlaz != null)
					izlaz.close();
				
			}
			catch (Exception e) {
				
			}	
		}
	 }	
   }
}
