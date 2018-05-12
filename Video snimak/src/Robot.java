import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.util.List;

public class Robot {
	
	public static void main (String[] args) {
		
		List<IndustrijskiRobot> lista = IndustrijskiRobot.load("C:\\Users\\Marko\\Desktop\\Preuzimanja\\eclipse-jee-oxygen-2-win32\\eclipse\\eclipse source\\Video snimak\\src\\ulaz.dat");
		
		double suma = 0.0;
		
		for (IndustrijskiRobot ir : lista) {
			suma += ir.getEfikasnost();
		}
		double srvr = suma/ lista.size();
		
		for (int i = 0; i < lista.size(); i ++) {
			if(lista.get(i).getEfikasnost() * 1.25 < srvr || 
					lista.get(i).getEfikasnost() * 0.75 > srvr) {
				lista.remove(i);
				i--;
				
			}	
		}
		
		try {
			PrintWriter pw = new PrintWriter("izlaz.txt");
			
			for(IndustrijskiRobot ir : lista) {
			pw.println(ir);
			}
			
			pw.flush();
			pw.close();
			
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			System.out.println("Greška!");
			e.printStackTrace();
		}
		
		
		
	}

}
