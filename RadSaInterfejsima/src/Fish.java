
public class Fish extends Animal implements SwimingAbility{

	public Fish(String name, String color) {
		super(name, color);
		
	}

	@Override
	public void swim() {
	System.out.println("I am swiming...");	
	}

	@Override
	public String makeNoise() {
		return "";
	}

	
}
