
public class Bird extends Animal implements FlyingAbility {

	
	public Bird(String name, String color) {
		super(name, color);
		
	}

	@Override
	public String makeNoise() {
	
		return "Tweet";
	}

	@Override
	public void fly() {
		System.out.println("I am flying..." + makeNoise());
		
	}

	@Override
	public void land() {
		System.out.println("I am landing..." + makeNoise());
		
	}
	
	

}
