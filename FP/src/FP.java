import java.util.Scanner;

public class FP {

	public static void main(String[] args) {

		Scanner s = new Scanner(System.in);

		System.out.println("Unesite ime datoteke sa konfiguracionim paramtrima: ");
		String imeDatoteke = s.nextLine();

		ConfigReaderFactory crf = new ConfigReaderFactory(imeDatoteke);

		try {
			ConfigReader cr = crf.getConfigReader();
			String adminUserName = cr.readProperty("ADMIN_USERNAME");
			System.out.println("Trazena konfiguracija je: " + adminUserName);
		} catch (Exception e) {
			System.err.println("Greska: " + e.getMessage() );

		}
			s.close();
	}

}
