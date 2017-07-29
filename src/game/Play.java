package game;

import java.awt.event.KeyEvent;

import com.rupeng.game.GameCore;

public class Play implements Runnable {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		GameCore.start(new Play());
	}

	private int score = 0;
	
	@Override
	public void run() {
		// TODO Auto-generated method stub
		
		GameCore.loadBgView("background.png");
		
		/************************
		 * 	generate random coins
		 ************************/
		CoinInfo[] coins = new CoinInfo[10];
		for (int i = 0; i < coins.length; i++) {
			coins[i] = new CoinInfo();
			int x = GameCore.rand(0, 500);
			int y = GameCore.rand(0, 500);
			coins[i].getSprite().setPosition(x, y);
		}
		
		/************************
		 * 	Setting Mario
		 ************************/
		GameSprite mario = new GameSprite("mario");
		mario.setPosition(0, 0);
		mario.playAnimate("walk", true);
		/************************
		 * 	Setting scoreboard
		 ************************/
		GameText textScore = new GameText();
		textScore.setPosition(700, 0);
		
		// move action
		while (true) {
			int keycode = GameCore.getPressedKeyCode();
			switch(keycode) {
				case KeyEvent.VK_LEFT:
					mario.moveLeft();
					mario.setFlipX(false);
					break;
				case KeyEvent.VK_RIGHT:
					mario.moveRight();
					mario.setFlipX(true);
					break;
				case KeyEvent.VK_UP:
					mario.moveUp();
					break;
				case KeyEvent.VK_DOWN:
					mario.moveDown();
					break;	
			}
			// check collision
			for (CoinInfo coin : coins) {
				if (coin.isAlive() && mario.isIntersectWith(coin.getSprite())) {
					coin.setAlive(false);
					coin.getSprite().hide();
					score++;
					textScore.setText(Integer.toString(score));
				}
			}
			
			GameCore.pause(1);
		}
		
	}
}
	
class CoinInfo {
	private boolean isAlive;
	private GameSprite sprite;
	
	public CoinInfo() {
		this.isAlive = true;
		this.sprite = new GameSprite("coin");
		this.sprite.playAnimate("rotate");
	}

	public boolean isAlive() {
		return isAlive;
	}

	public void setAlive(boolean isAlive) {
		this.isAlive = isAlive;
	}

	public GameSprite getSprite() {
		return sprite;
	}

	public void setSprite(GameSprite sprite) {
		this.sprite = sprite;
	}
}
	

