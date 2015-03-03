package lieberman.snake;

import java.util.ArrayList;

public class Snake {
	private ArrayList<SnakeBody> snake;
	
	public Snake(){
		snake = new ArrayList<SnakeBody>();
	}

	public ArrayList<SnakeBody> getSnake() {
		return snake;
	}
	
}
