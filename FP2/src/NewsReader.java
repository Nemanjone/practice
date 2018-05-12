import java.util.List;

public abstract class NewsReader {

	final private String url;

	protected String getUrl() {
		return url;
	}

	public NewsReader(String url) {
		super();
		this.url = url;
	}

	abstract public List<NewsItem> getTop5();
	

}
