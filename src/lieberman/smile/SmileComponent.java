package lieberman.smile;

import java.awt.Color;
import java.awt.Graphics;

import javax.swing.JComponent;

public class SmileComponent extends JComponent {

	boolean wink = true;

	// never call paintComponent!! (the JVM does)
	@Override
	protected void paintComponent(Graphics g) {

		super.paintComponent(g);

		int width = getWidth();
		int height = getHeight();
		int left = width / 4;
		int top = 100;

		g.setColor(Color.YELLOW);
		g.fillOval(left, top, width / 2, height - height / 4); // face

		g.setColor(Color.RED);
		g.drawArc(left + width / 16, height - height / 2, width / 3, 150, 0,
				-180); // smile

		g.setColor(Color.GREEN);
		g.fillOval(left + width / 16, top + height / 6, width / 8, width / 8); // right
																				// eye
		g.fillOval(left + width / 4, top + height / 6, width / 8, width / 8); // left
																				// eye

		if (wink) {
			g.setColor(Color.YELLOW);
			g.fillOval(left + width / 4, top + height / 6, width / 8, width / 8);
			g.setColor(Color.BLACK);
			g.drawArc(left + width / 4, top + height / 6, width / 8, width / 8,
					0, -180);
			wink = false;

		} else {
			wink = true;
		}

	}

}
