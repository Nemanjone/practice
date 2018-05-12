import java.util.ArrayList;
import java.util.List;

public class RadSaInterfejsima {
	
	public static void main(String[] args) {
		
		List<Animal> animals = new ArrayList<>();
		
		animals.add(new Cat("Pega", "belo-crna"));
		animals.add(new Tigar("Shircan", "zlatna"));
		animals.add(new Fish("Cuca", "crvena"));
		animals.add(new Bird("Tviti", "žuta"));
		
		for (Animal animal : animals) {
			if(animal instanceof ClimbingAbility) {
				((ClimbingAbility) animal).climb();	
			}
			if(animal instanceof SwimingAbility) {
				((SwimingAbility) animal).swim();	
			}
			if(animal instanceof FlyingAbility) {
				((FlyingAbility) animal).fly();
				((FlyingAbility) animal).land();
			}
		}

	}

}
