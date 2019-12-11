package MiniTennis;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.RenderingHints;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.Image;
import java.awt.Toolkit;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;

@SuppressWarnings("serial")
public class Game extends JPanel {
	
	Image img = Toolkit.getDefaultToolkit().getImage("src/resources/hh.jpg");
	Image img1 = Toolkit.getDefaultToolkit().getImage("src/resources/bb.png");

	Ball ball = new Ball(this);
	Racquet racquet = new Racquet(this);
	int speed = 3;
	int score = 0;
	
	private Menu menu = new Menu(this);
	
	private int getScore() {
		return score ;
	}

	public static  enum STATE{ // Membuat 2 keadaan, yaitu menu dan game
		MENU,GAME
	};
	
	public static STATE State = STATE.MENU;
	
	public Game() {
		this.addMouseListener(new MouseInput());
		addKeyListener(new KeyListener() {
			@Override
			public void keyTyped(KeyEvent e) {
			}

			@Override
			public void keyReleased(KeyEvent e) {
				racquet.keyReleased(e);
			}

			@Override
			public void keyPressed(KeyEvent e) {
				racquet.keyPressed(e);
			}
		});
		setFocusable(true);
		if(State == STATE.GAME) {
			Sound.BACK.loop();
		}
		
	}
	private void move() {
		if(State == STATE.GAME) { // jika keadaan = game
		ball.move();
		racquet.move();
	}
	}
	
	

	@Override
	public void paint(Graphics g) {
		super.paint(g); // supaya bolanya tetep jadi bola
		Graphics2D g2d = (Graphics2D) g;
		
		g2d.drawImage(img1, 0, 0, null);
		
		if(State == STATE.GAME) {
		g2d.setRenderingHint(RenderingHints.KEY_ANTIALIASING,
				RenderingHints.VALUE_ANTIALIAS_ON); // memperhalus bentuk bola
		ball.paint(g2d);
		racquet.paint(g2d);

		g2d.setColor(Color.BLUE);
		g2d.setFont(new Font("Verdana", Font.BOLD, 30));
		g2d.drawString(String.valueOf(getScore()), 10, 30);
		}
		
		else if(State == STATE.MENU) {
			g2d.drawImage(img, 0, 0, null);
			menu.render(g2d);
			
		}
	}

	public void gameOver() {
		Sound.BACK.stop();
		Sound.GAMEOVER.play();
		JOptionPane.showMessageDialog(this, "your score is: " + getScore(),
				"Game Over", JOptionPane.YES_NO_OPTION);
		System.exit(ABORT);
	}

	public static void main(String[] args) throws InterruptedException {
		JFrame frame = new JFrame("Mini Tennis");
		Game game = new Game();
		
		frame.add(game);
		frame.setSize(700,800);
		frame.setVisible(true); // supaya windownya muncul
		frame.setResizable(false);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); // supaya programnya berhenti saat window ditutup

		while (true) {
			game.move(); // menambah posisi (x,y)
			game.repaint();
			Thread.sleep(10);
		}
	}
}
