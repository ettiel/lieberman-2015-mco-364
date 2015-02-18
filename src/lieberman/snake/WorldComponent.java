package lieberman.snake;

import java.awt.Graphics;

import javax.swing.JComponent;

public class WorldComponent extends JComponent{ //responsible to draw e/t to the screen
	
	private World world;
	
	public WorldComponent(World world){
		this.world = world;
	}
	
	@Override
	protected void paintComponent(Graphics g) {
		super.paintComponent(g);
		
		
		//either pass graphics object and inside world do g.___
			//world.draw(g);
		
		//or get stuff from world
			//Snake snake = world.getSnake();
			//g.fillRect(arg0, arg1, arg2, arg3);
		
	}

}
