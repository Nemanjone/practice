
final public class ConfigReaderFactory {

	private String imeDatoteke;

	public ConfigReaderFactory(String imeDatoteke) {
		super();
		this.imeDatoteke = imeDatoteke;
	}

	public ConfigReader getConfigReader() throws Exception {
		                                                         //cnb Binary
	                                                           	 //cnt Text

		if (imeDatoteke.toLowerCase().endsWith("cnb")) {
			return new BinaryConfigReader(imeDatoteke);
		}

		if (imeDatoteke.toLowerCase().endsWith("cnt")) {
			return new TextConfigReader(imeDatoteke);
		}

		throw new Exception("Nije poznata ekstenzija.");


	}

}
