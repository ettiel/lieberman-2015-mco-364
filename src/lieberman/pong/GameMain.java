package lieberman.pong;

import java.awt.BorderLayout;

import java.awt.Dimension;

import javax.swing.JFrame;
import javax.swing.JPanel;

public class GameMain extends JPanel implements Runnable {

	private static final long serialVersionUID = 1L;
	
	JFrame frame;
	public final int WIDTH = 400;
	public final int HEIGHT = 700;
	public final Dimension gameSize = new Dimension(WIDTH, HEIGHT);



	@Override
	public void run() {
		
	}

	public GameMain() {
		frame = new JFrame();
		
		setPreferredSize(gameSize);
		

		frame.add(this, BorderLayout.CENTER);
		frame.pack();
		
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setVisible(true);
		frame.setResizable(false);
		frame.setTitle("PONG");

	}

	public static void main(String[] args) {
		new GameMain();
	}

}
