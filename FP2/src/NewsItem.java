
public class NewsItem {

	final private String title, url, excerpt, content, date;

	public NewsItem(String title, String url, String excerpt, String content, String date) {
		super();
		this.title = title;
		this.url = url;
		this.excerpt = excerpt;
		this.content = content;
		this.date = date;
	}

	public String getTitle() {
		return title;
	}

	public String getUrl() {
		return url;
	}

	public String getExcerpt() {
		return excerpt;
	}

	public String getContent() {
		return content;
	}

	public String getDate() {
		return date;
	}

	@Override
	public String toString() {
		String vest = "";
		vest +="[" +  this.date + "]" + this.title + "\n";
		vest += "<" + this.url + ">" + "\n";
		vest += this.content + "\n";
		for(int i = 0; i < 20; i++) {
			vest += "- ";
		}
		vest += "\n";
		return  vest;
	}

}
