package lieberman.snakeNew;

import java.awt.Color;
import java.awt.Graphics;

public class Food {

	private int x, y, width, height;

	public Food(int x, int y, int size) {
		this.x = x;
		this.y = y;
		width = size;
		height = size;
	}

	public void tick() {

	}

	public void draw(Graphics g) {
		g.setColor(Color.RED);
		g.fillRect(x * width, y * height, width, height);
	}

	public int getX() {
		return x;
	}

	public int getY() {
		return y;
	}

}
