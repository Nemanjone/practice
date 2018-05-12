import java.util.ArrayList;
import java.util.List;

public class RssNewsReader extends NewsReader {

	public RssNewsReader(String url) {
		super(url);
	
	}

	@Override
	public List<NewsItem> getTop5() {
		
			List<NewsItem> item = new ArrayList<>();
			
			item.add(new NewsItem("Vest 1 RSS", "http://vest-rss.com/vest1", "", "sadrzaj vesti1" , "2018-04-11 10:10.12"));
			item.add(new NewsItem("Vest 2 RSS", "http://vest-rss.com/vest2", "", "sadrzaj vesti2" , "2018-04-11 10:20.12"));
			item.add(new NewsItem("Vest 3 RSS", "http://vest-rss.com/vest3", "", "sadrzaj vesti3" , "2018-04-11 10:30.12"));
			item.add(new NewsItem("Vest 4 RSS", "http://vest-rss.com/vest4", "", "sadrzaj vesti4" , "2018-04-11 10:40.12"));
			item.add(new NewsItem("Vest 5 RSS", "http://vest-rss.com/vest5", "", "sadrzaj vesti5" , "2018-04-11 10:50.12"));
			
			return item;

	}

}
