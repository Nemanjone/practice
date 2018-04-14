package igrica;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Rectangle;
import java.awt.image.BufferedImage;
import java.util.Random;

public class Player extends GameObject {                                 // Igra�
	
	Random r = new Random();
	Handler handler;
	
	private BufferedImage player_image;

	public Player(float x, float y, ID id, Handler handler) {
		super(x, y, id);
		this.handler = handler;
		
		SpriteSheet ss = new SpriteSheet(Game.sprite_sheet);
		
		player_image = ss.grabImage(1, 1, 32, 32);
	}

	
	public Rectangle getBounds() {
		return new Rectangle((int)x,(int) y, 32, 32);
	}
	
	public void tick() {
		
		x += velX;                                           // vel(osoty) je brzina
		y += velY;
		
		x = Game.clamp(x, 0, Game.WIDTH - 37);
		y = Game.clamp(y, 0, Game.HEIGHT - 60);
		
		handler.addObject(new Trail((int)x, (int)y,ID.Trail, Color.WHITE, 32, 32, 0.05f, handler)); //ako ovo izbri�e�, onda u�itava slike, ali bez traga; bolje ovako
	
		collision();
	}

	private void collision() {                                          // ako dodirne� neprijateja, ionako su sve pravougaonici zbog intersects()
		for ( int i = 0; i < handler.object.size(); i ++) {
			
			GameObject tempObject = handler.object.get(i);
			
			if (tempObject.getId() == ID.BasicEnemy ||       
					tempObject.getId() == ID.FastEnemy ||
					tempObject.getId() == ID.SmartEnemy ||
			        tempObject.getId() == ID.EnemyBoss) {
				
				if (getBounds().intersects(tempObject.getBounds())) {
					HUD.HEALTH -= 2;
				}
			}
		}
	}
	
	public void render(Graphics g) {
		
		Graphics2D g2d = (Graphics2D) g;
	
		//g.setColor(Color.WHITE);
		//g.fillRect((int)x,(int)y, 32, 32);
		g.drawImage(player_image,(int) x, (int)y, null);
		
		
		
		
		
		
		
		
		
		
	}
	
	

}
