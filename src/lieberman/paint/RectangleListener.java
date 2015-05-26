package lieberman.paint;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.MouseMotionListener;

public class RectangleListener extends BrushListener {

	public RectangleListener(Canvas canvas) {
		super(canvas);
		// TODO Auto-generated constructor stub
	}

	@Override
	public void draw(Graphics g) {
		// TODO Auto-generated method stub
		g.drawRect(startX, startY, lastX-startX, lastY-startY);
		
	}

	@Override
	public void drawPreview(Graphics2D g) {
		// TODO Auto-generated method stub
		width = Math.abs(startX - lastX);
		height = Math.abs(startY - lastY);
		Integer x1 = startX < lastX ? startX : lastX;
		Integer y1 = startY < lastY ? startY : lastY;
		g.setColor(canvas.getColor());
		g.drawRect(x1, y1, width, height);
		canvas.repaint();
	}
	

}
