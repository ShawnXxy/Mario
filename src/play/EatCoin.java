package play;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Point;
import java.awt.event.KeyEvent;

import com.rupeng.game.GameCore;

public class EatCoin implements Runnable {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		GameCore.start(new EatCoin());
	}

	@Override
	public void run() {
		// TODO Auto-generated method stub
		
		// Setting game window
		GameCore.setGameTitle("Mario Getting Coins");
		Dimension gameWindow = GameCore.getGameSize();
		int gameWidth = gameWindow.width;
		int gameHeight = gameWindow.height - 20; // 20 is the height of window title block
		
		// Setting coins randomly
		int[] coinX = {50, 90, 210, 300, 320, 350, 400, 180};
		int[] coinY = {50, 100, 80, 2, 140, 55, 190, 360};
		// check coin's status
		boolean[] coinExists = new boolean[8];
		// create coins
		int[] coinNum = {1, 2, 3, 4, 5, 6, 7, 8};
		for (int i = 0; i < coinNum.length; i++) {
			int cur = coinNum[i];
			GameCore.createSprite(cur, "coin");
			int x = coinX[i];
			int y = coinY[i];
			GameCore.setSpritePosition(cur, x, y);
			GameCore.playSpriteAnimate(cur, "rotate", true);
		}
		
		// seting coin/score board
		int coinCollection = 0;
		int coinText = 0;
		GameCore.createImage(coinCollection, "coin.png");
		GameCore.setImagePosition(coinCollection, 800, 0);
		GameCore.createText(coinText, " x0");
		GameCore.setTextFontSize(coinText, 40);
		GameCore.setTextColor(coinText, Color.yellow);
		GameCore.setTextPosition(coinText, 840, 0);
		
		// Setting Mario
		int mario = 0;
		GameCore.createSprite(mario, "mario");
		GameCore.setSpritePosition(mario, 0, 0);
		GameCore.setSpriteFlipX(mario, true);
		GameCore.playSpriteAnimate(mario, "walk", true);
		// Getting sprites size
		Dimension marioSize = GameCore.getSpriteSize(mario);
		int marioWidth = marioSize.width;
		int marioHeight = marioSize.height;
		
		while (true) {
			int keyCode = GameCore.getPressedKeyCode();
			Point marioPos = GameCore.getSpritePosition(mario); // get current position
			int marioX = marioPos.x;
			int marioY = marioPos.y;
			// Control Mario to move
			if (keyCode == KeyEvent.VK_LEFT || keyCode == KeyEvent.VK_A) {
				if (marioX > 0) { // check is running out of window
					GameCore.setSpriteFlipX(mario, false);
					marioX--;
					GameCore.setSpritePosition(mario, marioX, marioY);
				}
			} else if (keyCode == KeyEvent.VK_RIGHT || keyCode == KeyEvent.VK_D) {
				if (marioX < gameWidth - marioWidth) {
					GameCore.setSpriteFlipX(mario, true);
					marioX++;
					GameCore.setSpritePosition(mario, marioX, marioY);
				}
			} else if (keyCode == KeyEvent.VK_UP|| keyCode == KeyEvent.VK_W) {
				if (marioY > 0) {
					marioY--;
					GameCore.setSpritePosition(mario, marioX, marioY);
				}
			} else if (keyCode == KeyEvent.VK_DOWN || keyCode == KeyEvent.VK_S) {
				if (marioY < gameHeight - marioHeight) {
					marioY++;
					GameCore.setSpritePosition(mario, marioX, marioY);
				}
			}
			GameCore.pause(10);
		}
		
	}

}
