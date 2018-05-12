
public class BinaryConfigReader extends ConfigReader {

	public BinaryConfigReader(String imeDatoteke) {
		super(imeDatoteke);

	}

	@Override
	public String readProperty(String ime) {

		return "Vrednost " + ime + " podesavanja iz BIN konfiguracionog fajla.";
	}

}
