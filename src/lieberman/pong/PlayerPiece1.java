package lieberman.pong;

import java.awt.Color;
import java.awt.Graphics;

public class PlayerPiece1 {
	int x; // horizontal
	int y; // vertical
	int width = 15;
	int height = 45;

	boolean up = false;
	boolean down = false;

	public PlayerPiece1(int x, int y) {
		this.x = x;
		this.y = y;
	}

	public void tick(GameMain game) {
		if (up && y >= 0) {
			y--; // move piece up
		}
		if (down && y < game.getHeight()  - height) {
			y++;
		}
	}

	public void render(Graphics g) {
		g.setColor(Color.GREEN);
		g.fillRect(x, y, width, height);
	}
}
