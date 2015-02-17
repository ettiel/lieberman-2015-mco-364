//package lieberman.smile;

import java.awt.Color;
import java.awt.Graphics;

import javax.swing.JComponent;

public class SmileComponent extends JComponent {

	boolean wink = true;

	// never call paintComponent!! (the JVM does)
	@Override
	protected void paintComponent(Graphics g) {

		super.paintComponent(g);

		g.setColor(Color.YELLOW);
		g.fillOval(this.getX() + 150, this.getY() + 150, this.getWidth() / 2,
				this.getHeight() / 2); // face

		g.setColor(Color.RED);
		g.drawArc(this.getX() + 250, this.getY() + 250, this.getWidth() / 4,
				this.getHeight() / 4, 0, -180); // smile

		g.setColor(Color.GREEN);
		g.fillOval(this.getX() + 250, this.getY() + 200, this.getWidth() / 10,
				this.getHeight() / 10); // right eye
		g.fillOval(this.getX() + 355, this.getY() + 200, this.getWidth() / 10,
				this.getHeight() / 10); // left eye

		if (wink) {
			g.setColor(Color.YELLOW);
			g.fillOval(this.getX() + 355, this.getY() + 200,
					this.getWidth() / 10, this.getHeight() / 10);
			g.setColor(Color.BLACK);
			g.drawArc(this.getX() + 355, this.getY() + 200,
					this.getWidth() / 10, this.getHeight() / 10, 0, -180);
			wink = false;

		} else {
			wink = true;
		}

	}

}
