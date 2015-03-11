package lieberman.pong;

import java.awt.BorderLayout;
import java.awt.Canvas;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.image.BufferStrategy;
import java.awt.image.BufferedImage;

import javax.swing.JFrame;

public class GameMain extends Canvas implements Runnable {

	private static final long serialVersionUID = 1L;

	JFrame frame;
	GameInput GI;
	public final int WIDTH = 400;
	public final int HEIGHT = 225;
	public final Dimension gameSize = new Dimension(WIDTH, HEIGHT);

	BufferedImage image = new BufferedImage(WIDTH, HEIGHT,
			BufferedImage.TYPE_INT_BGR);

	public  PlayerPiece1 player1;
	public  PlayerPiece2 player2;
	public  Ball ball;
	boolean gameRunning = false;

	public PlayerPiece1 getPlayer1() {
		return player1;
	}

	public PlayerPiece2 getPlayer2() {
		return player2;
	}

	public Ball getBall() {
		return ball;
	}

	int p1Score = 0, p2Score = 0;

	@Override
	public void run() {
		while (gameRunning) {
			tick();
			draw();

			try {
				Thread.sleep(7); // slow down piece
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
	}

	public void start() {
		gameRunning = true;
		new Thread(this).start();

	}
	
	public void end() {
		if (ball.getWinner()=="player 1"){
			drawWinner("PLAYER 1");
		}
		if (ball.getWinner()=="player 2"){
			drawWinner("PLAYER 2");
		}
		gameRunning = false;
		try {
			new Thread(this).join();
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
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
		frame.setLocationRelativeTo(null);
		this.requestFocus();
		GI = new GameInput(this);

		player1 = new PlayerPiece1(10, 60);
		player2 = new PlayerPiece2(385, 120);

		ball = new Ball(getWidth() / 2, getHeight() / 2);
	}

	public void tick() {
		player1.tick(this);
		player2.tick(this);
		ball.tick(this);
	}

	public void draw() {
		BufferStrategy bufStr = getBufferStrategy();
		if (bufStr == null) {
			createBufferStrategy(3);
			return;
		}

		Graphics g = bufStr.getDrawGraphics();

		g.setColor(Color.BLACK);
		g.drawImage(image, 0, 0, getWidth(), getHeight(), null);

		g.setColor(Color.BLUE);
		g.drawString("Player 1 SCORE: " + p1Score, 50, 30);
		g.drawString("Player 2 SCORE: " + p2Score, 250, 30);

		player1.draw(g);
		player2.draw(g);
		ball.draw(g);

		g.dispose();
		bufStr.show();

	}

	public void drawWinner(String won) {
		BufferStrategy bufStr = getBufferStrategy();
		if (bufStr == null) {
			createBufferStrategy(1);
			return;
		}

		Graphics g = bufStr.getDrawGraphics();

		g.setColor(Color.LIGHT_GRAY);
		
		g.drawString("WINNER!!!!!!! " + won, 145, 120);
		

		g.dispose();
		bufStr.show();

	}
	
	
	public static void main(String[] args) {
		GameMain game = new GameMain();
		game.start();
	}

}
