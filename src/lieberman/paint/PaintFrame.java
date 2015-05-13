package lieberman.paint;

import java.awt.BorderLayout;

import javax.swing.JFrame;

public class PaintFrame extends JFrame{

	private DrawListener drawListener;

	
	public PaintFrame() {
		setTitle("Paint");
		setSize(800, 600);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setLayout(new BorderLayout());

		Canvas canvas = new Canvas(600, 600);
		add(canvas, BorderLayout.CENTER);
		
		DrawListener listener = new DrawListener(canvas);
		canvas.addMouseListener(listener);
		canvas.addMouseMotionListener(listener);
	}
	
	public static void main(String[] args) {
		PaintFrame paintWindow = new PaintFrame();
		paintWindow.setVisible(true);
		}
	
}
