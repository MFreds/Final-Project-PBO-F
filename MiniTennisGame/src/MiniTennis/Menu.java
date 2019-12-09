package MiniTennis;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Rectangle;

public class Menu {
	
	public Rectangle playButton = new Rectangle(280,250,100,50);
	public Rectangle quitButton = new Rectangle(280,350,100,50);
	private Game game;

	public Menu(Game game) {
		this.game = game;
	}

	public void render(Graphics g) {
		Graphics2D g2d = (Graphics2D) g;
		
		Font fnt0 = new Font("calibri",Font.BOLD, 100);
		g.setFont(fnt0);
		g.setColor(Color.BLACK);
		g.drawString("MINI TENNIS",game.getWidth()/2, 100);
		
		Font fnt1 = new Font("arial", Font.BOLD, 30);
		g.setFont(fnt1);
		g.drawString("Play", playButton.x + 19, playButton.y + 30);
		g2d.draw(playButton);
		g.drawString("Quit", quitButton.x + 19, quitButton.y + 30);
		g2d.draw(quitButton); 
	}
}
