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

		
		//4 or LEFT - turn left
		//6 or RIGHT - turn right
		//2 or DOWN
		//8 or UP
		
		System.out.println("keyPressed");
	

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
