package lieberman.paint;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JColorChooser;
import javax.swing.JFrame;

public class PaintFrame extends JFrame {

	private BrushListener drawListener;
	private BrushListener rectListener;
	private JColorChooser colorChooser;
	private JButton colorButton;
	private ModeButton drawButton;
	private ModeButton rectButton;

	public PaintFrame() {
		setTitle("Paint");
		setSize(800, 600);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setLayout(new BorderLayout());

		final Canvas canvas = new Canvas(600, 600);
		add(canvas, BorderLayout.CENTER);
		drawListener = new DrawListener(canvas);
		rectListener = new RectangleListener(canvas);
		
		
		//canvas.addMouseListener(rectListener);
		//canvas.addMouseMotionListener(rectListener);
		
	
		
		ActionListener actionListener = new ActionListener(){

			@Override
			public void actionPerformed(ActionEvent event) {
				ModeButton button = (ModeButton) event.getSource();
				BrushListener listener = button.getListener();
				canvas.addMouseListener(listener);
				canvas.addMouseMotionListener(listener);
				
			}
			
		};
		
		rectButton = new ModeButton(rectListener);
		rectButton.addActionListener(actionListener);
		drawButton = new ModeButton(drawListener);
		drawButton.addActionListener(actionListener);
		

	

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
