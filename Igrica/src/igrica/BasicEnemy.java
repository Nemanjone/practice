package igrica;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Rectangle;
import java.awt.image.BufferedImage;

public class BasicEnemy extends GameObject {                              // prvi i najva�niji neprijatelj
	
	private Handler handler;
	private BufferedImage enemy_image;

	public BasicEnemy(float x, float y, ID id, Handler handler) {
		super(x, y, id);
		this.handler = handler;
		
		velX = 5;
		velY = 5;
		
		SpriteSheet ss = new SpriteSheet(Game.sprite_sheet);
		
		enemy_image = ss.grabImage(1, 2, 16, 16);
	}
	
	
	public Rectangle getBounds() {
		return new Rectangle((int)x,(int) y, 16, 16);
	}

	@Override
	public void tick() {
		x += velX;
		y += velY;
		
		if (y <= 0 || y > Game.HEIGHT - 32) velY *= -1; //ako ide dole, bi�e negativan, pa ga di�e gore
		                                                // i obrnuto...
		if (x<= 0 || x > Game.WIDTH - 16) velX *= -1;
		
		handler.addObject(new Trail((int)x, (int)y,ID.Trail, Color.RED, 16, 16, 0.02f, handler));

	}

	@Override
	public void render(Graphics g) {
		//g.setColor(Color.RED);
		//g.fillRect((int)x,(int) y, 16, 16);
		g.drawImage(enemy_image, (int)x, (int)y, null);
		
	}
	
	

}
