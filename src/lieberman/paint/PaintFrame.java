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
	private JColorChooser colorChooser;
	private JButton colorButton;

	public PaintFrame() {
		setTitle("Paint");
		setSize(800, 600);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setLayout(new BorderLayout());

		final Canvas canvas = new Canvas(600, 600);
		add(canvas, BorderLayout.CENTER);

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
		
		canvas.add(colorButton);

		DrawListener listener = new DrawListener(canvas);
		canvas.addMouseListener(listener);
		canvas.addMouseMotionListener(listener);
	}

	public static void main(String[] args) {
		PaintFrame paintWindow = new PaintFrame();
		paintWindow.setVisible(true);
	}

}
