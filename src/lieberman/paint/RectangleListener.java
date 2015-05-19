package lieberman.paint;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.MouseMotionListener;

public class RectangleListener implements MouseListener, MouseMotionListener {

	private Canvas canvas;
	private int lastX;
	private int lastY;
	private int startX, startY, width, height;

	public RectangleListener(Canvas canvas) {
		this.canvas = canvas;
	}

	@Override
	public void mouseClicked(MouseEvent event) {

	}

	@Override
	public void mouseEntered(MouseEvent event) {
		// TODO Auto-generated method stub

	}

	@Override
	public void mouseExited(MouseEvent event) {
		// TODO Auto-generated method stub

	}

	@Override
	public void mousePressed(MouseEvent event) {

		// TODO Auto-generated method stub
		startX = event.getX();
		startY = event.getY();
		lastX = startX;
		lastY = startY;

	}

	@Override
	public void mouseReleased(MouseEvent event) {
		// TODO Auto-generated method stub
		lastX = event.getX();
		lastY = event.getY();
		width = Math.abs(startX - lastX);
		height = Math.abs(startY - lastY);
		startX = startX < lastX ? startX: lastX ;
		startY = startY < lastY ? startY: lastY ;
		

		Graphics graphics = canvas.getImage().getGraphics();
		graphics.setColor(canvas.getColor());
		graphics.drawRect(startX, startY, width, height);

		canvas.repaint();

	}

	@Override
	public void mouseDragged(MouseEvent event) {
		lastX = event.getX();
		lastY = event.getY();
		canvas.repaint();
	}

	@Override
	public void mouseMoved(MouseEvent event) {
		// TODO Auto-generated method stub

	}

}
