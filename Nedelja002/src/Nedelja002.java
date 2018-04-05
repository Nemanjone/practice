
public class Nedelja002 {

	public static void main (String[] args) {
		
		prika�iPre�eniPut(Brzina.fromMetersPerSeconds(4), Vreme.fromMinutes(4));

	}
	
	public static void prika�iPre�eniPut(Brzina brzina, Vreme vreme) {
		Put p = Put.fromMeters(brzina.toMetersPerSeconds() * vreme.toSeconds());
		
		System.out.println("Pre�eni put je: " + p.toKilometers() + "km");
	}
	
}
