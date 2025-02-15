package med4.game_of_oose.gamestate;

import java.awt.Graphics;

import med4.game_of_oose.entities.Player;
import med4.game_of_oose.main.ApplicationPanel;
import med4.game_of_oose.mapping.Map;
import med4.game_of_oose.resources.Images;
//import med4.game_of_oose.objects.Block;

public class Level2State extends ApplicationState {


	private Player player;
	private Map map;
	private int varX = 200;
	private int varY = 200;
	private int backX1 = 0;
	private int backY1 = 0;
	private int backX2 = 0;
	private int backY2 = 0;
	private int backPosX1 = 0;
	private int backPosY1 = 0;
	private int backPosX2 = varX;
	private int backPosY2 = varY;
	private int backPosX3 = varX;
	private int backPosY3 = varY;
	
	public static int level2XSpawn = -200;
	public static int level2YSpawn = -800;
	
	
	public Level2State(ApplicationStateManager asm) {
		super(asm);
	}

	
	public void init() {
		player = new Player(30, 30);
		map = new Map("/Maps/map2.map");
		
		xOffset = level2XSpawn;
		yOffset = level2YSpawn;
		level = 2;
	}

	
	public void tick() {
		player.tick(map.getBlocks(), map.getMovingBlocks(), map.getBasicEnemies());
		map.tick();
		if (player.dead){
			asm.states.push(new GameOverState(asm));
		}
		if (player.goal){
			asm.states.push(new WinState(asm));
		}
	}

	
	public void draw(Graphics g){
		g.clearRect(0, 0, ApplicationPanel.WIDTH, ApplicationPanel.HEIGHT);
		
		g.drawImage(Images.backs[0], backPosX1, backPosY1, ApplicationPanel.WIDTH, ApplicationPanel.HEIGHT, null);
		
		backPosX2 = backX1 - (int)(xOffset / 1.5);
		backPosY2 = backY1 - (int)yOffset / 10;
		if((int)xOffset / 1.5 > backX1 + ApplicationPanel.WIDTH){
			backX1 += ApplicationPanel.WIDTH;
		}
		if((int)xOffset / 1.5 < backX1 - ApplicationPanel.WIDTH){
			backX1 -= ApplicationPanel.WIDTH;
		}
		g.drawImage(Images.backs[1], backPosX2, backPosY2, ApplicationPanel.WIDTH, ApplicationPanel.HEIGHT, null);
		g.drawImage(Images.backs[1], backPosX2 + ApplicationPanel.WIDTH, backPosY2, ApplicationPanel.WIDTH, ApplicationPanel.HEIGHT, null);
		g.drawImage(Images.backs[1], backPosX2 - ApplicationPanel.WIDTH , backPosY2, ApplicationPanel.WIDTH, ApplicationPanel.HEIGHT, null);
		
		backPosX3 = backX2 - (int)(xOffset / 1.25);
		backPosY3 = backY2 - (int)yOffset / 8;
		if((int)xOffset / 1.25 > backX2 + ApplicationPanel.WIDTH){
			backX2 += ApplicationPanel.WIDTH;
		}
		if((int)xOffset / 1.25 < backX2 - ApplicationPanel.WIDTH){
			backX2 -= ApplicationPanel.WIDTH;
		}
		g.drawImage(Images.backs[2], backPosX3, backPosY3, ApplicationPanel.WIDTH, ApplicationPanel.HEIGHT, null);
		g.drawImage(Images.backs[2], backPosX3 + ApplicationPanel.WIDTH, backPosY3, ApplicationPanel.WIDTH, ApplicationPanel.HEIGHT, null);
		g.drawImage(Images.backs[2], backPosX3 - ApplicationPanel.WIDTH , backPosY3, ApplicationPanel.WIDTH, ApplicationPanel.HEIGHT, null);
		
		
		player.draw(g);
		map.draw(g);
	}

	
	public void keyPressed(int k) {
		player.keyPressed(k);
	}

	
	public void keyReleased(int k) {
		player.keyReleased(k);
	}
	
	
	public void Death(){
		if (player.dead){
			asm.states.push(new GameOverState(asm));
		}
	}
	

}
