import java.util.HashMap;
import java.util.Map;

    public class Generici {

		public static void sluèaj1() {
		
		
		Map<Point3D<Double>, String> mapa = new HashMap<>();
		mapa.put(new Point3D(1.34, 3.45, -19.2), "Neki tekst A");
		mapa.put(new Point3D(10.9, -5.11, 0.11), "Neki tekst B");
		
		mapa.forEach((point, tekst) -> {
			System.out.println("Na taèki: " + point + " se nalazi tekst: " + tekst);;
		});
	}


    public static void sluèaj2() {
    	
		Map<Point3D<Integer>, NekiTip> mapa = new HashMap<>();
		mapa.put(new Point3D(1, 3, -19), new NekiTip("Neki tekst A", 10.2, 12));
		mapa.put(new Point3D(10, -5, 0), new NekiTip("Neki tekst B", 20.1, -9));
		
		mapa.forEach((point, tekst) -> {
			System.out.println("Na taèki: " + point + " se nalazi tekst: " + tekst);;
		});
    }
    
	    public static void sluèaj3() {
	    	
			Map<Point3D<String>, NekiTip> mapa = new HashMap<>();
			mapa.put(new Point3D("A", "B","C"), new NekiTip("Neki tekst C", 20.2, 11));
			mapa.put(new Point3D("B","B","C"), new NekiTip("Neki tekst D", 30.1, -5));
			
			mapa.forEach((point, tekst) -> {
				System.out.println("Na taèki: " + point + " se nalazi tekst: " + tekst);;
			});
    
    }

	public static void main (String [] args) {
		
		sluèaj1();
		sluèaj2();
		sluèaj3();
	}
 }