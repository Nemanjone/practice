package igrica;

import java.awt.Graphics;
import java.awt.Rectangle;

public abstract class GameObject {              // apstraktna klasa nad svim ostalima
	
	protected float x,y;					    // bilo je sve int, ali SmartEnemy ne radi baš najbolje, pa sam sve menjao u float; džaba, i dalje nije nešto 
	protected ID id;
	protected float velX, velY;                 //brzina
	
	public GameObject(float x, float y, ID id) {            
		super();
		this.x = x;
		this.y = y;
		this.id = id;
	}
	
	public abstract void tick();                 // apstrktni  metodi za ostale klase; render za grafiku, getBounds za 
	public abstract void render(Graphics g);     // koordinate i tick za ostalo
	public abstract Rectangle getBounds() ; 

	public float getX() {                         // geteri i seteri 
		return x;
	}

	public void setX(float x) {
		this.x = x;
	}

	public float getY() {
		return y;
	}

	public void setY(float y) {
		this.y = y;
	}

	public ID getId() {
		return id;
	}

	public void setId(ID id) {
		this.id = id;
	}

	public float getVelX() {
		return velX;
	}

	public void setVelX(float velX) {
		this.velX = velX;
	}

	public float getVelY() {
		return velY;
	}

	public void setVelY(float velY) {
		this.velY = velY;
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	

}
