package MarbleRoller;

import java.awt.Dimension;

import com.rupeng.game.GameCore;

public class BouncingBall implements Runnable {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		GameCore.start(new BouncingBall());
	}

	@Override
	public void run() {
		// TODO Auto-generated method stub
		
		int ball = 0;
		GameCore.createSprite(ball, "ball1");
		GameCore.playSpriteAnimate(ball, "rotate", true);
		GameCore.setSpritePosition(ball, 100, 0);
		
		int vx = 2; // verlocity at x
		int vy = 1; // verlocity at y
		int t = 2; // time
		Dimension windowSize = GameCore.getGameSize();
		// initial position
		int x = 0;
		int y = 200;
		for (;;) {
			x = x + vx * t;
			y = y + vy * t;
			GameCore.setSpritePosition(ball, x, y);
			GameCore.pause(10);
			// check if hit on edges
			if (x <= 0 || x >= windowSize.width - 20) {
				vx = -vx;
			}
			if (y <= 0 || y >= windowSize.height - 50) {
				vy = -vy;
			}
		}
	}

}
