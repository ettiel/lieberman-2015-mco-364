package lieberman.paint;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JColorChooser;
import javax.swing.JFrame;

public class PaintFrame extends JFrame {

	private DrawListener drawListener;
	private RectangleListener rectListener;
	private JColorChooser colorChooser;
	private JButton colorButton;
	private JButton drawButton;
	private JButton rectButton;

	public PaintFrame() {
		setTitle("Paint");
		setSize(800, 600);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setLayout(new BorderLayout());

		final Canvas canvas = new Canvas(600, 600);
		add(canvas, BorderLayout.CENTER);
		final DrawListener listener = new DrawListener(canvas);
		final RectangleListener rectListener = new RectangleListener(canvas);

		drawButton = new JButton("free draw");
		drawButton.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent arg0) {

				canvas.addMouseListener(listener);
				canvas.addMouseMotionListener(listener);
				canvas.removeMouseListener(rectListener);
				canvas.removeMouseMotionListener(rectListener);
				// TODO Auto-generated method stub

			}

		});
		rectButton = new JButton("rectangle");
		rectButton.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub

				canvas.addMouseListener(rectListener);
				canvas.addMouseMotionListener(rectListener);
				canvas.removeMouseListener(listener);
				canvas.removeMouseMotionListener(listener);

			}

		});

		colorButton = new JButton("color");
		colorButton.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				Color color = JColorChooser.showDialog(canvas, "color",
						Color.BLACK);

				if (color != null) {
					canvas.setColor(color);
				}
			}

		});

		canvas.add(drawButton);
		canvas.add(rectButton);
		canvas.add(colorButton);

	}

	public static void main(String[] args) {
		PaintFrame paintWindow = new PaintFrame();
		paintWindow.setVisible(true);
	}

}
