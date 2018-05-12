import java.awt.BasicStroke;
import java.awt.Color;
import java.awt.Graphics2D;

public class MapGenerator {
	
	
	public int map[][];
	public int brickWidth;
	public int brickHeight;
	
	public MapGenerator(int row, int col) {                           //konstruktor
	
		map = new int[row][col];
		for (int i = 0; i < map.length; i++) {                        //du�ina vrste
			for (int j = 0; j < map[0].length; j++) {                 //du�ina kolone
				map[i][j] = 1;
			}
		}
		brickWidth = 540/col;
		brickHeight = 150/row;
	}
	
	public void draw (Graphics2D g) {                               // nacrtaj cigle, takve i takve
		
		for (int i = 0; i < map.length; i++) {
			for (int j = 0; j < map[0].length; j++) {
				if (map[i][j] > 0) {
					g.setColor(Color.WHITE);
					g.fillRect(j * brickWidth + 80, i * brickHeight + 50, brickWidth, brickHeight);
					
					g.setStroke(new BasicStroke(3));                 // razmak izme�u cigli
					g.setColor(Color.BLACK);
					g.drawRect(j * brickWidth + 80, i * brickHeight + 50, brickWidth, brickHeight);
				}

			}
		}	
	}
	
	public void setBrickValue (int value, int row, int col) {
		map[row][col] = value;
	} 
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	

}
