
public abstract class ConfigReader {

	final private String imeDatoteke;

	public ConfigReader(String imeDatoteke) {
		super();
		this.imeDatoteke = imeDatoteke;
	}

	protected String getImeDatoteke() {
		return imeDatoteke;
	}

	public abstract String readProperty(String ime);

}
