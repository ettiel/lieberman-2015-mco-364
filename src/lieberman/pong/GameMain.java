package lieberman.pong;

import java.awt.BorderLayout;
import java.awt.Canvas;
import java.awt.Dimension;

import javax.swing.JFrame;

public class GameMain extends Canvas implements Runnable {

	JFrame frame;
	public final int WIDTH = 400;
	public final int HEIGHT = WIDTH / 9 * 16;
	public final Dimension gameSize = new Dimension(WIDTH, HEIGHT);

	boolean gameRunning = false;

	@Override
	public void run() {
		while (gameRunning) {
			
		}
	}

	public GameMain() {
		frame = new JFrame();
		setMinimumSize(gameSize);
		setPreferredSize(gameSize);
		setMaximumSize(gameSize);

		frame.add(this, BorderLayout.CENTER);
		frame.pack();
		
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setVisible(true);
		frame.setResizable(false);
		frame.setTitle("PONG");

	}

	public static void main(String[] args) {
		GameMain game = new GameMain();
	}

}

