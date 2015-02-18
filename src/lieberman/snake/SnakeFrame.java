package lieberman.snake;


import java.awt.BorderLayout;
import java.awt.Container;


import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

import javax.swing.JFrame;

public class SnakeFrame extends JFrame implements KeyListener{
	
	public SnakeFrame(){
		setSize(800, 600);
		setTitle("SNAKE");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		
		Container contentPane = getContentPane();
		contentPane.setLayout(new BorderLayout());
		
		WorldComponent comp = new WorldComponent();
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
		/*
		switch (e.getKeyCode()) {
		case KeyEvent.VK_RIGHT:
			if (GameLoopThread.direction != 2)
				GameLoopThread.direction = 1;
			break;
		case KeyEvent.VK_UP:
			if (GameLoopThread.direction != 4)
				GameLoopThread.direction = 3;
			break;

		case KeyEvent.VK_LEFT:
			if (GameLoopThread.direction != 1)
				GameLoopThread.direction = 2;
			break;

		case KeyEvent.VK_DOWN:
			if (GameLoopThread.direction != 3)
				GameLoopThread.direction = 4;
			break;

		default:
			break;
		}
		*/
	}

	@Override
	public void keyReleased(KeyEvent arg0) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void keyTyped(KeyEvent arg0) { //pressed and released
		// TODO Auto-generated method stub
		
	}

}
