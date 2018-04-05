
public class Nedelja002 {

	public static void main (String[] args) {
		
		prikažiPreðeniPut(Brzina.fromMetersPerSeconds(4), Vreme.fromMinutes(4));

	}
	
	public static void prikažiPreðeniPut(Brzina brzina, Vreme vreme) {
		Put p = Put.fromMeters(brzina.toMetersPerSeconds() * vreme.toSeconds());
		
		System.out.println("Preðeni put je: " + p.toKilometers() + "km");
	}
	
}
