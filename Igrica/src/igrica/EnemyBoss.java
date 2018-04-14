package igrica;


import java.awt.Color;
import java.awt.Graphics;
import java.awt.Rectangle;
import java.util.Random;

public class EnemyBoss extends GameObject {                                // tata svih neprijatelja; ispaljuje munje nasumièno
	
		private Handler handler;
		Random r = new Random();
		
		private int timer = 80;                                           // dva tajmera da bi se pojavio( zastrašio svojom pojavom ) 
		private int timer2 = 50;										  // pa tek onda osuo paljbu

		public EnemyBoss(float x, float y, ID id, Handler handler) {
			super(x, y, id);
			this.handler = handler;
			
			velX = 0;                                               //brzina
			velY = 2;
		}
		
		
		public Rectangle getBounds() {
			return new Rectangle((int)x,(int) y, 96, 96);                           //ogroman je
		}

		@Override
		public void tick() {
			x += velX;
			y += velY;
			
			if (timer <= 0) velY = 0;
			timer--;
			
			if (timer <= 0) timer2--;
			
			if (timer2 <= 0) {
				if (velX == 0) velX = 2;
				if(velX > 0)                             // ubrzava vremenom
				velX += 0.005f;
				else if(velX < 0)
					velX -=0.005f;
				
				velX = Game.clamp(velX, -10, 10);
				
				int spawn = r.nextInt(10);
				if (spawn == 0) handler.addObject(new EnemyBossBullet((int)x + 48, (int) y +48, ID.BasicEnemy, handler));  // ispaljuje objekte
			}
			
			//if (y <= 0 || y > Game.HEIGHT - 32) velY *= -1; //ako ide dole, biæe negativan, pa ga diže gore
			                                                // i obrnuto...
			if (x<= 0 || x > Game.WIDTH - 96) velX *= -1;
			
		//	handler.addObject(new Trail((int)x, (int)y,ID.Trail, Color.RED, 96, 96, 0.008f, handler));

		}

		@Override
		public void render(Graphics g) {
			g.setColor(Color.RED);
			g.fillRect((int)x,(int) y, 96, 96);
			
		}
		
		

	}


