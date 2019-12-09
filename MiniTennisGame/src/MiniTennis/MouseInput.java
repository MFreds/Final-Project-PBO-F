package MiniTennis;

import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.MouseMotionListener;

import javafx.scene.paint.Color;

public class MouseInput implements MouseListener{

	
	@Override
	public void mouseClicked(MouseEvent arg0) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mouseEntered(MouseEvent arg0) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mouseExited(MouseEvent arg0) {
		// TODO Auto-generated method stub
		
	}
	
	public void mousePressed(MouseEvent e) {
		int mx = e.getX();
		int my = e.getY();
/*	public Rectangle playButton = new Rectangle(320,250,100,50);
	public Rectangle quitButton = new Rectangle(320,350,100,50);*/
		if(Game.State == Game.STATE.MENU) {
			//Play Button
			if(mx >= 280 && mx <= 380) {
				if(my >= 250 && my <= 300) {
					//Pressed Play Button
					Game.State = Game.STATE.GAME;
					Sound.BACK.play();
				}
			}
			//Quit Button
			if(mx >= 280 && mx <= 380) {
				if(my >= 350 && my <= 400) {
					//Pressed Quit Button
					System.exit(1);
				}
			}
		}
	}

	@Override
	public void mouseReleased(MouseEvent arg0) {
		// TODO Auto-generated method stub
		
	}

}
