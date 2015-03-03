package lieberman.snake;

import java.awt.GridLayout;

import javax.swing.JFrame;

public class SnakeFrame extends JFrame{

	public SnakeFrame(){
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setResizable(false);
		
		start();
	}
	
	public void start(){
		setLayout(new GridLayout(1,1,0,0));
		SnakePanel snakePanel = new SnakePanel();
		add(snakePanel);
		pack();
		setLocationRelativeTo(null);
		setVisible(true);
	}
	
	public static void main(String[] args){
		new SnakeFrame();
	}
}
