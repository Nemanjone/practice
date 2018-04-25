import java.util.ArrayList;
import java.util.List;

public class JsonNewsReader extends NewsReader {

	public JsonNewsReader(String url) {
		super(url);
	}


	public List<NewsItem> getTop5() {
		List<NewsItem> item = new ArrayList<>();
		
		item.add(new NewsItem("Vest 1 JSON", "http://vest-json.com/vest1", "", "sadrzaj vesti1" , "2018-04-11 10:10.12"));
		item.add(new NewsItem("Vest 2 JSON", "http://vest-json.com/vest2", "", "sadrzaj vesti2" , "2018-04-11 10:20.12"));
		item.add(new NewsItem("Vest 3 JSON", "http://vest-json.com/vest3", "", "sadrzaj vesti3" , "2018-04-11 10:30.12"));
		item.add(new NewsItem("Vest 4 JSON", "http://vest-json.com/vest4", "", "sadrzaj vesti4" , "2018-04-11 10:40.12"));
		item.add(new NewsItem("Vest 5 JSON", "http://vest-json.com/vest5", "", "sadrzaj vesti5" , "2018-04-11 10:50.12"));
		
		return item;
	}



}
