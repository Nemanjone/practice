package igrica;

import java.awt.Graphics;
import java.util.LinkedList;

public class Handler {                                                      // ovde se hendluje igrom...
	
	LinkedList<GameObject> object =new LinkedList<GameObject>();
	
	public int spd = 5;                            //brzina za Shop klasu
	
	public void tick() {
		for (int i = 0; i < object.size(); i++) {
			GameObject temObject = object.get(i);
			
			temObject.tick();
		}
		
	}
	
	public void render(Graphics g) {
		for (int i = 0; i < object.size(); i++) {
			GameObject temObject = object.get(i);
			
			temObject.render(g);
		
		}
	}
		public void clearEnemys() {                                  //da bi na kraju poèistio sve
			for (int i = 0; i < object.size(); i++) {
				GameObject temObject = object.get(i);
				
				if (temObject.getId() != ID.Player)
					object.clear();
				if (Game.gameState != Game.STATE.END)
				addObject(new Player((int)temObject.getX(), (int)temObject.getY(),
			              ID.Player, this));
				
		}
	}
	
	public void addObject (GameObject object) {
		this.object.add(object);
	}
	
	public void removeObject (GameObject object) {
		this.object.remove(object);
	}
	
	
	
	
	
	

}
