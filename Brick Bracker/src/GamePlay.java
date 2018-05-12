import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Rectangle;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import javax.swing.Timer;
import javax.swing.JPanel;

public class GamePlay extends JPanel implements KeyListener, ActionListener {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;             //jebo ih broj!
	
	private boolean play = false;
	private int score = 0;
	private int totalBricks  = 21;
	private  Timer timer;                                        // uvek me zeza Timer jer uvozi Java.Util.Timer, a ne swing
	private int delay = 4;                                       // a dok se ja setim �ta je ...
	private int playerX = 310;
	private int ballposX = 120;
	private int balposY = 350;
	private int ballXdir = -1;
	private int ballYdir = -2;
	private MapGenerator map;
	
	
    public GamePlay() {                                               //konstruktor
		// TODO Auto-generated constructor stub
    	
		map = new MapGenerator(3, 7);
		addKeyListener(this);
		setFocusable(true);
		setFocusTraversalKeysEnabled(false);
		timer = new Timer(delay, this);
		timer.start();
	}
    
    public void paint(Graphics g) {
    	
    	g.setColor(Color.BLACK);                       //pozadina
    	g.fillRect(1, 1, 692, 592);
    	
    	map.draw((Graphics2D) g);
    	
    	
    	g.setColor(Color.YELLOW);                      //okvir, granice, borders
    	g.fillRect(0, 0, 3, 592);
    	g.fillRect(0, 0, 692, 3);
    	g.fillRect(691, 0, 3, 592);
    	
    	g.setColor(Color.YELLOW);                      //rezultat
    	g.setFont(new Font("serif", Font.BOLD,25));
    	g.drawString(""+score
    			, 590, 30);
    	
    	g.setColor(Color.GREEN);                       //pravougaonik od koga se odbija loptica
    	g.fillRect(playerX, 550, 100, 8);
    	
    	g.setColor(Color.YELLOW);                      //loptica
    	g.fillOval(ballposX, balposY, 20, 20);
    	
    	if(totalBricks <= 0) {                         //ako si uni�tio sve cigle, pobeda!!!
    		
    		play = false;
    		ballXdir = 0;
    		ballYdir = 0;
    		g.setColor(Color.RED);
    		g.setFont(new Font("serif",Font.BOLD, 30));
    		g.drawString("POBEDA!!!",265, 300);
    		g.drawString("Rezultat: " + score, 245, 335);
    		
    		g.setColor(Color.BLUE);
    		g.setFont(new Font("serif",Font.BOLD, 20));
    		g.drawString("Pritisni Enter za novu igru",220, 370);
    		
    	}
    
    	if (balposY > 570) {                            //ako loptica pro�e dole - kraj igre
    		play = false;
    		ballXdir = 0;
    		ballYdir = 0;
    		g.setColor(Color.RED);
    		g.setFont(new Font("serif",Font.BOLD, 30));
    		g.drawString("Igra je zavr�ena!",220, 300);
    		g.drawString("Rezultat: " + score, 245, 335);
    		
    		g.setColor(Color.BLUE);
    		g.setFont(new Font("serif",Font.BOLD, 20));
    		g.drawString("Pritisni Enter za novu igru",220, 370);
    	}
    	
    	g.dispose();
    	
    }
	
   
	@Override
	public void actionPerformed(ActionEvent e) {
		
		timer.start();
		
		
		if(play) {                                                        
			
			if(new Rectangle(ballposX, balposY, 20, 20).intersects(             //da se odbije loptica
					new Rectangle(playerX, 550,
					               100, 8))) {
				ballYdir = -ballYdir;	
			}
			
		A:	for (int i = 0; i < map.map.length; i++) {                          // pravljenje cigli
				for (int j = 0; j < map.map[0].length; j++) {
					if (map.map[i][j] > 0) {
						int brickX = j * map.brickWidth + 80;
						int brickY = i * map.brickHeight + 50;
						int brickWidth = map.brickWidth;
						int brickHeight = map.brickHeight;
						
						Rectangle rect = new Rectangle(brickX, brickY, brickWidth, brickHeight); // cigla
						Rectangle ballRect = new Rectangle(ballposX, balposY, 20, 20);           // pravougaonik za lopticu
						Rectangle brickRect = rect;											     // pravougaonik za ciglu zbog intersects
						
						if (ballRect.intersects(brickRect)) {                                    // kad loptica udari u ciglu
							map.setBrickValue(0, i, j);											 // uni�ti je!!!	
							totalBricks--;                                                       // manje cigli
							score += 5;                                                          // vi�e poena
							
							if (ballposX + 19 <= brickRect.x ||
									ballposX +1 >= brickRect.x + brickWidth) {
								ballXdir = -ballXdir;
							} else {
								
								ballYdir = - ballYdir;
							}
						
							break A;                                             // iza�i iz spoljne petlje
						}
								
					}
				}
			}
			
			
			ballposX += ballXdir;               // pozicija loptice
			balposY += ballYdir;
			
			if (ballposX < 0) {                 // leva strana
				ballXdir = -ballXdir;
			}
			if (balposY < 0) {                  // gornja strana
				ballYdir = - ballYdir;
			}
			if (ballposX > 670) {               // desna strana
				ballXdir = - ballXdir;
			}
		}
	
		repaint();
		
	}		

		

	@Override
	public void keyPressed(KeyEvent doga�aj) {
	
		if(doga�aj.getKeyCode() == KeyEvent.VK_RIGHT) {  //da ne pre�e granicu okvira
			if(playerX >= 600) {
				playerX = 600;
			}
			else {
				pomeriDesno();
			}
		}
		
	if(doga�aj.getKeyCode() == KeyEvent.VK_LEFT) {
		if(playerX <10) {
			playerX = 10;
		}
		else {
			pomeriLevo();
		}
		
	  }
	if (doga�aj.getKeyCode() == KeyEvent.VK_ENTER) {  // ako pritisnes enter da igra opet po�ne
		if (!play) {
			play = true;
			ballposX = 120;
			balposY = 320;
			ballXdir = -1;
			ballYdir = -2;
			playerX = 310;
			score = 0;
			totalBricks = 21;
			map = new MapGenerator(3,7);
			
			repaint();
		}
	}
	
	}
	
	public void pomeriDesno() {                                 // jasno kao beli dan
		play = true;
		playerX+=20;
	}
	
	public void pomeriLevo() {
		play = true;
		playerX-=20;
	}

	@Override
	public void keyReleased(KeyEvent e) {}                     // metodi koji moraju da se implementiraju
															   // da bi interfejs radio	
	@Override
	public void keyTyped(KeyEvent e) {}


	
	

}
