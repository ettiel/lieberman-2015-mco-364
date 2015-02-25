package lieberman.snake;


import java.awt.Color;
import java.awt.Graphics;
import java.awt.Point;

public class Food {

	private Point food;
	

	public Food() {
		food = new Point(10,10);
	}



	public Point getFoodPoint() {
		return food;
	}

	public void setFoodPoint(Point food) {
		this.food = food;
	}

}
