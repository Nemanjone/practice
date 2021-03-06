import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Datoteka3 {
	
    public static List <Planeta> učitajPlanetu (String imeDatoteke) {
	  
    	List<Planeta> lista = new ArrayList<>();
    	
    	try {
			FileInputStream fis = new FileInputStream(imeDatoteke);
			Scanner s = new Scanner(fis);
			s.locale();
			
			while(s.hasNext()) {
				double masa = s.nextDouble();
				double x = s.nextDouble();
				double y = s.nextDouble();
				String ime = s.nextLine().trim();
				
				Planeta p = new Planeta(ime, x, y, masa);
				
				lista.add(p);
				
			}

			s.close();
			fis.close();
			
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
    	
    	 return lista; 
}
    
    public static Planeta učitajGlavnuPlanetu(String imeDatoteke) {
    	
    Planeta p = null;
    	
    	try {
    		
			FileInputStream fis = new FileInputStream(imeDatoteke);
			Scanner s = new Scanner(fis);
			
			
				double masa = s.nextDouble();
				double x = s.nextDouble();
				double y = s.nextDouble();
				String ime = s.nextLine();
				
			    p = new Planeta(ime, x, y, masa);
				
				

			s.close();
			fis.close();
			
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
    	
    	 return p; 
    	
    } 
    
    public static void sačuvajPlanetu(Planeta p, String imeDatoteke) {
    	
    	
    	try {
			PrintWriter pw = new PrintWriter(imeDatoteke);
			pw.println(p);
			pw.flush();
			pw.close();
			
			
			
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
    		
    }
    

    public static void main (String [] args) {
    	
    	List<Planeta> planete = učitajPlanetu("planeta.txt");
    	
    	Planeta glavna = učitajGlavnuPlanetu("glavna.txt");
    	
    	Planeta saNajmanjomSilomPrivlačenja = planete.get(0);
    	
    	for (Planeta p : planete) {
    		if (glavna.getSilaPrivlačenja(p) < glavna.getSilaPrivlačenja(saNajmanjomSilomPrivlačenja)) {
    		
    			saNajmanjomSilomPrivlačenja = p;
    			
    		}
    		
    		
    	}
    	sačuvajPlanetu(saNajmanjomSilomPrivlačenja, "izabrana.txt");
 
    }
    
}
