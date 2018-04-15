
public class Tigar extends Cat implements SwimingAbility {

	public Tigar(String name, String color) {
		super(name, color);
		
	}

	@Override
	public String makeNoise() {
		return "Roar";
	}

	@Override
	public void swim() {
		System.out.println("I am swiming..." + makeNoise());
		
	}

	
	
}
