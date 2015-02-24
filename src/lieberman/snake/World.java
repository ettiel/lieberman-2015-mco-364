package lieberman.snake;

import java.awt.Point;
import java.util.ArrayList;
import java.util.LinkedList;

public class World { //holds all the game objects

	Snake snake;
	Food food;
	
	
	public World(){
		snake = new Snake();
		food = new Food();
	}


	public Snake getSnake() {
		return snake;
	}


	public Food getFood() {
		return food;
	}

	
	
}