package lieberman.snake;

import java.awt.BorderLayout;
import java.awt.Container;

import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

import javax.swing.JFrame;

public class SnakeFrame extends JFrame implements KeyListener {
	World world;
	WorldComponent comp;

	public SnakeFrame() {
		setSize(800, 600);
		setTitle("SNAKE");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

		Container contentPane = getContentPane();
		contentPane.setLayout(new BorderLayout());

		world = new World();
		comp = new WorldComponent(world);
		comp.addKeyListener(this);
		comp.setFocusable(true);
		contentPane.add(comp);

		new GameLoopThread(comp).start();

	}

	@Override
	public void keyPressed(KeyEvent e) {
		// 4 or LEFT - turn left
		// 6 or RIGHT - turn right
		// 2 or DOWN
		// 8 or UP

		switch (e.getKeyCode()) {
		case KeyEvent.VK_UP:
			if (world.getSnake().getDirection() != Direction.DOWN)
			world.getSnake().setDirection(Direction.UP);
			break;
		case KeyEvent.VK_8:
			if (world.getSnake().getDirection() != Direction.DOWN)
			world.getSnake().setDirection(Direction.UP);
			break;
		case KeyEvent.VK_DOWN:
			if (world.getSnake().getDirection() != Direction.UP)
			world.getSnake().setDirection(Direction.DOWN);
			break;
		case KeyEvent.VK_2:
			if (world.getSnake().getDirection() != Direction.UP)
			world.getSnake().setDirection(Direction.DOWN);
			break;
		case KeyEvent.VK_RIGHT:
			if (world.getSnake().getDirection() != Direction.LEFT)
			world.getSnake().setDirection(Direction.RIGHT);
			break;
		case KeyEvent.VK_6:
			if (world.getSnake().getDirection() != Direction.LEFT)
			world.getSnake().setDirection(Direction.RIGHT);
			break;
		case KeyEvent.VK_LEFT:
			if (world.getSnake().getDirection() != Direction.RIGHT)
			world.getSnake().setDirection(Direction.LEFT);
			break;
		case KeyEvent.VK_4:
			if (world.getSnake().getDirection() != Direction.RIGHT)
			world.getSnake().setDirection(Direction.LEFT);
			break;

		}

	}

	@Override
	public void keyReleased(KeyEvent arg0) {
		// TODO Auto-generated method stub

	}

	@Override
	public void keyTyped(KeyEvent arg0) { // pressed and released
		// TODO Auto-generated method stub

	}

}