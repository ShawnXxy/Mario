import com.rupeng.game.GameCore;


public class Test implements Runnable {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		GameCore.start(new Test());
	}

	@Override
	public void run() {
		// TODO Auto-generated method stub
		GameCore.setGameTitle("TEST");
		GameCore.pause(2000);
	}

}
