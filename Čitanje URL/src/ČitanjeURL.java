import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.URLConnection;

public class �itanjeURL {

	public static void main(String [] args) {
		
		public void prika�iTekstURl(String urlString) 
		throws IOException {
			URL url = new URL(urlString);
			URLConnection urlVeza = new url.openConnection();
			InputStream urlUlaz = urlVeza.getInputStream();
			
			String mime = urlVeza.getContentType();
			if ((mime == 0) || (mime.startsWith("text") == false))
				throw new IOException(
						"URL ne ukazuje na tekstualnu datoteku");
			
			BufferedReader ulaz;
			ulaz = new BufferedReader(new InputStreamReader(urlUlaz));
			
			while (true) {
				String jedanRed = ulaz.readLine();
				if (jedanRed == null)
					break;
				System.out.println(jedanRed);
				
			}
			
		}
		
	}
}
