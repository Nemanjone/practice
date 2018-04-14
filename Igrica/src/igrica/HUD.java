package igrica;

import java.awt.Color;
import java.awt.Graphics;

public class HUD {                          // Head of the Game
	
	public int bounds = 0;                  //treba za Zdravlje u Prodavnici 
	private float greenValue = 255;         // max za boju jer æe se menjati nijansa
	public static float HEALTH = 100;
	private int score = 0;
	private int level = 1;

	public void tick() {
	
		HEALTH = (int) Game.clamp(HEALTH, 0, 100 + (bounds/2));
		greenValue = HEALTH * 2;
		greenValue = (int) Game.clamp(greenValue, 0, 255);             //slabi nijansa kako gubiš snagu
		
		
		
		score++;                                                       //rezultat samo raste, cilj je izdržati što duže
	}
	
	public void render(Graphics g) {                                   //izgled polja za igru
		
		g.setColor(Color.GRAY);
		g.fillRect(15, 15, 200 + bounds, 32);
		
		g.setColor(new Color(75,(int)greenValue, 0));
		g.fillRect(15, 15, (int) (HEALTH * 2), 32);
		
		g.setColor(Color.WHITE);
		g.drawRect(15, 15, 200 + bounds, 32);
		
		g.drawString("Rezultat: " + score, 15, 64);
		g.drawString("Nivo: " + level, 15, 80);
		g.drawString("Prodavnica", 15, 94);
	} 
	
	public void setScore (int score) {
		this.score = score;
	}

	public int getScore() {
		return score;
	}
	
	public int getLevel () {
		return level;
	}
	
	public void setLevel (int level) {
		this.level = level;
	}
	
	
	
	
	
}
