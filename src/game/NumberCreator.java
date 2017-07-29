package game;

public class NumberCreator {
	
	// Singleton pattern
	private static NumberCreator instance = new NumberCreator();
	public static NumberCreator getCreator() {
		return instance;
	}
	
	private NumberCreator() {
		
	}
	
	private int number;
	public synchronized int createNumber() { // multithread
		number++;
		return number;
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
