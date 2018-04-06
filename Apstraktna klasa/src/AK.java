import java.util.ArrayList;

public class AK {

	public static void main (String [] args) {
		
		ArrayList<Robot> roboti = new ArrayList<>();
	
		
		roboti.add(new AutoRobot(100, "Auto 1", "Test332", 45));
		roboti.add(new LeteæiRobot(2, "Letelica1", "Test211", 600));
		roboti.add(new TajniRobot(300,"Super tajni robot", "5165gfh6"));
		
		
		for (Robot r : roboti) {
			
	System.out.println("Tvoje ime: " + r.getIme());
	System.out.println("Težina ti je " + r.getTežinaKG());
		
		
		}
	}
}
