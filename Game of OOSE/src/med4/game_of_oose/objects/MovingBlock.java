package med4.game_of_oose.objects;

import java.awt.Graphics;
import java.awt.Rectangle;

import med4.game_of_oose.gamestate.ApplicationState;
import med4.game_of_oose.resources.Images;

public class MovingBlock extends Rectangle{
	private static final long serialVersionUID = 1L;
	
	private int leftBound, rightBound;
	private int move = 1;
	private int id;
	
	public MovingBlock(int x, int y, int id, int leftBound, int rightBound, int w, int h){
		setBounds(x, y, Block.blockSize*w, Block.blockSize*h);
		this.id = id;
		this.rightBound = rightBound;
		this.leftBound = leftBound;
	}
	
	public void tick(){
		//hits rightBound
		if(x + width - ApplicationState.xOffset >= rightBound - ApplicationState.xOffset && move != -1) {
			move *= -1;
		}
		//hits leftbound
		if(x - ApplicationState.xOffset <= leftBound - ApplicationState.xOffset && move != 1) {
			move *= -1;
		}
		
		x += move;
		
	}
	
	public void draw(Graphics g) {
		if(id != 0) {
			g.drawImage(Images.blocks[id + 8], x - (int)ApplicationState.xOffset, y - (int)ApplicationState.yOffset, width, height, null);
		}
	}
	
	public int getMove(){
		return move;
	}
	
	public int getID(){
		return id;
	}
}
