

public class GlavnaKlasa {

	public static void main(String[] args) {

		String url = "http://api.vesti.com/neka-kategorija-vesti/";

		NewsReader nr = NewsReaderFactory.getNewsReader(url, NewsReaderFactory.NewsApiType.JSON);

		if (nr == null) {
			System.out.println("Nije podrzan tip news reader klase. ");
		}

		for(NewsItem vest:nr.getTop5()) {
			System.out.println(vest);
		}

	}

}
