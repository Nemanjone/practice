import java.util.Scanner;

public class KućnaZabava {
	
	public static void main(String []args) {
		
		System.out.println("Drugari, žurka počinje!");
		System.out.println();
		
		TV tv = new TV("Samsung", new int [] {50, 100} ,new int [] {0, 99});
		DVDPlayer DVD = new DVDPlayer("Sharp", new int [] {50, 100});
		Scanner tastatura = new Scanner(System.in);
		tv.uključiUređaj();
		tv.pojačajTon();
		tv.smanjiTon();
		tv.promeniKanal(45);
		
		DVD.uključiUređaj();
		DVD.pojačajTon();
		DVD.ubaciDisk("Kolibri");
		DVD.prikažiDisk();
		DVD.smanjiTon();
		
		System.out.println();
		
		Uređaj u;
		for (int i = 0; i < 5; i++) {
			if (Math.random() < 0.5)
				u = new TV(Math.random()<0.5 ? "Sony":"LG", 
						new int[] {50, 100}, new int[] {0, 99});
		
		else
			u=new DVDPlayer (Math.random()<0.5 ? "Sharp":"Panasonic", 
						new int[] {50, 100});
		
		}
		
		tv.isključiUređaj();
		DVD.isključiUređaj();
	}

}
