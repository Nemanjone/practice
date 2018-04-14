package igrica;

import java.util.Random;

public class Spawn {                             /*ovde su definisani nivoi i koji neprijatelj se
												  pojavljuje na kom nivou i na kom mestu*/
	private Handler handler;
	private HUD hud;
	private Game game;
	private int scoreKeep = 0;
	private Random r = new Random();
	
	public Spawn (Handler handler, HUD hud, Game game) {
		this.handler = handler;
		this.hud = hud;
		this.game = game;
	}
	
	public void tick() {
		
		scoreKeep++;                                                                         //1000 poena sledeæi nivo
		
		if (scoreKeep >= 1000) {
			scoreKeep = 0;
			hud.setLevel(hud.getLevel() + 1);
			
			if (game.diff == 0) {
				
				if (hud.getLevel() == 2) {
					handler.addObject(new BasicEnemy(r.nextInt((int) Game.WIDTH -50), 
							r.nextInt((int) Game.HEIGHT - 50), ID.BasicEnemy,handler));
					
				} else if (hud.getLevel() == 3) {
						handler.addObject(new BasicEnemy(r.nextInt((int) Game.WIDTH - 50), 
								r.nextInt((int) Game.HEIGHT - 50), ID.BasicEnemy,handler));	
						
				} else if (hud.getLevel() == 4) {
							handler.addObject(new FastEnemy(r.nextInt((int) Game.WIDTH -50), 
									r.nextInt((int) Game.HEIGHT - 50), ID.FastEnemy,handler));
							
				} else if (hud.getLevel() == 5) {
								handler.addObject(new SmartEnemy(r.nextInt((int) Game.WIDTH - 50), 
										r.nextInt((int) Game.HEIGHT - 50), ID.SmartEnemy,handler));		
				} else if (hud.getLevel() == 6) {
					handler.addObject(new FastEnemy(r.nextInt((int) Game.WIDTH - 50), 
							r.nextInt((int) Game.HEIGHT - 50), ID.FastEnemy,handler));
					
				} else if (hud.getLevel() == 7) {
						handler.addObject(new FastEnemy(r.nextInt((int) Game.WIDTH - 50), 
								r.nextInt((int) Game.HEIGHT - 50), ID.FastEnemy,handler));	
						
				} else if (hud.getLevel() == 10) {
					handler.clearEnemys(); 
							handler.addObject(new EnemyBoss(((Game.WIDTH / 2 )- 48), 
									-150, ID.EnemyBoss,handler));			
						
				}
			
			}
			
			else if (game.diff == 1) {
			
			if (hud.getLevel() == 2) {
				handler.addObject(new HardEnemy(r.nextInt((int) Game.WIDTH -50), 
						r.nextInt((int) Game.HEIGHT - 50), ID.BasicEnemy,handler));
				
			} else if (hud.getLevel() == 3) {
					handler.addObject(new HardEnemy(r.nextInt((int) Game.WIDTH - 50), 
							r.nextInt((int) Game.HEIGHT - 50), ID.BasicEnemy,handler));	
					
			} else if (hud.getLevel() == 4) {
						handler.addObject(new FastEnemy(r.nextInt((int) Game.WIDTH -50), 
								r.nextInt((int) Game.HEIGHT - 50), ID.FastEnemy,handler));
						
			} else if (hud.getLevel() == 5) {
							handler.addObject(new SmartEnemy(r.nextInt((int) Game.WIDTH - 50), 
									r.nextInt((int) Game.HEIGHT - 50), ID.SmartEnemy,handler));		
			} else if (hud.getLevel() == 6) {
				handler.addObject(new FastEnemy(r.nextInt((int) Game.WIDTH - 50), 
						r.nextInt((int) Game.HEIGHT - 50), ID.FastEnemy,handler));
				
			} else if (hud.getLevel() == 7) {
					handler.addObject(new FastEnemy(r.nextInt((int) Game.WIDTH - 50), 
							r.nextInt((int) Game.HEIGHT - 50), ID.FastEnemy,handler));	
					
			} else if (hud.getLevel() == 10) {
				handler.clearEnemys(); 
						handler.addObject(new EnemyBoss(((Game.WIDTH / 2 )- 48), 
								-150, ID.EnemyBoss,handler));			
					
							}
						}
				   }
				}
			}
		

	

