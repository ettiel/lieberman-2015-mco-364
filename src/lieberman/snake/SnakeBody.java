package lieberman.snake;

import java.awt.Color;
import java.awt.Graphics;

public class SnakeBody {

	private int x, y, width, height;

	public SnakeBody(int x, int y, int size) {
		this.x = x;
		this.y = y;
		width = size;
		height = size;
	}

	public int getX() {
		return x;
	}

	public int getY() {
		return y;
	}

	public void tick() {

	}

	public void draw(Graphics g) {
		g.setColor(Color.BLACK);
		g.fillRect(x * width, y * height, width, height);
		g.setColor(Color.GREEN);
		g.fillRect(x * width + 2, y * height + 2, width - 4, height - 4);
	}
}
