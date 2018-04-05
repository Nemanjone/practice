
public class Nedelja002 {

	public static void main (String[] args) {
		
		prikažiPređeniPut(Brzina.fromMetersPerSeconds(4), Vreme.fromMinutes(4));

	}
	
	public static void prikažiPređeniPut(Brzina brzina, Vreme vreme) {
		Put p = Put.fromMeters(brzina.toMetersPerSeconds() * vreme.toSeconds());
		
		System.out.println("Pređeni put je: " + p.toKilometers() + "km");
	}
	
}
