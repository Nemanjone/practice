package igrica;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Rectangle;
import java.awt.image.BufferedImage;
import java.util.Random;

public class HardEnemy extends GameObject {                            //vrsta neprijatelja
	
	
		
		private Handler handler;
		private Random r = new Random();
		private BufferedImage enemy3image;
		
		
		public HardEnemy(float x, float y, ID id, Handler handler) {
			super(x, y, id);
			this.handler = handler;
			
			velX = 5;
			velY = 5;
			
			SpriteSheet ss = new SpriteSheet(Game.sprite_sheet);
			
			enemy3image = ss.grabImage(1, 4, 16, 16);
		}
		
		
		public Rectangle getBounds() {
			return new Rectangle((int)x,(int) y, 16, 16);
		}

		@Override
		public void tick() {
			x += velX;
			y += velY;
			                                             //ako ide gore ili dole
			if (y <= 0 || y > Game.HEIGHT - 32) {
			if (velY < 0) velY = - (r.nextInt(7) + 1) * -1; else velY = (r.nextInt(9) + 1) * -1; 
			}                                             
			if (x<= 0 || x > Game.WIDTH - 16) {
			if (velX < 0 ) velX = - (r.nextInt(7) + 1) * -1; else velX = (r.nextInt(9) + 1) * -1; 
			}
			handler.addObject(new Trail((int)x, (int)y,ID.Trail, Color.YELLOW, 16, 16, 0.02f, handler));

		}

		@Override
		public void render(Graphics g) {
			//g.setColor(Color.YELLOW);
			//g.fillRect((int)x,(int) y, 16, 16);
			g.drawImage(enemy3image, (int) x, (int) y, null);   //slika radi ako iskljuèim Trail, videæeš u Game klasi, metod tick()
		}
		
		

	}



