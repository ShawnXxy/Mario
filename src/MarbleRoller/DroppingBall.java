package MarbleRoller;

import com.rupeng.game.GameCore;

public class DroppingBall implements Runnable {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		GameCore.start(new DroppingBall());
	}

	@Override
	public void run() {
		// TODO Auto-generated method stub
		
		int ball = 0;
		GameCore.createSprite(ball, "ball1");
		GameCore.playSpriteAnimate(ball, "rotate", true);
		GameCore.setSpritePosition(ball, 100, 0);
		// ball dropping
		// s = 1 / 2 * at^2
		double v = 0; // velocity
		double t = 0.5; // time = 0.5 second
		double y = 0; // y - axis
		for (;;) {
			v = v + 0.5 * 9.8 * t * t; // 9.8 represents gravity acceleration
			y = y + v * t; 
			if (y >= 300) { // 300 is height of  window
				v = -v; // bouncing
			}
			System.out.println("v=" + v + ", y = " + y);
			GameCore.setSpritePosition(ball, 100, (int) y);
			GameCore.pause(20);
		}
	}

}
