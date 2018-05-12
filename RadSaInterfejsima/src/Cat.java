
public class Cat extends Animal implements ClimbingAbility {

	
	
	public Cat(String name, String color) {
		super(name, color);
	
	}

	@Override
	public String makeNoise() {
		return "Meow!";
	}

	@Override
	public void climb() {
		System.out.println("I am climbing..." + makeNoise());
		
	}

}
