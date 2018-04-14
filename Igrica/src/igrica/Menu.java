package igrica;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.Random;
import igrica.Game.STATE;

public class Menu extends MouseAdapter {                                        //Meni
	
	private Game game;
	private Handler handler;
	private HUD hud;
	private Random r = new Random();
	
	public Menu(Game game, Handler handler, HUD hud) {
		this.game = game;
		this.handler = handler;
		this.hud = hud;
	} 
	
	public void mousePressed(MouseEvent e) {
		
		int mx = e.getX();                                                         // uzmi poziciju gde miš klikne
		int my = e.getY();
		
		
		if (game.gameState == STATE.MENU) {
			
		//dugme Igraj
		if (mouseOver(mx, my, 210, 150, 200, 64)) {
			//  game.gameState = STATE.Game;                                                 //prva varijanta
			 //   handler.addObject(new Player(Game.WIDTH/2 - 32, Game.HEIGHT/2 - 32,
			   // 		ID.Player, handler));
			  //handler.clearEnemys();

			  //handler.addObject(new BasicEnemy(r.nextInt((int) Game.WIDTH -50), 
				//		r.nextInt((int) Game.HEIGHT - 50), ID.BasicEnemy,handler));
		
			 Game.gameState = STATE.SELECT;
			 AudioPlayer.getSound("menu_sound").play();
			 return;
		}
		
		
		//dugme Pomoæ
		if (mouseOver(mx, my, 210, 250, 200, 64))	{
			game.gameState = STATE.HELP;
			
			AudioPlayer.getSound("menu_sound").play();
		}
		
		//dugme Kraj igre
		
		if (mouseOver(mx, my, 210, 350, 200, 64)) {
			System.exit(0);
				}

		}
		
	
		
		
		//dugme Nazad iz Pomoæi
		if (game.gameState == STATE.HELP) {
			if (mouseOver(mx, my, 210, 350, 200, 64)) {
				game.gameState = STATE.MENU;
				AudioPlayer.getSound("menu_sound").play();
				return;
			}
		}
		
		//dugme za pokušaj Ponovo
		if (Game.gameState == STATE.END) {
			if (mouseOver(mx, my, 210, 350, 200, 64)) {
				Game.gameState = STATE.MENU;
				hud.setLevel(1);
				hud.setScore(0);
		
			  AudioPlayer.getSound("menu_sound").play();
			}
		}
	
		
		if (Game.gameState == STATE.SELECT ) {
			
			// dugme normalno
			
		if (mouseOver(mx, my, 210, 150, 200, 64)) {
			  game.gameState = STATE.GAME;
			   handler.addObject(new Player(Game.WIDTH/2 - 32, Game.HEIGHT/2 - 32,
			    		ID.Player, handler));
			   handler.clearEnemys();

			   handler.addObject(new BasicEnemy(r.nextInt((int) Game.WIDTH -50), 
						r.nextInt((int) Game.HEIGHT - 50), ID.BasicEnemy,handler));
		
			   game.diff = 0;
			
		 AudioPlayer.getSound("menu_sound").play();
		}
		
	
		//dugme teško
		if (mouseOver(mx, my, 210, 250, 200, 64))	{
			  game.gameState = STATE.GAME;
			   handler.addObject(new Player(Game.WIDTH/2 - 32, Game.HEIGHT/2 - 32,
			    		ID.Player, handler));
			   handler.clearEnemys();

			   handler.addObject(new HardEnemy(r.nextInt((int) Game.WIDTH -50), 
						r.nextInt((int) Game.HEIGHT - 50), ID.BasicEnemy,handler));
		
			   game.diff = 1;
			
		 AudioPlayer.getSound("menu_sound").play();
		}
		
		
		
		
		//dugme nazad
	
			if (mouseOver(mx, my, 210, 350, 200, 64)) {
				game.gameState = STATE.MENU;
				AudioPlayer.getSound("menu_sound").play();
				return;
			}
		}	
		
	}
	
	public void mouseReleased (MouseEvent e) {
		
		
	}
	
	private boolean mouseOver(int mx, int my,int x, int y, int width, int height) {
		
		if (mx > x && mx < (x + width)) {                 //ako smo mišem iznad izabranog okvira
			if (my > y && my < ( y + height)) {           // da ne kucam za svaku posebno
				return true;
			}else  return false;
		}else return false;
	}
	
	public void tick() {
		
		
	}
	
	public void render (Graphics g) {                       // ovo je jasno
		
		if (game.gameState == STATE.MENU) {
			
		Font fnt = new Font("arial", 1, 50);
		Font fnt2 = new Font("arial", 1, 30);
		
		
		g.setFont(fnt);
		g.setColor(Color.WHITE);
		g.drawString("Munje", 240, 70);
		
		g.setFont(fnt2);
		g.drawRect(210, 150, 200, 64);
		g.drawString("Igraj", 280, 190);
		
		g.drawRect(210, 250, 200, 64);
		g.drawString("Pomoæ", 260, 290);
		
		g.drawRect(210, 350, 200, 64);
		g.drawString("Kraj igre", 250, 390);
	
		} else if (game.gameState == STATE.HELP) {
			
			Font fnt = new Font("arial", 1, 50);
			Font fnt2 = new Font("arial", 1, 30);
			
			g.setFont(fnt);
			g.setColor(Color.WHITE);
			g.drawString("Pomoæ", 230, 70);
			
			g.setFont(new Font("arial", Font.PLAIN, 18));
			g.drawString("Koristi strelice (GORE, DOLE, LEVO, DESNO) da bi bežao od neprijatelja.", 35, 120);
			g.drawString("Igra ima više nivoa sa  razlièitim neprijateljima.", 35, 150);
			g.drawString("Zelena traka pokazuje koliko snage ti je preostalo.", 35, 180);
			g.drawString("Rezultat prikazuje koliko poena si osvojio.", 35, 210);
			g.drawString("Probaj da izdržiš do kraja!", 35, 240); 
			g.setFont(new Font("arial", Font.BOLD, 30));
			g.drawString("Sreæno!", 35, 300);
			
			g.setFont(fnt2);
			g.drawRect(210, 350, 200, 64);
			g.drawString("Nazad", 270, 390);
			
		}
		
		
		else if (game.gameState == STATE.END) {
			
			Font fnt = new Font("arial", 1, 50);
			Font fnt2 = new Font("arial", 1, 30);
			
			g.setFont(fnt);
			g.setColor(Color.WHITE);
			g.drawString("Kraj igre", 215, 70);
			
			g.setFont(new Font("arial", Font.PLAIN, 25));
			g.drawString("Izgubio si!", 240, 200);
			g.drawString("Broj poena: " + hud.getScore(), 215, 250);
			
			g.setFont(fnt2);
			g.drawRect(210, 350, 200, 64);
			g.drawString("Pokušaj opet", 215, 390);
			
			} else if (game.gameState == STATE.SELECT) {
				
				Font fnt = new Font("arial", 1, 50);
				Font fnt2 = new Font("arial", 1, 30);
				
				
				g.setFont(fnt);
				g.setColor(Color.WHITE);
				g.drawString("Izaberi težinu: ", 150, 70);
				
				g.setFont(fnt2);
				g.drawRect(210, 150, 200, 64);
				g.drawString("Normalno", 245, 190);
				
				g.drawRect(210, 250, 200, 64);
				g.drawString("Teško", 265, 290);
				
				g.drawRect(210, 350, 200, 64);
				g.drawString("Nazad", 265, 390);
				
				
			}
		}
	}
