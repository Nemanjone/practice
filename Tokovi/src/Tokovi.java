import java.text.ParseException;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class Tokovi {

	public static void main(String[] args) {

		final List<Test> testovi = new ArrayList<>();

		popuniListu(testovi);

		System.out.println("--------------");
		final String subjectCode = "IR1PR1";


		/*int brojTestova = 0;
		double suma = 0.0;

		for (Test test : testovi) {
			if (test.getSubject().getCode().equals(subjectCode)) {
				suma += test.getMark();
				brojTestova++;

			}
		}
		double prosek = suma / brojTestova;
		System.out.println("Prosecan broj poena je: " + prosek);*/

		double prosek = prosecanBrojPoenaNaTestovimaIzPredmeta(testovi, subjectCode);    //umesto ovog gore*
		System.out.println("Prosecan broj poena je: " + prosek);

		System.out.println("--------------");

		/*for (Test test:testovi) {
			if (test.getSubject().getCode().equals(subjectCode)) {
				System.out.print(test.getStudent().getIndex() + "\t");
				System.out.print(test.getStudent().getForename() + " "  
				+ test.getStudent().getSurname() + "\t");
				System.out.println(test.getMark());

			}
		}*/

		prikaziRezultateZaPredmet(testovi, subjectCode);                 //umesto ovog gore*

		testovi.stream()
		.collect(Collectors.groupingBy(test ->test.getSubject()))

		.forEach((subject, lista) -> 
		{
			System.out.println("Testovi iz predmeta: " + subject.getName() + " [ " + subject.getCode() +"]");
			lista.stream()
			.sorted(
					(testA,testB) -> 
					testA.getStudent().getIndex().compareTo(testB.getStudent().getIndex())
					).forEach(Tokovi::prikaziTest);

		}

				);

	}

	public static void popuniListu (final List<Test> testovi) {

		try {
			testovi.add(new Test(new Subject("Programiranje1", "IR1PR1"), 
					new Student("Pera", "Peric", "20564168"), "2016-04-10", 23.5));
			testovi.add(new Test(new Subject("Programiranje1", "IR1PR1"), 
					new Student("Ivan", "Ivanovic", "51651613"), "2016-04-10", 28.0));
			testovi.add(new Test(new Subject("Programiranje1", "IR1PR1"), 
					new Student("Goran", "Ilic", "16161616"), "2016-04-10", 18.5));
			testovi.add(new Test(new Subject("Programiranje2", "IR2PR2"), 
					new Student("Pera", "Peric", "20564165"), "2017-04-10", 29.1));
			testovi.add(new Test(new Subject("Programiranje2", "IR2PR2"), 
					new Student("Ivan", "Ivanovic", "51651616"), "2017-04-10", 22.5));
			testovi.add(new Test(new Subject("Baze podataka", "IR2BP"), 
					new Student("Goran", "Ilic", "16161617"), "2017-04-14", 24.0));
			testovi.add(new Test(new Subject("Baze podataka", "IR2BP"), 
					new Student("Pera", "Peric", "20564169"), "2017-04-14", 20.0));
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

	public static double prosecanBrojPoenaNaTestovimaIzPredmeta(final List<Test> testovi, String subjectCode) {

		return	testovi.stream()
				.filter(test -> test.getSubject().getCode().equals(subjectCode))
				.mapToDouble(Test::getMark)
				.average()
				.getAsDouble();

	}

	public static void prikaziTest(Test test) {

		System.out.print(test.getStudent().getIndex() + "\t");
		System.out.print(test.getStudent().getForename() + " "  
				+ test.getStudent().getSurname() + "\t");
		System.out.println(test.getMark());
	}

	public static void prikaziRezultateZaPredmet(final List<Test> testovi, String subjectCode) {

		testovi.stream()
		.filter(test -> test.getSubject().getCode().equals(subjectCode))
		.sorted(
				(testA,testB) -> testA.getStudent().getIndex().compareTo(testB.getStudent().getIndex())
				).forEach(Tokovi::prikaziTest);

	}

}
