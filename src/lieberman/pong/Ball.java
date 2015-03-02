package lieberman.pong;

import java.awt.Color;
import java.awt.Graphics;

public class Ball {
	int x, y;
	int speed = 2;
	int speedX;
	int speedY;
	int size = 16;

	public Ball(int x, int y) {
		this.x = x;
		this.y = y;

		speedX = speed;
		speedY = speed;

	}

	public void tick(GameMain game) {

		if (x <= 0) { // left edge
			speedX = speed; //moves to right
		} else if (x + size >= game.getWidth()) { //right edge
			speedX = -speed; //moves to left
		}

		if (y <= 0) {
			speedY = speed;
		} else if (y + size >= game.getHeight()) {
			speedY = -speed;
		}

		x += speedX;
		x += speedY;
	}

	public void render(Graphics g) {
		g.setColor(Color.RED);
		g.fillOval(x, y, size, size);
	}
}
