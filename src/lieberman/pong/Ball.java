package lieberman.pong;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Rectangle;

public class Ball {
	int x, y;
	int speed = 2;
	int speedX;
	int speedY;
	int size = 16;

	Rectangle box;

	public Ball(int x, int y) {
		this.x = x;
		this.y = y;

		speedX = speed;
		speedY = speed;

		box = new Rectangle(x, y, size, size);
		box.setBounds(this.x, this.y, this.size, this.size); // box around for
																// collision
																// bounds

	}

	public void tick(GameMain game) {
		box.setBounds(x, y, size, size);

		if (x <= 0) { // left edge
			game.p2Score++;
			speedX = speed; // moves to right

		} else if (x + size >= game.getWidth()) { // right edge
			game.p1Score++;
			speedX = -speed; // moves to left
		}

		if (y <= 0) {
			speedY = speed;
		} else if (y + size >= game.getHeight()) {
			speedY = -speed;

		}

		x += speedX;
		y += speedY;

		collision(game);
	}

	private void collision(GameMain game) {
		if (box.intersects(game.player1.box)) {
			speedX = speed;
		} else if (box.intersects(game.player2.box)) {
			speedX = -speed;
		}
	}

	public void render(Graphics g) {
		g.setColor(Color.YELLOW);
		g.fillOval(x, y, size, size);
	}
}
