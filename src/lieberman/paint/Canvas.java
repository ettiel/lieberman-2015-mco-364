package lieberman.paint;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.image.BufferedImage;

import javax.swing.JPanel;

public class Canvas extends JPanel {

	private BufferedImage image;
	private Color color = Color.black;

	public BufferedImage getImage() {
		return image;
	}

	public Canvas(int width, int height) {
		image = new BufferedImage(width, height, BufferedImage.TYPE_INT_RGB);
		Graphics graphics = image.getGraphics();
		graphics.setColor(Color.WHITE);
		graphics.fillRect(0, 0, width, height);
	}

	@Override
	protected void paintComponent(Graphics g) {
		super.paintComponent(g);
		g.drawImage(image, 0, 0, null);
		
		//listener.draw(g);
	}

	public void setColor(Color color) {
		this.color = color;

	}

	public Color getColor() {
		return color;
	}

}
