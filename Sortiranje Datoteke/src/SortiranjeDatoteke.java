import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Arrays;
import java.util.Scanner;


public class SortiranjeDatoteke {

	public static void main (String [] args) {
		
		Scanner ulaz;
		PrintWriter izlaz;
		double [] brojevi = new double [10];
		int k = 0;
		
		try {
			ulaz = new Scanner(new FileReader("podaci.txt"));
		}
		
		catch (FileNotFoundException e) {
			System.out.print("Ulazna datoteka podaci.txt ");
			System.out.println("nije naðena!");
			return;	
		}
		
		try {
			izlaz = new PrintWriter(new File("sort-podaci.txt"));
		}
		catch(IOException e) {
			System.out.print("Otvaranje izlazne datoteke ");
			System.out.println("sort.podaci.txt nije uspelo!");
			System.out.println("Greška" + e);
			ulaz.close();
			return;	
		}
		
		try {
			
			while (ulaz.hasNext()) {
				brojevi[k] = ulaz.nextDouble();
				k = k + 1;	
			}
			
			Arrays.sort(brojevi, 0,k);
			
			for (int i = 0; i < k; i++)
				izlaz.println(brojevi[i]);
			
			System.out.println("Datoteka je sortirana.");
		}
		
		catch (RuntimeException e) {
			
			System.out.println("Problem u radu sa nizom!");
			System.out.println("Greška: " + e.getMessage());
		}
		
		catch (Exception e)	{
			System.out.println("Problem pri èitanju/pisanju datoteka!");
			System.out.println("Greška: " + e.getMessage());
		}
			finally {
				ulaz.close();
				izlaz.close();
			}
		  }
		}
	

