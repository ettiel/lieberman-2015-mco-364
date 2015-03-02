package lieberman.pong;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Rectangle;

public class PlayerPiece2 {
	int x; 
	int y; 
	int width = 15;
	int height = 45;

	Rectangle box;
	
	boolean up = false;
	boolean down = false;

	public PlayerPiece2(int x, int y) {
		this.x = x;
		this.y = y;
		box = new Rectangle(x, y, width, height);
		box.setBounds(x, y, width, height); //box around for collision bounds
	}

	public void tick(GameMain game) {
		box.setBounds(x, y, width, height); 
		if (up && y >= 0) {
			y--;
		}
		if (down && y < game.getHeight()  - height) {
			y++;
		}
	}

	public void draw(Graphics g) {
		g.setColor(Color.MAGENTA);
		g.fillRect(x, y, width, height);
	}
}
