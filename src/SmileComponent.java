//package lieberman.smile;

import java.awt.Color;
import java.awt.Graphics;

import javax.swing.JComponent;

public class SmileComponent extends JComponent {

	// never call paintComponent!! (the JVM does)
	@Override
	protected void paintComponent(Graphics g) {
		 //boolean wink = false;
		super.paintComponent(g);

		g.setColor(Color.YELLOW);
		g.fillOval(200, 100, 320, 400); // face
		
		g.setColor(Color.RED);
		g.drawArc(250, 300, 200, 150, 0, -180); // smile

		g.setColor(Color.GREEN);
		g.fillOval(250, 200, 50, 50); // right eye

		 //if (wink){
		 //g.setColor(Color.BLACK);
		 //g.drawArc - eyelid
		 //}
		 //else {

		g.fillOval(375, 200, 50, 50); // left eye
		
		 //wink = true; }

	}

}
