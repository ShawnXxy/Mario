package game;

import java.awt.Dimension;
import java.awt.Point;

import com.rupeng.game.GameCore;

public class GameSprite extends GameRect {
	
	private int number;
	public GameSprite (String spriteName) {
		this.number = NumberCreator.getCreator().createNumber();
		GameCore.createSprite(this.number, spriteName);
	}

	public void playAnimate (String animateName, boolean repeat) {
		GameCore.playSpriteAnimate(this.number, animateName, repeat);
	}
	
	public void playAnimate(String animateName) {
		this.playAnimate(animateName, true);
	}
	
	public void setFlipX(boolean flipX) {
		GameCore.setSpriteFlipX(this.number, flipX);
	}
	public void setFlipY(boolean flipY) {
		GameCore.setSpriteFlipY(this.number, flipY);
	}
	
	@Override
	public Dimension getSize() {
		return GameCore.getSpriteSize(this.number);
	}
	
	@Override
	public void hide() {
		// TODO Auto-generated method stub
		GameCore.hideSprite(this.number);
	}

	@Override
	public void show() {
		// TODO Auto-generated method stub
		GameCore.showSprite(this.number);
	}

	@Override
	public Point getPosition() {
		// TODO Auto-generated method stub
		return GameCore.getSpritePosition(this.number);
	}

	@Override
	public void setPosition(int x, int y) {
		// TODO Auto-generated method stub
		GameCore.setSpritePosition(this.number, x, y);
	}

}
