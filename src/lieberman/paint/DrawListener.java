package lieberman.paint;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.MouseMotionListener;

public class DrawListener extends BrushListener {

	private Canvas canvas;
	private int lastX;
	private int lastY;

	public DrawListener(Canvas canvas) {
		super(canvas);
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
		int x = event.getX();
		int y = event.getY();

		Graphics graphics = canvas.getImage().getGraphics();
		graphics.setColor(canvas.getColor());
		graphics.drawLine(x, y, x, y);
		
		lastX = x;
		lastY = y;
		
		canvas.repaint();
		// TODO Auto-generated method stub

	}

	@Override
	public void mouseReleased(MouseEvent event) {
		// TODO Auto-generated method stub

	}

	@Override
	public void mouseDragged(MouseEvent event) {
		int x = event.getX();
		int y = event.getY();

		Graphics graphics = canvas.getImage().getGraphics();
		graphics.setColor(canvas.getColor());
		graphics.drawLine(lastX, lastY, x, y);
		
		lastX = x;
		lastY = y;
		
		canvas.repaint();
	}

	@Override
	public void mouseMoved(MouseEvent event) {
		// TODO Auto-generated method stub

	}

	@Override
	public void draw(Graphics g) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void drawPreview(Graphics2D g) {
		// TODO Auto-generated method stub
		
	}
	
	

}
