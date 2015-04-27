package med4.game_of_oose;

import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

import javax.swing.JPanel;

public class ApplicationPanel extends JPanel implements Runnable, KeyListener{
	private static final long serialVersionUID = 1L;
	
	public static final int HEIGHT = 600;
	public static final int WIDTH = 800;
	
	private Thread thread;
	private boolean isRunning = false;
	
	private int FPS = 60;
	private long targetTime = 1000/FPS;
	
	public ApplicationPanel(){
		setPreferredSize (new Dimension(WIDTH,HEIGHT));
		
		start();
	}
	
	private void start(){
		isRunning = true;
		thread = new Thread(this);
		thread.start();
	}
	
	public void run(){
		long start, elapsed, wait;
		while(isRunning){
			start = System.nanoTime();
			
			tick();
			repaint();
			
			elapsed = System.nanoTime() - start;
			wait = targetTime - elapsed / 1000000;
			
			if(wait <= 0){
				wait = 5;
			}
			try {
				Thread.sleep(wait);
			} catch(Exception e){
				e.printStackTrace();
			}
		}
	}
	
	public void tick(){
		System.out.println("It runs!");
		
	}
	
	public void paintComponent(Graphics g){
		super.paintComponent(g);
		
		g.drawRect(100, 100, 50, 50);
	}
	

	public void keyPressed(KeyEvent arg0) {
		
		
	}

	public void keyReleased(KeyEvent arg0) {
		
		
	}

	public void keyTyped(KeyEvent arg0) {
		
		
	}
}
