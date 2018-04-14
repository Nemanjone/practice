package igrica;

import java.awt.Canvas;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.image.BufferStrategy;
import java.awt.image.BufferedImage;
import java.util.Random;

public class Game extends Canvas implements Runnable {                 //main klasa
	
	/**
	 * 
	 */
	private static final long serialVersionUID = -4301142046781709642L;
	
	public static final float WIDTH = 640, HEIGHT = WIDTH/12*9;      // formula, navodno lepa za oko
	 
	private Thread thread;                   // nit
	private boolean running = false;
	public static boolean paused = false;
	public int diff = 0;                     // 0 = normalno; 1 = teško; nivo
	private Random r;                        // sve iz drugih klasa... 
	private Handler handler;
	private HUD hud;
	private Spawn spawner;
	private Menu menu;
	private Shop shop;
	
	public enum STATE {
		MENU, HELP, GAME, END, SELECT, SHOP              // enumi
	};
	
	public static STATE gameState = STATE.MENU;          // tip promenjive
	
	public static BufferedImage sprite_sheet;            // ovo sam crtao u Paint.net likove
	
	public Game() {                                      // konstruktor
		
		
		
		BufferedImageLoader loader = new BufferedImageLoader();
		
		try {
			sprite_sheet = loader.loadImage("/slikeIgrica.png");
		
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		handler = new Handler();
		hud = new HUD();
		shop = new Shop(handler, hud);
		menu = new Menu(this, handler, hud);
		this.addKeyListener(new KeyInput(handler, this));
		this.addMouseListener(menu);
		this.addMouseListener(shop);
		
		new Window(WIDTH, HEIGHT, "Hajde da napravimo igricu!", this);

		
		
		AudioPlayer.load();
		AudioPlayer.getMusic("music").loop();;
		
		spawner = new Spawn(handler, hud, this);
		
	    r = new Random();
		
	    if (gameState == STATE.GAME) {
		
	    handler.addObject(new Player(WIDTH/2 - 32, HEIGHT/2 - 32,
	    		ID.Player, handler));
	    handler.addObject(new BasicEnemy(r.nextInt((int) Game.WIDTH -50), 
				r.nextInt((int) Game.HEIGHT - 50), ID.BasicEnemy,handler));
	    
	    } else {
	    	for (int i= 0; i < 10; i++) {
	    		 handler.addObject(new MenuParticle(r.nextInt((int) WIDTH),r.nextInt((int) HEIGHT),
	    		    		ID.MenuParticle, handler));
	    		
	    	}
	    	
	    }
	   // handler.addObject(new EnemyBoss((Game.WIDTH/2) - 48, -120, ID.EnemyBoss,handler));
	}	    

	public synchronized  void start() {
		
		thread = new Thread(this);
		thread.start();
		running = true;
	}
	
	public synchronized  void stop() {
		
		try {
			thread.join();
			
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		running = false;
		
	}	
	public void run() {                                // ovo je neki gejmerski kod za metod run, dobro radi,
		this.requestFocus();						   // mada mi nije do kraja jasan
		long lastTime = System.nanoTime();
		double amaountOfTicks = 60.0;
		double ns = 1000000000 /amaountOfTicks;
		double delta = 0;
		long timer = System.currentTimeMillis();
		int frames = 0;
		while (running) {
			long now = System.nanoTime();
			delta += (now - lastTime) / ns;
			lastTime = now;
			while (delta >= 1) {
				tick();
				delta--;
				
			}
			if (running)
				render();
			frames++;
			
			if (System.currentTimeMillis() - timer > 1000) {
				timer += 1000;
				//System.out.println("FPS: " + frames);          //frejmova po sekundi, radi testa
				frames = 0;
			}	
		}
		stop();
		
	}
	
	private void tick() {
		
		handler.tick();                     //ako ga stavim u if onda radi pauza, ali ne i munje u meniju, pre igre
												   //ovako munje rade, a pauza ne!?
		if (gameState == STATE.GAME) {
			
			if (!paused) {
				 
				hud.tick();
				spawner.tick();
				
				
				if (HUD.HEALTH <= 0) {
					HUD.HEALTH = 100;
					gameState = STATE.END;
					handler.clearEnemys();
					for (int i= 0; i < 10; i++) {
			    		 handler.addObject(new MenuParticle(r.nextInt((int) WIDTH),r.nextInt((int) HEIGHT),
			    		    		ID.MenuParticle, handler));
					
				}
			}
		}
		else if (gameState == STATE.MENU || gameState == STATE.END ||
				 gameState == STATE.SELECT) {
			menu.tick();
			handler.tick();
				}
			}
	}
	
	private void render() {
		
		BufferStrategy bs = this.getBufferStrategy();
		if (bs == null) {
			this.createBufferStrategy(3);
			return;
		}
		
		Graphics g = bs.getDrawGraphics();
		
		g.setColor(Color.BLACK);
		g.fillRect(0, 0, (int)WIDTH,(int) HEIGHT);
		
		if (paused) {
			g.drawString("PAUZA", 100, 100);
		}
		
		if (gameState == STATE.GAME) {
		
		hud.render(g);
		handler.render(g);
		
	}else if (gameState == STATE.SHOP) {
		shop.render(g);
		
	}else if 
		(gameState == STATE.MENU || gameState == STATE.HELP ||
		 gameState == STATE.END  || gameState == STATE.SELECT) {
			menu.render(g);
			handler.render(g);
	} 
		
		g.dispose();
		bs.show();
		
	}
	
	public static float clamp(float var,float min, float max) {     // vrlo koristan metod; kad god preðe granicu, vrati ga
		
		if (var >= max)
			return var = max;
		else if (var <= min)
			return var = min;
		else 
			return var;
	}
	
	public static void main (String [] args) {                      // main metod
		
		new Game();
	}

}
