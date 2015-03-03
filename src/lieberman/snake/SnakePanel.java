package lieberman.snake;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.util.ArrayList;
import java.util.Random;

import javax.swing.JPanel;

public class SnakePanel extends JPanel implements Runnable {

	public static final int WIDTH = 600;
	public static final int HEIGHT = 600;
	private Thread thread;
	private boolean running = false;

	private SnakeBody body;
	private Snake snake;

	private Food food;
	private ArrayList<Food> foods;

	private Random random;

	private int x = 10, y = 10;
	private int size = 3;

	public boolean right = true, left = false, up = false, down = false;
	private int ticks = 0;

	private Input key;

	public SnakePanel() {
		setFocusable(true);
		key = new Input();
		addKeyListener(key);
		setPreferredSize(new Dimension(WIDTH, HEIGHT));

		random = new Random();

		snake = new Snake();
		foods = new ArrayList<Food>();
		start();
	}

	public void tick() {
		if (snake.getSnake().size() == 0) {
			body = new SnakeBody(x, y, 10);
			snake.getSnake().add(body);
		}
		if (foods.size() == 0) {
			int xCoor = random.nextInt(59);
			int yCoor = random.nextInt(59);

			food = new Food(xCoor, yCoor, 10);
			foods.add(food);
		}

		for (int i = 0; i < foods.size(); i++) {
			if (x == foods.get(i).getX() && y == foods.get(i).getY()) {
				size++;
				foods.remove(i);
				i--;
			}
		}

		for (int i = 0; i < snake.getSnake().size(); i++) {
			if (x == snake.getSnake().get(i).getX()
					&& y == snake.getSnake().get(i).getY()) { // eats itself
				if (i != snake.getSnake().size() - 1) { // take out head
					end();
				}
			}
		}

		if (x < 0 || x > 59 || y < 0 || y > 59) {
			end();
		}

		ticks++;

		if (ticks > 250000) {
			if (right)
				x++;
			if (left)
				x--;
			if (up)
				y--;
			if (down)
				y++;

			ticks = 0;

			body = new SnakeBody(x, y, 10);
			snake.getSnake().add(body);

			if (snake.getSnake().size() > size) {
				snake.getSnake().remove(0);
			}
		}
	}

	public void paint(Graphics g) {
		g.clearRect(0, 0, WIDTH, HEIGHT);
		g.setColor(Color.BLUE);
		// for (int i = 0; i < WIDTH / 10; i++) {
		// g.drawLine(i * 10, 0, i * 10, HEIGHT);
		// }
		// for (int i = 0; i < HEIGHT / 10; i++) {
		// g.drawLine(0, i * 10, WIDTH, i * 10);
		// }

		for (int i = 0; i < snake.getSnake().size(); i++) {
			snake.getSnake().get(i).draw(g);
		}

		for (int i = 0; i < foods.size(); i++) {
			foods.get(i).draw(g);
		}
	}

	public void start() {
		running = true;
		thread = new Thread(this, "Snake Loop");
		thread.start();
	}

	public void end() {
		running = false;
		try {
			thread.join();
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	public void run() {
		while (running) {
			tick();
			repaint();
		}
	}

	public boolean isRight() {
		return right;
	}

	public boolean isLeft() {
		return left;
	}

	public boolean isUp() {
		return up;
	}

	public boolean isDown() {
		return down;
	}

	public class Input implements KeyListener {

		@Override
		public void keyPressed(KeyEvent e) {
			int key = e.getKeyCode();
			if (key == KeyEvent.VK_RIGHT && !left) {
				up = false;
				down = false;
				right = true;
				left = false;
			}

			if (key == KeyEvent.VK_LEFT && !right) {
				up = false;
				down = false;
				right = false;
				left = true;
			}

			if (key == KeyEvent.VK_UP && !down) {
				up = true;
				down = false;
				right = false;
				left = false;
			}

			if (key == KeyEvent.VK_DOWN && !up) {
				up = false;
				down = true;
				right = false;
				left = false;
			}
		}

		@Override
		public void keyReleased(KeyEvent e) {
			// TODO Auto-generated method stub

		}

		@Override
		public void keyTyped(KeyEvent e) {
			// TODO Auto-generated method stub

		}

	}

}
