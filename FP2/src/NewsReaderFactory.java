
final public class NewsReaderFactory {

	public static enum NewsApiType {HTML, JSON, RSS};

	private NewsReaderFactory() {}

	public static NewsReader getNewsReader (String url, NewsApiType newsApiType) {

		if (newsApiType == null) {
			return null;
		}

		switch (newsApiType) {
		case HTML: return new HtmlNewsReader(url);
		case JSON: return new JsonNewsReader(url);
		case RSS: return new RssNewsReader(url);
		}
		return null;
	}

}
