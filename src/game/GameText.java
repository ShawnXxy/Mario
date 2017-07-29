package game;

import java.awt.Color;
import java.awt.Point;

import com.rupeng.game.GameCore;

public class GameText extends GameObj {

	private int number;
	private String text;
	public GameText(String text) {
		this.number = NumberCreator.getCreator().createNumber();
		GameCore.createText(this.number, text);
	}
	// Overload
	public GameText() {
		this("");
	}
	
	public void setText(String text) {
		GameCore.setText(this.number, text);
		this.text = text;
	}
	
	public String setText() {
		return this.text;
	}
	
	public void setFontSize(int fontSize) {
		GameCore.setTextFontSize(this.number, fontSize);
	}
	
	public void setColor (Color color) {
		GameCore.setTextColor(this.number, color);
	}

	@Override
	public void hide() {
		// TODO Auto-generated method stub
		GameCore.hideText(this.number);
	}

	@Override
	public void show() {
		// TODO Auto-generated method stub
		GameCore.showText(this.number);
	}

	@Override
	public Point getPosition() {
		// TODO Auto-generated method stub
		return GameCore.getTextPosition(this.number);
	}

	@Override
	public void setPosition(int x, int y) {
		// TODO Auto-generated method stub
		GameCore.setTextPosition(this.number, x, y);
	}
	
	
}
