import java.io.BufferedReader;
import java.io.FileReader;

public class BrojacRedova {

	public static void main(String[] args) {

		if(args.length == 0) {
			System.out.println("Niste uneli nijedno ime datoteke u komandnom redu!");
			return;
		}

		for (int i = 0; i < args.length; i++) {
			System.out.println(args[i] + ": ");
			brojacRedova(args[i]);
		}

	}

	private static void brojacRedova(String imeDatoteke) {
		try {
			BufferedReader ulaz = new BufferedReader(new FileReader(imeDatoteke));

			int brojacRedova = 0;
			String red = ulaz.readLine();
			while (red != null) {
				brojacRedova++;
				red = ulaz.readLine();
			}
			
			System.out.println(brojacRedova + " redova");
			ulaz.close();
		}
		catch(Exception e) {
			System.out.println("Greska prilikom uèitavanja datoteke!");

		}
	} 
}
