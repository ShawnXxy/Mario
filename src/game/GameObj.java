package game;

import java.awt.Point;

import com.rupeng.game.GameCore;

public abstract class GameObj {
	
	public abstract void hide();
	public abstract void show();
	public abstract Point getPosition();
	public abstract void setPosition(int x, int y);
	
	public void moveRight() {
		Point position = this.getPosition(); // this.getPosition()
		int x = position.x;
		int y = position.y;
		x++;
		this.setPosition(x, y); // this.setPostion()
		GameCore.pause(5);
	}
	public void moveLeft() {
		Point position = this.getPosition(); // this.getPosition()
		int x = position.x;
		int y = position.y;
		x--;
		this.setPosition(x, y); // this.setPostion()
		GameCore.pause(5);
	}
	public void moveUp() {
		Point position = this.getPosition(); // this.getPosition()
		int x = position.x;
		int y = position.y;
		y--;
		this.setPosition(x, y); // this.setPostion()
		GameCore.pause(5);
	}
	public void moveDown() {
		Point position = this.getPosition(); // this.getPosition()
		int x = position.x;
		int y = position.y;
		y++;
		this.setPosition(x, y); // this.setPostion()
		GameCore.pause(5);
	}
	
}
