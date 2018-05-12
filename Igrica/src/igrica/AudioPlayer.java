package igrica;

import java.util.HashMap;
import java.util.Map;

import org.newdawn.slick.Music;
import org.newdawn.slick.SlickException;
import org.newdawn.slick.Sound;

public class AudioPlayer {                                                          //Zvuk za klik mišem i muzika u pozadini sa dve HashMape
	
	public static Map<String, Sound> soundMap = new HashMap<String, Sound>();
	public static Map<String, Music> musicMap = new HashMap<String, Music>();
	
	public static void load() {
		
		
		try {	
			soundMap.put("menu_sound", new Sound("Resursi/click3.ogg"));
			musicMap.put("music", new Music("Resursi/BackRoundSound.ogg"));
		} 
		catch (SlickException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public static Music getMusic(String key) {
		return musicMap.get(key);
	}
	
	public static Sound getSound(String key) {
		return soundMap.get(key);
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
}
