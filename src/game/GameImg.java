package game;

import java.awt.Dimension;
import java.awt.Point;

import com.rupeng.game.GameCore;

public class GameImg extends GameRect {
	
	private int number;
	public GameImg (String imgName) {
		this.number = NumberCreator.getCreator().createNumber(); 
		GameCore.createImage(this.number);
	}
	//Overload
	public GameImg() {
		this("");
	}

	public void setImgName (String imgName) {
		GameCore.setImageSource(this.number, imgName);
	}
	
	@Override
	public Dimension getSize() {
		return GameCore.getImageSize(this.number);
	}
	
	@Override
	public void hide() {
		// TODO Auto-generated method stub
		GameCore.hideImage(this.number);
	}

	@Override
	public void show() {
		// TODO Auto-generated method stub
		GameCore.showImage(this.number);
	}

	@Override
	public Point getPosition() {
		// TODO Auto-generated method stub
		return GameCore.getImagePosition(this.number);
	}

	@Override
	public void setPosition(int x, int y) {
		// TODO Auto-generated method stub
		GameCore.setImagePosition(this.number, x, y);
	}

}
