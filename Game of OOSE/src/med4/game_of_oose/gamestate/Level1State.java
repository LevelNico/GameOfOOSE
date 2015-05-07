package med4.game_of_oose.gamestate;

import java.awt.Graphics;

import med4.game_of_oose.entities.Player;
import med4.game_of_oose.main.ApplicationPanel;
import med4.game_of_oose.mapping.Map;
import med4.game_of_oose.resources.Images;
//import med4.game_of_oose.objects.Block;

public class Level1State extends ApplicationState {
	
	private Player player;
	private Map map;
	private int backPosX = 0;
	private int backPosY = 0;
	private int varX = 200;
	private int varY = 100;
	
	public Level1State(ApplicationStateManager asm) {
		super(asm);
	}

	
	public void init() {
		player = new Player(30, 30);
		map = new Map("/Maps/map1.map");
		
		xOffset =- 200;
		yOffset =- 400;
	}

	
	public void tick() {
		player.tick(map.getBlocks(), map.getMovingBlocks());
		map.tick();
	}

	
	public void draw(Graphics g){
		g.clearRect(0, 0, ApplicationPanel.WIDTH, ApplicationPanel.HEIGHT);
		backPosX = varX - (int)xOffset / 2;
		backPosY = varY - (int)yOffset / 8;
		if(backPosX + ApplicationPanel.WIDTH <= 0){
			backPosX += ApplicationPanel.WIDTH;
			//g.drawImage(Images.backs[0], backPosX + ApplicationPanel.WIDTH, backPosY, ApplicationPanel.WIDTH, ApplicationPanel.HEIGHT, null);
		}
		if(backPosX - ApplicationPanel.WIDTH >= 0){
			backPosX -= ApplicationPanel.WIDTH;
			//g.drawImage(Images.backs[0], backPosX - ApplicationPanel.WIDTH , backPosY, ApplicationPanel.WIDTH, ApplicationPanel.HEIGHT, null);
		}
		g.drawImage(Images.backs[0], backPosX, backPosY, ApplicationPanel.WIDTH, ApplicationPanel.HEIGHT, null);
		g.drawImage(Images.backs[0], backPosX + ApplicationPanel.WIDTH, backPosY, ApplicationPanel.WIDTH, ApplicationPanel.HEIGHT, null);
		g.drawImage(Images.backs[0], backPosX - ApplicationPanel.WIDTH , backPosY, ApplicationPanel.WIDTH, ApplicationPanel.HEIGHT, null);
		player.draw(g);
		map.draw(g);
	}

	
	public void keyPressed(int k) {
		player.keyPressed(k);
	}

	
	public void keyReleased(int k) {
		player.keyReleased(k);
	}

}
