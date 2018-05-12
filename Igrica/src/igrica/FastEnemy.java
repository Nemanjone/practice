package igrica;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Rectangle;
import java.awt.image.BufferedImage;

public class FastEnemy extends GameObject {                                   // jedan od neprijatelja
	
	
		
	private Handler handler;
	private BufferedImage enemy2image;

	 public FastEnemy(float x, float y, ID id, Handler handler) {

			super(x, y, id);
			this.handler = handler;
			
			velX = 2;
			velY = 9;
			
			SpriteSheet ss = new SpriteSheet(Game.sprite_sheet);
			
			enemy2image = ss.grabImage(1, 3, 16, 16);
		}
		
		
		public Rectangle getBounds() {
			return new Rectangle((int)x,(int) y, 16, 16);
		}

		@Override
		public void tick() {
			x += velX;
			y += velY;
			
			if (y <= 0 || y > Game.HEIGHT - 32) velY *= -1; //ako ide dole, biæe negativan, pa ga diže gore
			                                                // i obrnuto...
			if (x<= 0 || x > Game.WIDTH - 16) velX *= -1;
			
			handler.addObject(new Trail((int)x,(int) y,ID.Trail, Color.CYAN, 16, 16, 0.02f, handler));

		}

		@Override
		public void render(Graphics g) {
			//g.setColor(Color.CYAN);
			//g.fillRect((int)x,(int) y, 16, 16);
			g.drawImage(enemy2image, (int)x, (int)y, null);
		}
		
		

	}

	


