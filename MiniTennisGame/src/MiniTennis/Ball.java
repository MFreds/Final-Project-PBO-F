package MiniTennis;

import java.awt.Graphics2D;
import java.awt.Rectangle;
import java.awt.Image;
import java.awt.Toolkit;

public class Ball {
	private static final int DIAMETER = 30;
	Image img = Toolkit.getDefaultToolkit().getImage("src/resources/ball1.png");
	
	int x = 0;
	int y = 0;
	int xa = 5;
	int ya = 5;
	private Game game;

	public Ball(Game game) {
		this.game = game;
	}

	void move() {
		boolean changeDirection = true;
		if (x + xa < 0) // limit border canvasnya
			xa = game.speed;
		else if (x + xa > game.getWidth() - DIAMETER)
			xa = -game.speed;
		else if (y + ya < 0)
			ya = game.speed;
		else if (y + ya > game.getHeight() - DIAMETER)
			game.gameOver();
		else if (collision()){ // jika kena raket
			ya = -game.speed;
			y = game.racquet.getTopY() - DIAMETER;
			game.speed++;
			game.score++;
		} else 
			changeDirection = false;
		
		if (changeDirection) 
			Sound.BALL.play();
		x = x + xa;
		y = y + ya;
	}

	private boolean collision() {
		return game.racquet.getBounds().intersects(getBounds()); // kalo kena raket, akan dipantulkan
	}

	public void paint(Graphics2D g) {
		//g.fillOval(x, y, DIAMETER, DIAMETER);
		g.drawImage(img, x, y, null);
	}

	public Rectangle getBounds() {
		return new Rectangle(x, y, DIAMETER, DIAMETER);
	}
}
