
public class TextConfigReader extends ConfigReader {

	public TextConfigReader(String imeDatoteke) {
		super(imeDatoteke);
	}

	@Override
	public String readProperty(String ime) {

		return "Vrednost " + ime + " podesavanja iz TXT konfiguracionog fajla."; 
	}

}
