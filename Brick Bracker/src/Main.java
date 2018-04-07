import javax.swing.JFrame;

public class Main {

	public static void main(String[] args) {              //glavni metod
		// TODO Auto-generated method stub
		
		JFrame okvir = new JFrame();					  //konstrukcija okvira i objekta
		GamePlay novaIgra = new GamePlay();
		
		okvir.setBounds(10, 10, 700, 600);
		okvir.setTitle("Loptica razaraè");
		okvir.setResizable(false);
		okvir.setVisible(true);
		okvir.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		okvir.add(novaIgra);

	}

}
