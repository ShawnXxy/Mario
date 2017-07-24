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
		GameCore.loadBgView("background.png");
		/**********************
		 * Setting game window
		 **************************/
		GameCore.setGameTitle("Mario Getting Coins");
		Dimension gameWindow = GameCore.getGameSize();
		int gameWidth = gameWindow.width;
		int gameHeight = gameWindow.height - 20; // 20 is the height of window title block
		
		/*********************
		 * Setting coins randomly
		 ************************/
		int[] coinX = new int[10];
		int[] coinY = new int[10];
		for (int i = 0; i < 10; i++) {
			int randomX = GameCore.rand(3, 800);
			int randomY = GameCore.rand(5, 600);
			coinX[i] = randomX;
			coinY[i] = randomY;
		}
		// check coin's status
		boolean[] coinIsCollected = new boolean[8];
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
		
		/********************
		 *  Setting bombs
		 ***********************/
		int[] bombsX = new int[10];
		int[] bombsY = new int[10];
		for (int i = 0; i < 10; i++) {
			int randomX = GameCore.rand(6, 600);
			int randomY = GameCore.rand(10, 700);
			bombsX[i] = randomX;
			bombsY[i] = randomY;
		}
		int[] bombs = {11, 12, 13, 14, 15};
		for (int i = 0; i < bombs.length; i++) {
			int bomb = bombs[i];
			GameCore.createSprite(bomb, "bomb");
			int x = bombsX[i];
			int y = bombsY[i];
			GameCore.setSpritePosition(bomb, x, y);
			GameCore.playSpriteAnimate(bomb, "fire", true);
		}
		
		/************************
		 * seting coin/score board
		 **************************/
		int coinCollection = 0;
		int coinText = 0;
		GameCore.createImage(coinCollection, "coin.png");
		GameCore.setImagePosition(coinCollection, 800, 0);
		GameCore.createText(coinText, " x0");
		GameCore.setTextFontSize(coinText, 40);
		GameCore.setTextColor(coinText, Color.yellow);
		GameCore.setTextPosition(coinText, 840, 0);
		
		/*********************
		 * Setting Mario
		 ************************/
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
			
			// check if coin is collected by Mario
			for (int i = 0; i < coinNum.length; i++) {
				int cur = coinNum[i];
				boolean isEaten = coinIsCollected[i];
				if (isEaten) {
					continue;
				}
				// get coin image size
				int coinx = coinX[i];
				int coiny= coinY[i];
				Dimension coinSize = GameCore.getSpriteSize(cur);
				int coinWidth = coinSize.width;
				int coinHeight = coinSize.height;
				// get coin coordinate
				int coinCenterX = coinx + coinWidth / 2;
				int coinCenterY = coiny + coinHeight / 2;
				//get Mario coordinate
				int marioCenterX = marioX + marioWidth / 2;
				int marioCenterY = marioY + marioWidth / 2;
				// calculate distance between Mario and coin 
				double distance = Math.pow((coinCenterX - marioCenterX)  * (coinCenterX - marioCenterX) +  (coinCenterY - marioCenterY) * (coinCenterY - marioCenterY), 0.5);
				if (distance < 15) {
					GameCore.hideSprite(cur); // hide eaten coins
					coinIsCollected[i] = true;
					// update score and how many coins collected
					int eatenCoins = 0;
					for (int j = 0; j < coinIsCollected.length; j++) {
						if (coinIsCollected[j]) {
							eatenCoins++;
						}
					}
					GameCore.setText(coinText, "x" +  eatenCoins);
				}
			}
			
			// check if got bombs
			for (int i = 0; i < bombs.length; i++) {
				int bomb = bombs[i];
				int x = bombsX[i];
				int y = bombsY[i];
				// get bomb size
				Dimension bombSize = GameCore.getSpriteSize(bomb);
				int bombWidth = bombSize.width;
				int bombHeight = bombSize.height;
				// get bomb coordinates
				int bombCenterX = x + bombWidth / 2;
				int bombCenterY = y + bombHeight / 2;
				//get Mario coordinate
				int marioCenterX = marioX + marioWidth / 2;
				int marioCenterY = marioY + marioWidth / 2;
				// calculate distance between Mario and coin 
				double distance = Math.pow((x - marioCenterX)  * (x - marioCenterX) +  (y - marioCenterY) * (y - marioCenterY), 0.5);
				if (distance < 15) {
					GameCore.exit();
				}
			}
			GameCore.pause(10);
		}
		
	}

}
