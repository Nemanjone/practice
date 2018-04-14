package igrica;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class Shop extends MouseAdapter {                                    // Prodavnica
																			// Kupuješ zdravlje i brzinu	
	HUD hud;
	Handler handler;
	private int B1 = 1000;
	private int B2 = 1000;
	private int B3 = 1000;

	public Shop(Handler handler, HUD hud) {
		this.handler = handler;
		this.hud = hud;
	}
	
	public void render (Graphics g) {
		g.setColor(Color.PINK);
		g.setFont(new Font ("arial", 0, 48));
		g.drawString("Prodavnica", (int) (Game.WIDTH/2 - 120), 60);
		
		//box1
		g.setColor(Color.WHITE);
		g.setFont(new Font ("arial", Font.BOLD , 16));
		g.drawString("Unapredi zdravlje", 54, 130);
		g.drawString(" ", 110, 140);
		g.drawString("Cena: " + B1, 78 , 170);
		g.drawRect(50, 100, 140, 100);
		
		
		//box2
		g.drawString("Unapredi brzinu", 250, 130);
		g.drawString(" ", 260, 140);
		g.drawString("Cena: " + B2, 265 , 170);
		g.drawRect(240, 100, 140, 100);
		
	    //box3
		g.drawString("Dopuni zdravlje", 442, 130);
		g.drawString(" ", 410, 140);
		g.drawString("Cena: " + B3, 455 , 170);
		g.drawRect(430, 100, 140, 100);
		
		g.setColor(Color.YELLOW);
		g.drawString("Rezultat: " + hud.getScore(), 
				50, 300);
		g.setColor(Color.YELLOW);
		g.drawString("Pritisni Space da se vratiš nazad", 
				50, 330);
		
	}

	
	public void mousePressed (MouseEvent e) {
		
		int mx = e.getX();
		int my = e.getY();
		
		//box1
		if (mx >= 50 && mx <= 190) {
			if (my >= 100 && my <= 200 ) {
				if (hud.getScore() >= B1) {
					hud.setScore(hud.getScore() - B1);
					B1 +=1000;
					hud.bounds += 20;
					hud.HEALTH = (100 + (hud.bounds / 2));
				}
				
			}
		}
		
		//box2
		if (mx >= 240 && mx <= 380) {
			if (my >= 100 && my <= 200 ) {
				if (hud.getScore() >= B2) {
					hud.setScore(hud.getScore() - B2);
					B2 +=1000;
					handler.spd++;
					
			}
		}
	}	
		//box3
		if (mx >= 430 && mx <= 570) {
			if (my >= 100 && my <= 200 ) {
				if (hud.getScore() >= B3) {
					hud.setScore(hud.getScore() - B3);
					hud.HEALTH = (100 + (hud.bounds / 2));	
				}
			}
		
		}
				
	}
	
}
