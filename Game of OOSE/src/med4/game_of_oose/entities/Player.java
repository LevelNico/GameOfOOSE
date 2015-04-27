package med4.game_of_oose.entities;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Rectangle;
import java.awt.event.KeyEvent;

import med4.game_of_oose.main.ApplicationPanel;

public class Player extends Rectangle {
	private static final long serialVersionUID = 1L;
	
	private boolean right = false, left = false;
	
	public Player(int width, int height) {
		setBounds(ApplicationPanel.WIDTH / 2,ApplicationPanel.HEIGHT/2, width, height);
	}
	
	public void tick() {
		if(right){
			x++;
		}
		if(left){
			x--;
		}
	}
	
	public void draw(Graphics g) {
		g.setColor(Color.BLACK);
		g.fillRect(x, y, width, height);
	}
	
	public void keyPressed(int k) {
		if(k == KeyEvent.VK_D) {
			right = true;
			//System.out.print("x is " + x);
		}
		if(k == KeyEvent.VK_A) {
			left = true;
		}
	}
	
	public void keyReleased(int k) {
		if(k == KeyEvent.VK_D) right = false;
		if(k == KeyEvent.VK_A) left = false;
	}
}
